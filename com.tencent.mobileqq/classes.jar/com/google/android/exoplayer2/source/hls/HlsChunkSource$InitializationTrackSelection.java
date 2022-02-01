package com.google.android.exoplayer2.source.hls;

import android.os.SystemClock;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;

final class HlsChunkSource$InitializationTrackSelection
  extends BaseTrackSelection
{
  private int selectedIndex = indexOf(paramTrackGroup.getFormat(0));
  
  public HlsChunkSource$InitializationTrackSelection(TrackGroup paramTrackGroup, int[] paramArrayOfInt)
  {
    super(paramTrackGroup, paramArrayOfInt);
  }
  
  public int getSelectedIndex()
  {
    return this.selectedIndex;
  }
  
  public Object getSelectionData()
  {
    return null;
  }
  
  public int getSelectionReason()
  {
    return 0;
  }
  
  public void updateSelectedTrack(long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong1 = SystemClock.elapsedRealtime();
    if (!isBlacklisted(this.selectedIndex, paramLong1)) {
      return;
    }
    int i = this.length - 1;
    while (i >= 0)
    {
      if (!isBlacklisted(i, paramLong1))
      {
        this.selectedIndex = i;
        return;
      }
      i -= 1;
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.hls.HlsChunkSource.InitializationTrackSelection
 * JD-Core Version:    0.7.0.1
 */