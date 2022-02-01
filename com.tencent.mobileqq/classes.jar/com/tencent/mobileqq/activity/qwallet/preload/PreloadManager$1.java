package com.tencent.mobileqq.activity.qwallet.preload;

import alam;
import alao;
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
    Object localObject = (alao)this.this$0.a.getManager(245);
    if (localObject != null)
    {
      ((alao)localObject).c("preload", this.this$0);
      localObject = ((alao)localObject).a("preload");
      this.this$0.a((alam)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.1
 * JD-Core Version:    0.7.0.1
 */