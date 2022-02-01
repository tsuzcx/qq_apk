package com.tencent.liteav.audio.impl.Play;

import android.content.Context;
import com.tencent.liteav.basic.log.TXCLog;

public class TXCMultAudioTrackPlayer
{
  private static final String TAG;
  private int mAudioMode = 0;
  private TXCMultAudioTrackPlayer.AudioTrackThread mAudioThread = null;
  private volatile boolean mAudioTrackStarted = false;
  private int mBits = 16;
  private int mChannel = 2;
  private Context mContext = null;
  private volatile boolean mIsStarted = false;
  private boolean mMute = false;
  private int mSampleRate = 48000;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioCenter:");
    localStringBuilder.append(TXCMultAudioTrackPlayer.class.getSimpleName());
    TAG = localStringBuilder.toString();
  }
  
  private TXCMultAudioTrackPlayer()
  {
    nativeClassInit();
  }
  
  public static TXCMultAudioTrackPlayer getInstance()
  {
    return TXCMultAudioTrackPlayer.TXCMultAudioTrackPlayerHolder.getInstance();
  }
  
  private native void nativeClassInit();
  
  private native byte[] nativeGetMixedTracksDataToAudioTrack();
  
  public boolean isPlaying()
  {
    return this.mIsStarted;
  }
  
  public void setAudioMode(Context paramContext, int paramInt)
  {
    try
    {
      this.mContext = paramContext;
      this.mAudioMode = paramInt;
      if (this.mAudioTrackStarted) {
        TXCLog.w(TAG, "mult-track-player setAudioRoute~");
      } else {
        TXCLog.w(TAG, "mult-track-player do'not setAudioRoute~");
      }
      return;
    }
    finally {}
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.mMute = paramBoolean;
  }
  
  public void start()
  {
    TXCLog.w(TAG, "mult-track-player start!");
    if (this.mIsStarted)
    {
      TXCLog.e(TAG, "mult-track-player can not start because of has started!");
      return;
    }
    if ((this.mSampleRate != 0) && (this.mChannel != 0))
    {
      this.mIsStarted = true;
      if (this.mAudioThread == null)
      {
        this.mAudioThread = new TXCMultAudioTrackPlayer.1(this, "AUDIO_TRACK");
        this.mAudioThread.startLoop();
        this.mAudioThread.start();
      }
      TXCLog.w(TAG, "mult-track-player thread start finish!");
      return;
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("strat mult-track-player failed with invalid audio info , samplerate:");
    localStringBuilder.append(this.mSampleRate);
    localStringBuilder.append(", channels:");
    localStringBuilder.append(this.mChannel);
    TXCLog.e(str, localStringBuilder.toString());
  }
  
  public void stop()
  {
    TXCLog.w(TAG, "mult-track-player stop!");
    if (!this.mIsStarted)
    {
      TXCLog.w(TAG, "mult-track-player can not stop because of not started yet!");
      return;
    }
    TXCMultAudioTrackPlayer.AudioTrackThread localAudioTrackThread = this.mAudioThread;
    if (localAudioTrackThread != null)
    {
      localAudioTrackThread.stopLoop();
      this.mAudioThread = null;
    }
    this.mAudioMode = 0;
    this.mContext = null;
    this.mAudioTrackStarted = false;
    this.mIsStarted = false;
    TXCLog.w(TAG, "mult-track-player stop finish!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.Play.TXCMultAudioTrackPlayer
 * JD-Core Version:    0.7.0.1
 */