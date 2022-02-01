package com.tencent.mobileqq.auto.engine.loader.selector;

import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngineFactory;
import com.tencent.mobileqq.auto.engine.loader.ASEngineConfig;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.qphone.base.util.QLog;

public class ASPluginSelectorWnsProcess
  extends ASBaseSelectorProcess
{
  private ASPluginBean a;
  
  public ASPluginSelectorWnsProcess(ASPluginBean paramASPluginBean)
  {
    this.a = paramASPluginBean;
  }
  
  private ASPluginBean b(ASPluginBean paramASPluginBean)
  {
    if (ASDynamicEngineFactory.a(paramASPluginBean.getBusinessKey()).f().c())
    {
      QLog.i(ASDynamicEngine.a(paramASPluginBean.getBusinessKey()), 1, "ASPluginSelectorWnsProcess#checkWNS():WNS force use asset true");
      return paramASPluginBean;
    }
    QLog.i(ASDynamicEngine.a(paramASPluginBean.getBusinessKey()), 1, "ASPluginSelectorWnsProcess#checkWNS():WNS force use asset false");
    return null;
  }
  
  public ASPluginBean a()
  {
    return b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.selector.ASPluginSelectorWnsProcess
 * JD-Core Version:    0.7.0.1
 */