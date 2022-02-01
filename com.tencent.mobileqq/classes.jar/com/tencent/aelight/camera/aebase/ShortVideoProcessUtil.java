package com.tencent.aelight.camera.aebase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.MediaCodecSendTask;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.util.JumpUtil;
import com.tencent.aelight.camera.aioeditor.setting.ICameraEntrance;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.PtvFilterUtils;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.VideoSendPublicParam;
import com.tencent.aelight.camera.struct.editor.FlowComponentInterface;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

public class ShortVideoProcessUtil
{
  public static String a = "ShortVideoProcessUtil";
  
  private static Bundle a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dynamic_text", paramIntent.getStringExtra("dynamic_text"));
    String str1 = paramIntent.getStringExtra("widgetinfo");
    paramIntent = paramIntent.getStringExtra("key_camera_material_name");
    if (!TextUtils.isEmpty(str1))
    {
      localBundle.putString("widgetinfo", str1);
      if (!TextUtils.isEmpty(paramIntent)) {
        localBundle.putString("key_camera_material_name", paramIntent);
      }
    }
    if (QLog.isColorLevel())
    {
      String str2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBundle templateId:");
      localStringBuilder.append(str1);
      localStringBuilder.append(", name:");
      localStringBuilder.append(paramIntent);
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    return localBundle;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ICameraEntrance paramICameraEntrance)
  {
    if ((paramActivity != null) && (paramIntent != null) && (paramICameraEntrance != null))
    {
      paramActivity.getIntent().putExtra("forward_source_from_shoot_quick", true);
      PublishParam localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      if ((localPublishParam != null) && (localPublishParam.i == 1))
      {
        Object localObject1 = localPublishParam.c;
        paramActivity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
        if (QLog.isColorLevel())
        {
          localObject2 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("hwEncodeVideo videoMergeThumbPath =");
          localStringBuilder.append((String)localObject1);
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
          localObject1 = jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("publishParam =");
          ((StringBuilder)localObject2).append(localPublishParam.toString());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        PtvFilterUtils.a(new File(localPublishParam.j).getParent(), localPublishParam.b);
        Object localObject2 = a(paramIntent);
        localObject1 = (SessionInfo)paramIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
        boolean bool = paramIntent.getBooleanExtra("gotoAIO", false);
        a(paramActivity, (SessionInfo)localObject1, localPublishParam, (Bundle)localObject2, null, "", 1, null, false, "", false);
        if ((localObject1 != null) && (bool))
        {
          paramIntent = AIOUtils.a(new Intent(paramActivity, SplashActivity.class), new int[] { 2 });
          paramIntent.putExtra("uin", ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString);
          paramIntent.putExtra("uintype", ((SessionInfo)localObject1).jdField_a_of_type_Int);
          paramIntent.putExtra("troop_uin", ((SessionInfo)localObject1).b);
          paramActivity.startActivity(paramIntent);
          return;
        }
        if (paramIntent.getBooleanExtra("short_video_multi_share", false)) {
          JumpUtil.a(paramActivity, paramIntent.getBooleanExtra("quick_shoot_jump_story", true), paramICameraEntrance);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleVideoFromEditVideoActivity params are wrong");
    }
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, Bundle paramBundle)
  {
    a(paramActivity, paramSessionInfo, paramPublishParam, paramBundle, null, "", 1, null, false, "", false);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, Bundle paramBundle, FlowComponentInterface paramFlowComponentInterface, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    VideoSendPublicParam localVideoSendPublicParam = new VideoSendPublicParam();
    localVideoSendPublicParam.mContext = paramActivity;
    localVideoSendPublicParam.mVideoCacheDir = new File(paramPublishParam.j).getParent();
    int i;
    if (paramPublishParam.f <= 5) {
      i = paramPublishParam.f;
    } else {
      i = 0;
    }
    localVideoSendPublicParam.mEncodeMode = i;
    localVideoSendPublicParam.mVideoFilePath = paramPublishParam.j;
    localVideoSendPublicParam.mThumbFilePath = paramPublishParam.c;
    localVideoSendPublicParam.mThumbWidth = 0;
    localVideoSendPublicParam.mThumbHeight = 0;
    localVideoSendPublicParam.fakeVid = paramPublishParam.b;
    localVideoSendPublicParam.mUserCallBack = paramFlowComponentInterface;
    localVideoSendPublicParam.mContent = paramString1;
    localVideoSendPublicParam.mPriv = paramInt;
    localVideoSendPublicParam.mPrivUinList = paramArrayList;
    localVideoSendPublicParam.mEnableEditVideo = paramBoolean1;
    localVideoSendPublicParam.topicId = paramString2;
    localVideoSendPublicParam.topicSyncQzone = paramBoolean2;
    localVideoSendPublicParam.templateId = paramBundle.getString("widgetinfo");
    localVideoSendPublicParam.templateName = paramBundle.getString("key_camera_material_name");
    paramActivity = "";
    if (paramSessionInfo != null)
    {
      paramActivity = paramSessionInfo.jdField_a_of_type_JavaLangString;
      paramInt = paramSessionInfo.jdField_a_of_type_Int;
      paramSessionInfo = paramSessionInfo.b;
    }
    else
    {
      paramSessionInfo = "";
      paramInt = 0;
    }
    localVideoSendPublicParam.mUin = paramActivity;
    localVideoSendPublicParam.mUinType = paramInt;
    localVideoSendPublicParam.mTroopUin = paramSessionInfo;
    new MediaCodecSendTask(localVideoSendPublicParam).execute(new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.ShortVideoProcessUtil
 * JD-Core Version:    0.7.0.1
 */