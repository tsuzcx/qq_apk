package com.tencent.mobileqq.auto.engine.loader.selector;

import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.qphone.base.util.QLog;

public class ASSelectorNativeProcess
  extends ASBaseSelectorProcess
{
  public ASPluginBean a;
  
  public ASSelectorNativeProcess(ASPluginBean paramASPluginBean)
  {
    this.a = paramASPluginBean;
  }
  
  public ASPluginBean a()
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      QLog.i("ASDynamicEngine", 1, "ASSelectorNativeProcess#checkAsset():No Asset Info");
      return null;
    }
    localObject = ASDynamicEngine.a(((ASPluginBean)localObject).getBusinessKey());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ASSelectorNativeProcess#checkAsset():use asset plugin , assetVersion:");
    localStringBuilder.append(this.a.getVersionCode());
    localStringBuilder.append(" ,MiniSupportVersion:");
    localStringBuilder.append(this.a.getSupportMinHostVersion());
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.selector.ASSelectorNativeProcess
 * JD-Core Version:    0.7.0.1
 */