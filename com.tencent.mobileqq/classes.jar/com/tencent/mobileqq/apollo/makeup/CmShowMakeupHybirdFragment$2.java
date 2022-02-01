package com.tencent.mobileqq.apollo.makeup;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.apollo.statistics.ApolloQualityReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import org.light.CameraController.CmShowCallback;

class CmShowMakeupHybirdFragment$2
  implements CameraController.CmShowCallback
{
  CmShowMakeupHybirdFragment$2(CmShowMakeupHybirdFragment paramCmShowMakeupHybirdFragment) {}
  
  public void callback()
  {
    if (CmShowMakeupHybirdFragment.b(this.a))
    {
      ApolloDtReportUtil.a("dressup_3d_page", "model", "expose", null);
      ApolloQualityReportUtil.a("dressup_first_frame", String.valueOf(System.currentTimeMillis() - CmShowMakeupHybirdFragment.a(this.a)), null);
      TraceReportUtil.a(126, 4, 0, new Object[0]);
      CmShowMakeupHybirdFragment.a(this.a, false);
      QLog.i("CmShowMakeupHybirdFragment", 1, "[doSetCmShowAssetsData] first frame");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupHybirdFragment.2
 * JD-Core Version:    0.7.0.1
 */