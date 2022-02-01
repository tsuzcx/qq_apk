package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.decoder.DecoderCounters;

class VideoRendererEventListener$EventDispatcher$1
  implements Runnable
{
  VideoRendererEventListener$EventDispatcher$1(VideoRendererEventListener.EventDispatcher paramEventDispatcher, DecoderCounters paramDecoderCounters) {}
  
  public void run()
  {
    VideoRendererEventListener.EventDispatcher.access$000(this.this$0).onVideoEnabled(this.val$decoderCounters);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.1
 * JD-Core Version:    0.7.0.1
 */