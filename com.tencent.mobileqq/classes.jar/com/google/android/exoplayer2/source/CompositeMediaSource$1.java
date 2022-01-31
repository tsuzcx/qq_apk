package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;

class CompositeMediaSource$1
  implements MediaSource.Listener
{
  CompositeMediaSource$1(CompositeMediaSource paramCompositeMediaSource, Object paramObject, MediaSource paramMediaSource) {}
  
  public void onSourceInfoRefreshed(MediaSource paramMediaSource, Timeline paramTimeline, @Nullable Object paramObject)
  {
    this.this$0.onChildSourceInfoRefreshed(this.val$id, this.val$mediaSource, paramTimeline, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.CompositeMediaSource.1
 * JD-Core Version:    0.7.0.1
 */