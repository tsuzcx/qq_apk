package com.tencent.hippy.qq.module;

import android.app.Activity;
import com.tencent.hippy.qq.api.OpenHippyInfo;
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
    else
    {
      paramHippyMap.finish();
      if (bool) {
        paramHippyMap.overridePendingTransition(0, 2130772025);
      }
      localHippyMap.pushInt("retCode", 0);
    }
    paramPromise.resolve(localHippyMap);
  }
  
  @HippyMethod(name="push")
  public void push(HippyMap paramHippyMap, Promise paramPromise)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("push:");
      ((StringBuilder)localObject).append(paramHippyMap);
      QLog.i("QQNavigatorModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new HippyMap();
    if (new OpenHippyInfo(paramHippyMap).openHippy(getActivity()))
    {
      ((HippyMap)localObject).pushInt("retCode", 0);
    }
    else
    {
      ((HippyMap)localObject).pushInt("retCode", -1);
      ((HippyMap)localObject).pushString("errMsg", "error.");
    }
    paramPromise.resolve(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQNavigatorModule
 * JD-Core Version:    0.7.0.1
 */