package com.tencent.mobileqq.ark.API;

import alql;
import bcpw;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppYYBDownloadModule$2
  implements Runnable
{
  public ArkAppYYBDownloadModule$2(alql paramalql, String paramString) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      bcpw.a(localBaseActivity, this.a, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppYYBDownloadModule.2
 * JD-Core Version:    0.7.0.1
 */