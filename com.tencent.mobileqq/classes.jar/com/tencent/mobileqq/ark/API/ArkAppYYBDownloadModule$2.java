package com.tencent.mobileqq.ark.API;

import anhb;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class ArkAppYYBDownloadModule$2
  implements Runnable
{
  public ArkAppYYBDownloadModule$2(anhb paramanhb, String paramString) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      QQToast.a(localBaseActivity, this.a, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.2
 * JD-Core Version:    0.7.0.1
 */