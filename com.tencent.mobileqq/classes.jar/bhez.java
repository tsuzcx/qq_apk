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

public class bhez
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
    paramIntent = paramIntent.getStringExtra("widgetinfo");
    if (!TextUtils.isEmpty(paramIntent)) {
      localBundle.putString("widgetinfo", paramIntent);
    }
    return localBundle;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, bhzb parambhzb, bhfa parambhfa)
  {
    a(paramActivity, paramIntent, paramVideoCaptureResult, parambhzb, parambhfa, null, "", 1, null, false, "", false);
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, bhzb parambhzb, bhfa parambhfa, ahhl paramahhl, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    if ((paramActivity == null) || (paramIntent == null) || (parambhzb == null)) {
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
      a(paramActivity, (SessionInfo)localObject, localPublishParam, paramVideoCaptureResult, localBundle, parambhfa, paramahhl, paramString1, paramInt, paramArrayList, paramBoolean1, paramString2, paramBoolean2);
      if ((localObject != null) && (bool))
      {
        paramIntent = aciy.a(new Intent(paramActivity, SplashActivity.class), new int[] { 2 });
        paramIntent.putExtra("uin", ((SessionInfo)localObject).jdField_a_of_type_JavaLangString);
        paramIntent.putExtra("uintype", ((SessionInfo)localObject).jdField_a_of_type_Int);
        paramIntent.putExtra("troop_uin", ((SessionInfo)localObject).jdField_b_of_type_JavaLangString);
        paramActivity.startActivity(paramIntent);
        return;
      }
    } while (!paramIntent.getBooleanExtra("short_video_multi_share", false));
    bjeg.a(paramActivity, paramIntent.getBooleanExtra("quick_shoot_jump_story", true), parambhzb);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, Bundle paramBundle, bhfa parambhfa)
  {
    a(paramActivity, paramSessionInfo, paramPublishParam, paramVideoCaptureResult, paramBundle, parambhfa, null, "", 1, null, false, "", false);
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, PublishParam paramPublishParam, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, Bundle paramBundle, bhfa parambhfa, ahhl paramahhl, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    biyq localbiyq = new biyq();
    localbiyq.jdField_a_of_type_AndroidAppActivity = paramActivity;
    localbiyq.jdField_a_of_type_JavaLangString = new File(paramPublishParam.jdField_j_of_type_JavaLangString).getParent();
    localbiyq.jdField_b_of_type_JavaLangString = paramPublishParam.jdField_k_of_type_JavaLangString;
    int i;
    boolean bool;
    if (paramPublishParam.f <= 5)
    {
      i = paramPublishParam.f;
      localbiyq.jdField_a_of_type_Int = i;
      localbiyq.jdField_c_of_type_JavaLangString = paramPublishParam.jdField_j_of_type_JavaLangString;
      localbiyq.f = paramPublishParam.jdField_c_of_type_JavaLangString;
      localbiyq.jdField_c_of_type_Int = 0;
      localbiyq.jdField_d_of_type_Int = 0;
      localbiyq.jdField_j_of_type_JavaLangString = paramPublishParam.jdField_b_of_type_JavaLangString;
      localbiyq.jdField_j_of_type_Int = paramPublishParam.o;
      localbiyq.jdField_k_of_type_Int = paramPublishParam.p;
      if (paramPublishParam.jdField_i_of_type_Int != 1) {
        break label350;
      }
      bool = true;
      label132:
      localbiyq.jdField_c_of_type_Boolean = bool;
      localbiyq.jdField_l_of_type_Int = paramPublishParam.f;
      localbiyq.jdField_a_of_type_Ahhl = paramahhl;
      localbiyq.g = paramString1;
      localbiyq.jdField_e_of_type_Int = paramInt;
      localbiyq.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
      localbiyq.jdField_a_of_type_Boolean = paramBoolean1;
      localbiyq.jdField_i_of_type_JavaLangString = paramString2;
      localbiyq.jdField_b_of_type_Boolean = paramBoolean2;
      if (paramVideoCaptureResult != null) {
        break label356;
      }
      avan.a(new RuntimeException("videoCaptureResult == null"));
      QLog.e(jdField_a_of_type_JavaLangString, 2, "videoCaptureResult == null");
      localbiyq.h = 0;
      label228:
      localbiyq.jdField_i_of_type_Int = ((int)paramPublishParam.jdField_a_of_type_Long);
      localbiyq.jdField_k_of_type_JavaLangString = paramBundle.getString("dynamic_text");
      localbiyq.jdField_l_of_type_JavaLangString = paramBundle.getString("widgetinfo");
      paramVideoCaptureResult = "";
      paramInt = 0;
      paramActivity = "";
      if (paramSessionInfo != null)
      {
        paramVideoCaptureResult = paramSessionInfo.jdField_a_of_type_JavaLangString;
        paramInt = paramSessionInfo.jdField_a_of_type_Int;
        paramActivity = paramSessionInfo.jdField_b_of_type_JavaLangString;
      }
      localbiyq.jdField_d_of_type_JavaLangString = paramVideoCaptureResult;
      localbiyq.jdField_b_of_type_Int = paramInt;
      localbiyq.jdField_e_of_type_JavaLangString = paramActivity;
      if (paramPublishParam.jdField_e_of_type_Int != 1) {
        break label368;
      }
    }
    label350:
    label356:
    label368:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      new biyp(localbiyq, false, paramBoolean1, parambhfa).execute(new Void[0]);
      return;
      i = 0;
      break;
      bool = false;
      break label132;
      localbiyq.h = paramVideoCaptureResult.videoFrameCount;
      break label228;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhez
 * JD-Core Version:    0.7.0.1
 */