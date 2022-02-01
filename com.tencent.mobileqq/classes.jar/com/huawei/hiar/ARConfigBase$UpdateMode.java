package com.huawei.hiar;

import com.huawei.hiar.exceptions.ARFatalException;

public enum ARConfigBase$UpdateMode
{
  BLOCKING(0),  LATEST_CAMERA_IMAGE(1);
  
  final int mNativeCode;
  
  private ARConfigBase$UpdateMode(int paramInt)
  {
    this.mNativeCode = paramInt;
  }
  
  static UpdateMode forNumber(int paramInt)
  {
    UpdateMode[] arrayOfUpdateMode = values();
    int j = arrayOfUpdateMode.length;
    int i = 0;
    UpdateMode localUpdateMode;
    while (i < j)
    {
      localUpdateMode = arrayOfUpdateMode[i];
      if (localUpdateMode.mNativeCode == paramInt) {
        break label62;
      }
      i += 1;
    }
    throw new ARFatalException("Unexpected value for native UpdateMode, value=" + paramInt);
    label62:
    return localUpdateMode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.ARConfigBase.UpdateMode
 * JD-Core Version:    0.7.0.1
 */