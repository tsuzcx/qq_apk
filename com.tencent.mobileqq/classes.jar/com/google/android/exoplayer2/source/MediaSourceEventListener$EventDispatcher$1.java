package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;

class MediaSourceEventListener$EventDispatcher$1
  implements Runnable
{
  MediaSourceEventListener$EventDispatcher$1(MediaSourceEventListener.EventDispatcher paramEventDispatcher, DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    MediaSourceEventListener.EventDispatcher.access$100(this.this$0).onLoadStarted(this.val$dataSpec, this.val$dataType, this.val$trackType, this.val$trackFormat, this.val$trackSelectionReason, this.val$trackSelectionData, MediaSourceEventListener.EventDispatcher.access$000(this.this$0, this.val$mediaStartTimeUs), MediaSourceEventListener.EventDispatcher.access$000(this.this$0, this.val$mediaEndTimeUs), this.val$elapsedRealtimeMs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.1
 * JD-Core Version:    0.7.0.1
 */