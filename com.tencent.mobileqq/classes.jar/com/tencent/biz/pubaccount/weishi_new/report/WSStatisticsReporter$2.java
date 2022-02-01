package com.tencent.biz.pubaccount.weishi_new.report;

import UserGrowth.stWeishiDengtaReportRsp;
import com.tencent.biz.pubaccount.weishi_new.net.RspHeaderBean;
import com.tencent.biz.pubaccount.weishi_new.net.common.ServiceCallback;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceErrorInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSStatisticsReporter$2
  extends ServiceCallback<stWeishiDengtaReportRsp, Object>
{
  WSStatisticsReporter$2(WSStatisticsReporter paramWSStatisticsReporter) {}
  
  protected Object a(WSRequest<stWeishiDengtaReportRsp> paramWSRequest, stWeishiDengtaReportRsp paramstWeishiDengtaReportRsp, RspHeaderBean paramRspHeaderBean)
  {
    WSLog.b("beaconData2Server", "BeaconSendRequest onTaskResponse succeed: " + paramstWeishiDengtaReportRsp.code + " , " + paramstWeishiDengtaReportRsp.msg);
    if (paramstWeishiDengtaReportRsp.code != 0) {
      WSStatisticsReporter.access$1800(this.a, String.valueOf(2), String.valueOf(paramstWeishiDengtaReportRsp.code), paramstWeishiDengtaReportRsp.msg);
    }
    return null;
  }
  
  public void a(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    WSLog.d("beaconData2Server", "BeaconSendRequest onTaskResponse failed code:" + paramWSServiceErrorInfo.a() + ", msg:" + paramWSServiceErrorInfo.a());
    WSStatisticsReporter.access$1800(this.a, String.valueOf(1), String.valueOf(paramWSServiceErrorInfo.a()), paramWSServiceErrorInfo.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.2
 * JD-Core Version:    0.7.0.1
 */