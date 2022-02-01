package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.decoder.DecoderCounters;

class VideoRendererEventListener$EventDispatcher$7
  implements Runnable
{
  VideoRendererEventListener$EventDispatcher$7(VideoRendererEventListener.EventDispatcher paramEventDispatcher, DecoderCounters paramDecoderCounters) {}
  
  public void run()
  {
    this.val$counters.ensureUpdated();
    VideoRendererEventListener.EventDispatcher.access$000(this.this$0).onVideoDisabled(this.val$counters);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.7
 * JD-Core Version:    0.7.0.1
 */