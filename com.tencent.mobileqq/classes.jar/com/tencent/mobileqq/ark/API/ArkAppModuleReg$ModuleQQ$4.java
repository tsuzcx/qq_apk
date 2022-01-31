package com.tencent.mobileqq.ark.API;

import alat;
import alem;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import aphp;
import baev;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.qphone.base.util.QLog;

public class ArkAppModuleReg$ModuleQQ$4
  implements Runnable
{
  public ArkAppModuleReg$ModuleQQ$4(alat paramalat, ArkAppMessage paramArkAppMessage) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if ((localBaseActivity instanceof FragmentActivity))
    {
      Bundle localBundle = baev.a(this.a.appName, this.a.appView, this.a.appMinVersion, this.a.metaList, alem.a(), null, null);
      localBundle.putBoolean("forward_ark_app_direct", false);
      localBundle.putString("forward_ark_app_name", this.a.appName);
      localBundle.putString("forward_ark_app_view", this.a.appView);
      localBundle.putString("forward_ark_app_desc", this.a.appDesc);
      localBundle.putString("forward_ark_app_ver", this.a.appMinVersion);
      localBundle.putString("forward_ark_app_meta", this.a.metaList);
      localBundle.putString("forward_ark_app_prompt", this.a.promptText);
      localBundle.putString("forward_ark_app_config", this.a.config);
      Intent localIntent = new Intent();
      localIntent.setClass(localBaseActivity, ForwardRecentActivity.class);
      localIntent.putExtra("forward_type", 27);
      localIntent.putExtra("is_ark_display_share", true);
      localIntent.putExtras(localBundle);
      if (QLog.isColorLevel()) {
        QLog.i("ArkApp", 2, "multiAio.buildForwardIntent: " + localBundle);
      }
      aphp.a(localBaseActivity, localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ.4
 * JD-Core Version:    0.7.0.1
 */