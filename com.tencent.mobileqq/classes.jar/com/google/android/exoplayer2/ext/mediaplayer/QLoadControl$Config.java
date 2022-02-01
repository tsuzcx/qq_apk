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
    return "QLoadControl.Config[bufferSegmentSize=" + this.bufferSegmentSize + ",minBufferMs=" + this.minBufferMs + ",maxBufferMs=" + this.maxBufferMs + ",bufferForPlaybackMs=" + this.bufferForPlaybackMs + ",bufferForPlaybackRebufferMs=" + this.bufferForPlaybackRebufferMs + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.QLoadControl.Config
 * JD-Core Version:    0.7.0.1
 */