package com.google.android.exoplayer2.video;

import android.view.Surface;

class VideoRendererEventListener$EventDispatcher$6
  implements Runnable
{
  VideoRendererEventListener$EventDispatcher$6(VideoRendererEventListener.EventDispatcher paramEventDispatcher, Surface paramSurface) {}
  
  public void run()
  {
    VideoRendererEventListener.EventDispatcher.access$000(this.this$0).onRenderedFirstFrame(this.val$surface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.6
 * JD-Core Version:    0.7.0.1
 */