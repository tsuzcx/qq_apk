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
    boolean bool = true;
    if (paramVarArgs.length == 1) {}
    for (;;)
    {
      Assertions.checkArgument(bool);
      return new FixedTrackSelection(paramTrackGroup, paramVarArgs[0], this.reason, this.data);
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.trackselection.FixedTrackSelection.Factory
 * JD-Core Version:    0.7.0.1
 */