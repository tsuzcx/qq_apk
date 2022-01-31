package com.google.android.filament;

import java.util.List;
import java.util.Map;

public class DynamicBoneManager
{
  private long mNativeObject;
  private long startTime;
  
  public DynamicBoneManager(Engine paramEngine, @Entity int paramInt)
  {
    this.mNativeObject = nCreateManager(paramEngine.getNativeObject(), paramInt);
  }
  
  private static native void nAddDynamicBone(long paramLong, int paramInt, List<Map<String, String>> paramList1, List<Map<String, String>> paramList2, boolean paramBoolean, float[] paramArrayOfFloat);
  
  private static native void nClear(long paramLong);
  
  private static native long nCreateManager(long paramLong, int paramInt);
  
  private static native void nUpdate(long paramLong, double paramDouble);
  
  private static native void nUpdateHeadData(long paramLong, float[] paramArrayOfFloat1, int paramInt, float[] paramArrayOfFloat2);
  
  public void add(@Entity int paramInt, List<Map<String, String>> paramList1, List<Map<String, String>> paramList2, boolean paramBoolean, float[] paramArrayOfFloat)
  {
    nAddDynamicBone(this.mNativeObject, paramInt, paramList1, paramList2, paramBoolean, paramArrayOfFloat);
  }
  
  public void clear()
  {
    nClear(this.mNativeObject);
  }
  
  public long getNativeObject()
  {
    return this.mNativeObject;
  }
  
  public void update()
  {
    long l = System.currentTimeMillis();
    if (this.startTime <= 0L) {
      this.startTime = l;
    }
    double d = (l - this.startTime) / 1000.0D;
    nUpdate(this.mNativeObject, d);
  }
  
  public void updateHeadData(float[] paramArrayOfFloat1, int paramInt, float[] paramArrayOfFloat2)
  {
    nUpdateHeadData(this.mNativeObject, paramArrayOfFloat1, paramInt, paramArrayOfFloat2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.DynamicBoneManager
 * JD-Core Version:    0.7.0.1
 */