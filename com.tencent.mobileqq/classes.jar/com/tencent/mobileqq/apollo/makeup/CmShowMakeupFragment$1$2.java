package com.tencent.mobileqq.apollo.makeup;

import com.tencent.TMG.utils.QLog;

class CmShowMakeupFragment$1$2
  implements Runnable
{
  CmShowMakeupFragment$1$2(CmShowMakeupFragment.1 param1) {}
  
  public void run()
  {
    if (CmShowMakeupFragment.a(this.a.a))
    {
      QLog.d("[cmshow]CmShowMakeupFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_FETCH_BUNDLE , aekitview ready , refresh bundle path");
      return;
    }
    QLog.e("[cmshow]CmShowMakeupFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_FETCH_BUNDLE , aekitview not ready");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment.1.2
 * JD-Core Version:    0.7.0.1
 */