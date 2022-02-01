package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class NewerGuidePlugin$2
  extends BroadcastReceiver
{
  NewerGuidePlugin$2(NewerGuidePlugin paramNewerGuidePlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("NewerGuidePlugin", 2, String.format("mAvatarReceiver.onReceive action=%s", new Object[] { paramContext }));
    }
    if ("ACTION_NEWER_GUIDE_SELECT_AVATAR_RESULT".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
      boolean bool = paramIntent.getBooleanExtra("PhotoConst.SYNCQZONE", false);
      paramIntent = paramIntent.getStringExtra("PhotoConst.SOURCE_FROM");
      if (!TextUtils.isEmpty(paramContext))
      {
        if (QLog.isColorLevel()) {
          QLog.d("NewerGuidePlugin", 2, String.format("mAvatarReceiver.onReceive path=%s syncQZone=%s sourceFrom=%s", new Object[] { paramContext, Boolean.valueOf(bool), paramIntent }));
        }
        Bundle localBundle = new Bundle();
        localBundle.putString("key_action", "setAvatar");
        localBundle.putString("path", paramContext);
        localBundle.putBoolean("PhotoConst.SYNCQZONE", bool);
        localBundle.putString("PhotoConst.SOURCE_FROM", paramIntent);
        paramContext = DataFactory.a("ipc_newer_guide", null, NewerGuidePlugin.a(this.a).key, localBundle);
        ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramContext);
        if (NewerGuidePlugin.b(this.a) == null)
        {
          paramContext = this.a.mRuntime.d();
          int i = paramContext.getResources().getDimensionPixelSize(2131299920);
          NewerGuidePlugin.a(this.a, new QQProgressDialog(paramContext, i));
          NewerGuidePlugin.b(this.a).a(HardCodeUtil.a(2131905288));
        }
        NewerGuidePlugin.b(this.a).show();
      }
    }
    else if ("ACTION_NEWER_GUIDE_CMSHOW_AVATAR_RESULT".equals(paramContext))
    {
      paramContext = paramIntent.getStringExtra("path");
      NewerGuidePlugin.a(this.a, true, paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewerGuidePlugin.2
 * JD-Core Version:    0.7.0.1
 */