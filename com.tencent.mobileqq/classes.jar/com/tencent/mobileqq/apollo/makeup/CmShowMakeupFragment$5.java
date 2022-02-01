package com.tencent.mobileqq.apollo.makeup;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import org.light.CameraController.CmShowCallback;

class CmShowMakeupFragment$5
  implements CameraController.CmShowCallback
{
  CmShowMakeupFragment$5(CmShowMakeupFragment paramCmShowMakeupFragment) {}
  
  public void callback()
  {
    if (CmShowMakeupFragment.h(this.a))
    {
      ApolloDtReportUtil.a("dressup_3d_page", "model", "expose", null);
      ApolloQualityReportUtil.a("dressup_first_frame", String.valueOf(System.currentTimeMillis() - CmShowMakeupFragment.i(this.a)), null);
      TraceReportUtil.a(126, 4, 0, new Object[0]);
      CmShowMakeupFragment.a(this.a, false);
      QLog.i("[cmshow]CmShowMakeupFragment", 1, "[doSetCmShowAssetsData] first frame");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupFragment.5
 * JD-Core Version:    0.7.0.1
 */