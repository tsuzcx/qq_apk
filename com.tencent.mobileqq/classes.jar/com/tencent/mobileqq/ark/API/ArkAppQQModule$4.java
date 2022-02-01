package com.tencent.mobileqq.ark.API;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import aopk;
import aoqa;
import atky;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;
import com.tencent.qphone.base.util.QLog;

public class ArkAppQQModule$4
  implements Runnable
{
  public ArkAppQQModule$4(aoqa paramaoqa, ArkAppMessage paramArkAppMessage) {}
  
  public void run()
  {
    Activity localActivity = aopk.a();
    if ((localActivity instanceof FragmentActivity))
    {
      Bundle localBundle = QQCustomArkDialog.AppInfo.zipArgs(this.a.appName, this.a.appView, this.a.appMinVersion, this.a.metaList, ArkAppCenterUtil.getDensity(), null, null);
      localBundle.putBoolean("forward_ark_app_direct", false);
      localBundle.putString("forward_ark_app_name", this.a.appName);
      localBundle.putString("forward_ark_app_view", this.a.appView);
      localBundle.putString("forward_ark_app_desc", this.a.appDesc);
      localBundle.putString("forward_ark_app_ver", this.a.appMinVersion);
      localBundle.putString("forward_ark_app_meta", this.a.metaList);
      localBundle.putString("forward_ark_app_prompt", this.a.promptText);
      localBundle.putString("forward_ark_app_config", this.a.config);
      Intent localIntent = new Intent();
      localIntent.setClass(localActivity, ForwardRecentActivity.class);
      localIntent.putExtra("forward_type", 27);
      localIntent.putExtra("is_ark_display_share", true);
      localIntent.putExtras(localBundle);
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp.ArkAppQQModule", 2, "multiAio.buildForwardIntent: " + localBundle);
      }
      atky.a(localActivity, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppQQModule.4
 * JD-Core Version:    0.7.0.1
 */