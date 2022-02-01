package com.tencent.mobileqq.ark.api.module;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class ArkAppYYBDownloadModule$2
  implements Runnable
{
  ArkAppYYBDownloadModule$2(ArkAppYYBDownloadModule paramArkAppYYBDownloadModule, String paramString) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      QQToast.a(localBaseActivity, this.a, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppYYBDownloadModule.2
 * JD-Core Version:    0.7.0.1
 */