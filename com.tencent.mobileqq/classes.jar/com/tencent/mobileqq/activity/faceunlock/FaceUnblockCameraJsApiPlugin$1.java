package com.tencent.mobileqq.activity.faceunlock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class FaceUnblockCameraJsApiPlugin$1
  extends BroadcastReceiver
{
  FaceUnblockCameraJsApiPlugin$1(FaceUnblockCameraJsApiPlugin paramFaceUnblockCameraJsApiPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("recording_time_out", false))
    {
      QQToast.a(this.a.mRuntime.a(), 2131698852, 0).a();
      QLog.e("FaceUnblockCameraJsApiPlugin", 1, "FaceUnlock record timeout!");
      return;
    }
    paramContext = paramIntent.getStringExtra("target_media_url");
    FaceUnblockCameraJsApiPlugin.a(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.FaceUnblockCameraJsApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */