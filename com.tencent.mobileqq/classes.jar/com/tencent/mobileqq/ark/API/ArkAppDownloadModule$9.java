package com.tencent.mobileqq.ark.API;

import alob;
import bcpw;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppDownloadModule$9
  implements Runnable
{
  public ArkAppDownloadModule$9(alob paramalob, String paramString) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null) {
      bcpw.a(localBaseActivity, this.a, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDownloadModule.9
 * JD-Core Version:    0.7.0.1
 */