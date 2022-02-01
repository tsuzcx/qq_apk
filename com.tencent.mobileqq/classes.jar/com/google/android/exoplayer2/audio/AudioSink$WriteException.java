package com.google.android.exoplayer2.audio;

public final class AudioSink$WriteException
  extends Exception
{
  public final int errorCode;
  
  public AudioSink$WriteException(int paramInt)
  {
    super("AudioTrack write failed: " + paramInt);
    this.errorCode = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioSink.WriteException
 * JD-Core Version:    0.7.0.1
 */