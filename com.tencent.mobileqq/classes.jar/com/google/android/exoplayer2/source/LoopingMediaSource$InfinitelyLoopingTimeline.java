package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Timeline;

final class LoopingMediaSource$InfinitelyLoopingTimeline
  extends ForwardingTimeline
{
  public LoopingMediaSource$InfinitelyLoopingTimeline(Timeline paramTimeline)
  {
    super(paramTimeline);
  }
  
  public int getNextWindowIndex(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt2 = this.timeline.getNextWindowIndex(paramInt1, paramInt2, paramBoolean);
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = getFirstWindowIndex(paramBoolean);
    }
    return paramInt1;
  }
  
  public int getPreviousWindowIndex(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt2 = this.timeline.getPreviousWindowIndex(paramInt1, paramInt2, paramBoolean);
    paramInt1 = paramInt2;
    if (paramInt2 == -1) {
      paramInt1 = getLastWindowIndex(paramBoolean);
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.LoopingMediaSource.InfinitelyLoopingTimeline
 * JD-Core Version:    0.7.0.1
 */