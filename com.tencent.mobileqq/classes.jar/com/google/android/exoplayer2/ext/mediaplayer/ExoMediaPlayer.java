package com.google.android.exoplayer2.ext.mediaplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayer.EventListener;
import com.google.android.exoplayer2.ExoPlayer.ExoPlayerMessage;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.ext.audio.AudioFrameManager;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.source.ClippingMediaSource;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.DynamicConcatenatingMediaSource;
import com.google.android.exoplayer2.source.ExtractorMediaSource.Factory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.hls.HlsMediaSource.Factory;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.Factory;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.DataSource.Factory;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource.Factory;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(16)
public class ExoMediaPlayer
  implements AudioLevelSupport, MediaPlayerInterface
{
  private static final DefaultBandwidthMeter BANDWIDTH_METER = new DefaultBandwidthMeter();
  private static final int BUFFER_REPEAT_DELAY = 1000;
  public static final String DEFAULT_LC_SAMPLE_CONFIG = "65536,15000,30000,2000,5000";
  private static final String HANDLER_THREAD_NAME = "SimpleExoMediaPlayer_HandlerThread";
  private static final String TAG = "ExoMediaPlayer";
  private static ILogger sLogger = null;
  private Context mAppContext;
  protected DecoderInfo mAudioDecoderInfo;
  private MediaPlayerInterface.AudioEventListener mAudioEventListener;
  protected Format mAudioFormat;
  private AudioFrameManager mAudioFrameManager;
  private int mAudioSessionId = 0;
  private Repeater mBufferUpdateRepeater;
  private boolean mCalculateAudioLevel = false;
  private ArrayList<Long> mClipDurations = new ArrayList();
  private ExoPlayer.EventListener mExo2EventListener;
  private ExoPlayer mExoPlayer;
  private boolean mFirstFrameDecoded = false;
  private boolean mFirstFrameDecodedEventSent = false;
  private HandlerThread mHandlerThread;
  private boolean mIsLooping;
  private volatile boolean mIsRelease;
  private double mLastAudioLevelDuration = -1.0D;
  private double mLastAudioLevelEnergy = -1.0D;
  private int mLastBufferedPercentage;
  private boolean mLoopingPlaySeek;
  private Handler mMainHandler;
  private MediaSource mMediaSource;
  private MediaSourceEventListener mMediaSourceEventListener;
  private MediaPlayerInterface.OnBufferingUpdateListener mOnBufferingUpdateListener;
  private MediaPlayerInterface.OnCompletionListener mOnCompletionListener;
  private MediaPlayerInterface.OnErrorListener mOnErrorListener;
  private MediaPlayerInterface.OnInfoListener mOnInfoListener;
  private MediaPlayerInterface.OnLoopStartListener mOnLoopStartListener;
  private MediaPlayerInterface.OnPreparedListener mOnPreparedListener;
  private MediaPlayerInterface.OnSeekCompleteListener mOnSeekCompleteListener;
  private MediaPlayerInterface.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
  private boolean mOwnsSurface;
  private List<Renderer> mRenderers;
  private boolean mScreenOnWhilePlaying;
  private ExoMediaPlayer.StateStore mStateStore;
  private boolean mStayAwake;
  private final AtomicBoolean mStopped = new AtomicBoolean();
  private Surface mSurface;
  private SurfaceHolder mSurfaceHolder;
  private final ExoMediaPlayer.SurfaceListener mSurfaceListener;
  private TextureView mTextureView;
  protected DecoderInfo mVideoDecoderInfo;
  protected Format mVideoFormat;
  private int mVideoHeight;
  private int mVideoWidth;
  private PowerManager.WakeLock mWakeLock = null;
  
  public ExoMediaPlayer(Context paramContext)
  {
    this.mAppContext = paramContext;
    this.mHandlerThread = new HandlerThread("SimpleExoMediaPlayer_HandlerThread");
    this.mHandlerThread.start();
    this.mMainHandler = new Handler(this.mHandlerThread.getLooper());
    this.mStateStore = new ExoMediaPlayer.StateStore(null);
    this.mExo2EventListener = new ExoMediaPlayer.Exo2EventListener(this, null);
    paramContext = new ExoMediaPlayer.BufferRepeatListener(this, null);
    this.mMediaSourceEventListener = new ExoMediaPlayer.ExoMediaSourceEventListener(this, null);
    this.mSurfaceListener = new ExoMediaPlayer.SurfaceListener(this, null);
    this.mBufferUpdateRepeater = new Repeater(this.mMainHandler);
    this.mBufferUpdateRepeater.setRepeaterDelay(1000);
    this.mBufferUpdateRepeater.setRepeatListener(paramContext);
    paramContext = new ExoMediaPlayer.RendererEventListener(this, null);
    this.mRenderers = new DefaultRendererProvider(this.mAppContext, this.mMainHandler, paramContext, paramContext, paramContext, paramContext).generate();
    this.mMainHandler.post(new ExoMediaPlayer.1(this));
    try
    {
      for (;;)
      {
        paramContext = this.mExoPlayer;
        if (paramContext != null) {
          break;
        }
        try
        {
          wait();
        }
        catch (InterruptedException paramContext)
        {
          Thread.currentThread().interrupt();
        }
      }
    }
    finally {}
  }
  
  private DataSource.Factory buildDataSourceFactory(DefaultBandwidthMeter paramDefaultBandwidthMeter, String paramString)
  {
    return new DefaultDataSourceFactory(this.mAppContext, paramDefaultBandwidthMeter, buildHttpDataSourceFactory(paramDefaultBandwidthMeter, paramString));
  }
  
  private DataSource.Factory buildDataSourceFactory(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    for (DefaultBandwidthMeter localDefaultBandwidthMeter = BANDWIDTH_METER;; localDefaultBandwidthMeter = null) {
      return buildDataSourceFactory(localDefaultBandwidthMeter, paramString);
    }
  }
  
  private HttpDataSource.Factory buildHttpDataSourceFactory(DefaultBandwidthMeter paramDefaultBandwidthMeter, String paramString)
  {
    return new DefaultHttpDataSourceFactory(paramString, paramDefaultBandwidthMeter);
  }
  
  private MediaSource buildMediaSource(Context paramContext, Uri paramUri, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (int i = Util.inferContentType(paramUri);; i = Util.inferContentType("." + paramString))
    {
      paramContext = Util.getUserAgent(paramContext, "ExoMediaPlayer");
      switch (i)
      {
      default: 
        throw new IllegalStateException("Unsupported type: " + i);
      }
    }
    return new HlsMediaSource.Factory(buildDataSourceFactory(BANDWIDTH_METER, paramContext)).createMediaSource(paramUri, this.mMainHandler, this.mMediaSourceEventListener);
    paramContext = new ExtractorMediaSource.Factory(buildDataSourceFactory(BANDWIDTH_METER, paramContext));
    paramContext.setContinueLoadingCheckIntervalBytes(2097152);
    paramContext.setMinLoadableRetryCount(10);
    return paramContext.createMediaSource(paramUri, this.mMainHandler, this.mMediaSourceEventListener);
  }
  
  private void clearVideoSurface(Surface paramSurface)
  {
    if ((paramSurface != null) && (paramSurface == this.mSurface)) {
      setSurface(null);
    }
  }
  
  private void clearVideoSurfaceHolder(SurfaceHolder paramSurfaceHolder)
  {
    if ((paramSurfaceHolder != null) && (paramSurfaceHolder == this.mSurfaceHolder)) {
      setDisplay(null);
    }
  }
  
  private void clearVideoSurfaceView(SurfaceView paramSurfaceView)
  {
    if (paramSurfaceView == null) {}
    for (paramSurfaceView = null;; paramSurfaceView = paramSurfaceView.getHolder())
    {
      clearVideoSurfaceHolder(paramSurfaceView);
      return;
    }
  }
  
  private void clearVideoTextureView(TextureView paramTextureView)
  {
    if ((paramTextureView != null) && (paramTextureView == this.mTextureView)) {
      setVideoTextureView(null);
    }
  }
  
  private int getBufferedPercentage()
  {
    if (this.mExoPlayer == null) {
      return 0;
    }
    return this.mExoPlayer.getBufferedPercentage();
  }
  
  public static ILogger getLogger()
  {
    if (sLogger == null) {}
    try
    {
      if (sLogger == null) {
        sLogger = new DefaultLogger();
      }
      return sLogger;
    }
    finally {}
  }
  
  private void initPlayer()
  {
    DefaultTrackSelector localDefaultTrackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(new DefaultBandwidthMeter()));
    QLoadControl localQLoadControl = new QLoadControl();
    this.mExoPlayer = ExoPlayerFactory.newInstance((Renderer[])this.mRenderers.toArray(new Renderer[this.mRenderers.size()]), localDefaultTrackSelector, localQLoadControl);
    this.mExoPlayer.addListener(this.mExo2EventListener);
  }
  
  private void notifyOnBufferingUpdate(int paramInt)
  {
    getLogger().v("ExoMediaPlayer", "notifyOnBufferingUpdate " + paramInt);
    try
    {
      if (this.mIsRelease) {
        return;
      }
      if (this.mOnBufferingUpdateListener != null)
      {
        this.mOnBufferingUpdateListener.onBufferingUpdate(this, paramInt);
        return;
      }
    }
    finally {}
  }
  
  private void notifyOnCompletion()
  {
    getLogger().v("ExoMediaPlayer", "notifyOnCompletion");
    try
    {
      if (this.mIsRelease) {
        return;
      }
      if (this.mOnCompletionListener != null)
      {
        this.mOnCompletionListener.onCompletion(this);
        return;
      }
    }
    finally {}
  }
  
  private boolean notifyOnError(int paramInt1, int paramInt2)
  {
    getLogger().d("ExoMediaPlayer", "notifyOnError [" + paramInt1 + "," + paramInt2 + "]");
    return (this.mOnErrorListener != null) && (this.mOnErrorListener.onError(this, paramInt1, paramInt2));
  }
  
  private boolean notifyOnInfo(int paramInt1, int paramInt2)
  {
    getLogger().d("ExoMediaPlayer", "notifyOnInfo [" + paramInt1 + "," + paramInt2 + "]");
    return (this.mOnInfoListener != null) && (this.mOnInfoListener.onInfo(this, paramInt1, paramInt2));
  }
  
  private void notifyOnPrepared()
  {
    getLogger().v("ExoMediaPlayer", "notifyOnPrepared");
    try
    {
      if (this.mIsRelease) {
        return;
      }
      if (this.mOnPreparedListener != null)
      {
        this.mOnPreparedListener.onPrepared(this);
        return;
      }
    }
    finally {}
  }
  
  private void notifyOnSeekComplete()
  {
    getLogger().v("ExoMediaPlayer", "notifyOnSeekComplete");
    try
    {
      if (this.mIsRelease) {
        return;
      }
      if (this.mOnSeekCompleteListener != null)
      {
        this.mOnSeekCompleteListener.onSeekComplete(this);
        return;
      }
    }
    finally {}
  }
  
  private void notifyOnVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    getLogger().v("ExoMediaPlayer", "notifyOnVideoSizeChanged [" + paramInt1 + "," + paramInt2 + "]");
    try
    {
      if (this.mIsRelease) {
        return;
      }
      if (this.mOnVideoSizeChangedListener != null)
      {
        this.mOnVideoSizeChangedListener.onVideoSizeChanged(this, paramInt1, paramInt2);
        return;
      }
    }
    finally {}
  }
  
  private void removeSurfaceCallbacks()
  {
    if (this.mTextureView != null)
    {
      if (this.mTextureView.getSurfaceTextureListener() == this.mSurfaceListener) {
        break label66;
      }
      getLogger().w("ExoMediaPlayer", "SurfaceTextureListener already unset or replaced");
    }
    for (;;)
    {
      this.mTextureView = null;
      if (this.mSurfaceHolder != null)
      {
        this.mSurfaceHolder.removeCallback(this.mSurfaceListener);
        this.mSurfaceHolder = null;
      }
      return;
      label66:
      this.mTextureView.setSurfaceTextureListener(null);
    }
  }
  
  private void reportPlayerState()
  {
    for (;;)
    {
      int j;
      try
      {
        if (this.mExoPlayer != null)
        {
          bool = this.mIsRelease;
          if (!bool) {}
        }
        else
        {
          return;
        }
        boolean bool = this.mExoPlayer.getPlayWhenReady();
        int i = this.mExoPlayer.getPlaybackState();
        j = this.mStateStore.getState(bool, i);
        if (j == this.mStateStore.getMostRecentState()) {
          continue;
        }
        getLogger().d("ExoMediaPlayer", "setMostRecentState [" + bool + "," + i + "]");
        this.mStateStore.setMostRecentState(bool, i);
        if (j == 3)
        {
          setBufferRepeaterStarted(true);
          if (j != this.mStateStore.getState(true, 4)) {
            break label224;
          }
          if (!isLooping()) {
            break label217;
          }
          getLogger().i("ExoMediaPlayer", "looping play start");
          this.mLoopingPlaySeek = true;
          seekTo(0L);
          if (this.mOnLoopStartListener == null) {
            continue;
          }
          this.mOnLoopStartListener.onLoopStart(this);
          continue;
        }
        if (j == 1) {
          break label209;
        }
      }
      finally {}
      if (j == 4)
      {
        label209:
        setBufferRepeaterStarted(false);
        continue;
        label217:
        notifyOnCompletion();
        continue;
        label224:
        if (this.mStateStore.matchesHistory(new int[] { this.mStateStore.getState(false, 1), this.mStateStore.getState(false, 2), this.mStateStore.getState(false, 3) }, false)) {
          notifyOnPrepared();
        } else if ((this.mStateStore.matchesHistory(new int[] { 100, 2, 3 }, true) | this.mStateStore.matchesHistory(new int[] { 2, 100, 3 }, true) | this.mStateStore.matchesHistory(new int[] { 100, 3, 2, 3 }, true)))
        {
          if (!this.mLoopingPlaySeek) {
            notifyOnSeekComplete();
          } else {
            this.mLoopingPlaySeek = false;
          }
        }
        else if (this.mStateStore.matchesHistory(new int[] { this.mStateStore.getState(true, 3), this.mStateStore.getState(true, 2) }, false)) {
          notifyOnInfo(701, getBufferedPercentage());
        } else if (this.mStateStore.matchesHistory(new int[] { this.mStateStore.getState(true, 2), this.mStateStore.getState(true, 3) }, false)) {
          notifyOnInfo(702, getBufferedPercentage());
        }
      }
    }
  }
  
  private void sendMessage(int paramInt1, int paramInt2, Object paramObject)
  {
    sendMessage(paramInt1, paramInt2, paramObject, false);
  }
  
  private void sendMessage(int paramInt1, int paramInt2, Object paramObject, boolean paramBoolean)
  {
    if (this.mRenderers.isEmpty()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mRenderers.iterator();
    while (localIterator.hasNext())
    {
      Renderer localRenderer = (Renderer)localIterator.next();
      if (localRenderer.getTrackType() == paramInt1) {
        localArrayList.add(new ExoPlayer.ExoPlayerMessage(localRenderer, paramInt2, paramObject));
      }
    }
    if (paramBoolean)
    {
      this.mExoPlayer.blockingSendMessages((ExoPlayer.ExoPlayerMessage[])localArrayList.toArray(new ExoPlayer.ExoPlayerMessage[localArrayList.size()]));
      return;
    }
    this.mExoPlayer.sendMessages((ExoPlayer.ExoPlayerMessage[])localArrayList.toArray(new ExoPlayer.ExoPlayerMessage[localArrayList.size()]));
  }
  
  private void setBufferRepeaterStarted(boolean paramBoolean)
  {
    getLogger().d("ExoMediaPlayer", "setBufferRepeaterStarted " + paramBoolean);
    if ((paramBoolean) && (this.mOnBufferingUpdateListener != null))
    {
      this.mBufferUpdateRepeater.start();
      return;
    }
    this.mBufferUpdateRepeater.stop();
  }
  
  public static void setLogger(ILogger paramILogger)
  {
    try
    {
      sLogger = paramILogger;
      return;
    }
    finally {}
  }
  
  private void setVideoSurfaceInternal(Surface paramSurface, boolean paramBoolean)
  {
    if (this.mExoPlayer == null)
    {
      getLogger().w("ExoMediaPlayer", "call setVideoSurfaceInternal after release");
      return;
    }
    if ((this.mSurface != null) && (this.mSurface != paramSurface) && (paramSurface != null))
    {
      if (this.mOwnsSurface) {
        this.mSurface.release();
      }
      sendMessage(2, 1, paramSurface, true);
      long l = this.mExoPlayer.getCurrentPosition();
      if (Util.SDK_INT < 23) {
        this.mMainHandler.postDelayed(new ExoMediaPlayer.2(this, l), 200L);
      }
    }
    for (;;)
    {
      this.mSurface = paramSurface;
      this.mOwnsSurface = paramBoolean;
      updateSurfaceScreenOn();
      return;
      sendMessage(2, 1, paramSurface, false);
    }
  }
  
  private void setVideoSurfaceView(SurfaceView paramSurfaceView)
  {
    if (paramSurfaceView == null) {}
    for (paramSurfaceView = null;; paramSurfaceView = paramSurfaceView.getHolder())
    {
      setDisplay(paramSurfaceView);
      return;
    }
  }
  
  private void setVideoTextureView(TextureView paramTextureView)
  {
    Surface localSurface = null;
    removeSurfaceCallbacks();
    this.mTextureView = paramTextureView;
    if (paramTextureView == null)
    {
      setVideoSurfaceInternal(null, true);
      return;
    }
    if (paramTextureView.getSurfaceTextureListener() != null) {
      getLogger().w("ExoMediaPlayer", "Replacing existing SurfaceTextureListener");
    }
    SurfaceTexture localSurfaceTexture = paramTextureView.getSurfaceTexture();
    if (localSurfaceTexture == null) {}
    for (;;)
    {
      setVideoSurfaceInternal(localSurface, true);
      paramTextureView.setSurfaceTextureListener(this.mSurfaceListener);
      return;
      localSurface = new Surface(localSurfaceTexture);
    }
  }
  
  private void stayAwake(boolean paramBoolean)
  {
    if (this.mWakeLock != null)
    {
      if ((!paramBoolean) || (this.mWakeLock.isHeld())) {
        break label38;
      }
      this.mWakeLock.acquire();
    }
    for (;;)
    {
      this.mStayAwake = paramBoolean;
      updateSurfaceScreenOn();
      return;
      label38:
      if ((!paramBoolean) && (this.mWakeLock.isHeld())) {
        this.mWakeLock.release();
      }
    }
  }
  
  public static void updateLoadControlConfig(QLoadControl.Config paramConfig)
  {
    getLogger().d("ExoMediaPlayer", "updateLoadControlConfig " + paramConfig);
    QLoadControl.updateConfig(paramConfig);
  }
  
  public static void updateLoadControlConfig(String paramString)
  {
    getLogger().d("ExoMediaPlayer", "updateLoadControlConfig " + paramString);
    QLoadControl.updateConfig(paramString);
  }
  
  private void updateSurfaceScreenOn()
  {
    SurfaceHolder localSurfaceHolder;
    if (this.mSurfaceHolder != null)
    {
      localSurfaceHolder = this.mSurfaceHolder;
      if ((!this.mScreenOnWhilePlaying) || (!this.mStayAwake)) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      localSurfaceHolder.setKeepScreenOn(bool);
      return;
    }
  }
  
  public static void warmDecoder()
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      MediaCodecUtil.warmDecoderInfoCache("video/hevc", false);
      MediaCodecUtil.warmDecoderInfoCache("video/avc", false);
      MediaCodecUtil.warmDecoderInfoCache("audio/mp4a-latm", false);
    }
  }
  
  public DecoderInfo getAudioDecoderInfo()
  {
    return this.mAudioDecoderInfo;
  }
  
  public double getAudioDuration()
  {
    if (this.mAudioFrameManager != null) {
      return this.mAudioFrameManager.getDuration();
    }
    return 0.0D;
  }
  
  public double getAudioEnergy()
  {
    if (this.mAudioFrameManager != null) {
      return this.mAudioFrameManager.getAudioEnergy();
    }
    return 0.0D;
  }
  
  public Format getAudioFormat()
  {
    return this.mAudioFormat;
  }
  
  public double getAudioLevel()
  {
    double d1 = 0.0D;
    double d2 = d1;
    if (this.mAudioFrameManager != null)
    {
      d2 = this.mAudioFrameManager.getDuration() - this.mLastAudioLevelDuration;
      if (d2 > 0.0D) {
        d1 = Math.sqrt((this.mAudioFrameManager.getAudioEnergy() - this.mLastAudioLevelEnergy) / d2);
      }
      this.mLastAudioLevelDuration = this.mAudioFrameManager.getDuration();
      this.mLastAudioLevelEnergy = this.mAudioFrameManager.getAudioEnergy();
      d2 = d1;
    }
    return d2;
  }
  
  public int getAudioSessionId()
  {
    return this.mAudioSessionId;
  }
  
  public long getCurrentPosition()
  {
    if (this.mExoPlayer == null) {
      return 0L;
    }
    if (this.mClipDurations.size() > 0)
    {
      int i = this.mExoPlayer.getCurrentWindowIndex();
      for (long l = 0L; i > 0; l = ((Long)this.mClipDurations.get(i)).longValue() + l) {
        i -= 1;
      }
      return this.mExoPlayer.getCurrentPosition() + l;
    }
    return this.mExoPlayer.getCurrentPosition();
  }
  
  public long getDuration()
  {
    if (this.mExoPlayer == null) {
      return 0L;
    }
    if (this.mClipDurations.size() > 0)
    {
      Iterator localIterator = this.mClipDurations.iterator();
      for (long l = 0L; localIterator.hasNext(); l = ((Long)localIterator.next()).longValue() + l) {}
      return l;
    }
    return this.mExoPlayer.getDuration();
  }
  
  public DecoderInfo getVideoDecoderInfo()
  {
    return this.mVideoDecoderInfo;
  }
  
  public Format getVideoFormat()
  {
    return this.mVideoFormat;
  }
  
  public int getVideoHeight()
  {
    return this.mVideoHeight;
  }
  
  public int getVideoWidth()
  {
    return this.mVideoWidth;
  }
  
  public boolean isLooping()
  {
    return this.mIsLooping;
  }
  
  public boolean isPlaying()
  {
    if (this.mExoPlayer == null) {}
    do
    {
      return false;
      switch (this.mExoPlayer.getPlaybackState())
      {
      default: 
        return false;
      case 1: 
      case 3: 
        return this.mExoPlayer.getPlayWhenReady();
      }
    } while (!this.mIsLooping);
    return true;
  }
  
  public void pause()
  {
    if (this.mExoPlayer == null) {
      return;
    }
    this.mExoPlayer.setPlayWhenReady(false);
  }
  
  public void prepareAsync()
  {
    getLogger().v("ExoMediaPlayer", "prepareAsync");
    if (this.mSurface != null) {
      setSurface(this.mSurface);
    }
    if (this.mIsLooping) {
      getLogger().v("ExoMediaPlayer", "looping play video");
    }
    this.mExoPlayer.setPlayWhenReady(false);
    this.mExoPlayer.prepare(this.mMediaSource);
  }
  
  public void release()
  {
    try
    {
      this.mIsRelease = true;
      if (this.mExoPlayer != null)
      {
        setBufferRepeaterStarted(false);
        if (this.mExoPlayer != null)
        {
          this.mExoPlayer.release();
          this.mExoPlayer.removeListener(this.mExo2EventListener);
          this.mExoPlayer = null;
        }
        this.mSurface = null;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mSurfaceHolder = null;
        this.mClipDurations.clear();
        this.mLastBufferedPercentage = 0;
      }
      if (this.mHandlerThread != null)
      {
        this.mHandlerThread.quit();
        this.mHandlerThread = null;
      }
      stayAwake(false);
      updateSurfaceScreenOn();
      removeSurfaceCallbacks();
      if (this.mSurface != null)
      {
        if (this.mOwnsSurface) {
          this.mSurface.release();
        }
        this.mSurface = null;
      }
      this.mOnPreparedListener = null;
      this.mOnCompletionListener = null;
      this.mOnBufferingUpdateListener = null;
      this.mOnSeekCompleteListener = null;
      this.mOnVideoSizeChangedListener = null;
      this.mOnErrorListener = null;
      this.mOnInfoListener = null;
      return;
    }
    finally {}
  }
  
  public void reset()
  {
    if (this.mExoPlayer != null)
    {
      setBufferRepeaterStarted(false);
      if (this.mExoPlayer != null)
      {
        this.mExoPlayer.setPlayWhenReady(false);
        this.mExoPlayer.stop(true);
      }
      this.mIsLooping = false;
      this.mFirstFrameDecoded = false;
      this.mFirstFrameDecodedEventSent = false;
      this.mStateStore.reset();
      this.mClipDurations.clear();
      this.mLastBufferedPercentage = 0;
    }
  }
  
  public void seekTo(long paramLong)
  {
    if (this.mExoPlayer == null) {
      return;
    }
    int i;
    if (this.mClipDurations.size() > 0)
    {
      long l = 0L;
      i = 0;
      if (i < this.mClipDurations.size())
      {
        l += ((Long)this.mClipDurations.get(i)).longValue();
        if (l <= paramLong) {
          break label106;
        }
        this.mExoPlayer.seekTo(i, paramLong - l + ((Long)this.mClipDurations.get(i)).longValue());
      }
    }
    for (;;)
    {
      this.mStateStore.setMostRecentState(this.mStateStore.isLastReportedPlayWhenReady(), 100);
      return;
      label106:
      i += 1;
      break;
      this.mExoPlayer.seekTo(paramLong);
    }
  }
  
  public void setAudioEventListener(MediaPlayerInterface.AudioEventListener paramAudioEventListener)
  {
    this.mAudioEventListener = paramAudioEventListener;
  }
  
  public void setCalculateAudioLevel(boolean paramBoolean)
  {
    this.mCalculateAudioLevel = paramBoolean;
  }
  
  public void setDataSource(Context paramContext, Uri paramUri)
  {
    this.mMediaSource = buildMediaSource(this.mAppContext, paramUri, null);
  }
  
  public void setDataSource(Context paramContext, Uri paramUri, Map<String, String> paramMap)
  {
    setDataSource(paramContext, paramUri);
  }
  
  public void setDataSource(Context paramContext, List<String> paramList)
  {
    paramContext = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!TextUtils.isEmpty(str)) {
        paramContext.add(buildMediaSource(this.mAppContext, Uri.parse(str), null));
      }
    }
    this.mMediaSource = new ConcatenatingMediaSource((MediaSource[])paramContext.toArray(new MediaSource[paramContext.size()]));
  }
  
  public void setDataSource(String paramString)
  {
    setDataSource(this.mAppContext, Uri.parse(paramString));
  }
  
  public void setDataSource(List<VideoMeta> paramList)
  {
    this.mMediaSource = new DynamicConcatenatingMediaSource();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (VideoMeta)paramList.next();
      long l2 = ((VideoMeta)localObject).startPosition * 1000L;
      if (((VideoMeta)localObject).endPosition == -1L) {}
      for (long l1 = ((VideoMeta)localObject).duration;; l1 = ((VideoMeta)localObject).endPosition)
      {
        l1 *= 1000L;
        if (l1 > l2) {
          break;
        }
        throw new IllegalArgumentException("wrong range [" + l2 + "," + l1 + "]");
      }
      long l3 = (l1 - l2) / 1000L;
      this.mClipDurations.add(Long.valueOf(l3));
      localObject = buildMediaSource(this.mAppContext, Uri.parse(((VideoMeta)localObject).uri), null);
      ((DynamicConcatenatingMediaSource)this.mMediaSource).addMediaSource(new ClippingMediaSource((MediaSource)localObject, l2, l1));
    }
  }
  
  public void setDataSource(VideoMeta... paramVarArgs)
  {
    setDataSource(Arrays.asList(paramVarArgs));
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    removeSurfaceCallbacks();
    this.mSurfaceHolder = paramSurfaceHolder;
    if (paramSurfaceHolder == null)
    {
      setVideoSurfaceInternal(null, false);
      return;
    }
    setVideoSurfaceInternal(paramSurfaceHolder.getSurface(), false);
    paramSurfaceHolder.addCallback(this.mSurfaceListener);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.mIsLooping = paramBoolean;
    getLogger().i("ExoMediaPlayer", "setLooping " + this.mIsLooping);
  }
  
  public void setNextMediaPlayer(MediaPlayerInterface paramMediaPlayerInterface)
  {
    throw new UnsupportedOperationException("setNextMediaPlayer is not supported by " + ExoMediaPlayer.class.getSimpleName());
  }
  
  public void setOnBufferingUpdateListener(MediaPlayerInterface.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.mOnBufferingUpdateListener = paramOnBufferingUpdateListener;
    if (paramOnBufferingUpdateListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      setBufferRepeaterStarted(bool);
      return;
    }
  }
  
  public void setOnCompletionListener(MediaPlayerInterface.OnCompletionListener paramOnCompletionListener)
  {
    this.mOnCompletionListener = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(MediaPlayerInterface.OnErrorListener paramOnErrorListener)
  {
    this.mOnErrorListener = paramOnErrorListener;
  }
  
  public void setOnInfoListener(MediaPlayerInterface.OnInfoListener paramOnInfoListener)
  {
    this.mOnInfoListener = paramOnInfoListener;
  }
  
  public void setOnLoopStartListener(MediaPlayerInterface.OnLoopStartListener paramOnLoopStartListener)
  {
    this.mOnLoopStartListener = paramOnLoopStartListener;
  }
  
  public void setOnPreparedListener(MediaPlayerInterface.OnPreparedListener paramOnPreparedListener)
  {
    this.mOnPreparedListener = paramOnPreparedListener;
  }
  
  public void setOnSeekCompleteListener(MediaPlayerInterface.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.mOnSeekCompleteListener = paramOnSeekCompleteListener;
  }
  
  public void setOnVideoSizeChangedListener(MediaPlayerInterface.OnVideoSizeChangedListener paramOnVideoSizeChangedListener)
  {
    this.mOnVideoSizeChangedListener = paramOnVideoSizeChangedListener;
  }
  
  public void setRate(float paramFloat)
  {
    PlaybackParameters localPlaybackParameters = new PlaybackParameters(paramFloat, paramFloat);
    this.mExoPlayer.setPlaybackParameters(localPlaybackParameters);
  }
  
  public void setScreenOnWhilePlaying(boolean paramBoolean)
  {
    if (this.mScreenOnWhilePlaying != paramBoolean)
    {
      if ((paramBoolean) && (this.mSurfaceHolder == null)) {
        getLogger().w("ExoMediaPlayer", "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
      }
      this.mScreenOnWhilePlaying = paramBoolean;
      updateSurfaceScreenOn();
    }
    updateSurfaceScreenOn();
  }
  
  public void setSeekParameters(SeekParameters paramSeekParameters)
  {
    if (this.mExoPlayer != null) {
      this.mExoPlayer.setSeekParameters(paramSeekParameters);
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    if ((this.mScreenOnWhilePlaying) && (paramSurface != null)) {
      getLogger().w("ExoMediaPlayer", "setScreenOnWhilePlaying(true) is ineffective for Surface");
    }
    removeSurfaceCallbacks();
    setVideoSurfaceInternal(paramSurface, false);
  }
  
  public void setVolume(float paramFloat1, float paramFloat2)
  {
    sendMessage(1, 2, Float.valueOf(paramFloat1));
  }
  
  public void setWakeMode(Context paramContext, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (this.mWakeLock != null)
    {
      bool1 = bool2;
      if (this.mWakeLock.isHeld())
      {
        bool1 = true;
        this.mWakeLock.release();
      }
      this.mWakeLock = null;
    }
    try
    {
      if (paramContext.getPackageManager().checkPermission("android.permission.WAKE_LOCK", paramContext.getPackageName()) == 0)
      {
        this.mWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(0x20000000 | paramInt, ExoMediaPlayer.class.getName());
        this.mWakeLock.setReferenceCounted(false);
      }
      for (;;)
      {
        stayAwake(bool1);
        return;
        getLogger().w("ExoMediaPlayer", "Unable to acquire WAKE_LOCK due to missing manifest permission");
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        getLogger().w("ExoMediaPlayer", "Unable to acquire WAKE_LOCK ", paramContext);
      }
    }
  }
  
  public void start()
  {
    if (this.mExoPlayer == null) {}
    do
    {
      return;
      this.mExoPlayer.setPlayWhenReady(true);
    } while ((this.mFirstFrameDecodedEventSent) || (!this.mFirstFrameDecoded));
    notifyOnInfo(3, 0);
    this.mFirstFrameDecodedEventSent = true;
  }
  
  public void stop()
  {
    if (this.mExoPlayer == null) {}
    while (this.mStopped.getAndSet(true)) {
      return;
    }
    this.mExoPlayer.setPlayWhenReady(false);
    this.mExoPlayer.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer
 * JD-Core Version:    0.7.0.1
 */