package com.tencent.mobileqq.activity.qwallet.preload;

import aktx;
import aktz;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class PreloadManager$1
  implements Runnable
{
  PreloadManager$1(PreloadManager paramPreloadManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "synDataFromMoggy");
    }
    Object localObject = (aktz)this.this$0.a.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    if (localObject != null)
    {
      ((aktz)localObject).c("preload", this.this$0);
      localObject = ((aktz)localObject).a("preload");
      this.this$0.a((aktx)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.1
 * JD-Core Version:    0.7.0.1
 */