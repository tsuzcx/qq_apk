package com.tencent.hippy.qq.utils;

import com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

final class HippyAccessHelper$3
  implements HippyQQEngine.HippyQQEngineListener
{
  HippyAccessHelper$3(String paramString1, HippyQQPreloadEngine paramHippyQQPreloadEngine, boolean paramBoolean, String paramString2) {}
  
  public void onError(int paramInt, String paramString)
  {
    HippyErrorManager.getInstance().endAllOperation();
    QLog.e("HippyAccessHelper", 1, "preloadHippyPage onError statusCode:" + paramInt + " msg:" + paramString);
  }
  
  public void onSuccess()
  {
    HippyErrorManager.getInstance().endAllOperation();
    synchronized (HippyAccessHelper.access$100())
    {
      ArrayList localArrayList = (ArrayList)HippyAccessHelper.access$200().get(this.val$moduleName);
      if (localArrayList != null)
      {
        localArrayList.add(this.val$hippyQQEngine);
        if (localArrayList.size() >= 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("HippyAccessHelper", 2, "preloadHippyPage onSuccess size:" + localArrayList.size());
          }
          return;
        }
        HippyAccessHelper.access$300(this.val$moduleName, this.val$isDebugMode, this.val$pageUrl);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.HippyAccessHelper.3
 * JD-Core Version:    0.7.0.1
 */