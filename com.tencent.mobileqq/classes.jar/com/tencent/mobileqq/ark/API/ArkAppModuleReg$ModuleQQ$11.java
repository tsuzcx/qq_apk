package com.tencent.mobileqq.ark.API;

import alat;
import alem;
import android.content.Intent;
import aphp;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppModuleReg$ModuleQQ$11
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$11(alat paramalat, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      Intent localIntent = ArkFullScreenAppActivity.a(localBaseActivity, this.a, this.this$0.a, this.b, this.c, alem.a());
      if (localIntent != null) {
        aphp.a(localBaseActivity, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.11
 * JD-Core Version:    0.7.0.1
 */