package com.tencent.mobileqq.apollo.makeup;

import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import org.jetbrains.annotations.Nullable;

class CmShowMakeupFragment$2
  implements CmShowCrossEngineLoader.CEInitListener
{
  CmShowMakeupFragment$2(CmShowMakeupFragment paramCmShowMakeupFragment) {}
  
  public void a(int paramInt1, int paramInt2, @Nullable CmShowCrossEngineLoader.CEInitResult paramCEInitResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CrossEngine init onComplete step=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" errorcode=");
    localStringBuilder.append(paramInt2);
    QLog.i("[cmshow]CmShowMakeupFragment", 1, localStringBuilder.toString());
    if (paramInt2 != 0) {
      CmShowMakeupFragment.a(this.a).post(new CmShowMakeupFragment.2.1(this, paramInt2));
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return;
      }
      QLog.d("[cmshow]CmShowMakeupFragment", 0, "[CrossEngine][cmShowResPreLoad][onComplete] step = STEP_INIT_CMSRES");
      if (paramInt2 == 0) {
        paramInt1 = 0;
      } else {
        paramInt1 = paramInt2;
      }
      TraceReportUtil.a(126, 7, paramInt1, new Object[0]);
      if ((paramInt2 == 0) && (paramCEInitResult != null))
      {
        CmShowMakeupFragment.a(this.a, paramCEInitResult.a);
        this.a.b();
      }
    }
    else
    {
      QLog.d("[cmshow]CmShowMakeupFragment", 0, "[CrossEngine][cmShowResPreLoad][onComplete] step = STEP_INIT_ENGINE");
      if (paramInt2 == 0) {
        paramInt1 = 0;
      } else {
        paramInt1 = paramInt2;
      }
      TraceReportUtil.a(126, 6, paramInt1, new Object[0]);
      if (paramInt2 == 0)
      {
        QLog.d("[cmshow]CmShowMakeupFragment", 0, "[CrossEngine][cmShowResPreLoad][onComplete] step = STEP_INIT_ENGINE success");
        CmShowMakeupFragment.a(this.a).post(new CmShowMakeupFragment.2.2(this));
        return;
      }
      QLog.e("[cmshow]CmShowMakeupFragment", 0, "[CrossEngine][cmShowResPreLoad][onComplete] step = STEP_INIT_ENGINE fail!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment.2
 * JD-Core Version:    0.7.0.1
 */