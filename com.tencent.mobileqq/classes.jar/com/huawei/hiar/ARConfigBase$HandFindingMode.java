package com.huawei.hiar;

import com.huawei.hiar.exceptions.ARFatalException;

@Deprecated
public enum ARConfigBase$HandFindingMode
{
  DISABLED(0),  ENABLE_2D(1),  ENABLE_3D(2);
  
  final int mNativeCode;
  
  private ARConfigBase$HandFindingMode(int paramInt)
  {
    this.mNativeCode = paramInt;
  }
  
  static HandFindingMode forNumber(int paramInt)
  {
    HandFindingMode[] arrayOfHandFindingMode = values();
    int j = arrayOfHandFindingMode.length;
    int i = 0;
    HandFindingMode localHandFindingMode;
    while (i < j)
    {
      localHandFindingMode = arrayOfHandFindingMode[i];
      if (localHandFindingMode.mNativeCode == paramInt) {
        break label62;
      }
      i += 1;
    }
    throw new ARFatalException("Unexpected value for native HandFindingModeMode, value=" + paramInt);
    label62:
    return localHandFindingMode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.ARConfigBase.HandFindingMode
 * JD-Core Version:    0.7.0.1
 */