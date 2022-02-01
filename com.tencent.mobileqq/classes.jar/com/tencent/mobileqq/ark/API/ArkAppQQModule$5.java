package com.tencent.mobileqq.ark.API;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.qphone.base.util.QLog;

class ArkAppQQModule$5
  implements Runnable
{
  ArkAppQQModule$5(ArkAppQQModule paramArkAppQQModule, String paramString) {}
  
  public void run()
  {
    Activity localActivity = ArkAppModuleBase.a();
    if ((localActivity instanceof FragmentActivity))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.5
 * JD-Core Version:    0.7.0.1
 */