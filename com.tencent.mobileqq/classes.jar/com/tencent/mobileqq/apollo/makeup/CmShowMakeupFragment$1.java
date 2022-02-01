package com.tencent.mobileqq.apollo.makeup;

import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;

class CmShowMakeupFragment$1
  implements CmShowEALoader.InitListener
{
  CmShowMakeupFragment$1(CmShowMakeupFragment paramCmShowMakeupFragment) {}
  
  public void a(int paramInt1, int paramInt2, CmShowEALoader.InitResult paramInitResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onComplete errcpde ");
    localStringBuilder.append(paramInt2);
    QLog.d("[cmshow]CmShowMakeupFragment", 0, localStringBuilder.toString());
    if (paramInt2 != 0) {
      CmShowMakeupFragment.a(this.a).post(new CmShowMakeupFragment.1.1(this, paramInt2));
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return;
        }
        if (paramInt2 == 0)
        {
          QLog.d("[cmshow]CmShowMakeupFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_FETCH_BUNDLE success");
          CmShowMakeupFragment.a(this.a).post(new CmShowMakeupFragment.1.2(this));
          return;
        }
        QLog.e("[cmshow]CmShowMakeupFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_FETCH_BUNDLE fail!");
        return;
      }
      QLog.d("[cmshow]CmShowMakeupFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_INIT_CMSRES");
      if (paramInt2 == 0) {
        paramInt1 = 0;
      } else {
        paramInt1 = paramInt2;
      }
      TraceReportUtil.a(126, 5, paramInt1, new Object[0]);
      if (paramInt2 == 0)
      {
        CmShowMakeupFragment.a(this.a, paramInitResult.a);
        this.a.b();
      }
    }
    else
    {
      QLog.d("[cmshow]CmShowMakeupFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_INIT_ENGINE");
      if (paramInt2 == 0) {
        paramInt1 = 0;
      } else {
        paramInt1 = paramInt2;
      }
      TraceReportUtil.a(126, 2, paramInt1, new Object[0]);
      if (paramInt2 == 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[cmShowResPreLoad][onComplete] step = STEP_INIT_ENGINE success, path = ");
        localStringBuilder.append(paramInitResult.b);
        QLog.d("[cmshow]CmShowMakeupFragment", 0, localStringBuilder.toString());
        CmShowMakeupFragment.a(this.a, paramInitResult.b);
        CmShowMakeupFragment.a(this.a).post(new CmShowMakeupFragment.1.3(this));
        return;
      }
      QLog.e("[cmshow]CmShowMakeupFragment", 0, "[cmShowResPreLoad][onComplete] step = STEP_INIT_ENGINE fail!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment.1
 * JD-Core Version:    0.7.0.1
 */