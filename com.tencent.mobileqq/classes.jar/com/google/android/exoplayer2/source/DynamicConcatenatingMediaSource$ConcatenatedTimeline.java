package com.google.android.exoplayer2.source;

import android.util.SparseIntArray;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Util;
import java.util.Collection;
import java.util.Iterator;

final class DynamicConcatenatingMediaSource$ConcatenatedTimeline
  extends AbstractConcatenatedTimeline
{
  private final SparseIntArray childIndexByUid;
  private final int[] firstPeriodInChildIndices;
  private final int[] firstWindowInChildIndices;
  private final int periodCount;
  private final Timeline[] timelines;
  private final int[] uids;
  private final int windowCount;
  
  public DynamicConcatenatingMediaSource$ConcatenatedTimeline(Collection<DynamicConcatenatingMediaSource.MediaSourceHolder> paramCollection, int paramInt1, int paramInt2, ShuffleOrder paramShuffleOrder, boolean paramBoolean)
  {
    super(paramBoolean, paramShuffleOrder);
    this.windowCount = paramInt1;
    this.periodCount = paramInt2;
    paramInt1 = paramCollection.size();
    this.firstPeriodInChildIndices = new int[paramInt1];
    this.firstWindowInChildIndices = new int[paramInt1];
    this.timelines = new Timeline[paramInt1];
    this.uids = new int[paramInt1];
    this.childIndexByUid = new SparseIntArray();
    paramCollection = paramCollection.iterator();
    paramInt1 = 0;
    while (paramCollection.hasNext())
    {
      paramShuffleOrder = (DynamicConcatenatingMediaSource.MediaSourceHolder)paramCollection.next();
      this.timelines[paramInt1] = paramShuffleOrder.timeline;
      this.firstPeriodInChildIndices[paramInt1] = paramShuffleOrder.firstPeriodIndexInChild;
      this.firstWindowInChildIndices[paramInt1] = paramShuffleOrder.firstWindowIndexInChild;
      this.uids[paramInt1] = paramShuffleOrder.uid;
      this.childIndexByUid.put(this.uids[paramInt1], paramInt1);
      paramInt1 += 1;
    }
  }
  
  protected int getChildIndexByChildUid(Object paramObject)
  {
    if (!(paramObject instanceof Integer)) {}
    int i;
    do
    {
      return -1;
      i = this.childIndexByUid.get(((Integer)paramObject).intValue(), -1);
    } while (i == -1);
    return i;
  }
  
  protected int getChildIndexByPeriodIndex(int paramInt)
  {
    return Util.binarySearchFloor(this.firstPeriodInChildIndices, paramInt + 1, false, false);
  }
  
  protected int getChildIndexByWindowIndex(int paramInt)
  {
    return Util.binarySearchFloor(this.firstWindowInChildIndices, paramInt + 1, false, false);
  }
  
  protected Object getChildUidByChildIndex(int paramInt)
  {
    return Integer.valueOf(this.uids[paramInt]);
  }
  
  protected int getFirstPeriodIndexByChildIndex(int paramInt)
  {
    return this.firstPeriodInChildIndices[paramInt];
  }
  
  protected int getFirstWindowIndexByChildIndex(int paramInt)
  {
    return this.firstWindowInChildIndices[paramInt];
  }
  
  public int getPeriodCount()
  {
    return this.periodCount;
  }
  
  protected Timeline getTimelineByChildIndex(int paramInt)
  {
    return this.timelines[paramInt];
  }
  
  public int getWindowCount()
  {
    return this.windowCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.DynamicConcatenatingMediaSource.ConcatenatedTimeline
 * JD-Core Version:    0.7.0.1
 */