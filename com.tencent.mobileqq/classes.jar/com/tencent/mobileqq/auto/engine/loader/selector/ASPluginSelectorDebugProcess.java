package com.tencent.mobileqq.auto.engine.loader.selector;

import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class ASPluginSelectorDebugProcess
  extends ASBaseSelectorProcess
{
  private ASPluginBean a;
  
  private ASPluginBean b()
  {
    if ((this.a != null) && (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion()))
    {
      QLog.i(ASDynamicEngine.a(this.a.getBusinessKey()), 1, "ASPluginSelectorDebugProcess#checkDebug():use test plugin？ true");
      return this.a;
    }
    QLog.i("ASDynamicEngine", 1, "ASPluginSelectorDebugProcess#checkDebug():use test plugin？ false");
    return null;
  }
  
  public ASPluginBean a()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.selector.ASPluginSelectorDebugProcess
 * JD-Core Version:    0.7.0.1
 */