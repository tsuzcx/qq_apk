package com.tencent.biz.qcircleshadow.remoteCheck;

import android.os.Looper;
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
    paramBaseRequest.append(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCircleGetRainBowRequest.getTraceId());
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
      QCirclePluginManager.a(this.jdField_a_of_type_ComTencentBizQcircleshadowRemoteCheckQCirclePluginManager, paramGetRainbowTableConfigRsp);
      return;
    }
    QCirclePluginQualityReporter.report(new QCirclePluginQualityReporter.ReportData().setEvent_id("qcircle_plugin_cmd_rsp").setRetCode(paramLong));
    paramBaseRequest = new StringBuilder();
    paramBaseRequest.append(" retcode= ");
    paramBaseRequest.append(paramLong);
    paramBaseRequest.append(" errMsg=");
    paramBaseRequest.append(paramString);
    QLog.e("QCirclePluginManager", 1, paramBaseRequest.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.remoteCheck.QCirclePluginManager.1
 * JD-Core Version:    0.7.0.1
 */