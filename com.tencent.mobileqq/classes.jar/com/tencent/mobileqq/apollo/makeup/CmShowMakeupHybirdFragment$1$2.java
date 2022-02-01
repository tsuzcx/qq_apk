package com.tencent.mobileqq.apollo.makeup;

import com.tencent.TMG.utils.QLog;

class CmShowMakeupHybirdFragment$1$2
  implements Runnable
{
  CmShowMakeupHybirdFragment$1$2(CmShowMakeupHybirdFragment.1 param1) {}
  
  public void run()
  {
    if (CmShowMakeupHybirdFragment.a(this.a.a))
    {
      QLog.d("CmShowMakeupHybirdFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_FETCH_BUNDLE , aekitview ready , refresh bundle path");
      return;
    }
    QLog.e("CmShowMakeupHybirdFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_FETCH_BUNDLE , aekitview not ready");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupHybirdFragment.1.2
 * JD-Core Version:    0.7.0.1
 */