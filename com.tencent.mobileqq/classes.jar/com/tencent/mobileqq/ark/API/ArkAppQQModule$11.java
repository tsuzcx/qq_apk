package com.tencent.mobileqq.ark.API;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.forward.ForwardBaseOption;

class ArkAppQQModule$11
  implements Runnable
{
  ArkAppQQModule$11(ArkAppQQModule paramArkAppQQModule, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Activity localActivity = ArkAppModuleBase.a();
    if (localActivity != null)
    {
      Intent localIntent = ArkFullScreenAppActivity.a(localActivity, this.a, this.this$0.a, this.b, this.c, ArkAppCenterUtil.a());
      if (localIntent != null) {
        ForwardBaseOption.a(localActivity, localIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.11
 * JD-Core Version:    0.7.0.1
 */