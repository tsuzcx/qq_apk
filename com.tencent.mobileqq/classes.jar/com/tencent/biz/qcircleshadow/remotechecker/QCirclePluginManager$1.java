package com.tencent.biz.qcircleshadow.remotechecker;

import android.os.Looper;
import com.tencent.biz.qcircleshadow.remotecheck.QCircleGetRainBowRequest;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePluginQualityReporter;
import cooperation.qqcircle.report.QCirclePluginQualityReporter.ReportData;
import mqq.os.MqqHandler;
import qqcircle.QQCircleConfig.GetRainbowTableConfigRsp;

class QCirclePluginManager$1
  implements VSDispatchObserver.onVSRspCallBack<QQCircleConfig.GetRainbowTableConfigRsp>
{
  QCirclePluginManager$1(QCirclePluginManager paramQCirclePluginManager, QCircleGetRainBowRequest paramQCircleGetRainBowRequest) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleConfig.GetRainbowTableConfigRsp paramGetRainbowTableConfigRsp)
  {
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append("traceId:");
    paramBaseRequest.append(this.a.getTraceId());
    paramBaseRequest.append(" retcode:");
    paramBaseRequest.append(paramLong);
    QLog.i("QCirclePluginManager", 1, paramBaseRequest.toString());
    if (paramBoolean)
    {
      if (Looper.myLooper().equals(Looper.getMainLooper()))
      {
        ThreadManager.getSubThreadHandler().post(new QCirclePluginManager.1.1(this, paramGetRainbowTableConfigRsp));
        return;
      }
      QCirclePluginManager.a(this.b, paramGetRainbowTableConfigRsp);
      return;
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEventId("qcircle_plugin_cmd_rsp").setRetCode(paramLong));
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append(" retcode= ");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(" errMsg=");
    paramBaseRequest.append(paramString);
    QLog.e("QCirclePluginManager", 1, paramBaseRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remotechecker.QCirclePluginManager.1
 * JD-Core Version:    0.7.0.1
 */