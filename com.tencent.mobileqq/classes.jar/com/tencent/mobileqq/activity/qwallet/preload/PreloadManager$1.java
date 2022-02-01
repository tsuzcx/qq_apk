package com.tencent.mobileqq.activity.qwallet.preload;

import akpb;
import akpd;
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
    Object localObject = (akpd)this.this$0.a.getManager(245);
    if (localObject != null)
    {
      ((akpd)localObject).c("preload", this.this$0);
      localObject = ((akpd)localObject).a("preload");
      this.this$0.a((akpb)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.1
 * JD-Core Version:    0.7.0.1
 */