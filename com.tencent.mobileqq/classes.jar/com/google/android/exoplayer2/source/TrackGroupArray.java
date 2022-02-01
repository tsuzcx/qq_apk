package com.google.android.exoplayer2.source;

import java.util.Arrays;

public final class TrackGroupArray
{
  public static final TrackGroupArray EMPTY = new TrackGroupArray(new TrackGroup[0]);
  private int hashCode;
  public final int length;
  private final TrackGroup[] trackGroups;
  
  public TrackGroupArray(TrackGroup... paramVarArgs)
  {
    this.trackGroups = paramVarArgs;
    this.length = paramVarArgs.length;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (TrackGroupArray)paramObject;
    } while ((this.length == paramObject.length) && (Arrays.equals(this.trackGroups, paramObject.trackGroups)));
    return false;
  }
  
  public TrackGroup get(int paramInt)
  {
    return this.trackGroups[paramInt];
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0) {
      this.hashCode = Arrays.hashCode(this.trackGroups);
    }
    return this.hashCode;
  }
  
  public int indexOf(TrackGroup paramTrackGroup)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.trackGroups[i] == paramTrackGroup) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.length == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.TrackGroupArray
 * JD-Core Version:    0.7.0.1
 */