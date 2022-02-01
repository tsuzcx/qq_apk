package com.tencent.mobileqq.auto.engine.loader.net;

import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngineFactory;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.ASEngineQualityReport;
import cooperation.qqcircle.report.ASEngineQualityReport.ReportData;
import qqcircle.QQCircleConfig.GetRainbowTableConfigRsp;

class ASNetInfoManger$1$1
  implements Runnable
{
  ASNetInfoManger$1$1(ASNetInfoManger.1 param1, boolean paramBoolean, QQCircleConfig.GetRainbowTableConfigRsp paramGetRainbowTableConfigRsp, long paramLong) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("executeOnFileThread isSuccess:");
    localStringBuilder.append(this.a);
    QLog.i("ASNetInfoManger", 1, localStringBuilder.toString());
    if (this.a)
    {
      ASNetInfoManger.a(this.d.c, this.d.b, this.b);
      ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId("autoshadow_plugin_cmd_rsp").setExt1(this.d.b).setPluginVersion(ASDynamicEngineFactory.a(this.d.b).b().getVersionCode()).setPluginType("TYPE_NET").setRetCode(0L));
      return;
    }
    ASNetInfoManger.a(this.d.c);
    ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setEventId("autoshadow_plugin_cmd_rsp").setPluginVersion(ASDynamicEngineFactory.a(this.d.b).b().getVersionCode()).setPluginType("TYPE_NET").setExt1(this.d.b).setRetCode(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.net.ASNetInfoManger.1.1
 * JD-Core Version:    0.7.0.1
 */