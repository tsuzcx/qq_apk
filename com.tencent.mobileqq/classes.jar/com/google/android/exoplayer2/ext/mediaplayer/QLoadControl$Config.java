package com.google.android.exoplayer2.ext.mediaplayer;

public class QLoadControl$Config
{
  private int bufferForPlaybackMs = 2500;
  private int bufferForPlaybackRebufferMs = 5000;
  private int bufferSegmentSize = 65536;
  private int maxBufferMs = 30000;
  private int minBufferMs = 15000;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QLoadControl.Config[bufferSegmentSize=");
    localStringBuilder.append(this.bufferSegmentSize);
    localStringBuilder.append(",minBufferMs=");
    localStringBuilder.append(this.minBufferMs);
    localStringBuilder.append(",maxBufferMs=");
    localStringBuilder.append(this.maxBufferMs);
    localStringBuilder.append(",bufferForPlaybackMs=");
    localStringBuilder.append(this.bufferForPlaybackMs);
    localStringBuilder.append(",bufferForPlaybackRebufferMs=");
    localStringBuilder.append(this.bufferForPlaybackRebufferMs);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.QLoadControl.Config
 * JD-Core Version:    0.7.0.1
 */