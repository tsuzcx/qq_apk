package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroupArray;

public final class MappingTrackSelector$SelectionOverride
{
  public final TrackSelection.Factory factory;
  public final int groupIndex;
  public final int length;
  public final int[] tracks;
  
  public MappingTrackSelector$SelectionOverride(TrackSelection.Factory paramFactory, int paramInt, int... paramVarArgs)
  {
    this.factory = paramFactory;
    this.groupIndex = paramInt;
    this.tracks = paramVarArgs;
    this.length = paramVarArgs.length;
  }
  
  public boolean containsTrack(int paramInt)
  {
    boolean bool2 = false;
    int[] arrayOfInt = this.tracks;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (arrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public TrackSelection createTrackSelection(TrackGroupArray paramTrackGroupArray)
  {
    return this.factory.createTrackSelection(paramTrackGroupArray.get(this.groupIndex), this.tracks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.MappingTrackSelector.SelectionOverride
 * JD-Core Version:    0.7.0.1
 */