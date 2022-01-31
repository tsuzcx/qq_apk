package com.huawei.hiar;

import com.huawei.hiar.exceptions.ARFatalException;

public enum ARLightEstimate$State
{
  NOT_VALID(0),  VALID(1);
  
  final int nativeCode;
  
  private ARLightEstimate$State(int paramInt)
  {
    this.nativeCode = paramInt;
  }
  
  static State forNumber(int paramInt)
  {
    State[] arrayOfState = values();
    int j = arrayOfState.length;
    int i = 0;
    State localState;
    while (i < j)
    {
      localState = arrayOfState[i];
      if (localState.nativeCode == paramInt) {
        break label62;
      }
      i += 1;
    }
    throw new ARFatalException("Unexpected value for native ARLightEstimate.State, value=" + paramInt);
    label62:
    return localState;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.ARLightEstimate.State
 * JD-Core Version:    0.7.0.1
 */