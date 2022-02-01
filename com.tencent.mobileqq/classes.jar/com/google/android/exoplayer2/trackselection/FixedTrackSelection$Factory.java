package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.util.Assertions;

public final class FixedTrackSelection$Factory
  implements TrackSelection.Factory
{
  private final Object data;
  private final int reason;
  
  public FixedTrackSelection$Factory()
  {
    this.reason = 0;
    this.data = null;
  }
  
  public FixedTrackSelection$Factory(int paramInt, Object paramObject)
  {
    this.reason = paramInt;
    this.data = paramObject;
  }
  
  public FixedTrackSelection createTrackSelection(TrackGroup paramTrackGroup, int... paramVarArgs)
  {
    int i = paramVarArgs.length;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    Assertions.checkArgument(bool);
    return new FixedTrackSelection(paramTrackGroup, paramVarArgs[0], this.reason, this.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.FixedTrackSelection.Factory
 * JD-Core Version:    0.7.0.1
 */