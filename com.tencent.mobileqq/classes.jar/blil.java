import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.io.File;
import java.util.ArrayList;

public class blil
{
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "ShortVideoProcessUtil";
  }
  
  private static Bundle a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("dynamic_text", paramIntent.getStringExtra("dynamic_text"));
    String str = paramIntent.getStringExtra("widgetinfo");
    paramIntent = paramIntent.getStringExtra("key_camera_material_name");
    if (!TextUtils.isEmpty(str))
    {
      localBundle.putString("widgetinfo", str);
      if (!TextUtils.isEmpty(paramIntent)) {
        localBundle.putString("key_camera_material_name", paramIntent);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getBundle templateId:" + str + ", name:" + paramIntent);
    }
    return localBundle;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, bnbo parambnbo, blim paramblim)
  {
    a(paramActivity, paramIntent, parambnbo, paramblim, null, "", 1, null, false, "", false);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, bnbo parambnbo, blim paramblim, akry paramakry, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    if ((paramActivity == null) || (paramIntent == null) || (parambnbo == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleVideoFromEditVideoActivity params are wrong");
      }
    }
    do
    {
      PublishParam localPublishParam;
      do
      {
        return;
        paramActivity.getIntent().putExtra("forward_source_from_shoot_quick", true);
        localPublishParam = (PublishParam)paramIntent.getParcelableExtra(PublishParam.jdField_a_of_type_JavaLangString);
      } while ((localPublishParam == null) || (localPublishParam.jdField_j_of_type_Int != 1));
      Object localObject = localPublishParam.jdField_c_of_type_JavaLangString;
      paramActivity.getIntent().putExtra("ab_test_send_btn_click_time", SystemClock.uptimeMillis());
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "hwEncodeVideo videoMergeThumbPath =" + (String)localObject);
        QLog.d(jdField_a_of_type_JavaLangString, 2, "publishParam =" + localPublishParam.toString());
      }
      PtvFilterUtils.a(new File(localPublishParam.jdField_j_of_type_JavaLangString).getParent(), localPublishParam.jdField_b_of_type_JavaLangString);
      Bundle localBundle = a(paramIntent);
      localObject = (SessionInfo)paramIntent.getParcelableExtra("PhotoConst.SEND_SESSION_INFO");
      boolean bool = paramIntent.getBooleanExtra("gotoAIO", false);
      a(paramActivity, (SessionInfo)localObject, localPublishParam, localBundle, paramblim, paramakry, paramString1, paramInt, paramArrayList, paramBoolean1, paramString2, paramBoolean2);
      if ((localObject != null) && (bool))
      {
        paramIntent = AIOUtils.setOpenAIOIntent(new Intent(paramActivity, SplashActivity.class), new int[] { 2 });
        paramIntent.putExtra("uin", ((SessionInfo)localObject).curFriendUin);
        paramIntent.putExtra("uintype", ((SessionInfo)localObject).curType);
        paramIntent.putExtra("troop_uin", ((SessionInfo)localObject).troopUin);
        paramActivity.startActivity(paramIntent);
        return;
      }
    } while (!paramIntent.getBooleanExtra("short_video_multi_share", false));
    bnxs.a(paramActivity, paramIntent.getBooleanExtra("quick_shoot_jump_story", true), parambnbo);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, Bundle paramBundle, blim paramblim)
  {
    a(paramActivity, paramSessionInfo, paramPublishParam, paramBundle, paramblim, null, "", 1, null, false, "", false);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, Bundle paramBundle, blim paramblim, akry paramakry, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    bnsp localbnsp = new bnsp();
    localbnsp.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localbnsp.jdField_a_of_type_JavaLangString = new File(paramPublishParam.jdField_j_of_type_JavaLangString).getParent();
    localbnsp.jdField_b_of_type_JavaLangString = paramPublishParam.k;
    int i;
    boolean bool;
    if (paramPublishParam.f <= 5)
    {
      i = paramPublishParam.f;
      localbnsp.jdField_a_of_type_Int = i;
      localbnsp.jdField_c_of_type_JavaLangString = paramPublishParam.jdField_j_of_type_JavaLangString;
      localbnsp.f = paramPublishParam.jdField_c_of_type_JavaLangString;
      localbnsp.jdField_c_of_type_Int = 0;
      localbnsp.jdField_d_of_type_Int = 0;
      localbnsp.jdField_j_of_type_JavaLangString = paramPublishParam.jdField_b_of_type_JavaLangString;
      localbnsp.h = paramPublishParam.o;
      localbnsp.jdField_i_of_type_Int = paramPublishParam.p;
      if (paramPublishParam.jdField_i_of_type_Int != 1) {
        break label318;
      }
      bool = true;
      label132:
      localbnsp.jdField_c_of_type_Boolean = bool;
      localbnsp.jdField_j_of_type_Int = paramPublishParam.f;
      localbnsp.jdField_a_of_type_Akry = paramakry;
      localbnsp.g = paramString1;
      localbnsp.jdField_e_of_type_Int = paramInt;
      localbnsp.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      localbnsp.jdField_a_of_type_Boolean = paramBoolean1;
      localbnsp.jdField_i_of_type_JavaLangString = paramString2;
      localbnsp.jdField_b_of_type_Boolean = paramBoolean2;
      localbnsp.k = paramBundle.getString("dynamic_text");
      localbnsp.l = paramBundle.getString("widgetinfo");
      localbnsp.m = paramBundle.getString("key_camera_material_name");
      paramBundle = "";
      paramInt = 0;
      paramActivity = "";
      if (paramSessionInfo != null)
      {
        paramBundle = paramSessionInfo.curFriendUin;
        paramInt = paramSessionInfo.curType;
        paramActivity = paramSessionInfo.troopUin;
      }
      localbnsp.jdField_d_of_type_JavaLangString = paramBundle;
      localbnsp.jdField_b_of_type_Int = paramInt;
      localbnsp.jdField_e_of_type_JavaLangString = paramActivity;
      if (paramPublishParam.jdField_e_of_type_Int != 1) {
        break label324;
      }
    }
    label318:
    label324:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      new bnso(localbnsp, false, paramBoolean1, paramblim).execute(new Void[0]);
      return;
      i = 0;
      break;
      bool = false;
      break label132;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blil
 * JD-Core Version:    0.7.0.1
 */