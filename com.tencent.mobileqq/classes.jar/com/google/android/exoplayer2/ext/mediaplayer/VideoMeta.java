package com.google.android.exoplayer2.ext.mediaplayer;

public class VideoMeta
{
  public static final int OPEN_ENDED = -1;
  public final long duration;
  public long endPosition = -1L;
  public long startPosition;
  public final String uri;
  
  public VideoMeta(String paramString, long paramLong)
  {
    this.uri = paramString;
    this.duration = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.VideoMeta
 * JD-Core Version:    0.7.0.1
 */