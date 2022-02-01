package com.tencent.avgame.qav;

import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;

class AVGameCameraAssistant$ClearCacheTask
  implements Runnable
{
  boolean a = false;
  
  public void run()
  {
    if (!this.a)
    {
      VideoMemoryManager.getInstance().clearBeautyCache();
      if (QLog.isDevelopLevel()) {
        QLog.i("AVGameCameraAssistant", 4, "ClearCacheTask 1");
      }
    }
    if (!this.a)
    {
      VideoMemoryManager.getInstance().clearWM260();
      if (QLog.isDevelopLevel()) {
        QLog.i("AVGameCameraAssistant", 4, "ClearCacheTask 2");
      }
    }
    if (!this.a)
    {
      VideoMemoryManager.getInstance().clear();
      if (QLog.isDevelopLevel()) {
        QLog.i("AVGameCameraAssistant", 4, "ClearCacheTask 3");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameCameraAssistant.ClearCacheTask
 * JD-Core Version:    0.7.0.1
 */