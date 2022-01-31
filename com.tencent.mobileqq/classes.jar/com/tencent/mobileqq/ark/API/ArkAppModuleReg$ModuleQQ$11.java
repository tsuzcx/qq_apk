package com.tencent.mobileqq.ark.API;

import alpe;
import alsz;
import android.content.Intent;
import aqbe;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.app.BaseActivity;

public class ArkAppModuleReg$ModuleQQ$11
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$11(alpe paramalpe, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      Intent localIntent = ArkFullScreenAppActivity.a(localBaseActivity, this.a, this.this$0.a, this.b, this.c, alsz.a());
      if (localIntent != null) {
        aqbe.a(localBaseActivity, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.11
 * JD-Core Version:    0.7.0.1
 */