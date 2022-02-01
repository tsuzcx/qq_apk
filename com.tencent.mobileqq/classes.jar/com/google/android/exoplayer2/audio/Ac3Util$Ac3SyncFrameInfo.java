package com.google.android.exoplayer2.audio;

public final class Ac3Util$Ac3SyncFrameInfo
{
  public static final int STREAM_TYPE_TYPE0 = 0;
  public static final int STREAM_TYPE_TYPE1 = 1;
  public static final int STREAM_TYPE_TYPE2 = 2;
  public static final int STREAM_TYPE_UNDEFINED = -1;
  public final int channelCount;
  public final int frameSize;
  public final String mimeType;
  public final int sampleCount;
  public final int sampleRate;
  public final int streamType;
  
  private Ac3Util$Ac3SyncFrameInfo(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mimeType = paramString;
    this.streamType = paramInt1;
    this.channelCount = paramInt2;
    this.sampleRate = paramInt3;
    this.frameSize = paramInt4;
    this.sampleCount = paramInt5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.audio.Ac3Util.Ac3SyncFrameInfo
 * JD-Core Version:    0.7.0.1
 */