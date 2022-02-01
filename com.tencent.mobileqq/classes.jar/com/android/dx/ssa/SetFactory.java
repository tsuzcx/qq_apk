package com.android.dx.ssa;

import com.android.dx.util.BitIntSet;
import com.android.dx.util.IntSet;
import com.android.dx.util.ListIntSet;

public final class SetFactory
{
  private static final int DOMFRONT_SET_THRESHOLD_SIZE = 3072;
  private static final int INTERFERENCE_SET_THRESHOLD_SIZE = 3072;
  private static final int LIVENESS_SET_THRESHOLD_SIZE = 3072;
  
  static IntSet makeDomFrontSet(int paramInt)
  {
    if (paramInt <= 3072) {
      return new BitIntSet(paramInt);
    }
    return new ListIntSet();
  }
  
  public static IntSet makeInterferenceSet(int paramInt)
  {
    if (paramInt <= 3072) {
      return new BitIntSet(paramInt);
    }
    return new ListIntSet();
  }
  
  static IntSet makeLivenessSet(int paramInt)
  {
    if (paramInt <= 3072) {
      return new BitIntSet(paramInt);
    }
    return new ListIntSet();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.ssa.SetFactory
 * JD-Core Version:    0.7.0.1
 */