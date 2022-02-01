package com.tencent.mobileqq.ark.api.module;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.qphone.base.util.QLog;

class ArkAppQQModule$5
  implements Runnable
{
  ArkAppQQModule$5(ArkAppQQModule paramArkAppQQModule, String paramString) {}
  
  public void run()
  {
    Activity localActivity = ArkAppQQModuleBase.a();
    if ((localActivity instanceof BaseActivity))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("forward_text", this.a);
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      localIntent.putExtra("direct_send_if_dataline_forward", true);
      ForwardBaseOption.a(localActivity, localIntent, 21);
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage text success.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.5
 * JD-Core Version:    0.7.0.1
 */