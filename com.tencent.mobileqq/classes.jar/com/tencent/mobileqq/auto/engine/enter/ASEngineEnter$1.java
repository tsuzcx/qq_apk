package com.tencent.mobileqq.auto.engine.enter;

import com.tencent.mobileqq.auto.engine.enter.impl.IASEnter;
import com.tencent.mobileqq.auto.engine.lib.ASEnterBean;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngineFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

final class ASEngineEnter$1
  implements Runnable
{
  ASEngineEnter$1(ASEnterBean paramASEnterBean) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    IASEnter localIASEnter;
    if (ASEngineEnter.a().containsKey(this.a.getBusinessKey())) {
      localIASEnter = (IASEnter)ASEngineEnter.a().get(this.a.getBusinessKey());
    } else {
      localIASEnter = ASEngineEnter.b(this.a);
    }
    if (localIASEnter == null)
    {
      QLog.d(ASDynamicEngine.a(this.a.getBusinessKey()), 1, "their is no enter");
      return;
    }
    ASEngineEnter.a().put(this.a.getBusinessKey(), localIASEnter);
    if ((!ASDynamicEngineFactory.a(this.a.getBusinessKey()).g()) && (!ASDynamicEngineFactory.a(this.a.getBusinessKey()).d()))
    {
      localIASEnter.a(this.a);
      return;
    }
    localIASEnter.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.enter.ASEngineEnter.1
 * JD-Core Version:    0.7.0.1
 */