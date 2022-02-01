package com.tencent.liteav.audio;

import com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;

public class TXCUGCBGMPlayer
  implements TXAudioEffectManager.TXMusicPlayObserver
{
  private static final int PLAY_ERR_OPEN = -1;
  private static final int PLAY_SUCCESS = 0;
  private static final String TAG = "AudioCenter:TXCUGCBGMPlayer";
  private int mBGMId = -2147483648;
  private long mEndTimeMS = 0L;
  private boolean mIsRunning = false;
  private long mSeekBytes = 0L;
  private float mSpeedRate = 1.0F;
  private long mStartTimeMS = 0L;
  private float mVolume = 1.0F;
  private WeakReference<h> mWeakListener = null;
  
  static
  {
    com.tencent.liteav.basic.util.h.f();
  }
  
  private TXCUGCBGMPlayer()
  {
    TXCMultAudioTrackPlayer.getInstance();
  }
  
  public static TXCUGCBGMPlayer getInstance()
  {
    return TXCUGCBGMPlayer.a.a();
  }
  
  private void onPlayEnd(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.mWeakListener != null)
        {
          h localh = (h)this.mWeakListener.get();
          if (localh != null) {
            localh.onPlayEnd(paramInt);
          }
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
          h localh = (h)this.mWeakListener.get();
          if (localh != null) {
            localh.onPlayProgress(paramLong1, paramLong2);
          }
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  private void onPlayStart()
  {
    for (;;)
    {
      try
      {
        if (this.mWeakListener != null)
        {
          h localh = (h)this.mWeakListener.get();
          if (localh != null) {
            localh.onPlayStart();
          }
          return;
        }
      }
      finally {}
      Object localObject2 = null;
    }
  }
  
  public long getDurationMS(String paramString)
  {
    return TXAudioEffectManagerImpl.getCacheInstance().getMusicDurationInMS(paramString);
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
    onPlayStart();
  }
  
  public void pause()
  {
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "pause");
    TXAudioEffectManagerImpl.getCacheInstance().pausePlayMusic(this.mBGMId);
  }
  
  public void playFromTime(long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startPlayRange:");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramLong2);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", localStringBuilder.toString());
    this.mStartTimeMS = paramLong1;
    this.mEndTimeMS = paramLong2;
  }
  
  public void resume()
  {
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "resume");
    TXAudioEffectManagerImpl.getCacheInstance().resumePlayMusic(this.mBGMId);
  }
  
  public void seekBytes(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong < 0L)
    {
      TXCLog.e("AudioCenter:TXCUGCBGMPlayer", "seek bytes can not be negative. change to 0");
      l1 = 0L;
    }
    long l2 = TXAudioEffectManagerImpl.getCacheInstance().getAvailableBGMBytes(this.mBGMId);
    paramLong = l1;
    if (l2 > 0L) {
      paramLong = l1 % l2;
    }
    this.mSeekBytes = paramLong;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mSeekBytes:");
    localStringBuilder.append(this.mSeekBytes);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", localStringBuilder.toString());
    TXAudioEffectManagerImpl.getCacheInstance().seekMusicToPosInBytes(this.mBGMId, paramLong);
  }
  
  public void setChangerType(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("changerType:");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", localStringBuilder.toString());
    TXAudioEffectManagerImpl.getCacheInstance().setMusicChangerType(this.mBGMId, paramInt);
  }
  
  public void setOnPlayListener(h paramh)
  {
    if (paramh == null) {}
    try
    {
      this.mWeakListener = null;
      this.mWeakListener = new WeakReference(paramh);
      return;
    }
    finally {}
  }
  
  public void setReverbType(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("int reverbType:");
    localStringBuilder.append(paramInt);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", localStringBuilder.toString());
    TXAudioEffectManagerImpl.getCacheInstance().setMusicReverbType(this.mBGMId, paramInt);
  }
  
  public void setSpeedRate(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setSpeedRate:");
    localStringBuilder.append(paramFloat);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", localStringBuilder.toString());
    this.mSpeedRate = paramFloat;
    TXAudioEffectManagerImpl.getCacheInstance().setMusicPlayoutSpeedRate(this.mBGMId, paramFloat);
  }
  
  public void setVolume(float paramFloat)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setVolume:");
    localStringBuilder.append(paramFloat);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", localStringBuilder.toString());
    this.mVolume = paramFloat;
    TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(this.mBGMId, (int)(paramFloat * 100.0F));
  }
  
  public void startPlay(String paramString, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startPlay:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("record:");
    ((StringBuilder)localObject).append(paramBoolean);
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", ((StringBuilder)localObject).toString());
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return;
      }
      if (this.mIsRunning)
      {
        TXCLog.w("AudioCenter:TXCUGCBGMPlayer", "BGM is playing, restarting...");
        stopPlay();
      }
      this.mSeekBytes = 0L;
      this.mIsRunning = true;
      localObject = new TXAudioEffectManager.AudioMusicParam(this.mBGMId, paramString);
      ((TXAudioEffectManager.AudioMusicParam)localObject).publish = paramBoolean;
      ((TXAudioEffectManager.AudioMusicParam)localObject).loopCount = 0;
      ((TXAudioEffectManager.AudioMusicParam)localObject).startTimeMS = this.mStartTimeMS;
      ((TXAudioEffectManager.AudioMusicParam)localObject).endTimeMS = this.mEndTimeMS;
      ((TXAudioEffectManager.AudioMusicParam)localObject).isShortFile = true;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start bgm play : filePath = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" publish:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" startTimeMS:");
      localStringBuilder.append(this.mStartTimeMS);
      localStringBuilder.append(" endTimeMS:");
      localStringBuilder.append(this.mEndTimeMS);
      localStringBuilder.append(" isShortFile:");
      localStringBuilder.append(((TXAudioEffectManager.AudioMusicParam)localObject).isShortFile);
      localStringBuilder.append("mVolume:");
      localStringBuilder.append(this.mVolume);
      TXCLog.i("AudioCenter:TXCUGCBGMPlayer", localStringBuilder.toString());
      TXAudioEffectManagerImpl.getCacheInstance().setMusicVolume(this.mBGMId, (int)(this.mVolume * 100.0F));
      TXAudioEffectManagerImpl.getCacheInstance().setMusicPlayoutSpeedRate(this.mBGMId, this.mSpeedRate);
      if (paramBoolean) {
        TXAudioEffectManagerImpl.getCacheInstance().setMuteDataDurationToPublish(this.mBGMId, 200);
      }
      paramBoolean = TXAudioEffectManagerImpl.getCacheInstance().startPlayMusic((TXAudioEffectManager.AudioMusicParam)localObject);
      TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(this.mBGMId, this);
      if (!paramBoolean)
      {
        onPlayEnd(-1);
        return;
      }
      onPlayStart();
    }
  }
  
  public void stopPlay()
  {
    TXCLog.i("AudioCenter:TXCUGCBGMPlayer", "stopPlay");
    this.mIsRunning = false;
    long l = System.currentTimeMillis();
    try
    {
      TXAudioEffectManagerImpl.getCacheInstance().setMusicObserver(this.mBGMId, null);
      TXAudioEffectManagerImpl.getCacheInstance().stopPlayMusic(this.mBGMId);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopBGMPlay cost(MS): ");
      localStringBuilder.append(System.currentTimeMillis() - l);
      TXCLog.i("AudioCenter:TXCUGCBGMPlayer", localStringBuilder.toString());
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.TXCUGCBGMPlayer
 * JD-Core Version:    0.7.0.1
 */