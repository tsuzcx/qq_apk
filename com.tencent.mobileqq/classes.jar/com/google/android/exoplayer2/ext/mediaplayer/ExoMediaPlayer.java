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
    for (;;)
    {
      try
      {
        paramContext = this.mExoPlayer;
        if (paramContext != null) {
          break;
        }
      }
      finally
      {
        continue;
        throw paramContext;
        continue;
      }
      try
      {
        wait();
      }
      catch (InterruptedException paramContext)
      {
        continue;
      }
      Thread.currentThread().interrupt();
    }
  }
  
  private DataSource.Factory buildDataSourceFactory(DefaultBandwidthMeter paramDefaultBandwidthMeter, String paramString)
  {
    return new DefaultDataSourceFactory(this.mAppContext, paramDefaultBandwidthMeter, buildHttpDataSourceFactory(paramDefaultBandwidthMeter, paramString));
  }
  
  private DataSource.Factory buildDataSourceFactory(boolean paramBoolean, String paramString)
  {
    DefaultBandwidthMeter localDefaultBandwidthMeter;
    if (paramBoolean) {
      localDefaultBandwidthMeter = BANDWIDTH_METER;
    } else {
      localDefaultBandwidthMeter = null;
    }
    return buildDataSourceFactory(localDefaultBandwidthMeter, paramString);
  }
  
  private HttpDataSource.Factory buildHttpDataSourceFactory(DefaultBandwidthMeter paramDefaultBandwidthMeter, String paramString)
  {
    return new DefaultHttpDataSourceFactory(paramString, paramDefaultBandwidthMeter);
  }
  
  private MediaSource buildMediaSource(Context paramContext, Uri paramUri, String paramString)
  {
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      i = Util.inferContentType(paramUri);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(".");
      localStringBuilder.append(paramString);
      i = Util.inferContentType(localStringBuilder.toString());
    }
    paramContext = Util.getUserAgent(paramContext, "ExoMediaPlayer");
    if (i != 2)
    {
      if (i == 3)
      {
        paramContext = new ExtractorMediaSource.Factory(buildDataSourceFactory(BANDWIDTH_METER, paramContext));
        paramContext.setContinueLoadingCheckIntervalBytes(2097152);
        paramContext.setMinLoadableRetryCount(10);
        return paramContext.createMediaSource(paramUri, this.mMainHandler, this.mMediaSourceEventListener);
      }
      paramContext = new StringBuilder();
      paramContext.append("Unsupported type: ");
      paramContext.append(i);
      throw new IllegalStateException(paramContext.toString());
    }
    return new HlsMediaSource.Factory(buildDataSourceFactory(BANDWIDTH_METER, paramContext)).createMediaSource(paramUri, this.mMainHandler, this.mMediaSourceEventListener);
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
    if (paramSurfaceView == null) {
      paramSurfaceView = null;
    } else {
      paramSurfaceView = paramSurfaceView.getHolder();
    }
    clearVideoSurfaceHolder(paramSurfaceView);
  }
  
  private void clearVideoTextureView(TextureView paramTextureView)
  {
    if ((paramTextureView != null) && (paramTextureView == this.mTextureView)) {
      setVideoTextureView(null);
    }
  }
  
  private int getBufferedPercentage()
  {
    ExoPlayer localExoPlayer = this.mExoPlayer;
    if (localExoPlayer == null) {
      return 0;
    }
    return localExoPlayer.getBufferedPercentage();
  }
  
  public static ILogger getLogger()
  {
    if (sLogger == null) {
      try
      {
        if (sLogger == null) {
          sLogger = new DefaultLogger();
        }
      }
      finally {}
    }
    return sLogger;
  }
  
  private void initPlayer()
  {
    DefaultTrackSelector localDefaultTrackSelector = new DefaultTrackSelector(new AdaptiveTrackSelection.Factory(new DefaultBandwidthMeter()));
    QLoadControl localQLoadControl = new QLoadControl();
    List localList = this.mRenderers;
    this.mExoPlayer = ExoPlayerFactory.newInstance((Renderer[])localList.toArray(new Renderer[localList.size()]), localDefaultTrackSelector, localQLoadControl);
    this.mExoPlayer.addListener(this.mExo2EventListener);
  }
  
  private void notifyOnBufferingUpdate(int paramInt)
  {
    Object localObject1 = getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyOnBufferingUpdate ");
    localStringBuilder.append(paramInt);
    ((ILogger)localObject1).v("ExoMediaPlayer", localStringBuilder.toString());
    try
    {
      if (this.mIsRelease) {
        return;
      }
      localObject1 = this.mOnBufferingUpdateListener;
      if (localObject1 != null) {
        ((MediaPlayerInterface.OnBufferingUpdateListener)localObject1).onBufferingUpdate(this, paramInt);
      }
      return;
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
      MediaPlayerInterface.OnCompletionListener localOnCompletionListener = this.mOnCompletionListener;
      if (localOnCompletionListener != null) {
        localOnCompletionListener.onCompletion(this);
      }
      return;
    }
    finally {}
  }
  
  private boolean notifyOnError(int paramInt1, int paramInt2)
  {
    Object localObject = getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyOnError [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    ((ILogger)localObject).d("ExoMediaPlayer", localStringBuilder.toString());
    localObject = this.mOnErrorListener;
    return (localObject != null) && (((MediaPlayerInterface.OnErrorListener)localObject).onError(this, paramInt1, paramInt2));
  }
  
  private boolean notifyOnInfo(int paramInt1, int paramInt2)
  {
    Object localObject = getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyOnInfo [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    ((ILogger)localObject).d("ExoMediaPlayer", localStringBuilder.toString());
    localObject = this.mOnInfoListener;
    return (localObject != null) && (((MediaPlayerInterface.OnInfoListener)localObject).onInfo(this, paramInt1, paramInt2));
  }
  
  private void notifyOnPrepared()
  {
    getLogger().v("ExoMediaPlayer", "notifyOnPrepared");
    try
    {
      if (this.mIsRelease) {
        return;
      }
      MediaPlayerInterface.OnPreparedListener localOnPreparedListener = this.mOnPreparedListener;
      if (localOnPreparedListener != null) {
        localOnPreparedListener.onPrepared(this);
      }
      return;
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
      MediaPlayerInterface.OnSeekCompleteListener localOnSeekCompleteListener = this.mOnSeekCompleteListener;
      if (localOnSeekCompleteListener != null) {
        localOnSeekCompleteListener.onSeekComplete(this);
      }
      return;
    }
    finally {}
  }
  
  private void notifyOnVideoSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyOnVideoSizeChanged [");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("]");
    ((ILogger)localObject1).v("ExoMediaPlayer", localStringBuilder.toString());
    try
    {
      if (this.mIsRelease) {
        return;
      }
      localObject1 = this.mOnVideoSizeChangedListener;
      if (localObject1 != null) {
        ((MediaPlayerInterface.OnVideoSizeChangedListener)localObject1).onVideoSizeChanged(this, paramInt1, paramInt2);
      }
      return;
    }
    finally {}
  }
  
  private void removeSurfaceCallbacks()
  {
    Object localObject = this.mTextureView;
    if (localObject != null)
    {
      if (((TextureView)localObject).getSurfaceTextureListener() != this.mSurfaceListener) {
        getLogger().w("ExoMediaPlayer", "SurfaceTextureListener already unset or replaced");
      } else {
        this.mTextureView.setSurfaceTextureListener(null);
      }
      this.mTextureView = null;
    }
    localObject = this.mSurfaceHolder;
    if (localObject != null)
    {
      ((SurfaceHolder)localObject).removeCallback(this.mSurfaceListener);
      this.mSurfaceHolder = null;
    }
  }
  
  private void reportPlayerState()
  {
    for (;;)
    {
      int j;
      try
      {
        if ((this.mExoPlayer != null) && (!this.mIsRelease))
        {
          boolean bool1 = this.mExoPlayer.getPlayWhenReady();
          int i = this.mExoPlayer.getPlaybackState();
          j = this.mStateStore.getState(bool1, i);
          if (j != this.mStateStore.getMostRecentState())
          {
            ILogger localILogger = getLogger();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("setMostRecentState [");
            localStringBuilder.append(bool1);
            localStringBuilder.append(",");
            localStringBuilder.append(i);
            localStringBuilder.append("]");
            localILogger.d("ExoMediaPlayer", localStringBuilder.toString());
            this.mStateStore.setMostRecentState(bool1, i);
            if (j != 3) {
              break label513;
            }
            setBufferRepeaterStarted(true);
            continue;
            setBufferRepeaterStarted(false);
            if (j == this.mStateStore.getState(true, 4))
            {
              if (isLooping())
              {
                getLogger().i("ExoMediaPlayer", "looping play start");
                this.mLoopingPlaySeek = true;
                seekTo(0L);
                if (this.mOnLoopStartListener != null) {
                  this.mOnLoopStartListener.onLoopStart(this);
                }
              }
              else
              {
                notifyOnCompletion();
              }
              return;
            }
            if (this.mStateStore.matchesHistory(new int[] { this.mStateStore.getState(false, 1), this.mStateStore.getState(false, 2), this.mStateStore.getState(false, 3) }, false))
            {
              notifyOnPrepared();
              return;
            }
            bool1 = this.mStateStore.matchesHistory(new int[] { 100, 2, 3 }, true);
            boolean bool2 = this.mStateStore.matchesHistory(new int[] { 2, 100, 3 }, true);
            if ((this.mStateStore.matchesHistory(new int[] { 100, 3, 2, 3 }, true) | bool1 | bool2))
            {
              if (!this.mLoopingPlaySeek) {
                notifyOnSeekComplete();
              } else {
                this.mLoopingPlaySeek = false;
              }
              return;
            }
            if (this.mStateStore.matchesHistory(new int[] { this.mStateStore.getState(true, 3), this.mStateStore.getState(true, 2) }, false))
            {
              notifyOnInfo(701, getBufferedPercentage());
              return;
            }
            if (this.mStateStore.matchesHistory(new int[] { this.mStateStore.getState(true, 2), this.mStateStore.getState(true, 3) }, false))
            {
              notifyOnInfo(702, getBufferedPercentage());
              return;
            }
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      label513:
      if (j != 1) {
        if (j != 4) {}
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
    ILogger localILogger = getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setBufferRepeaterStarted ");
    localStringBuilder.append(paramBoolean);
    localILogger.d("ExoMediaPlayer", localStringBuilder.toString());
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
    Surface localSurface = this.mSurface;
    if ((localSurface != null) && (localSurface != paramSurface) && (paramSurface != null))
    {
      if (this.mOwnsSurface) {
        localSurface.release();
      }
      sendMessage(2, 1, paramSurface, true);
      long l = this.mExoPlayer.getCurrentPosition();
      if (Util.SDK_INT < 23) {
        this.mMainHandler.postDelayed(new ExoMediaPlayer.2(this, l), 200L);
      }
    }
    else
    {
      sendMessage(2, 1, paramSurface, false);
    }
    this.mSurface = paramSurface;
    this.mOwnsSurface = paramBoolean;
    updateSurfaceScreenOn();
  }
  
  private void setVideoSurfaceView(SurfaceView paramSurfaceView)
  {
    if (paramSurfaceView == null) {
      paramSurfaceView = null;
    } else {
      paramSurfaceView = paramSurfaceView.getHolder();
    }
    setDisplay(paramSurfaceView);
  }
  
  private void setVideoTextureView(TextureView paramTextureView)
  {
    removeSurfaceCallbacks();
    this.mTextureView = paramTextureView;
    Surface localSurface = null;
    if (paramTextureView == null)
    {
      setVideoSurfaceInternal(null, true);
      return;
    }
    if (paramTextureView.getSurfaceTextureListener() != null) {
      getLogger().w("ExoMediaPlayer", "Replacing existing SurfaceTextureListener");
    }
    SurfaceTexture localSurfaceTexture = paramTextureView.getSurfaceTexture();
    if (localSurfaceTexture != null) {
      localSurface = new Surface(localSurfaceTexture);
    }
    setVideoSurfaceInternal(localSurface, true);
    paramTextureView.setSurfaceTextureListener(this.mSurfaceListener);
  }
  
  private void stayAwake(boolean paramBoolean)
  {
    PowerManager.WakeLock localWakeLock = this.mWakeLock;
    if (localWakeLock != null) {
      if ((paramBoolean) && (!localWakeLock.isHeld())) {
        this.mWakeLock.acquire();
      } else if ((!paramBoolean) && (this.mWakeLock.isHeld())) {
        this.mWakeLock.release();
      }
    }
    this.mStayAwake = paramBoolean;
    updateSurfaceScreenOn();
  }
  
  public static void updateLoadControlConfig(QLoadControl.Config paramConfig)
  {
    ILogger localILogger = getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateLoadControlConfig ");
    localStringBuilder.append(paramConfig);
    localILogger.d("ExoMediaPlayer", localStringBuilder.toString());
    QLoadControl.updateConfig(paramConfig);
  }
  
  public static void updateLoadControlConfig(String paramString)
  {
    ILogger localILogger = getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateLoadControlConfig ");
    localStringBuilder.append(paramString);
    localILogger.d("ExoMediaPlayer", localStringBuilder.toString());
    QLoadControl.updateConfig(paramString);
  }
  
  private void updateSurfaceScreenOn()
  {
    SurfaceHolder localSurfaceHolder = this.mSurfaceHolder;
    if (localSurfaceHolder != null)
    {
      boolean bool;
      if ((this.mScreenOnWhilePlaying) && (this.mStayAwake)) {
        bool = true;
      } else {
        bool = false;
      }
      localSurfaceHolder.setKeepScreenOn(bool);
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
    AudioFrameManager localAudioFrameManager = this.mAudioFrameManager;
    if (localAudioFrameManager != null) {
      return localAudioFrameManager.getDuration();
    }
    return 0.0D;
  }
  
  public double getAudioEnergy()
  {
    AudioFrameManager localAudioFrameManager = this.mAudioFrameManager;
    if (localAudioFrameManager != null) {
      return localAudioFrameManager.getAudioEnergy();
    }
    return 0.0D;
  }
  
  public Format getAudioFormat()
  {
    return this.mAudioFormat;
  }
  
  public double getAudioLevel()
  {
    AudioFrameManager localAudioFrameManager = this.mAudioFrameManager;
    double d1 = 0.0D;
    double d2 = d1;
    if (localAudioFrameManager != null)
    {
      d2 = localAudioFrameManager.getDuration() - this.mLastAudioLevelDuration;
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
    ExoPlayer localExoPlayer = this.mExoPlayer;
    long l = 0L;
    if (localExoPlayer == null) {
      return 0L;
    }
    if (this.mClipDurations.size() > 0)
    {
      int i = this.mExoPlayer.getCurrentWindowIndex();
      while (i > 0)
      {
        i -= 1;
        l += ((Long)this.mClipDurations.get(i)).longValue();
      }
      return l + this.mExoPlayer.getCurrentPosition();
    }
    return this.mExoPlayer.getCurrentPosition();
  }
  
  public long getDuration()
  {
    Object localObject = this.mExoPlayer;
    long l = 0L;
    if (localObject == null) {
      return 0L;
    }
    if (this.mClipDurations.size() > 0)
    {
      localObject = this.mClipDurations.iterator();
      while (((Iterator)localObject).hasNext()) {
        l += ((Long)((Iterator)localObject).next()).longValue();
      }
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
    ExoPlayer localExoPlayer = this.mExoPlayer;
    if (localExoPlayer == null) {
      return false;
    }
    int i = localExoPlayer.getPlaybackState();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label51;
        }
        if (i != 4) {
          return false;
        }
      }
      return this.mIsLooping;
    }
    label51:
    return this.mExoPlayer.getPlayWhenReady();
  }
  
  public void pause()
  {
    ExoPlayer localExoPlayer = this.mExoPlayer;
    if (localExoPlayer == null) {
      return;
    }
    localExoPlayer.setPlayWhenReady(false);
  }
  
  public void prepareAsync()
  {
    getLogger().v("ExoMediaPlayer", "prepareAsync");
    Surface localSurface = this.mSurface;
    if (localSurface != null) {
      setSurface(localSurface);
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
      ExoPlayer localExoPlayer = this.mExoPlayer;
      if (localExoPlayer != null)
      {
        localExoPlayer.setPlayWhenReady(false);
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
    if (this.mClipDurations.size() > 0)
    {
      long l = 0L;
      int i = 0;
      while (i < this.mClipDurations.size())
      {
        l += ((Long)this.mClipDurations.get(i)).longValue();
        if (l > paramLong)
        {
          this.mExoPlayer.seekTo(i, paramLong - l + ((Long)this.mClipDurations.get(i)).longValue());
          break;
        }
        i += 1;
      }
    }
    this.mExoPlayer.seekTo(paramLong);
    ExoMediaPlayer.StateStore localStateStore = this.mStateStore;
    localStateStore.setMostRecentState(localStateStore.isLastReportedPlayWhenReady(), 100);
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
      long l1;
      if (((VideoMeta)localObject).endPosition == -1L) {
        l1 = ((VideoMeta)localObject).duration;
      } else {
        l1 = ((VideoMeta)localObject).endPosition;
      }
      l1 *= 1000L;
      if (l1 > l2)
      {
        long l3 = (l1 - l2) / 1000L;
        this.mClipDurations.add(Long.valueOf(l3));
        localObject = buildMediaSource(this.mAppContext, Uri.parse(((VideoMeta)localObject).uri), null);
        ((DynamicConcatenatingMediaSource)this.mMediaSource).addMediaSource(new ClippingMediaSource((MediaSource)localObject, l2, l1));
      }
      else
      {
        paramList = new StringBuilder();
        paramList.append("wrong range [");
        paramList.append(l2);
        paramList.append(",");
        paramList.append(l1);
        paramList.append("]");
        throw new IllegalArgumentException(paramList.toString());
      }
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
    ILogger localILogger = getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLooping ");
    localStringBuilder.append(this.mIsLooping);
    localILogger.i("ExoMediaPlayer", localStringBuilder.toString());
  }
  
  public void setNextMediaPlayer(MediaPlayerInterface paramMediaPlayerInterface)
  {
    paramMediaPlayerInterface = new StringBuilder();
    paramMediaPlayerInterface.append("setNextMediaPlayer is not supported by ");
    paramMediaPlayerInterface.append(ExoMediaPlayer.class.getSimpleName());
    throw new UnsupportedOperationException(paramMediaPlayerInterface.toString());
  }
  
  public void setOnBufferingUpdateListener(MediaPlayerInterface.OnBufferingUpdateListener paramOnBufferingUpdateListener)
  {
    this.mOnBufferingUpdateListener = paramOnBufferingUpdateListener;
    boolean bool;
    if (paramOnBufferingUpdateListener != null) {
      bool = true;
    } else {
      bool = false;
    }
    setBufferRepeaterStarted(bool);
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
    ExoPlayer localExoPlayer = this.mExoPlayer;
    if (localExoPlayer != null) {
      localExoPlayer.setSeekParameters(paramSeekParameters);
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
    PowerManager.WakeLock localWakeLock = this.mWakeLock;
    boolean bool;
    if (localWakeLock != null)
    {
      if (localWakeLock.isHeld())
      {
        bool = true;
        this.mWakeLock.release();
      }
      else
      {
        bool = false;
      }
      this.mWakeLock = null;
    }
    else
    {
      bool = false;
    }
    try
    {
      if (paramContext.getPackageManager().checkPermission("android.permission.WAKE_LOCK", paramContext.getPackageName()) == 0)
      {
        this.mWakeLock = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(paramInt | 0x20000000, ExoMediaPlayer.class.getName());
        this.mWakeLock.setReferenceCounted(false);
      }
      else
      {
        getLogger().w("ExoMediaPlayer", "Unable to acquire WAKE_LOCK due to missing manifest permission");
      }
    }
    catch (Exception paramContext)
    {
      getLogger().w("ExoMediaPlayer", "Unable to acquire WAKE_LOCK ", paramContext);
    }
    stayAwake(bool);
  }
  
  public void start()
  {
    ExoPlayer localExoPlayer = this.mExoPlayer;
    if (localExoPlayer == null) {
      return;
    }
    localExoPlayer.setPlayWhenReady(true);
    if ((!this.mFirstFrameDecodedEventSent) && (this.mFirstFrameDecoded))
    {
      notifyOnInfo(3, 0);
      this.mFirstFrameDecodedEventSent = true;
    }
  }
  
  public void stop()
  {
    if (this.mExoPlayer == null) {
      return;
    }
    if (!this.mStopped.getAndSet(true))
    {
      this.mExoPlayer.setPlayWhenReady(false);
      this.mExoPlayer.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayer
 * JD-Core Version:    0.7.0.1
 */