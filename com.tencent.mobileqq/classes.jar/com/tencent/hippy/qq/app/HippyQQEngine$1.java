package com.tencent.hippy.qq.app;

import com.tencent.hippy.qq.update.HippyQQUpdateManager.PackageUpdateListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class HippyQQEngine$1
  implements HippyQQUpdateManager.PackageUpdateListener
{
  HippyQQEngine$1(HippyQQEngine paramHippyQQEngine, long paramLong) {}
  
  public void onUpdateComplete(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new HippyQQEngine.1.1(this, paramInt, paramString1, paramString2);
    if (HippyQQEngine.isMainThread())
    {
      paramString1.run();
      return;
    }
    ThreadManager.getUIHandler().post(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine.1
 * JD-Core Version:    0.7.0.1
 */