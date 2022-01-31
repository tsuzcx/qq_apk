package com.google.android.exoplayer2.source;

class MediaSourceEventListener$EventDispatcher$5
  implements Runnable
{
  MediaSourceEventListener$EventDispatcher$5(MediaSourceEventListener.EventDispatcher paramEventDispatcher, int paramInt, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    MediaSourceEventListener.EventDispatcher.access$100(this.this$0).onUpstreamDiscarded(this.val$trackType, MediaSourceEventListener.EventDispatcher.access$000(this.this$0, this.val$mediaStartTimeUs), MediaSourceEventListener.EventDispatcher.access$000(this.this$0, this.val$mediaEndTimeUs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.5
 * JD-Core Version:    0.7.0.1
 */