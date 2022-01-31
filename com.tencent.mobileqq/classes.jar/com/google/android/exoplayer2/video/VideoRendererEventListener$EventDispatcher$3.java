package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.Format;

class VideoRendererEventListener$EventDispatcher$3
  implements Runnable
{
  VideoRendererEventListener$EventDispatcher$3(VideoRendererEventListener.EventDispatcher paramEventDispatcher, Format paramFormat) {}
  
  public void run()
  {
    VideoRendererEventListener.EventDispatcher.access$000(this.this$0).onVideoInputFormatChanged(this.val$format);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.3
 * JD-Core Version:    0.7.0.1
 */