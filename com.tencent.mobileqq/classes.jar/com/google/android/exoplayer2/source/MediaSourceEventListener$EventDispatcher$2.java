package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSpec;

class MediaSourceEventListener$EventDispatcher$2
  implements Runnable
{
  MediaSourceEventListener$EventDispatcher$2(MediaSourceEventListener.EventDispatcher paramEventDispatcher, DataSpec paramDataSpec, int paramInt1, int paramInt2, Format paramFormat, int paramInt3, Object paramObject, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {}
  
  public void run()
  {
    MediaSourceEventListener.EventDispatcher.access$100(this.this$0).onLoadCompleted(this.val$dataSpec, this.val$dataType, this.val$trackType, this.val$trackFormat, this.val$trackSelectionReason, this.val$trackSelectionData, MediaSourceEventListener.EventDispatcher.access$000(this.this$0, this.val$mediaStartTimeUs), MediaSourceEventListener.EventDispatcher.access$000(this.this$0, this.val$mediaEndTimeUs), this.val$elapsedRealtimeMs, this.val$loadDurationMs, this.val$bytesLoaded);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.MediaSourceEventListener.EventDispatcher.2
 * JD-Core Version:    0.7.0.1
 */