package com.google.android.exoplayer2.source;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public final class ConcatenatingMediaSource
  extends CompositeMediaSource<Integer>
{
  private final boolean isAtomic;
  private MediaSource.Listener listener;
  private final Object[] manifests;
  private final MediaSource[] mediaSources;
  private final ShuffleOrder shuffleOrder;
  private final Map<MediaPeriod, Integer> sourceIndexByMediaPeriod;
  private ConcatenatingMediaSource.ConcatenatedTimeline timeline;
  private final Timeline[] timelines;
  
  public ConcatenatingMediaSource(boolean paramBoolean, ShuffleOrder paramShuffleOrder, MediaSource... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      Assertions.checkNotNull(paramVarArgs[i]);
      i += 1;
    }
    if (paramShuffleOrder.getLength() == paramVarArgs.length) {
      bool = true;
    }
    Assertions.checkArgument(bool);
    this.mediaSources = paramVarArgs;
    this.isAtomic = paramBoolean;
    this.shuffleOrder = paramShuffleOrder;
    this.timelines = new Timeline[paramVarArgs.length];
    this.manifests = new Object[paramVarArgs.length];
    this.sourceIndexByMediaPeriod = new HashMap();
  }
  
  public ConcatenatingMediaSource(boolean paramBoolean, MediaSource... paramVarArgs)
  {
    this(paramBoolean, new ShuffleOrder.DefaultShuffleOrder(paramVarArgs.length), paramVarArgs);
  }
  
  public ConcatenatingMediaSource(MediaSource... paramVarArgs)
  {
    this(false, paramVarArgs);
  }
  
  private static boolean[] buildDuplicateFlags(MediaSource[] paramArrayOfMediaSource)
  {
    boolean[] arrayOfBoolean = new boolean[paramArrayOfMediaSource.length];
    IdentityHashMap localIdentityHashMap = new IdentityHashMap(paramArrayOfMediaSource.length);
    int i = 0;
    if (i < paramArrayOfMediaSource.length)
    {
      MediaSource localMediaSource = paramArrayOfMediaSource[i];
      if (!localIdentityHashMap.containsKey(localMediaSource)) {
        localIdentityHashMap.put(localMediaSource, null);
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfBoolean[i] = true;
      }
    }
    return arrayOfBoolean;
  }
  
  public MediaPeriod createPeriod(MediaSource.MediaPeriodId paramMediaPeriodId, Allocator paramAllocator)
  {
    int i = this.timeline.getChildIndexByPeriodIndex(paramMediaPeriodId.periodIndex);
    paramMediaPeriodId = paramMediaPeriodId.copyWithPeriodIndex(paramMediaPeriodId.periodIndex - this.timeline.getFirstPeriodIndexByChildIndex(i));
    paramMediaPeriodId = this.mediaSources[i].createPeriod(paramMediaPeriodId, paramAllocator);
    this.sourceIndexByMediaPeriod.put(paramMediaPeriodId, Integer.valueOf(i));
    return paramMediaPeriodId;
  }
  
  protected void onChildSourceInfoRefreshed(Integer paramInteger, MediaSource paramMediaSource, Timeline paramTimeline, @Nullable Object paramObject)
  {
    this.timelines[paramInteger.intValue()] = paramTimeline;
    this.manifests[paramInteger.intValue()] = paramObject;
    int i = paramInteger.intValue() + 1;
    while (i < this.mediaSources.length)
    {
      if (this.mediaSources[i] == paramMediaSource)
      {
        this.timelines[i] = paramTimeline;
        this.manifests[i] = paramObject;
      }
      i += 1;
    }
    paramInteger = this.timelines;
    int j = paramInteger.length;
    i = 0;
    while (i < j)
    {
      if (paramInteger[i] == null) {
        return;
      }
      i += 1;
    }
    this.timeline = new ConcatenatingMediaSource.ConcatenatedTimeline((Timeline[])this.timelines.clone(), this.isAtomic, this.shuffleOrder);
    this.listener.onSourceInfoRefreshed(this, this.timeline, this.manifests.clone());
  }
  
  public void prepareSource(ExoPlayer paramExoPlayer, boolean paramBoolean, MediaSource.Listener paramListener)
  {
    super.prepareSource(paramExoPlayer, paramBoolean, paramListener);
    this.listener = paramListener;
    paramExoPlayer = buildDuplicateFlags(this.mediaSources);
    if (this.mediaSources.length == 0) {
      paramListener.onSourceInfoRefreshed(this, Timeline.EMPTY, null);
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.mediaSources.length)
      {
        if (paramExoPlayer[i] == 0) {
          prepareChildSource(Integer.valueOf(i), this.mediaSources[i]);
        }
        i += 1;
      }
    }
  }
  
  public void releasePeriod(MediaPeriod paramMediaPeriod)
  {
    int i = ((Integer)this.sourceIndexByMediaPeriod.get(paramMediaPeriod)).intValue();
    this.sourceIndexByMediaPeriod.remove(paramMediaPeriod);
    this.mediaSources[i].releasePeriod(paramMediaPeriod);
  }
  
  public void releaseSource()
  {
    super.releaseSource();
    this.listener = null;
    this.timeline = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.ConcatenatingMediaSource
 * JD-Core Version:    0.7.0.1
 */