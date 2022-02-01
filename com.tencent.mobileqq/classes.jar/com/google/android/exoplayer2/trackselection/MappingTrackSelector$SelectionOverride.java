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
    int[] arrayOfInt = this.tracks;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public TrackSelection createTrackSelection(TrackGroupArray paramTrackGroupArray)
  {
    return this.factory.createTrackSelection(paramTrackGroupArray.get(this.groupIndex), this.tracks);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.MappingTrackSelector.SelectionOverride
 * JD-Core Version:    0.7.0.1
 */