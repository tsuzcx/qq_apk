package com.tencent.aelight.camera.aioeditor;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.shortvideo.SendVideoActivity;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AIOShortVideoUtil
{
  public static long a;
  public static long b;
  public static long c;
  public static long d;
  public static long e;
  public static long f;
  public static long g;
  public static long h;
  public static long i;
  public static long j;
  public static long k;
  public static long l;
  public static long m;
  
  public static int a(int paramInt)
  {
    int n = 11;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000) {
          return 11;
        }
        return 10;
      }
      n = 9;
    }
    return n;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent, SessionInfo paramSessionInfo, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      String str = PreferenceManager.getDefaultSharedPreferences(paramActivity).getString("camera_photo_path", "");
      if ("".equals(str))
      {
        QLog.d("AIOShortVideoUtil", 1, "camera result null");
        return;
      }
      if (paramSessionInfo.a == 9501)
      {
        ChatActivityUtils.a(paramQQAppInterface, paramActivity, paramSessionInfo, 1, paramIntent, 1);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("on camera result ");
        paramIntent.append(paramInt1);
        QLog.d("AIOShortVideoUtil", 2, paramIntent.toString());
      }
      paramActivity.getIntent().removeExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
      paramIntent = EditPicActivity.startEditPic(paramActivity, str, true, true, true, true, false, 2, 99, 1);
      paramIntent.putExtra("qq_sub_business_id", 109);
      AIOUtils.a(paramIntent, null);
      paramIntent.putExtra("camera_type", paramInt1);
      if (Utils.c(paramSessionInfo.b)) {
        paramIntent.putExtra("babyq_ability", ((BabyQHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).c());
      }
      paramIntent.putExtra("key_activity_code", ChatActivityUtils.a(paramActivity));
      paramIntent.putExtra("editpic_cameratype", 3);
      paramActivity.startActivity(paramIntent);
      return;
    }
    paramQQAppInterface = new Intent(paramActivity, SendVideoActivity.class);
    paramIntent = PreferenceManager.getDefaultSharedPreferences(paramActivity).getString("camera_photo_path", "");
    paramQQAppInterface.putExtra("file_send_path", paramIntent);
    paramQQAppInterface.putExtra("file_send_size", new File(paramIntent).length());
    paramQQAppInterface.putExtra("file_send_duration", ShortVideoUtils.getDuration(paramIntent));
    paramQQAppInterface.putExtra("uin", paramSessionInfo.b);
    paramQQAppInterface.putExtra("uintype", paramSessionInfo.a);
    paramQQAppInterface.putExtra("file_source", "camera");
    paramQQAppInterface.putExtra("start_init_activity_after_sended", false);
    paramActivity.startActivity(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.AIOShortVideoUtil
 * JD-Core Version:    0.7.0.1
 */