package com.huawei.hiar;

import com.huawei.hiar.exceptions.ARFatalException;

public enum ARConfigBase$PowerMode
{
  NORMAL(0),  POWER_SAVING(1),  ULTRA_POWER_SAVING(2);
  
  final int mNativeCode;
  
  private ARConfigBase$PowerMode(int paramInt)
  {
    this.mNativeCode = paramInt;
  }
  
  static PowerMode forNumber(int paramInt)
  {
    PowerMode[] arrayOfPowerMode = values();
    int j = arrayOfPowerMode.length;
    int i = 0;
    PowerMode localPowerMode;
    while (i < j)
    {
      localPowerMode = arrayOfPowerMode[i];
      if (localPowerMode.mNativeCode == paramInt) {
        break label62;
      }
      i += 1;
    }
    throw new ARFatalException("Unexpected value for native PowerMode, value=" + paramInt);
    label62:
    return localPowerMode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.ARConfigBase.PowerMode
 * JD-Core Version:    0.7.0.1
 */