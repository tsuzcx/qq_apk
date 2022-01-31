package com.huawei.hiar;

import com.huawei.hiar.exceptions.ARFatalException;

public enum ARConfigBase$PlaneFindingMode
{
  DISABLED(0),  ENABLE(3),  HORIZONTAL_ONLY(1),  VERTICAL_ONLY(2);
  
  final int mNativeCode;
  
  private ARConfigBase$PlaneFindingMode(int paramInt)
  {
    this.mNativeCode = paramInt;
  }
  
  static PlaneFindingMode forNumber(int paramInt)
  {
    PlaneFindingMode[] arrayOfPlaneFindingMode = values();
    int j = arrayOfPlaneFindingMode.length;
    int i = 0;
    PlaneFindingMode localPlaneFindingMode;
    while (i < j)
    {
      localPlaneFindingMode = arrayOfPlaneFindingMode[i];
      if (localPlaneFindingMode.mNativeCode == paramInt) {
        break label62;
      }
      i += 1;
    }
    throw new ARFatalException("Unexpected value for native PlaneFindingMode, value=" + paramInt);
    label62:
    return localPlaneFindingMode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.ARConfigBase.PlaneFindingMode
 * JD-Core Version:    0.7.0.1
 */