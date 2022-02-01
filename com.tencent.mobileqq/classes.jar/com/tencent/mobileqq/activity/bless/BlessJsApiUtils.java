package com.tencent.mobileqq.activity.bless;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.IQIMWebEffectUnit;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class BlessJsApiUtils
{
  public static String a = "BlessJsApiUtils";
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString1.trim())))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("param_type", 9003);
      localIntent.putExtra("param_entrance", 15);
      localIntent.putExtra("param_only_friends", true);
      localIntent.putExtra("param_donot_need_contacts", true);
      localIntent.putExtra("param_title", paramActivity.getString(2131887583));
      localIntent.putExtra("param_done_button_wording", paramActivity.getString(2131888010));
      localIntent.putExtra("param_exit_animation", 1);
      localIntent.putExtra("param_blesstype", 1);
      localIntent.putExtra("param_blessword_content", paramString1);
      localIntent.putExtra("param_web_callback", paramString2);
      ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startBlessSelectMemberActivity(paramActivity, localIntent);
      paramActivity.overridePendingTransition(2130772009, 2130772010);
      return;
    }
    QQToast.makeText(paramActivity, 2131887577, 1).show();
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startBlessPtvActivity , supportVideo:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", supportPhoto:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", cameraMode:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", unfoldDDStr:");
      localStringBuilder.append(paramString5);
      localStringBuilder.append(", dDItemID:");
      localStringBuilder.append(paramString6);
      localStringBuilder.append(", callback:");
      localStringBuilder.append(paramString8);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    boolean bool1 = "1".equals(paramString1);
    boolean bool2 = "1".equals(paramString2);
    int i;
    if ("1".equals(paramString3)) {
      i = 2;
    } else {
      i = 1;
    }
    boolean bool3 = "1".equals(paramString4);
    boolean bool4 = "1".equals(paramString7);
    boolean bool5 = "1".equals(paramString5);
    if (!((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture())
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "supportMediaCodec = false");
      }
      QQToast.makeText(paramActivity, paramActivity.getString(2131887581), 0).show();
      return false;
    }
    paramString1 = ((IQIMWebEffectUnit)QRoute.api(IQIMWebEffectUnit.class)).generateArgs(bool1, bool2, i, true, bool3, bool5, paramString6, bool4, 107);
    paramString2 = new Intent(paramActivity, StoryTransitionActivity.class);
    paramString2.putExtras(paramString1);
    paramString2.putExtra("jump_action", 7);
    paramActivity.startActivity(paramString2);
    return true;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    boolean bool = VideoEnvironment.supportShortVideoRecordAndPlay();
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d(a, 2, "isMobileSupportPTV false");
    }
    return bool;
  }
  
  public static boolean b(AppInterface paramAppInterface)
  {
    boolean bool = PtvFilterSoLoad.a();
    if ((!bool) && (QLog.isColorLevel())) {
      QLog.d(a, 2, "isSupportFilterSo false");
    }
    return bool;
  }
  
  public static boolean c(AppInterface paramAppInterface)
  {
    if (paramAppInterface.getCurrentAccountUin() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "isAccLoginSuccess false.");
      }
      return false;
    }
    if (!a(paramAppInterface)) {
      return false;
    }
    if (((IAEResUtil)QRoute.api(IAEResUtil.class)).isLightCameraBaseResNotAllExist())
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "PtvFilterSoLoad getFilterSoState is false");
      }
      return false;
    }
    if (!((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture()) {
      return false;
    }
    return VideoEnvironment.checkAndLoadAVCodec();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessJsApiUtils
 * JD-Core Version:    0.7.0.1
 */