import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;
import dov.com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import java.io.File;
import java.util.ArrayList;

public class bkkb
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
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getBundele templateId:" + str + ", name:" + paramIntent);
    }
    return localBundle;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, bmcu parambmcu, bkkc parambkkc)
  {
    a(paramActivity, paramIntent, paramVideoCaptureResult, parambmcu, parambkkc, null, "", 1, null, false, "", false);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, bmcu parambmcu, bkkc parambkkc, ajlk paramajlk, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    if ((paramActivity == null) || (paramIntent == null) || (parambmcu == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleVideofromEditVideoActivity params are wrong");
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
      a(paramActivity, (SessionInfo)localObject, localPublishParam, paramVideoCaptureResult, localBundle, parambkkc, paramajlk, paramString1, paramInt, paramArrayList, paramBoolean1, paramString2, paramBoolean2);
      if ((localObject != null) && (bool))
      {
        paramIntent = aekt.a(new Intent(paramActivity, SplashActivity.class), new int[] { 2 });
        paramIntent.putExtra("uin", ((SessionInfo)localObject).jdField_a_of_type_JavaLangString);
        paramIntent.putExtra("uintype", ((SessionInfo)localObject).jdField_a_of_type_Int);
        paramIntent.putExtra("troop_uin", ((SessionInfo)localObject).jdField_b_of_type_JavaLangString);
        paramActivity.startActivity(paramIntent);
        return;
      }
    } while (!paramIntent.getBooleanExtra("short_video_multi_share", false));
    bngr.a(paramActivity, paramIntent.getBooleanExtra("quick_shoot_jump_story", true), parambmcu);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, Bundle paramBundle, bkkc parambkkc)
  {
    a(paramActivity, paramSessionInfo, paramPublishParam, paramVideoCaptureResult, paramBundle, parambkkc, null, "", 1, null, false, "", false);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, Bundle paramBundle, bkkc parambkkc, ajlk paramajlk, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    bnbd localbnbd = new bnbd();
    localbnbd.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localbnbd.jdField_a_of_type_JavaLangString = new File(paramPublishParam.jdField_j_of_type_JavaLangString).getParent();
    localbnbd.jdField_b_of_type_JavaLangString = paramPublishParam.jdField_k_of_type_JavaLangString;
    int i;
    boolean bool;
    if (paramPublishParam.f <= 5)
    {
      i = paramPublishParam.f;
      localbnbd.jdField_a_of_type_Int = i;
      localbnbd.jdField_c_of_type_JavaLangString = paramPublishParam.jdField_j_of_type_JavaLangString;
      localbnbd.f = paramPublishParam.jdField_c_of_type_JavaLangString;
      localbnbd.jdField_c_of_type_Int = 0;
      localbnbd.jdField_d_of_type_Int = 0;
      localbnbd.jdField_j_of_type_JavaLangString = paramPublishParam.jdField_b_of_type_JavaLangString;
      localbnbd.jdField_j_of_type_Int = paramPublishParam.o;
      localbnbd.jdField_k_of_type_Int = paramPublishParam.p;
      if (paramPublishParam.jdField_i_of_type_Int != 1) {
        break label362;
      }
      bool = true;
      label132:
      localbnbd.jdField_c_of_type_Boolean = bool;
      localbnbd.jdField_l_of_type_Int = paramPublishParam.f;
      localbnbd.jdField_a_of_type_Ajlk = paramajlk;
      localbnbd.g = paramString1;
      localbnbd.jdField_e_of_type_Int = paramInt;
      localbnbd.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      localbnbd.jdField_a_of_type_Boolean = paramBoolean1;
      localbnbd.jdField_i_of_type_JavaLangString = paramString2;
      localbnbd.jdField_b_of_type_Boolean = paramBoolean2;
      if (paramVideoCaptureResult != null) {
        break label368;
      }
      axsh.a(new RuntimeException("videoCaptureResult == null"));
      QLog.e(jdField_a_of_type_JavaLangString, 2, "videoCaptureResult == null");
      localbnbd.h = 0;
      label228:
      localbnbd.jdField_i_of_type_Int = ((int)paramPublishParam.jdField_a_of_type_Long);
      localbnbd.jdField_k_of_type_JavaLangString = paramBundle.getString("dynamic_text");
      localbnbd.jdField_l_of_type_JavaLangString = paramBundle.getString("widgetinfo");
      localbnbd.m = paramBundle.getString("key_camera_material_name");
      paramVideoCaptureResult = "";
      paramInt = 0;
      paramActivity = "";
      if (paramSessionInfo != null)
      {
        paramVideoCaptureResult = paramSessionInfo.jdField_a_of_type_JavaLangString;
        paramInt = paramSessionInfo.jdField_a_of_type_Int;
        paramActivity = paramSessionInfo.jdField_b_of_type_JavaLangString;
      }
      localbnbd.jdField_d_of_type_JavaLangString = paramVideoCaptureResult;
      localbnbd.jdField_b_of_type_Int = paramInt;
      localbnbd.jdField_e_of_type_JavaLangString = paramActivity;
      if (paramPublishParam.jdField_e_of_type_Int != 1) {
        break label380;
      }
    }
    label362:
    label368:
    label380:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      new bnbc(localbnbd, false, paramBoolean1, parambkkc).execute(new Void[0]);
      return;
      i = 0;
      break;
      bool = false;
      break label132;
      localbnbd.h = paramVideoCaptureResult.videoFrameCount;
      break label228;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkkb
 * JD-Core Version:    0.7.0.1
 */