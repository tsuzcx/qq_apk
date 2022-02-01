package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action;

import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.SoftAdReportData;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.qroute.QRoute;

final class ReadInJoyAdReportUtils$1
  implements Runnable
{
  ReadInJoyAdReportUtils$1(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, boolean paramBoolean1, Integer paramInteger, ReportAction paramReportAction, int paramInt3, boolean paramBoolean2, SoftAdReportData paramSoftAdReportData) {}
  
  public void run()
  {
    if (((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).isGameComponentType(this.a))
    {
      ReadInJoyAdReportUtils.a(this.a, this.b, this.c, this.d, this.e, this.f);
      return;
    }
    if (this.a.isSoftAd())
    {
      ReadInJoyAdReportUtils.a(this.a, this.g, this.b, this.c, this.d, this.e, this.f, this.h, this.i);
      return;
    }
    ReadInJoyAdReportUtils.b(this.a, this.g, this.b, this.d, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils.1
 * JD-Core Version:    0.7.0.1
 */