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

public class bmvc
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
  
  public static void a(Activity paramActivity, Intent paramIntent, borg paramborg, bmvd parambmvd)
  {
    a(paramActivity, paramIntent, paramborg, parambmvd, null, "", 1, null, false, "", false);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, borg paramborg, bmvd parambmvd, alpu paramalpu, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    if ((paramActivity == null) || (paramIntent == null) || (paramborg == null)) {
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
      a(paramActivity, (SessionInfo)localObject, localPublishParam, localBundle, parambmvd, paramalpu, paramString1, paramInt, paramArrayList, paramBoolean1, paramString2, paramBoolean2);
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
    bpnk.a(paramActivity, paramIntent.getBooleanExtra("quick_shoot_jump_story", true), paramborg);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, Bundle paramBundle, bmvd parambmvd)
  {
    a(paramActivity, paramSessionInfo, paramPublishParam, paramBundle, parambmvd, null, "", 1, null, false, "", false);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, Bundle paramBundle, bmvd parambmvd, alpu paramalpu, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    bpih localbpih = new bpih();
    localbpih.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localbpih.jdField_a_of_type_JavaLangString = new File(paramPublishParam.jdField_j_of_type_JavaLangString).getParent();
    localbpih.jdField_b_of_type_JavaLangString = paramPublishParam.k;
    int i;
    boolean bool;
    if (paramPublishParam.f <= 5)
    {
      i = paramPublishParam.f;
      localbpih.jdField_a_of_type_Int = i;
      localbpih.jdField_c_of_type_JavaLangString = paramPublishParam.jdField_j_of_type_JavaLangString;
      localbpih.f = paramPublishParam.jdField_c_of_type_JavaLangString;
      localbpih.jdField_c_of_type_Int = 0;
      localbpih.jdField_d_of_type_Int = 0;
      localbpih.jdField_j_of_type_JavaLangString = paramPublishParam.jdField_b_of_type_JavaLangString;
      localbpih.h = paramPublishParam.o;
      localbpih.jdField_i_of_type_Int = paramPublishParam.p;
      if (paramPublishParam.jdField_i_of_type_Int != 1) {
        break label318;
      }
      bool = true;
      label132:
      localbpih.jdField_c_of_type_Boolean = bool;
      localbpih.jdField_j_of_type_Int = paramPublishParam.f;
      localbpih.jdField_a_of_type_Alpu = paramalpu;
      localbpih.g = paramString1;
      localbpih.jdField_e_of_type_Int = paramInt;
      localbpih.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      localbpih.jdField_a_of_type_Boolean = paramBoolean1;
      localbpih.jdField_i_of_type_JavaLangString = paramString2;
      localbpih.jdField_b_of_type_Boolean = paramBoolean2;
      localbpih.k = paramBundle.getString("dynamic_text");
      localbpih.l = paramBundle.getString("widgetinfo");
      localbpih.m = paramBundle.getString("key_camera_material_name");
      paramBundle = "";
      paramInt = 0;
      paramActivity = "";
      if (paramSessionInfo != null)
      {
        paramBundle = paramSessionInfo.curFriendUin;
        paramInt = paramSessionInfo.curType;
        paramActivity = paramSessionInfo.troopUin;
      }
      localbpih.jdField_d_of_type_JavaLangString = paramBundle;
      localbpih.jdField_b_of_type_Int = paramInt;
      localbpih.jdField_e_of_type_JavaLangString = paramActivity;
      if (paramPublishParam.jdField_e_of_type_Int != 1) {
        break label324;
      }
    }
    label318:
    label324:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      new bpig(localbpih, false, paramBoolean1, parambmvd).execute(new Void[0]);
      return;
      i = 0;
      break;
      bool = false;
      break label132;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvc
 * JD-Core Version:    0.7.0.1
 */