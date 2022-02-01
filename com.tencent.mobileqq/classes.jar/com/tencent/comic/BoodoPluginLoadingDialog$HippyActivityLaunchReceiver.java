package com.tencent.comic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class BoodoPluginLoadingDialog$HippyActivityLaunchReceiver
  extends BroadcastReceiver
{
  private BoodoPluginLoadingDialog$HippyActivityLaunchReceiver(BoodoPluginLoadingDialog paramBoodoPluginLoadingDialog) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BoodoPluginLoadingDialog", 1, "HippyActivityLaunchReceiver onReceive");
    }
    if ("action_hippy_activity_launch".equals(paramIntent.getAction())) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.BoodoPluginLoadingDialog.HippyActivityLaunchReceiver
 * JD-Core Version:    0.7.0.1
 */