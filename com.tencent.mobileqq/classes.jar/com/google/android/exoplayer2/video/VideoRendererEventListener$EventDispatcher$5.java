package com.google.android.exoplayer2.video;

class VideoRendererEventListener$EventDispatcher$5
  implements Runnable
{
  VideoRendererEventListener$EventDispatcher$5(VideoRendererEventListener.EventDispatcher paramEventDispatcher, int paramInt1, int paramInt2, int paramInt3, float paramFloat) {}
  
  public void run()
  {
    VideoRendererEventListener.EventDispatcher.access$000(this.this$0).onVideoSizeChanged(this.val$width, this.val$height, this.val$unappliedRotationDegrees, this.val$pixelWidthHeightRatio);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.VideoRendererEventListener.EventDispatcher.5
 * JD-Core Version:    0.7.0.1
 */