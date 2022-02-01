package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public final class MergingMediaSource
  extends CompositeMediaSource<Integer>
{
  private static final int PERIOD_COUNT_UNSET = -1;
  private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
  private MediaSource.Listener listener;
  private final MediaSource[] mediaSources;
  private MergingMediaSource.IllegalMergeException mergeError;
  private final ArrayList<MediaSource> pendingTimelineSources;
  private int periodCount;
  private Object primaryManifest;
  private Timeline primaryTimeline;
  
  public MergingMediaSource(CompositeSequenceableLoaderFactory paramCompositeSequenceableLoaderFactory, MediaSource... paramVarArgs)
  {
    this.mediaSources = paramVarArgs;
    this.compositeSequenceableLoaderFactory = paramCompositeSequenceableLoaderFactory;
    this.pendingTimelineSources = new ArrayList(Arrays.asList(paramVarArgs));
    this.periodCount = -1;
  }
  
  public MergingMediaSource(MediaSource... paramVarArgs)
  {
    this(new DefaultCompositeSequenceableLoaderFactory(), paramVarArgs);
  }
  
  private MergingMediaSource.IllegalMergeException checkTimelineMerges(Timeline paramTimeline)
  {
    if (this.periodCount == -1) {
      this.periodCount = paramTimeline.getPeriodCount();
    }
    while (paramTimeline.getPeriodCount() == this.periodCount) {
      return null;
    }
    return new MergingMediaSource.IllegalMergeException(0);
  }
  
  public MediaPeriod createPeriod(MediaSource.MediaPeriodId paramMediaPeriodId, Allocator paramAllocator)
  {
    MediaPeriod[] arrayOfMediaPeriod = new MediaPeriod[this.mediaSources.length];
    int i = 0;
    while (i < arrayOfMediaPeriod.length)
    {
      arrayOfMediaPeriod[i] = this.mediaSources[i].createPeriod(paramMediaPeriodId, paramAllocator);
      i += 1;
    }
    return new MergingMediaPeriod(this.compositeSequenceableLoaderFactory, arrayOfMediaPeriod);
  }
  
  public void maybeThrowSourceInfoRefreshError()
  {
    if (this.mergeError != null) {
      throw this.mergeError;
    }
    super.maybeThrowSourceInfoRefreshError();
  }
  
  protected void onChildSourceInfoRefreshed(Integer paramInteger, MediaSource paramMediaSource, Timeline paramTimeline, @Nullable Object paramObject)
  {
    if (this.mergeError == null) {
      this.mergeError = checkTimelineMerges(paramTimeline);
    }
    if (this.mergeError != null) {}
    do
    {
      return;
      this.pendingTimelineSources.remove(paramMediaSource);
      if (paramMediaSource == this.mediaSources[0])
      {
        this.primaryTimeline = paramTimeline;
        this.primaryManifest = paramObject;
      }
    } while (!this.pendingTimelineSources.isEmpty());
    this.listener.onSourceInfoRefreshed(this, this.primaryTimeline, this.primaryManifest);
  }
  
  public void prepareSource(ExoPlayer paramExoPlayer, boolean paramBoolean, MediaSource.Listener paramListener)
  {
    super.prepareSource(paramExoPlayer, paramBoolean, paramListener);
    this.listener = paramListener;
    int i = 0;
    while (i < this.mediaSources.length)
    {
      prepareChildSource(Integer.valueOf(i), this.mediaSources[i]);
      i += 1;
    }
  }
  
  public void releasePeriod(MediaPeriod paramMediaPeriod)
  {
    paramMediaPeriod = (MergingMediaPeriod)paramMediaPeriod;
    int i = 0;
    while (i < this.mediaSources.length)
    {
      this.mediaSources[i].releasePeriod(paramMediaPeriod.periods[i]);
      i += 1;
    }
  }
  
  public void releaseSource()
  {
    super.releaseSource();
    this.listener = null;
    this.primaryTimeline = null;
    this.primaryManifest = null;
    this.periodCount = -1;
    this.mergeError = null;
    this.pendingTimelineSources.clear();
    Collections.addAll(this.pendingTimelineSources, this.mediaSources);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.source.MergingMediaSource
 * JD-Core Version:    0.7.0.1
 */