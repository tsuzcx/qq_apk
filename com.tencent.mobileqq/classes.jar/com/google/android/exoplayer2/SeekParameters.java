package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;

public final class SeekParameters
{
  public static final SeekParameters CLOSEST_SYNC;
  public static final SeekParameters DEFAULT = EXACT;
  public static final SeekParameters EXACT = new SeekParameters(0L, 0L);
  public static final SeekParameters NEXT_SYNC;
  public static final SeekParameters PREVIOUS_SYNC;
  public final long toleranceAfterUs;
  public final long toleranceBeforeUs;
  
  static
  {
    CLOSEST_SYNC = new SeekParameters(9223372036854775807L, 9223372036854775807L);
    PREVIOUS_SYNC = new SeekParameters(9223372036854775807L, 0L);
    NEXT_SYNC = new SeekParameters(0L, 9223372036854775807L);
  }
  
  public SeekParameters(long paramLong1, long paramLong2)
  {
    if (paramLong1 >= 0L)
    {
      bool1 = true;
      Assertions.checkArgument(bool1);
      if (paramLong2 < 0L) {
        break label53;
      }
    }
    label53:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Assertions.checkArgument(bool1);
      this.toleranceBeforeUs = paramLong1;
      this.toleranceAfterUs = paramLong2;
      return;
      bool1 = false;
      break;
    }
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
      paramObject = (SeekParameters)paramObject;
    } while ((this.toleranceBeforeUs == paramObject.toleranceBeforeUs) && (this.toleranceAfterUs == paramObject.toleranceAfterUs));
    return false;
  }
  
  public int hashCode()
  {
    return (int)this.toleranceBeforeUs * 31 + (int)this.toleranceAfterUs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.SeekParameters
 * JD-Core Version:    0.7.0.1
 */