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

public class borr
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
      localBundle.putInt("VIDEO_STORY_FROM_TYPE", born.x.a());
    }
    localBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
    Object localObject = localBundle.getString("qq_camera_from_qcircle_scheme");
    bpam.d("AECameraLauncher", "[setDataForCircleAECamera] scheme:" + (String)localObject);
    paramBundle = localBundle;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = Uri.parse((String)localObject);
      paramBundle = localBundle;
      if (localObject != null)
      {
        localBundle.putString("tab", ((Uri)localObject).getQueryParameter("tab"));
        localBundle = brdx.a(localBundle, ((Uri)localObject).getQueryParameter("widgetinfo"));
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
    if (!paramBundle.getBoolean("BUNDLE_KEY_CIRCLE_CAN_PICK_VIDEO", true))
    {
      bpam.b("AECameraLauncher", "[AdditionalPick] setDataForCircleAECamera---canNotPickVideo set only photo flag for camera");
      paramBundle.putInt("ability_flag", 2);
    }
    return paramBundle;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, awgb paramawgb)
  {
    if (b()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("VIDEO_STORY_FROM_TYPE", paramInt2);
    localBundle.putInt("AECAMERA_MODE", 200);
    localBundle.putInt("ability_flag", 2);
    localBundle.putInt("edit_video_type", 10023);
    if (paramawgb != null)
    {
      localBundle.putBoolean("key_camera_prefer_id", paramawgb.jdField_a_of_type_Boolean);
      localBundle.putBoolean("key_has_countdown", paramawgb.b);
      localBundle.putBoolean("key_disable_face_detect", paramawgb.d);
      localBundle.putBoolean("key_need_check_sensitive", paramawgb.c);
      localBundle.putString("key_guide_image", paramawgb.jdField_a_of_type_JavaLangString);
    }
    QIMCameraCaptureActivity.a(paramActivity, localBundle, paramInt1);
    paramActivity.overridePendingTransition(2130772242, 2130772039);
  }
  
  public static void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if (b()) {
      return;
    }
    bowp.a().a("AECameraLauncher---launchAECameraUnit-begin");
    zmq localzmq = zmq.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("entrance_type", paramInt);
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (b(localBundle))
    {
      bpam.b("AECameraLauncher", "isOpenFrontFirst: true");
      bbgb.a(1);
    }
    bbgb.a();
    localzmq.a(paramActivity, localBundle, 20000);
    paramActivity.overridePendingTransition(2130772242, 2130772039);
    yup.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
    bowp.a().a("AECameraLauncher---launchAECameraUnit-end");
    bowp.a().a(false);
    bowp.a().e();
  }
  
  public static void a(Activity paramActivity, @Nullable Bundle paramBundle)
  {
    bpam.a("AECameraLauncher", "[AE Profiler] launchAECameraFromCircle");
    paramBundle = a(paramBundle);
    zmq localzmq = zmq.a();
    a(paramBundle);
    localzmq.a(paramActivity, paramBundle, 20000);
    paramActivity.overridePendingTransition(2130772242, 2130772039);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (b()) {
      return;
    }
    zmq localzmq = zmq.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (b(localBundle))
    {
      bpam.b("AECameraLauncher", "isOpenFrontFirst: true");
      bbgb.a(1);
    }
    localzmq.a(paramContext, localBundle);
    yup.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
  }
  
  private static void a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("flag_clear_top", true);
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
    if (!apdr.a(paramActivity)) {}
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
  
  public static boolean a(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.getBoolean("flag_clear_top"));
  }
  
  private static boolean a(boolean paramBoolean)
  {
    if (!bork.a(borf.b))
    {
      bpam.d("AECameraLauncher", "[isResReady] error versionIsOK:false");
      return false;
    }
    boolean bool1;
    boolean bool2;
    if (bork.a(borf.b) != 2)
    {
      bool1 = true;
      bool2 = bool1;
      if (paramBoolean) {
        if ((!bool1) || (!brkn.b(bplg.a()))) {
          break label98;
        }
      }
    }
    label98:
    for (paramBoolean = true;; paramBoolean = false)
    {
      bpam.d("AECameraLauncher", "[isResReady] isCheckAVCodec soIsExist:" + paramBoolean);
      bool2 = paramBoolean;
      if (bool2) {
        break label103;
      }
      bpam.d("AECameraLauncher", "[isResReady] error soIsExist:false");
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
    bpao.a(paramActivity, new Intent().putExtras(paramBundle));
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
  
  private static boolean b(Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1;
    if (((bbgb.a()) || (paramBundle.getInt("VIDEO_STORY_JUMP_TO_TYPE", 0) == 0)) && ((paramBundle.getInt("AECAMERA_MODE") != 202) || (!aqql.d())))
    {
      bool1 = bool2;
      if (paramBundle.getInt("AECAMERA_MODE") == 203)
      {
        bool1 = bool2;
        if (!aqql.d()) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     borr
 * JD-Core Version:    0.7.0.1
 */