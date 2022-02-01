package com.tencent.mobileqq.auto.engine.enter;

import com.tencent.mobileqq.auto.engine.enter.impl.IASEnter;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.qphone.base.util.QLog;

final class ASEngineEnter$2
  implements IASEnter
{
  public void a(ASEnterBean paramASEnterBean)
  {
    QLog.d(ASDynamicEngine.a(paramASEnterBean.getBusinessKey()), 1, "do thing native");
  }
  
  public void b(ASEnterBean paramASEnterBean)
  {
    QLog.d(ASDynamicEngine.a(paramASEnterBean.getBusinessKey()), 1, "do thing native");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.enter.ASEngineEnter.2
 * JD-Core Version:    0.7.0.1
 */