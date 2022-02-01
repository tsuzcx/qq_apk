package com.tencent.biz.videostory.support;

import NS_MINI_REPORT.REPORT.SingleDcData;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;

final class VSReporter$1
  implements Runnable
{
  VSReporter$1(String paramString, List paramList) {}
  
  public void run()
  {
    REPORT.SingleDcData localSingleDcData = new REPORT.SingleDcData();
    localSingleDcData.dcid.set(5);
    localSingleDcData.type.set(String.valueOf(2));
    localSingleDcData.report_data.add(VSReporter.a("event", this.a));
    localSingleDcData.report_data.addAll(VSReporter.a());
    List localList = this.b;
    if ((localList != null) && (!localList.isEmpty())) {
      localSingleDcData.report_data.addAll(this.b);
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).addMiniProgramReportData(localSingleDcData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.support.VSReporter.1
 * JD-Core Version:    0.7.0.1
 */