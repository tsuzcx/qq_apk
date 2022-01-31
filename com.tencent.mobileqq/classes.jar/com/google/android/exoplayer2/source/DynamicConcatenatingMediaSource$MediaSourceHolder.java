package com.google.android.exoplayer2.source;

import android.support.annotation.NonNull;

final class DynamicConcatenatingMediaSource$MediaSourceHolder
  implements Comparable<MediaSourceHolder>
{
  public int activeMediaPeriods;
  public int childIndex;
  public int firstPeriodIndexInChild;
  public int firstWindowIndexInChild;
  public boolean isPrepared;
  public boolean isRemoved;
  public final MediaSource mediaSource;
  public DynamicConcatenatingMediaSource.DeferredTimeline timeline;
  public final int uid;
  
  public DynamicConcatenatingMediaSource$MediaSourceHolder(MediaSource paramMediaSource, DynamicConcatenatingMediaSource.DeferredTimeline paramDeferredTimeline, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mediaSource = paramMediaSource;
    this.timeline = paramDeferredTimeline;
    this.childIndex = paramInt1;
    this.firstWindowIndexInChild = paramInt2;
    this.firstPeriodIndexInChild = paramInt3;
    this.uid = System.identityHashCode(this);
  }
  
  public int compareTo(@NonNull MediaSourceHolder paramMediaSourceHolder)
  {
    return this.firstPeriodIndexInChild - paramMediaSourceHolder.firstPeriodIndexInChild;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.DynamicConcatenatingMediaSource.MediaSourceHolder
 * JD-Core Version:    0.7.0.1
 */