package com.tencent.mobileqq.apollo.makeup;

import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;

class CmShowMakeupHybirdFragment$1
  implements CmShowEALoader.InitListener
{
  CmShowMakeupHybirdFragment$1(CmShowMakeupHybirdFragment paramCmShowMakeupHybirdFragment) {}
  
  public void a(int paramInt1, int paramInt2, CmShowEALoader.InitResult paramInitResult)
  {
    QLog.d("CmShowMakeupHybirdFragment", 0, "onComplete errcpde " + paramInt2);
    if (paramInt2 != 0) {
      CmShowMakeupHybirdFragment.a(this.a).post(new CmShowMakeupHybirdFragment.1.1(this, paramInt2));
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 3: 
      if (paramInt2 == 0)
      {
        QLog.d("CmShowMakeupHybirdFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_FETCH_BUNDLE success");
        CmShowMakeupHybirdFragment.a(this.a).post(new CmShowMakeupHybirdFragment.1.2(this));
      }
    case 1: 
      QLog.d("CmShowMakeupHybirdFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_INIT_ENGINE");
      if (paramInt2 == 0) {}
      for (paramInt1 = 0;; paramInt1 = paramInt2)
      {
        TraceReportUtil.a(126, 2, paramInt1, new Object[0]);
        if (paramInt2 != 0) {
          break label213;
        }
        QLog.d("CmShowMakeupHybirdFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_INIT_ENGINE success, path = " + paramInitResult.jdField_a_of_type_JavaLangString);
        CmShowMakeupHybirdFragment.a(this.a, paramInitResult.jdField_a_of_type_JavaLangString);
        CmShowMakeupHybirdFragment.a(this.a).post(new CmShowMakeupHybirdFragment.1.3(this));
        return;
        QLog.e("CmShowMakeupHybirdFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_FETCH_BUNDLE fail!");
        break;
      }
      label213:
      QLog.e("CmShowMakeupHybirdFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_INIT_ENGINE fail!");
      return;
    }
    QLog.d("CmShowMakeupHybirdFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_INIT_CMSRES");
    if (paramInt2 == 0) {}
    for (paramInt1 = 0;; paramInt1 = paramInt2)
    {
      TraceReportUtil.a(126, 5, paramInt1, new Object[0]);
      if (paramInt2 != 0) {
        break;
      }
      CmShowMakeupHybirdFragment.a(this.a, paramInitResult.jdField_a_of_type_DovComQqImAeSinkCmShowAssetsData);
      this.a.b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupHybirdFragment.1
 * JD-Core Version:    0.7.0.1
 */