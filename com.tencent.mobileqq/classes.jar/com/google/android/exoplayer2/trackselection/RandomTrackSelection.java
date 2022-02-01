package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.source.TrackGroup;
import java.util.Random;

public final class RandomTrackSelection
  extends BaseTrackSelection
{
  private final Random random;
  private int selectedIndex;
  
  public RandomTrackSelection(TrackGroup paramTrackGroup, int... paramVarArgs)
  {
    super(paramTrackGroup, paramVarArgs);
    this.random = new Random();
    this.selectedIndex = this.random.nextInt(this.length);
  }
  
  public RandomTrackSelection(TrackGroup paramTrackGroup, int[] paramArrayOfInt, long paramLong)
  {
    this(paramTrackGroup, paramArrayOfInt, new Random(paramLong));
  }
  
  public RandomTrackSelection(TrackGroup paramTrackGroup, int[] paramArrayOfInt, Random paramRandom)
  {
    super(paramTrackGroup, paramArrayOfInt);
    this.random = paramRandom;
    this.selectedIndex = paramRandom.nextInt(this.length);
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
    return 3;
  }
  
  public void updateSelectedTrack(long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong1 = SystemClock.elapsedRealtime();
    int m = 0;
    int i = 0;
    int k;
    for (int j = 0; i < this.length; j = k)
    {
      k = j;
      if (!isBlacklisted(i, paramLong1)) {
        k = j + 1;
      }
      i += 1;
    }
    this.selectedIndex = this.random.nextInt(j);
    if (j != this.length)
    {
      j = 0;
      i = m;
      while (i < this.length)
      {
        k = j;
        if (!isBlacklisted(i, paramLong1))
        {
          if (this.selectedIndex == j)
          {
            this.selectedIndex = i;
            return;
          }
          k = j + 1;
        }
        i += 1;
        j = k;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.RandomTrackSelection
 * JD-Core Version:    0.7.0.1
 */