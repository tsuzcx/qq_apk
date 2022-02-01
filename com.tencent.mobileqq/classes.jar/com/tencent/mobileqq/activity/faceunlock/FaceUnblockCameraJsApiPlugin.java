package com.tencent.mobileqq.activity.faceunlock;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FaceUnblockCameraJsApiPlugin
  extends WebViewPlugin
{
  public BroadcastReceiver a;
  private String a;
  private String b;
  
  public FaceUnblockCameraJsApiPlugin()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new FaceUnblockCameraJsApiPlugin.1(this);
    this.mPluginNameSpace = "faceUnblockCamera";
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    if (((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("edit_video_type", 10025);
      localBundle.putInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.M.a());
      localBundle.putInt("entrance_type", 132);
      localBundle.putBoolean("enable_local_video", false);
      localBundle.putBoolean("PeakConstants.ARG_BEAUTY", false);
      localBundle.putBoolean("PeakConstants.ARG_ALBUM", false);
      localBundle.putBoolean("PeakConstants.ARG_SHARP_FACE", false);
      localBundle.putBoolean("PeakConstants.ARG_SUPPORT_FILTER", false);
      localBundle.putInt("ability_flag", 3);
      localBundle.putIntegerArrayList("support_intent_mode", new ArrayList(Arrays.asList(new Integer[] { Integer.valueOf(0) })));
      localBundle.putString("key_face_unlock_code", paramString);
      paramString = new Intent();
      paramString.setAction("from_webtool_launchshortvideo");
      paramString.setClass(paramActivity, JumpActivity.class);
      paramString.putExtras(localBundle);
      paramActivity.startActivity(paramString);
      return;
    }
    QLog.d("FaceUnblockCameraJsApiPlugin", 1, "openQIMCameraCaptureActivity failed: not support media codec");
    this.b = ShortVideoUtils.getLocalShortVideoPath();
    paramActivity = new Intent("android.media.action.VIDEO_CAPTURE");
    paramActivity.putExtra("output", Uri.fromFile(new File(this.b)));
    paramActivity.putExtra("android.intent.extra.videoQuality", 1);
    startActivityForResult(paramActivity, (byte)0);
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ThreadManager.excute(new FaceUnblockCameraJsApiPlugin.2(this, paramString), 64, null, true);
      return;
    }
    QLog.d("FaceUnblockCameraJsApiPlugin", 1, "onActivityResult failed: media url is null");
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("Call FaceUnblockCameraJsApiPlugin handleJsRequest, url");
      paramJsBridgeListener.append(paramString1);
      paramJsBridgeListener.append(" pkgName:");
      paramJsBridgeListener.append(paramString2);
      QLog.d("FaceUnblockCameraJsApiPlugin", 2, paramJsBridgeListener.toString());
    }
    if ("faceUnblockCamera".equals(paramString2))
    {
      if ("startPTVActivity".equals(paramString3))
      {
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = new StringBuilder();
          paramJsBridgeListener.append("Call startPTVActivity, args:");
          paramJsBridgeListener.append(paramVarArgs);
          QLog.d("FaceUnblockCameraJsApiPlugin", 2, paramJsBridgeListener.toString());
        }
        this.jdField_a_of_type_JavaLangString = paramString1.split("#")[1];
        if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
          a(this.mRuntime.a(), paramVarArgs[0]);
        }
      }
      return true;
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if ((paramByte == 0) && (paramInt == -1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FaceUnblockCameraJsApiPlugin", 2, "onActivityResult: RESULT_OK, doParseData");
      }
      a(this.b);
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.FaceUnblockCameraJsApiPlugin");
    this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.FaceUnblockCameraJsApiPlugin
 * JD-Core Version:    0.7.0.1
 */