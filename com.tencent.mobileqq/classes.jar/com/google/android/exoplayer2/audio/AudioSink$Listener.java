package com.google.android.exoplayer2.audio;

public abstract interface AudioSink$Listener
{
  public abstract boolean isNeedAudioData();
  
  public abstract void onAudioSessionId(int paramInt);
  
  public abstract void onPositionDiscontinuity();
  
  public abstract void onRenderAudioData(byte[] paramArrayOfByte);
  
  public abstract void onUnderrun(int paramInt, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioSink.Listener
 * JD-Core Version:    0.7.0.1
 */