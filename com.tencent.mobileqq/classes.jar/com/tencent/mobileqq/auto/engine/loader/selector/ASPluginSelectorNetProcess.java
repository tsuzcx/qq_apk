package com.tencent.mobileqq.auto.engine.loader.selector;

import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.ASEngineQualityReport;
import cooperation.qqcircle.report.ASEngineQualityReport.ReportData;

public class ASPluginSelectorNetProcess
  extends ASBaseSelectorProcess
{
  ASPluginBean a;
  ASPluginBean b;
  
  public ASPluginSelectorNetProcess(ASPluginBean paramASPluginBean1, ASPluginBean paramASPluginBean2)
  {
    this.a = paramASPluginBean1;
    this.b = paramASPluginBean2;
  }
  
  private ASPluginBean a(ASPluginBean paramASPluginBean1, ASPluginBean paramASPluginBean2)
  {
    if (paramASPluginBean1.getVersionCode() <= paramASPluginBean2.getVersionCode())
    {
      a(4);
      paramASPluginBean2 = ASDynamicEngine.a(paramASPluginBean1.getBusinessKey());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ASPluginSelectorNetProcess#checkNet():net plugin version:");
      localStringBuilder.append(paramASPluginBean1.getVersionCode());
      localStringBuilder.append(" lower then asset, go to checkAsset");
      QLog.i(paramASPluginBean2, 1, localStringBuilder.toString());
      return null;
    }
    return b(paramASPluginBean1);
  }
  
  private void a(int paramInt)
  {
    if (this.a == null) {
      return;
    }
    ASEngineQualityReport.report(new ASEngineQualityReport.ReportData().setExt1(this.a.getBusinessKey()).setPluginVersion(this.a.getVersionCode()).setPluginType(this.a.getType()).setEventId("autoshadow_plugin_load_result").setRetCode(paramInt));
  }
  
  private ASPluginBean b(ASPluginBean paramASPluginBean)
  {
    if (!a(paramASPluginBean))
    {
      a(6);
      localObject1 = ASDynamicEngine.a(paramASPluginBean.getBusinessKey());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ASPluginSelectorNetProcess#checkNet():net plugin version:");
      ((StringBuilder)localObject2).append(paramASPluginBean.getVersionCode());
      ((StringBuilder)localObject2).append(" crash too many, go to checkAsset");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return null;
    }
    if (paramASPluginBean.getVersionCode() < paramASPluginBean.getSupportMinPluginVersion())
    {
      a(4);
      localObject1 = ASDynamicEngine.a(paramASPluginBean.getBusinessKey());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ASPluginSelectorNetProcess#checkNet():net plugin version:");
      ((StringBuilder)localObject2).append(paramASPluginBean.getVersionCode());
      ((StringBuilder)localObject2).append(" mini not support, go to checkAsset");
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      return null;
    }
    Object localObject2 = ASDynamicEngine.a(paramASPluginBean.getBusinessKey());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ASPluginSelectorNetProcess#checkNet():use netWork plugin, net version:");
    localStringBuilder.append(paramASPluginBean.getVersionCode());
    localStringBuilder.append(" asset version:");
    Object localObject1 = this.b;
    if (localObject1 != null) {
      localObject1 = Integer.valueOf(((ASPluginBean)localObject1).getVersionCode());
    } else {
      localObject1 = " ";
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(" MiniSupportVersion");
    localStringBuilder.append(paramASPluginBean.getSupportMinPluginVersion());
    QLog.i((String)localObject2, 1, localStringBuilder.toString());
    return paramASPluginBean;
  }
  
  public ASPluginBean a()
  {
    ASPluginBean localASPluginBean1 = this.a;
    if (localASPluginBean1 == null) {
      return null;
    }
    ASPluginBean localASPluginBean2 = this.b;
    if (localASPluginBean2 != null) {
      return a(localASPluginBean1, localASPluginBean2);
    }
    return b(localASPluginBean1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.selector.ASPluginSelectorNetProcess
 * JD-Core Version:    0.7.0.1
 */