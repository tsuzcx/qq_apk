package com.tencent.mobileqq.activity.faceunlock;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.entry.AECameraEntry;
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
    if (CaptureUtil.a())
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("edit_video_type", 10025);
      localBundle.putInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.K.a());
      localBundle.putInt("entrance_type", 132);
      localBundle.putBoolean("enable_local_video", false);
      localBundle.putBoolean("PeakConstants.ARG_BEAUTY", false);
      localBundle.putBoolean("PeakConstants.ARG_ALBUM", false);
      localBundle.putBoolean("PeakConstants.ARG_SHARP_FACE", false);
      localBundle.putBoolean("PeakConstants.ARG_SUPPORT_FILTER", false);
      localBundle.putInt("ability_flag", 3);
      localBundle.putLong("capture_max_duration", 5000L);
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
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FaceUnblockCameraJsApiPlugin", 2, "Call FaceUnblockCameraJsApiPlugin handleJsRequest, url" + paramString1 + " pkgName:" + paramString2);
    }
    if ("faceUnblockCamera".equals(paramString2))
    {
      if ("startPTVActivity".equals(paramString3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FaceUnblockCameraJsApiPlugin", 2, "Call startPTVActivity, args:" + paramVarArgs);
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
  
  public void onCreate()
  {
    super.onCreate();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.FaceUnblockCameraJsApiPlugin");
    this.mRuntime.a().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mRuntime.a().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.faceunlock.FaceUnblockCameraJsApiPlugin
 * JD-Core Version:    0.7.0.1
 */