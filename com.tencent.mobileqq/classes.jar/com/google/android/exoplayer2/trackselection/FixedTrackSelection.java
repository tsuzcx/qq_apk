package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;

public final class FixedTrackSelection
  extends BaseTrackSelection
{
  private final Object data;
  private final int reason;
  
  public FixedTrackSelection(TrackGroup paramTrackGroup, int paramInt)
  {
    this(paramTrackGroup, paramInt, 0, null);
  }
  
  public FixedTrackSelection(TrackGroup paramTrackGroup, int paramInt1, int paramInt2, Object paramObject)
  {
    super(paramTrackGroup, new int[] { paramInt1 });
    this.reason = paramInt2;
    this.data = paramObject;
  }
  
  public int getSelectedIndex()
  {
    return 0;
  }
  
  public Object getSelectionData()
  {
    return this.data;
  }
  
  public int getSelectionReason()
  {
    return this.reason;
  }
  
  public void updateSelectedTrack(long paramLong1, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.FixedTrackSelection
 * JD-Core Version:    0.7.0.1
 */