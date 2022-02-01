package com.tencent.biz.pubaccount.util.api.impl;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsIPCClient;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsIPCClient.Observer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PublicAccountH5AbilityPluginImpl$7
  implements Runnable
{
  PublicAccountH5AbilityPluginImpl$7(PublicAccountH5AbilityPluginImpl paramPublicAccountH5AbilityPluginImpl, String[] paramArrayOfString) {}
  
  public void run()
  {
    if (!((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture())
    {
      DialogUtil.a(this.this$0.activity, 230, null, HardCodeUtil.a(2131906556), null, this.this$0.activity.getString(2131892267), new PublicAccountH5AbilityPluginImpl.7.1(this), null).show();
      return;
    }
    Object localObject2;
    try
    {
      Object localObject3 = new JSONObject(this.a[0]);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("showUGCVideoRecordPage param json:");
        ((StringBuilder)localObject1).append(((JSONObject)localObject3).toString());
        QLog.i("Q.pubaccount.video.cameracapture", 2, ((StringBuilder)localObject1).toString());
      }
      String str2 = ((JSONObject)localObject3).optString("topicId");
      int i = ((JSONObject)localObject3).optInt("adtag");
      int j = ((JSONObject)localObject3).optInt("mode");
      String str3 = ((JSONObject)localObject3).optString("vid");
      String str4 = ((JSONObject)localObject3).optString("videourl");
      String str5 = ((JSONObject)localObject3).optString("coverurl");
      String str6 = ((JSONObject)localObject3).optString("md5");
      Object localObject1 = ((JSONObject)localObject3).optString("topicName");
      String str7 = ((JSONObject)localObject3).optString("cookie");
      try
      {
        String str1 = new String(Base64Util.decode((String)localObject1, 0));
        localObject1 = str1;
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
      }
      localObject2 = ((JSONObject)localObject3).optString("callback");
      localObject3 = this.this$0.mVideoIPCClient.callServer("CMD_CAMERA_CAPTURE_CHECK_SO_READY", null);
      boolean bool = ((Bundle)localObject3).getBoolean("VALUE_CAMERA_CAPTURE_IS_SO_READY");
      if (((Bundle)localObject3).getBoolean("VALUE_CAMERA_IS_VIDEO_CHATTING"))
      {
        QQToast.makeText(this.this$0.mRuntime.d(), 0, 2131916633, 0).show();
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("showUGCVideoRecordPage isSoReady=");
        ((StringBuilder)localObject3).append(bool);
        QLog.i("Q.pubaccount.video.cameracapture", 2, ((StringBuilder)localObject3).toString());
      }
      if (!bool)
      {
        localObject3 = new QQProgressDialog(this.this$0.mRuntime.d(), this.this$0.mRuntime.d().getResources().getDimensionPixelSize(2131299920));
        ((QQProgressDialog)localObject3).c(2131915564);
      }
      try
      {
        localObject1 = new PublicAccountH5AbilityPluginImpl.7.2(this, (QQProgressDialog)localObject3, str2, (String)localObject1, i, j, (String)localObject2, str3, str4, str5, str6, str7);
        this.this$0.mVideoIPCClient.addObserver((IVideoFeedsIPCClient.Observer)localObject1);
        this.this$0.mVideoIPCClient.callServer("CMD_CAMERA_CAPTURE_SO_DOWNLOAD", null);
        ((QQProgressDialog)localObject3).a(new PublicAccountH5AbilityPluginImpl.7.3(this, (IVideoFeedsIPCClient.Observer)localObject1));
        ((QQProgressDialog)localObject3).show();
        return;
      }
      catch (Exception localException1) {}
      PublicAccountH5AbilityPluginImpl.access$000(this.this$0, str2, (String)localObject1, i, j, (String)localObject2, str3, str4, str5, str6, str7);
      return;
    }
    catch (Exception localException2) {}
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("showUGCVideoRecordPage() Exception=");
      ((StringBuilder)localObject2).append(localException2.getMessage());
      QLog.i("Q.pubaccount.video.cameracapture", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl.7
 * JD-Core Version:    0.7.0.1
 */