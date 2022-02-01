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
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;

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
    Logger.logI("ArkApp.ArkPlayer", String.format("player.create.%h", new Object[] { this }));
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
    Logger.logI("ArkApp.ArkPlayer", String.format("player.destroy.%h", new Object[] { this }));
    Object localObject = this.mSurfaceHolder;
    if (localObject != null)
    {
      ((ArkPlayerSurfaceHolder)localObject).deinitialize();
      this.mSurfaceHolder = null;
    }
    localObject = this.mPlayer;
    if (localObject != null)
    {
      ((MediaPlayer)localObject).release();
      this.mPlayer = null;
    }
  }
  
  public double GetBufferedTime()
  {
    MediaPlayer localMediaPlayer = this.mPlayer;
    if (localMediaPlayer == null) {
      return 0.0D;
    }
    try
    {
      double d1 = localMediaPlayer.getDuration();
      int i = this.mBufferPercent;
      double d2 = i;
      Double.isNaN(d1);
      Double.isNaN(d2);
      return d1 * d2 / 100000.0D;
    }
    catch (Exception localException)
    {
      Logger.logE("ArkApp.ArkPlayer", localException.getLocalizedMessage());
    }
    return 0.0D;
  }
  
  public double GetCurrentTime()
  {
    if (this.mPlayer == null) {
      return 0.0D;
    }
    if (this.mMediaInfo.state == 5) {
      return 0.0D;
    }
    double d = this.mSeekPos;
    if (d >= 0.0D) {
      return d;
    }
    try
    {
      int i = this.mPlayer.getCurrentPosition();
      d = i;
      Double.isNaN(d);
      return d / 1000.0D;
    }
    catch (Exception localException)
    {
      Logger.logE("ArkApp.ArkPlayer", localException.getLocalizedMessage());
    }
    return 0.0D;
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
    if (!VideoPreviewSupported())
    {
      Logger.logE("ArkApp.ArkPlayer", "Load.unsupport.hardware!!");
      this.mErrorCode = -4;
      changeState(6);
      return false;
    }
    int i;
    if ((VideoPreviewSupported()) && (this.mFrameCallback != 0L)) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = null;
    if (i != 0)
    {
      if (this.mSurfaceHolder == null)
      {
        this.mSurfaceHolder = new ArkPlayerSurfaceHolder();
        if (!this.mSurfaceHolder.initialize())
        {
          this.mSurfaceHolder = null;
          Logger.logE("ArkApp.ArkPlayer", "Load.mSurfaceHolder.initialize.fail!!");
          return false;
        }
        this.mSurfaceHolder.SetFrameCallback(this.mFrameCallback, this.mFrameUserdata);
      }
      Surface localSurface = this.mSurfaceHolder.getSurface();
      localObject = localSurface;
      if (localSurface == null)
      {
        Logger.logE("ArkApp.ArkPlayer", "Load.mSurfaceHolder.getSurface.null!!");
        return false;
      }
    }
    else
    {
      Logger.logI("ArkApp.ArkPlayer", "Load.not.support.hw.rendering.play.audio.only!!");
    }
    if (this.mMediaInfo.state == 1)
    {
      Logger.logE("ArkApp.ArkPlayer", "Load.state.is.loading!!");
      return false;
    }
    this.mErrorCode = 0;
    if (this.mPlayer == null) {
      this.mPlayer = new ReportMediaPlayer();
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.mPlayer.reset();
      changeState(0);
      Logger.logI("ArkApp.ArkPlayer", "Load.url.is.null!!");
      return true;
    }
    if (this.mMediaInfo.state != 0) {
      this.mPlayer.reset();
    }
    this.mPlayer.setSurface((Surface)localObject);
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
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ArkPlayer.load.setDataSource url=");
    ((StringBuilder)localObject).append(paramString);
    Logger.logI("ArkApp.ArkPlayer", ((StringBuilder)localObject).toString());
    try
    {
      this.mPlayer.setDataSource(paramString);
      this.mPlayer.prepareAsync();
      changeState(1);
      return true;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Load.mPlayer.setDataSource.fail!!");
      ((StringBuilder)localObject).append(paramString.getMessage());
      Logger.logE("ArkApp.ArkPlayer", ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public boolean Pause()
  {
    if (!VideoPreviewSupported())
    {
      Logger.logE("ArkApp.ArkPlayer", "Pause.unsupport.hardware!!");
      this.mErrorCode = -4;
      changeState(6);
      return false;
    }
    if (this.mPlayer == null) {
      return false;
    }
    if (this.mMediaInfo.state != 3)
    {
      Logger.logE("ArkApp.ArkPlayer", StringUtil.format("Pause.wrong.state.%d!!", new Object[] { Integer.valueOf(this.mMediaInfo.state) }));
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
      Logger.logE("ArkApp.ArkPlayer", localIllegalStateException.getLocalizedMessage());
    }
    return false;
  }
  
  public boolean Play()
  {
    if (!VideoPreviewSupported())
    {
      Logger.logE("ArkApp.ArkPlayer", "Play.unsupport.hardware!!");
      this.mErrorCode = -4;
      changeState(6);
      return false;
    }
    if (this.mPlayer == null) {
      return false;
    }
    if ((this.mMediaInfo.state != 2) && (this.mMediaInfo.state != 4) && (this.mMediaInfo.state != 5) && (this.mMediaInfo.state != 3))
    {
      Logger.logE("ArkApp.ArkPlayer", StringUtil.format("Play.wrong.state.%d!!", new Object[] { Integer.valueOf(this.mMediaInfo.state) }));
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
      Logger.logE("ArkApp.ArkPlayer", localIllegalStateException.getLocalizedMessage());
    }
    return false;
  }
  
  public boolean Resume()
  {
    if (!VideoPreviewSupported())
    {
      Logger.logE("ArkApp.ArkPlayer", "Resume.unsupport.hardware!!");
      this.mErrorCode = -4;
      changeState(6);
      return false;
    }
    if (this.mPlayer == null) {
      return false;
    }
    if (this.mMediaInfo.state != 4)
    {
      Logger.logE("ArkApp.ArkPlayer", StringUtil.format("Resume.wrong.state.%d!!", new Object[] { Integer.valueOf(this.mMediaInfo.state) }));
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
      Logger.logE("ArkApp.ArkPlayer", localIllegalStateException.getLocalizedMessage());
    }
    return false;
  }
  
  public boolean Seek(double paramDouble)
  {
    if (!VideoPreviewSupported())
    {
      Logger.logE("ArkApp.ArkPlayer", "Seek.unsupport.hardware!!");
      this.mErrorCode = -4;
      changeState(6);
      return false;
    }
    if (this.mPlayer == null) {
      return false;
    }
    if ((this.mMediaInfo.state != 2) && (this.mMediaInfo.state != 4) && (this.mMediaInfo.state != 3))
    {
      Logger.logE("ArkApp.ArkPlayer", StringUtil.format("Seek.wrong.state.%d!!", new Object[] { Integer.valueOf(this.mMediaInfo.state) }));
      return false;
    }
    double d = paramDouble;
    if (paramDouble < 0.0D) {
      d = 0.0D;
    }
    paramDouble = d;
    try
    {
      if (d > this.mMediaInfo.duration) {
        paramDouble = this.mMediaInfo.duration;
      }
      this.mPlayer.seekTo((int)(1000.0D * paramDouble));
      this.mSeekPos = paramDouble;
      return true;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logger.logE("ArkApp.ArkPlayer", localIllegalStateException.getLocalizedMessage());
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
    ArkPlayerSurfaceHolder localArkPlayerSurfaceHolder = this.mSurfaceHolder;
    if (localArkPlayerSurfaceHolder != null) {
      localArkPlayerSurfaceHolder.SetFrameCallback(paramLong1, paramLong2);
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
    if (!VideoPreviewSupported())
    {
      Logger.logE("ArkApp.ArkPlayer", "SetVolume.unsupport.hardware!!");
      this.mErrorCode = -4;
      changeState(6);
      return false;
    }
    if ((this.mMediaInfo.state != 2) && (this.mMediaInfo.state != 4) && (this.mMediaInfo.state != 3) && (this.mMediaInfo.state != 5))
    {
      Logger.logE("ArkApp.ArkPlayer", StringUtil.format("SetVolume.wrong.state.%d!!", new Object[] { Integer.valueOf(this.mMediaInfo.state) }));
      return false;
    }
    if (this.mPlayer == null) {
      return false;
    }
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    paramFloat = f;
    if (f > 1.0F) {
      paramFloat = 1.0F;
    }
    try
    {
      this.mPlayer.setVolume(paramFloat, paramFloat);
      return true;
    }
    catch (Exception localException)
    {
      Logger.logE("ArkApp.ArkPlayer", localException.getLocalizedMessage());
    }
    return true;
  }
  
  public boolean Stop()
  {
    if (!VideoPreviewSupported())
    {
      Logger.logE("ArkApp.ArkPlayer", "Stop.unsupport.hardware!!");
      this.mErrorCode = -4;
      changeState(6);
      return false;
    }
    if (this.mPlayer == null) {
      return false;
    }
    if ((this.mMediaInfo.state != 1) && (this.mMediaInfo.state != 0)) {
      try
      {
        this.mPlayer.stop();
        changeState(5);
        return true;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Logger.logE("ArkApp.ArkPlayer", localIllegalStateException.getLocalizedMessage());
        return false;
      }
    }
    Logger.logE("ArkApp.ArkPlayer", StringUtil.format("Stop.wrong.state.%d!!", new Object[] { Integer.valueOf(this.mMediaInfo.state) }));
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
      Logger.logD("ArkApp.ArkPlayer", StringUtil.format("onBufferingUpdate.%d", new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (ENV.mIsDebug) {
      Logger.logD("ArkApp.ArkPlayer", "onCompletion.call!!");
    }
    try
    {
      paramMediaPlayer.stop();
    }
    catch (Exception paramMediaPlayer)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCompletion, exception!! ");
      localStringBuilder.append(paramMediaPlayer.getMessage());
      Logger.logE("ArkApp.ArkPlayer", localStringBuilder.toString());
    }
    changeState(5);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    Logger.logE("ArkApp.ArkPlayer", StringUtil.format("onError.what.%d.extra.%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (paramInt1 != -1010)
    {
      if ((paramInt1 != -1007) && (paramInt1 != -1004) && (paramInt1 != -110) && (paramInt1 != 100)) {
        this.mErrorCode = -1;
      } else {
        this.mErrorCode = -3;
      }
    }
    else {
      this.mErrorCode = -2;
    }
    changeState(6);
    return true;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (ENV.mIsDebug) {
      Logger.logD("ArkApp.ArkPlayer", StringUtil.format("onInfo.what.%d.extra.%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (paramInt1 != 701)
    {
      if (paramInt1 != 702) {
        return true;
      }
      bufferingChange(false);
      return true;
    }
    bufferingChange(true);
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    Logger.logI("ArkApp.ArkPlayer", "onPrepared.call!!");
    for (;;)
    {
      try
      {
        int j = paramMediaPlayer.getDuration();
        int k = paramMediaPlayer.getVideoWidth();
        int m = paramMediaPlayer.getVideoHeight();
        paramMediaPlayer = this.mMediaInfo;
        bool = true;
        if ((k > 0) && (m > 0))
        {
          i = 0;
          paramMediaPlayer.type = i;
          paramMediaPlayer = this.mMediaInfo;
          double d = j;
          Double.isNaN(d);
          d /= 1000.0D;
          paramMediaPlayer.duration = d;
          paramMediaPlayer = this.mMediaInfo;
          if (j > 0) {
            break label241;
          }
          paramMediaPlayer.islive = bool;
          if (this.mSurfaceHolder != null) {
            this.mSurfaceHolder.SetFrameSize(this.mMediaInfo.width, this.mMediaInfo.height);
          }
          if (VideoPreviewSupported())
          {
            this.mMediaInfo.width = k;
            this.mMediaInfo.height = m;
          }
          if (this.mPlayWhenReady)
          {
            this.mPlayWhenReady = false;
            this.mMediaInfo.state = 2;
            ArkDispatchQueue.asyncRun(this.mQueueKey, new ArkPlayer.2(this));
            return;
          }
          changeState(2);
          return;
        }
      }
      catch (IllegalStateException paramMediaPlayer)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPrepared, exception!! ");
        localStringBuilder.append(paramMediaPlayer.getMessage());
        Logger.logE("ArkApp.ArkPlayer", localStringBuilder.toString());
        return;
      }
      int i = 1;
      continue;
      label241:
      boolean bool = false;
    }
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (ENV.mIsDebug) {
      Logger.logD("ArkApp.ArkPlayer", StringUtil.format("onSeekComplete.pos.%.3f", new Object[] { Double.valueOf(this.mSeekPos) }));
    }
    this.mSeekPos = -1.0D;
  }
  
  public void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (ENV.mIsDebug) {
      Logger.logD("ArkApp.ArkPlayer", StringUtil.format("onVideoSizeChanged.%d.%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (VideoPreviewSupported())
    {
      paramMediaPlayer = this.mMediaInfo;
      paramMediaPlayer.width = paramInt1;
      paramMediaPlayer.height = paramInt2;
    }
    paramMediaPlayer = this.mSurfaceHolder;
    if (paramMediaPlayer != null) {
      paramMediaPlayer.SetFrameSize(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkPlayer
 * JD-Core Version:    0.7.0.1
 */