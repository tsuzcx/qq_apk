package com.google.android.exoplayer2.video;

class VideoRendererEventListener$EventDispatcher$2
  implements Runnable
{
  VideoRendererEventListener$EventDispatcher$2(VideoRendererEventListener.EventDispatcher paramEventDispatcher, String paramString, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    VideoRendererEventListener.EventDispatcher.access$000(this.this$0).onVideoDecoderInitialized(this.val$decoderName, this.val$initializedTimestampMs, this.val$initializationDurationMs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.2
 * JD-Core Version:    0.7.0.1
 */