package com.tencent.mobileqq.ark.api.module;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

class ArkAppDownloadModule$8
  implements Runnable
{
  ArkAppDownloadModule$8(ArkAppDownloadModule paramArkAppDownloadModule, String paramString) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      QQToast.makeText(localBaseActivity, this.a, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.8
 * JD-Core Version:    0.7.0.1
 */