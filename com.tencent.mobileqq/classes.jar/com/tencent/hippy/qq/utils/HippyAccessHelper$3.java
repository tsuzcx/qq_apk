package com.tencent.hippy.qq.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;

final class HippyAccessHelper$3
  implements HippyQQEngine.HippyQQEngineListener
{
  HippyAccessHelper$3(String paramString1, String paramString2, HippyQQPreloadEngine paramHippyQQPreloadEngine, HippyAccessHelper.OpenHippyInfo paramOpenHippyInfo) {}
  
  public void onError(int paramInt, String paramString)
  {
    HippyErrorManager.getInstance().endAllOperation();
    synchronized (HippyAccessHelper.access$200())
    {
      HippyAccessHelper.access$300().remove(this.val$moduleName);
      QLog.e("HippyAccessHelper", 1, "preloadHippyPage onError statusCode:" + paramInt + " msg:" + paramString);
      return;
    }
  }
  
  public void onSuccess()
  {
    HippyErrorManager.getInstance().endAllOperation();
    ??? = BaseApplicationImpl.getApplication().getRuntime();
    if (??? == null) {}
    for (??? = ""; (this.val$saveUin != null) && (!this.val$saveUin.equals(???)); ??? = ((AppRuntime)???).getAccount())
    {
      QLog.e("HippyAccessHelper", 1, "preloadHippyPage onSuccess uin changed.");
      this.val$hippyQQEngine.destoryEngineImmediately();
      return;
    }
    synchronized (HippyAccessHelper.access$200())
    {
      HippyAccessHelper.access$300().remove(this.val$moduleName);
      ArrayList localArrayList = (ArrayList)HippyAccessHelper.access$400().get(this.val$moduleName);
      if (localArrayList == null) {
        break label164;
      }
      localArrayList.add(this.val$hippyQQEngine);
      if (localArrayList.size() >= 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HippyAccessHelper", 2, "preloadHippyPage onSuccess size:" + localArrayList.size());
        }
        return;
      }
    }
    HippyAccessHelper.access$100(this.val$openHippyInfo);
    label164:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.HippyAccessHelper.3
 * JD-Core Version:    0.7.0.1
 */