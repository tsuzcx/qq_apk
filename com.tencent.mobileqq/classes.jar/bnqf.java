import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import java.util.LinkedList;
import java.util.List;

public class bnqf
{
  private static long a;
  
  private static Bundle a(@Nullable Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("AECAMERA_MODE", 200);
    if (!localBundle.containsKey("VIDEO_STORY_FROM_TYPE")) {
      localBundle.putInt("VIDEO_STORY_FROM_TYPE", bnqb.x.a());
    }
    localBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
    Object localObject = localBundle.getString("qq_camera_from_qcircle_scheme");
    bnzb.d("AECameraLauncher", "[setDataForCircleAECamera] scheme:" + (String)localObject);
    paramBundle = localBundle;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = Uri.parse((String)localObject);
      paramBundle = localBundle;
      if (localObject != null)
      {
        localBundle.putString("tab", ((Uri)localObject).getQueryParameter("tab"));
        localBundle = bqcc.a(localBundle, ((Uri)localObject).getQueryParameter("widgetinfo"));
        localBundle.putString("VIDEO_STORY_ACTIVITY_ID", ((Uri)localObject).getQueryParameter("activity_id"));
        localObject = ((Uri)localObject).getQueryParameter("editor_filter_id");
        paramBundle = localBundle;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localBundle.putString("editor_filter_id", (String)localObject);
          paramBundle = localBundle;
        }
      }
    }
    paramBundle.putInt("entrance_type", 120);
    paramBundle.putInt("edit_video_type", 10026);
    paramBundle.putInt("capture_intent_mode", 8);
    return paramBundle;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, avnq paramavnq)
  {
    if (b()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("VIDEO_STORY_FROM_TYPE", paramInt2);
    localBundle.putInt("AECAMERA_MODE", 200);
    localBundle.putInt("ability_flag", 2);
    localBundle.putInt("edit_video_type", 10023);
    if (paramavnq != null)
    {
      localBundle.putBoolean("key_camera_prefer_id", paramavnq.jdField_a_of_type_Boolean);
      localBundle.putBoolean("key_has_countdown", paramavnq.b);
      localBundle.putBoolean("key_disable_face_detect", paramavnq.d);
      localBundle.putBoolean("key_need_check_sensitive", paramavnq.c);
      localBundle.putString("key_guide_image", paramavnq.jdField_a_of_type_JavaLangString);
    }
    QIMCameraCaptureActivity.a(paramActivity, localBundle, paramInt1);
    paramActivity.overridePendingTransition(2130772242, 2130772039);
  }
  
  public static void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if (b()) {
      return;
    }
    bnvd.a().a("AECameraLauncher---launchAECameraUnit-begin");
    ziv localziv = ziv.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("entrance_type", paramInt);
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (a(localBundle))
    {
      bnzb.b("AECameraLauncher", "isOpenFrontFirst: true");
      bani.a(1);
    }
    bani.a();
    localziv.a(paramActivity, localBundle, 20000);
    paramActivity.overridePendingTransition(2130772242, 2130772039);
    yqu.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
    bnvd.a().a("AECameraLauncher---launchAECameraUnit-end");
    bnvd.a().a(false);
    bnvd.a().e();
  }
  
  public static void a(Activity paramActivity, @Nullable Bundle paramBundle)
  {
    bnzb.a("AECameraLauncher", "[AE Profiler] launchAECameraFromCircle");
    paramBundle = a(paramBundle);
    ziv.a().a(paramActivity, paramBundle, 20000);
    paramActivity.overridePendingTransition(2130772242, 2130772039);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (b()) {
      return;
    }
    ziv localziv = ziv.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (a(localBundle))
    {
      bnzb.b("AECameraLauncher", "isOpenFrontFirst: true");
      bani.a(1);
    }
    localziv.a(paramContext, localBundle);
    yqu.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
  }
  
  public static boolean a()
  {
    return a(true);
  }
  
  private static boolean a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return false;
    }
    if (!aoqb.a(paramActivity)) {}
    for (int i = 1;; i = 0)
    {
      LinkedList localLinkedList = new LinkedList();
      if (i != 0)
      {
        localLinkedList.add("android.permission.READ_EXTERNAL_STORAGE");
        localLinkedList.add("android.permission.WRITE_EXTERNAL_STORAGE");
      }
      if (localLinkedList.size() <= 0) {
        break;
      }
      paramActivity.requestPermissions((String[])localLinkedList.toArray(new String[0]), 1);
      return true;
    }
  }
  
  private static boolean a(Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1;
    if (((bani.a()) || (paramBundle.getInt("VIDEO_STORY_JUMP_TO_TYPE", 0) == 0)) && ((paramBundle.getInt("AECAMERA_MODE") != 202) || (!aqbj.d())))
    {
      bool1 = bool2;
      if (paramBundle.getInt("AECAMERA_MODE") == 203)
      {
        bool1 = bool2;
        if (!aqbj.d()) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private static boolean a(boolean paramBoolean)
  {
    if (!bnpy.a(bnpt.b))
    {
      bnzb.d("AECameraLauncher", "[isResReady] error versionIsOK:false");
      return false;
    }
    boolean bool1;
    boolean bool2;
    if (bnpy.a(bnpt.b) != 2)
    {
      bool1 = true;
      bool2 = bool1;
      if (paramBoolean) {
        if ((!bool1) || (!bqjb.b(bojl.a()))) {
          break label98;
        }
      }
    }
    label98:
    for (paramBoolean = true;; paramBoolean = false)
    {
      bnzb.d("AECameraLauncher", "[isResReady] isCheckAVCodec soIsExist:" + paramBoolean);
      bool2 = paramBoolean;
      if (bool2) {
        break label103;
      }
      bnzb.d("AECameraLauncher", "[isResReady] error soIsExist:false");
      return false;
      bool1 = false;
      break;
    }
    label103:
    return true;
  }
  
  public static void b(Activity paramActivity, @Nullable Bundle paramBundle)
  {
    if (!a(paramActivity))
    {
      if ((a()) && (Build.VERSION.SDK_INT >= 21)) {
        a(paramActivity, paramBundle);
      }
    }
    else {
      return;
    }
    bnzd.a(paramActivity, new Intent().putExtras(paramBundle));
  }
  
  private static boolean b()
  {
    long l = System.currentTimeMillis();
    QLog.d("AECameraLauncher", 2, "pre: " + a + " cur: " + l);
    if (Math.abs(l - a) < 500L)
    {
      QLog.d("AECameraLauncher", 2, "isFastClick.");
      a = l;
      return true;
    }
    a = l;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqf
 * JD-Core Version:    0.7.0.1
 */