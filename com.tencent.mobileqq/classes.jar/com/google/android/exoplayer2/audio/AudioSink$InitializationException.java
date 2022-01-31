package com.google.android.exoplayer2.audio;

public final class AudioSink$InitializationException
  extends Exception
{
  public final int audioTrackState;
  
  public AudioSink$InitializationException(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super("AudioTrack init failed: " + paramInt1 + ", Config(" + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + ")");
    this.audioTrackState = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.AudioSink.InitializationException
 * JD-Core Version:    0.7.0.1
 */