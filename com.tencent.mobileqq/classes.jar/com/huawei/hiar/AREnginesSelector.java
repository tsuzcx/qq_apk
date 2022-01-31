package com.huawei.hiar;

import android.content.Context;

public class AREnginesSelector
{
  private static final String TAG = AREnginesSelector.class.getSimpleName();
  
  public static AREnginesSelector.AREnginesAvaliblity checkAllAvailableEngines(Context paramContext)
  {
    return AREnginesSelector.AREnginesAvaliblity.forNumber(nativeCheckAllAvailableEngines(paramContext));
  }
  
  public static AREnginesSelector.AREnginesType getCreatedEngine()
  {
    return AREnginesSelector.AREnginesType.forNumber(nativeGetCreatedEngine());
  }
  
  private static native int nativeCheckAllAvailableEngines(Context paramContext);
  
  private static native int nativeGetCreatedEngine();
  
  private static native int nativeSetAR(int paramInt);
  
  public static AREnginesSelector.AREnginesType setAREngine(AREnginesSelector.AREnginesType paramAREnginesType)
  {
    return AREnginesSelector.AREnginesType.forNumber(nativeSetAR(paramAREnginesType.nativeCode));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.AREnginesSelector
 * JD-Core Version:    0.7.0.1
 */