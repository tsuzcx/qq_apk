package com.tencent.hippy.qq.module;

import android.app.Activity;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;

@HippyNativeModule(name="QQNavigatorModule")
public class QQNavigatorModule
  extends QQBaseModule
{
  static final String CLASSNAME = "QQNavigatorModule";
  
  public QQNavigatorModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  @HippyMethod(name="pop")
  public void pop(HippyMap paramHippyMap, Promise paramPromise)
  {
    HippyMap localHippyMap = new HippyMap();
    boolean bool = paramHippyMap.getBoolean("animated");
    paramHippyMap = getActivity();
    if (paramHippyMap == null)
    {
      localHippyMap.pushInt("retCode", -1);
      localHippyMap.pushString("errMsg", "activity is null.");
    }
    for (;;)
    {
      paramPromise.resolve(localHippyMap);
      return;
      paramHippyMap.finish();
      if (bool) {
        paramHippyMap.overridePendingTransition(0, 2130772012);
      }
      localHippyMap.pushInt("retCode", 0);
    }
  }
  
  @HippyMethod(name="push")
  public void push(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQNavigatorModule", 2, "push:" + paramHippyMap);
    }
    HippyMap localHippyMap = new HippyMap();
    if (HippyAccessHelper.startHippyPage(getActivity(), paramHippyMap)) {
      localHippyMap.pushInt("retCode", 0);
    }
    for (;;)
    {
      paramPromise.resolve(localHippyMap);
      return;
      localHippyMap.pushInt("retCode", -1);
      localHippyMap.pushString("errMsg", "error.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQNavigatorModule
 * JD-Core Version:    0.7.0.1
 */