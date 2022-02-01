package com.tencent.hippy.qq.utils;

import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

final class HippyAccessHelper$2
  implements HippyQQEngine.HippyQQEngineListener
{
  HippyAccessHelper$2(String paramString1, HippyQQPreloadEngine paramHippyQQPreloadEngine, String paramString2, OpenHippyInfo paramOpenHippyInfo) {}
  
  public void onError(int paramInt, String paramString)
  {
    HippyErrorManager.getInstance().endAllOperation();
    synchronized (HippyAccessHelper.access$100())
    {
      HippyAccessHelper.access$200().remove(this.val$moduleName);
      this.val$hippyQQEngine.destroyEngineImmediately();
      ??? = new StringBuilder();
      ((StringBuilder)???).append("preloadHippyPage onError statusCode:");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(" msg:");
      ((StringBuilder)???).append(paramString);
      QLog.e("HippyAccessHelper", 1, ((StringBuilder)???).toString());
      return;
    }
  }
  
  public void onSuccess()
  {
    HippyErrorManager.getInstance().endAllOperation();
    ??? = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (??? == null) {
      ??? = "";
    } else {
      ??? = ((AppRuntime)???).getAccount();
    }
    Object localObject2 = this.val$saveUin;
    if ((localObject2 != null) && (!((String)localObject2).equals(???)))
    {
      QLog.e("HippyAccessHelper", 1, "preloadHippyPage onSuccess uin changed.");
      this.val$hippyQQEngine.destroyEngineImmediately("accountChanged");
      return;
    }
    synchronized (HippyAccessHelper.access$100())
    {
      HippyAccessHelper.access$200().remove(this.val$moduleName);
      localObject2 = (ArrayList)HippyAccessHelper.access$300().get(this.val$moduleName);
      if (localObject2 != null)
      {
        ((ArrayList)localObject2).add(this.val$hippyQQEngine);
        if (((ArrayList)localObject2).size() >= 1)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("preloadHippyPage onSuccess size:");
            localStringBuilder.append(((ArrayList)localObject2).size());
            QLog.d("HippyAccessHelper", 2, localStringBuilder.toString());
          }
          return;
        }
        HippyAccessHelper.access$000(this.val$openHippyInfo);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.HippyAccessHelper.2
 * JD-Core Version:    0.7.0.1
 */