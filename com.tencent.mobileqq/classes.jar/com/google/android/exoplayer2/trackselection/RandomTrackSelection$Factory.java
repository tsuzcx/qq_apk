package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import java.util.Random;

public final class RandomTrackSelection$Factory
  implements TrackSelection.Factory
{
  private final Random random;
  
  public RandomTrackSelection$Factory()
  {
    this.random = new Random();
  }
  
  public RandomTrackSelection$Factory(int paramInt)
  {
    this.random = new Random(paramInt);
  }
  
  public RandomTrackSelection createTrackSelection(TrackGroup paramTrackGroup, int... paramVarArgs)
  {
    return new RandomTrackSelection(paramTrackGroup, paramVarArgs, this.random);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.RandomTrackSelection.Factory
 * JD-Core Version:    0.7.0.1
 */