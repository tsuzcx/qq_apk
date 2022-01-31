package com.tencent.mobileqq.activity.qwallet.preload;

import agzd;
import agzf;
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
    Object localObject = (agzf)this.this$0.a.getManager(245);
    if (localObject != null)
    {
      ((agzf)localObject).c("preload", this.this$0);
      localObject = ((agzf)localObject).a("preload");
      this.this$0.a((agzd)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.1
 * JD-Core Version:    0.7.0.1
 */