package com.google.android.exoplayer2.trackselection;

import java.util.Arrays;

public final class TrackSelectionArray
{
  private int hashCode;
  public final int length;
  private final TrackSelection[] trackSelections;
  
  public TrackSelectionArray(TrackSelection... paramVarArgs)
  {
    this.trackSelections = paramVarArgs;
    this.length = paramVarArgs.length;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (TrackSelectionArray)paramObject;
    return Arrays.equals(this.trackSelections, paramObject.trackSelections);
  }
  
  public TrackSelection get(int paramInt)
  {
    return this.trackSelections[paramInt];
  }
  
  public TrackSelection[] getAll()
  {
    return (TrackSelection[])this.trackSelections.clone();
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0) {
      this.hashCode = (Arrays.hashCode(this.trackSelections) + 527);
    }
    return this.hashCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.TrackSelectionArray
 * JD-Core Version:    0.7.0.1
 */