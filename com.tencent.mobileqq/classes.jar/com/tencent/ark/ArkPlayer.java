package com.tencent.ark;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.text.TextUtils;
import android.view.Surface;
import java.util.Locale;

public class ArkPlayer
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener, ark.PlayerStub
{
  protected static final ArkEnvironmentManager ENV = ;
  public static final String TAG = "ArkApp.ArkPlayer";
  public static final ark.PlayerStubFactory sFactory = new ArkPlayer.1();
  protected int mBufferPercent = 0;
  protected long mBufferingCallback = 0L;
  protected long mBufferingUserdata = 0L;
  protected int mErrorCode = 0;
  protected long mFrameCallback = 0L;
  protected long mFrameUserdata = 0L;
  protected ark.PlayerStub.MediaInfo mMediaInfo = new ark.PlayerStub.MediaInfo();
  protected boolean mPlayWhenReady;
  protected MediaPlayer mPlayer;
  protected String mQueueKey = ArkDispatchQueue.getCurrentQueueKey();
  protected double mSeekPos = -1.0D;
  protected long mStateCallback = 0L;
  protected long mStateUserdata = 0L;
  protected ArkPlayerSurfaceHolder mSurfaceHolder;
  
  protected ArkPlayer()
  {
    ENV.logI("ArkApp.ArkPlayer", String.format("player.create.%h", new Object[] { this }));
  }
  
  private void bufferingChange(boolean paramBoolean)
  {
    ArkDispatchQueue.asyncRun(this.mQueueKey, new ArkPlayer.4(this, paramBoolean));
  }
  
  private void changeState(int paramInt)
  {
    int i = this.mMediaInfo.state;
    this.mMediaInfo.state = paramInt;
    ArkDispatchQueue.asyncRun(this.mQueueKey, new ArkPlayer.3(this, i, paramInt));
  }
  
  public void Destroy()
  {
    ENV.logI("ArkApp.ArkPlayer", String.format("player.destroy.%h", new Object[] { this }));
    if (this.mSurfaceHolder != null)
    {
      this.mSurfaceHolder.deinitialize();
      this.mSurfaceHolder = null;
    }
    if (this.mPlayer != null)
    {
      this.mPlayer.release();
      this.mPlayer = null;
    }
  }
  
  public double GetBufferedTime()
  {
    if (this.mPlayer == null) {
      return 0.0D;
    }
    return this.mPlayer.getDuration() * this.mBufferPercent / 100000.0D;
  }
  
  public double GetCurrentTime()
  {
    if (this.mPlayer == null) {}
    while (this.mMediaInfo.state == 5) {
      return 0.0D;
    }
    if (this.mSeekPos >= 0.0D) {
      return this.mSeekPos;
    }
    return this.mPlayer.getCurrentPosition() / 1000.0D;
  }
  
  public int GetErrorCode()
  {
    return this.mErrorCode;
  }
  
  public ark.PlayerStub.MediaInfo GetMediaInfo()
  {
    return this.mMediaInfo;
  }
  
  public boolean Load(String paramString)
  {
    Object localObject = null;
    if (!VideoPreviewSupported())
    {
      ENV.logE("ArkApp.ArkPlayer", "Load.unsupport.hardware!!");
      this.mErrorCode = -4;
      changeState(6);
      return false;
    }
    int i;
    if ((VideoPreviewSupported()) && (this.mFrameCallback != 0L)) {
      i = 1;
    }
    while (i != 0) {
      if (this.mSurfaceHolder == null)
      {
        this.mSurfaceHolder = new ArkPlayerSurfaceHolder();
        if (!this.mSurfaceHolder.initialize())
        {
          this.mSurfaceHolder = null;
          ENV.logE("ArkApp.ArkPlayer", "Load.mSurfaceHolder.initialize.fail!!");
          return false;
          i = 0;
        }
        else
        {
          this.mSurfaceHolder.SetFrameCallback(this.mFrameCallback, this.mFrameUserdata);
        }
      }
      else
      {
        Surface localSurface = this.mSurfaceHolder.getSurface();
        localObject = localSurface;
        if (localSurface != null) {
          break label159;
        }
        ENV.logE("ArkApp.ArkPlayer", "Load.mSurfaceHolder.getSurface.null!!");
        return false;
      }
    }
    ENV.logI("ArkApp.ArkPlayer", "Load.not.support.hw.rendering.play.audio.only!!");
    label159:
    if (this.mMediaInfo.state == 1)
    {
      ENV.logE("ArkApp.ArkPlayer", "Load.state.is.loading!!");
      return false;
    }
    this.mErrorCode = 0;
    if (this.mPlayer == null) {
      this.mPlayer = new MediaPlayer();
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.mPlayer.reset();
      changeState(0);
      ENV.logI("ArkApp.ArkPlayer", "Load.url.is.null!!");
      return true;
    }
    if (this.mMediaInfo.state != 0) {
      this.mPlayer.reset();
    }
    this.mPlayer.setSurface(localObject);
    this.mPlayer.setOnPreparedListener(this);
    this.mPlayer.setOnCompletionListener(this);
    this.mPlayer.setOnInfoListener(this);
    this.mPlayer.setOnErrorListener(this);
    this.mPlayer.setOnBufferingUpdateListener(this);
    this.mPlayer.setOnSeekCompleteListener(this);
    if (i != 0) {
      this.mPlayer.setOnVideoSizeChangedListener(this);
    }
    this.mPlayWhenReady = false;
    ENV.logI("ArkApp.ArkPlayer", "ArkPlayer.load.setDataSource url=" + paramString);
    try
    {
      this.mPlayer.setDataSource(paramString);
      this.mPlayer.prepareAsync();
      changeState(1);
      return true;
    }
    catch (Exception paramString)
    {
      ENV.logE("ArkApp.ArkPlayer", "Load.mPlayer.setDataSource.fail!!" + paramString.getMessage());
    }
    return false;
  }
  
  public boolean Pause()
  {
    if (!VideoPreviewSupported())
    {
      ENV.logE("ArkApp.ArkPlayer", "Pause.unsupport.hardware!!");
      this.mErrorCode = -4;
      changeState(6);
    }
    while (this.mPlayer == null) {
      return false;
    }
    if (this.mMediaInfo.state != 3)
    {
      ENV.logE("ArkApp.ArkPlayer", String.format(Locale.CHINA, "Pause.wrong.state.%d!!", new Object[] { Integer.valueOf(this.mMediaInfo.state) }));
      return false;
    }
    try
    {
      this.mPlayer.pause();
      changeState(4);
      return true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      ENV.logD("ArkApp.ArkPlayer", localIllegalStateException.getLocalizedMessage());
    }
    return false;
  }
  
  public boolean Play()
  {
    if (!VideoPreviewSupported())
    {
      ENV.logE("ArkApp.ArkPlayer", "Play.unsupport.hardware!!");
      this.mErrorCode = -4;
      changeState(6);
    }
    while (this.mPlayer == null) {
      return false;
    }
    if ((this.mMediaInfo.state != 2) && (this.mMediaInfo.state != 4) && (this.mMediaInfo.state != 5) && (this.mMediaInfo.state != 3))
    {
      ENV.logE("ArkApp.ArkPlayer", String.format(Locale.CHINA, "Play.wrong.state.%d!!", new Object[] { Integer.valueOf(this.mMediaInfo.state) }));
      return false;
    }
    try
    {
      this.mSeekPos = 0.0D;
      if (this.mMediaInfo.state == 5)
      {
        this.mPlayWhenReady = true;
        this.mPlayer.prepareAsync();
        this.mMediaInfo.state = 1;
        return true;
      }
      if (this.mPlayer.getDuration() > 0) {
        this.mPlayer.seekTo(0);
      }
      this.mPlayer.start();
      changeState(3);
      return true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      ENV.logD("ArkApp.ArkPlayer", localIllegalStateException.getLocalizedMessage());
    }
    return false;
  }
  
  public boolean Resume()
  {
    if (!VideoPreviewSupported())
    {
      ENV.logE("ArkApp.ArkPlayer", "Resume.unsupport.hardware!!");
      this.mErrorCode = -4;
      changeState(6);
    }
    while (this.mPlayer == null) {
      return false;
    }
    if (this.mMediaInfo.state != 4)
    {
      ENV.logE("ArkApp.ArkPlayer", String.format(Locale.CHINA, "Resume.wrong.state.%d!!", new Object[] { Integer.valueOf(this.mMediaInfo.state) }));
      return false;
    }
    try
    {
      this.mPlayer.start();
      changeState(3);
      return true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      ENV.logD("ArkApp.ArkPlayer", localIllegalStateException.getLocalizedMessage());
    }
    return false;
  }
  
  public boolean Seek(double paramDouble)
  {
    double d = 0.0D;
    if (!VideoPreviewSupported())
    {
      ENV.logE("ArkApp.ArkPlayer", "Seek.unsupport.hardware!!");
      this.mErrorCode = -4;
      changeState(6);
    }
    while (this.mPlayer == null) {
      return false;
    }
    if ((this.mMediaInfo.state != 2) && (this.mMediaInfo.state != 4) && (this.mMediaInfo.state != 3))
    {
      ENV.logE("ArkApp.ArkPlayer", String.format(Locale.CHINA, "Seek.wrong.state.%d!!", new Object[] { Integer.valueOf(this.mMediaInfo.state) }));
      return false;
    }
    if (paramDouble < 0.0D) {
      paramDouble = d;
    }
    for (;;)
    {
      d = paramDouble;
      try
      {
        if (paramDouble > this.mMediaInfo.duration) {
          d = this.mMediaInfo.duration;
        }
        this.mPlayer.seekTo((int)(1000.0D * d));
        this.mSeekPos = d;
        return true;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        ENV.logD("ArkApp.ArkPlayer", localIllegalStateException.getLocalizedMessage());
      }
    }
    return false;
  }
  
  public void SetBufferingCallback(long paramLong1, long paramLong2)
  {
    this.mBufferingCallback = paramLong1;
    this.mBufferingUserdata = paramLong2;
  }
  
  public void SetFrameCallback(long paramLong1, long paramLong2)
  {
    this.mFrameCallback = paramLong1;
    this.mFrameUserdata = paramLong2;
    if (this.mSurfaceHolder != null) {
      this.mSurfaceHolder.SetFrameCallback(paramLong1, paramLong2);
    }
  }
  
  public void SetOutputSizeHint(int paramInt1, int paramInt2) {}
  
  public void SetStateCallback(long paramLong1, long paramLong2)
  {
    this.mStateCallback = paramLong1;
    this.mStateUserdata = paramLong2;
  }
  
  public boolean SetVolume(float paramFloat)
  {
    float f = 1.0F;
    if (!VideoPreviewSupported())
    {
      ENV.logE("ArkApp.ArkPlayer", "SetVolume.unsupport.hardware!!");
      this.mErrorCode = -4;
      changeState(6);
      return false;
    }
    if ((this.mMediaInfo.state != 2) && (this.mMediaInfo.state != 4) && (this.mMediaInfo.state != 3) && (this.mMediaInfo.state != 5))
    {
      ENV.logE("ArkApp.ArkPlayer", String.format(Locale.CHINA, "SetVolume.wrong.state.%d!!", new Object[] { Integer.valueOf(this.mMediaInfo.state) }));
      return false;
    }
    if (this.mPlayer == null) {
      return false;
    }
    if (paramFloat < 0.0F)
    {
      paramFloat = 0.0F;
      if (paramFloat <= 1.0F) {
        break label153;
      }
      paramFloat = f;
    }
    label153:
    for (;;)
    {
      this.mPlayer.setVolume(paramFloat, paramFloat);
      return true;
      break;
    }
  }
  
  public boolean Stop()
  {
    if (!VideoPreviewSupported())
    {
      ENV.logE("ArkApp.ArkPlayer", "Stop.unsupport.hardware!!");
      this.mErrorCode = -4;
      changeState(6);
    }
    while (this.mPlayer == null) {
      return false;
    }
    if ((this.mMediaInfo.state == 1) || (this.mMediaInfo.state == 0))
    {
      ENV.logE("ArkApp.ArkPlayer", String.format(Locale.CHINA, "Stop.wrong.state.%d!!", new Object[] { Integer.valueOf(this.mMediaInfo.state) }));
      return false;
    }
    try
    {
      this.mPlayer.stop();
      changeState(5);
      return true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      ENV.logD("ArkApp.ArkPlayer", localIllegalStateException.getLocalizedMessage());
    }
    return false;
  }
  
  public boolean VideoPreviewSupported()
  {
    return true;
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    this.mBufferPercent = paramInt;
    if (ENV.mIsDebug) {
      ENV.logD("ArkApp.ArkPlayer", String.format(Locale.CHINA, "onBufferingUpdate.%d", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (ENV.mIsDebug) {
      ENV.logD("ArkApp.ArkPlayer", "onCompletion.call!!");
    }
    paramMediaPlayer.stop();
    changeState(5);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    ENV.logE("ArkApp.ArkPlayer", String.format(Locale.CHINA, "onError.what.%d.extra.%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    switch (paramInt1)
    {
    default: 
      this.mErrorCode = -1;
    }
    for (;;)
    {
      changeState(6);
      return true;
      this.mErrorCode = -2;
      continue;
      this.mErrorCode = -3;
    }
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (ENV.mIsDebug) {
      ENV.logD("ArkApp.ArkPlayer", String.format(Locale.CHINA, "onInfo.what.%d.extra.%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    switch (paramInt1)
    {
    default: 
      return true;
    case 701: 
      bufferingChange(true);
      return true;
    }
    bufferingChange(false);
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    boolean bool = true;
    if (ENV.mIsDebug) {
      ENV.logD("ArkApp.ArkPlayer", "onPrepared.call!!");
    }
    int j = paramMediaPlayer.getDuration();
    int k = paramMediaPlayer.getVideoWidth();
    int m = paramMediaPlayer.getVideoHeight();
    paramMediaPlayer = this.mMediaInfo;
    int i;
    if ((k > 0) && (m > 0))
    {
      i = 0;
      paramMediaPlayer.type = i;
      this.mMediaInfo.duration = (j / 1000.0D);
      paramMediaPlayer = this.mMediaInfo;
      if (j > 0) {
        break label184;
      }
    }
    for (;;)
    {
      paramMediaPlayer.islive = bool;
      if (this.mSurfaceHolder != null) {
        this.mSurfaceHolder.SetFrameSize(this.mMediaInfo.width, this.mMediaInfo.height);
      }
      if (VideoPreviewSupported())
      {
        this.mMediaInfo.width = k;
        this.mMediaInfo.height = m;
      }
      if (!this.mPlayWhenReady) {
        break label190;
      }
      this.mPlayWhenReady = false;
      this.mMediaInfo.state = 2;
      ArkDispatchQueue.asyncRun(this.mQueueKey, new ArkPlayer.2(this));
      return;
      i = 1;
      break;
      label184:
      bool = false;
    }
    label190:
    changeState(2);
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (ENV.mIsDebug) {
      ENV.logD("ArkApp.ArkPlayer", String.format(Locale.CHINA, "onSeekComplete.pos.%.3f", new Object[] { Double.valueOf(this.mSeekPos) }));
    }
    this.mSeekPos = -1.0D;
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (ENV.mIsDebug) {
      ENV.logD("ArkApp.ArkPlayer", String.format(Locale.CHINA, "onVideoSizeChanged.%d.%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (VideoPreviewSupported())
    {
      this.mMediaInfo.width = paramInt1;
      this.mMediaInfo.height = paramInt2;
    }
    if (this.mSurfaceHolder != null) {
      this.mSurfaceHolder.SetFrameSize(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ArkPlayer
 * JD-Core Version:    0.7.0.1
 */