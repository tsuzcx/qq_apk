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
    paramWSRequest = new StringBuilder();
    paramWSRequest.append("BeaconSendRequest onTaskResponse succeed: ");
    paramWSRequest.append(paramstWeishiDengtaReportRsp.code);
    paramWSRequest.append(" , ");
    paramWSRequest.append(paramstWeishiDengtaReportRsp.msg);
    WSLog.b("beaconData2Server", paramWSRequest.toString());
    if (paramstWeishiDengtaReportRsp.code != 0) {
      WSStatisticsReporter.access$1500(this.a, String.valueOf(2), String.valueOf(paramstWeishiDengtaReportRsp.code), paramstWeishiDengtaReportRsp.msg);
    }
    return null;
  }
  
  protected void a(WSServiceErrorInfo paramWSServiceErrorInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BeaconSendRequest onTaskResponse failed code:");
    localStringBuilder.append(paramWSServiceErrorInfo.a());
    localStringBuilder.append(", msg:");
    localStringBuilder.append(paramWSServiceErrorInfo.b());
    WSLog.d("beaconData2Server", localStringBuilder.toString());
    WSStatisticsReporter.access$1500(this.a, String.valueOf(1), String.valueOf(paramWSServiceErrorInfo.a()), paramWSServiceErrorInfo.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.2
 * JD-Core Version:    0.7.0.1
 */