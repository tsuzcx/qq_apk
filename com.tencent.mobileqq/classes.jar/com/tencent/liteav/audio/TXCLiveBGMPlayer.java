package com.tencent.liteav.audio;

import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public class TXCLiveBGMPlayer
  implements TXAudioEffectManager.TXMusicPlayObserver
{
  private static final int PLAY_ERR_OPEN = -1;
  private static final int PLAY_SUCCESS = 0;
  private static final String TAG = "AudioCenter:TXCLiveBGMPlayer";
  private int mBGMId = 2147483647;
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  private boolean mIsPause = false;
  private boolean mIsRunning = false;
  private WeakReference<f> mWeakListener = null;
  
  static
  {
    com.tencent.liteav.basic.util.f.f();
  }
  
  public static TXCLiveBGMPlayer getInstance()
  {
    return TXCLiveBGMPlayer.a.a();
  }
  
  private void onPlayEnd(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.mWeakListener != null)
        {
          f localf = (f)this.mWeakListener.get();
          this.mHandler.post(new TXCLiveBGMPlayer.2(this, localf, paramInt));
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  private void onPlayProgress(long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        if (this.mWeakListener != null)
        {
          f localf = (f)this.mWeakListener.get();
          this.mHandler.post(new TXCLiveBGMPlayer.3(this, localf, paramLong1, paramLong2));
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  private void onPlayStart(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.mWeakListener != null)
        {
          f localf = (f)this.mWeakListener.get();
          this.mHandler.post(new TXCLiveBGMPlayer.1(this, localf));
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public int getBGMDuration(String paramString)
  {
    return (int)TXAudioEffectManagerImpl.getInstance().getMusicDurationInMS(paramString);
  }
  
  public long getBGMGetCurrentProgressInMs(String paramString)
  {
    if (paramString == null) {
      return TXAudioEffectManagerImpl.getInstance().getMusicCurrentPosInMS(this.mBGMId);
    }
    return 0L;
  }
  
  public boolean isPlaying()
  {
    return this.mIsRunning;
  }
  
  public boolean isRunning()
  {
    return (this.mIsRunning) && (!this.mIsPause);
  }
  
  public void onComplete(int paramInt1, int paramInt2)
  {
    onPlayEnd(paramInt2);
  }
  
  public void onPlayProgress(int paramInt, long paramLong1, long paramLong2)
  {
    onPlayProgress(paramLong1, paramLong2);
  }
  
  public void onStart(int paramInt1, int paramInt2)
  {
    onPlayStart(paramInt2);
  }
  
  public boolean pause()
  {
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", "pause");
    this.mIsPause = true;
    TXAudioEffectManagerImpl.getInstance().pausePlayMusic(this.mBGMId);
    return true;
  }
  
  public boolean resume()
  {
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", "resume");
    this.mIsPause = false;
    TXAudioEffectManagerImpl.getInstance().resumePlayMusic(this.mBGMId);
    return true;
  }
  
  public void setBGMPosition(int paramInt)
  {
    TXAudioEffectManagerImpl.getInstance().seekMusicToPosInMS(this.mBGMId, paramInt);
  }
  
  public void setOnPlayListener(f paramf)
  {
    if (paramf == null) {}
    try
    {
      this.mWeakListener = null;
      this.mWeakListener = new WeakReference(paramf);
      return;
    }
    finally {}
  }
  
  public void setPitch(float paramFloat)
  {
    TXAudioEffectManagerImpl.getInstance().setMusicPitch(this.mBGMId, paramFloat);
  }
  
  public boolean setPlayoutVolume(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPlayoutVolume:");
    localStringBuilder.append(paramFloat);
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", localStringBuilder.toString());
    TXAudioEffectManagerImpl.getInstance().setMusicPlayoutVolume(this.mBGMId, (int)(paramFloat * 100.0F));
    return true;
  }
  
  public boolean setPublishVolume(float paramFloat)
  {
    TXAudioEffectManagerImpl.getInstance().setMusicPublishVolume(this.mBGMId, (int)(paramFloat * 100.0F));
    return true;
  }
  
  public boolean setVolume(float paramFloat)
  {
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", "setVolume");
    TXAudioEffectManagerImpl.getInstance().setMusicVolume(this.mBGMId, (int)(paramFloat * 100.0F));
    return true;
  }
  
  public boolean startPlay(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      this.mIsRunning = true;
      Object localObject = new TXAudioEffectManager.AudioMusicParam(this.mBGMId, paramString);
      ((TXAudioEffectManager.AudioMusicParam)localObject).publish = true;
      ((TXAudioEffectManager.AudioMusicParam)localObject).loopCount = 0;
      boolean bool = TXAudioEffectManagerImpl.getInstance().startPlayMusic((TXAudioEffectManager.AudioMusicParam)localObject);
      TXAudioEffectManagerImpl.getInstance().setMusicObserver(this.mBGMId, this);
      if (!bool)
      {
        onPlayEnd(-1);
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start bgm play : filePath = ");
      ((StringBuilder)localObject).append(paramString);
      TXCLog.i("AudioCenter:TXCLiveBGMPlayer", ((StringBuilder)localObject).toString());
      return true;
    }
    TXCLog.e("AudioCenter:TXCLiveBGMPlayer", "start live bgm failed! invalid params!");
    return false;
  }
  
  public void stopAll()
  {
    TXAudioEffectManagerImpl.getInstance().stopAllMusics();
    TXAudioEffectManagerImpl.getAutoCacheHolder().stopAllMusics();
    TXAudioEffectManagerImpl.getCacheInstance().stopAllMusics();
  }
  
  public boolean stopPlay()
  {
    this.mIsRunning = false;
    long l = System.currentTimeMillis();
    TXAudioEffectManagerImpl.getInstance().setMusicObserver(this.mBGMId, null);
    TXAudioEffectManagerImpl.getInstance().stopPlayMusic(this.mBGMId);
    this.mIsPause = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopBGMPlay cost(MS): ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    TXCLog.i("AudioCenter:TXCLiveBGMPlayer", localStringBuilder.toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCLiveBGMPlayer
 * JD-Core Version:    0.7.0.1
 */