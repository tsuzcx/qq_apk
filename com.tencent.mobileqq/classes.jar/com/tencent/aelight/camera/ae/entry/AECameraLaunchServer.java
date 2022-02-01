package com.tencent.aelight.camera.ae.entry;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

public class AECameraLaunchServer
  extends QIPCModule
{
  private AECameraLaunchServer()
  {
    super("AECameraLaunchServer");
  }
  
  public static AECameraLaunchServer a()
  {
    return AECameraLaunchServer.Holder.a();
  }
  
  private void a(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      QQToast.a(MobileQQ.sMobileQQ, MobileQQ.sMobileQQ.getResources().getString(2131717180), 1).a();
      return;
    }
    int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    if (i == AECameraEntry.a.a()) {
      paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
    }
    paramBundle.putInt("AECAMERA_MODE", 200);
    paramBundle.putInt("VIDEO_STORY_FROM_TYPE", i);
    paramBundle.putString("KEY_CURRENT_SELECT_ID", paramBundle.getString("widgetid"));
    AECameraLauncher.a(MobileQQ.sMobileQQ, paramBundle);
  }
  
  private void b(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      QQToast.a(MobileQQ.sMobileQQ, MobileQQ.sMobileQQ.getResources().getString(2131717180), 1).a();
      return;
    }
    int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    if (i == AECameraEntry.a.a()) {
      paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
    }
    paramBundle.putInt("AECAMERA_MODE", 200);
    paramBundle.putInt("VIDEO_STORY_FROM_TYPE", i);
    paramBundle.putString("KEY_CURRENT_SELECT_ID", paramBundle.getString("widgetid"));
    paramBundle.putInt("key_camera_photo_edit_type", -2);
    paramBundle.putInt("key_camera_video_edit_type", -2);
    AECameraLauncher.a(MobileQQ.sMobileQQ, paramBundle);
  }
  
  private void c(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      QQToast.a(MobileQQ.sMobileQQ, MobileQQ.sMobileQQ.getResources().getString(2131717180), 1).a();
      return;
    }
    int i = paramBundle.getInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    if (i == AECameraEntry.a.a()) {
      paramBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
    }
    paramBundle.putInt("VIDEO_STORY_FROM_TYPE", i);
    paramBundle.putInt("ability_flag", 2);
    paramBundle.putInt("key_camera_photo_edit_type", 3);
    paramBundle.putBoolean("key_disable_face_detect", true);
    AECameraLauncher.a(MobileQQ.sMobileQQ, paramBundle);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onCall. action=");
    localStringBuilder.append(paramString);
    QLog.i("AECameraLaunchServer", 1, localStringBuilder.toString());
    if (MobileQQ.sMobileQQ != null)
    {
      if ("ACTION_MINI_LAUNCH_CAMERA_FOR_SIGN_IN".equals(paramString)) {
        a(paramBundle);
      } else if ("ACTION_MINI_LAUNCH_CAMERA_FOR_PLAY".equals(paramString)) {
        b(paramBundle);
      } else if ("ACTION_MINI_LAUNCH_CAMERA_FOR_MINIAPP".equals(paramString)) {
        c(paramBundle);
      }
    }
    else {
      QLog.e("AECameraLaunchServer", 1, "no mobile qq.");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.entry.AECameraLaunchServer
 * JD-Core Version:    0.7.0.1
 */