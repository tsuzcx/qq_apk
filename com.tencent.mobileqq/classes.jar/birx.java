import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;

public class birx
{
  private static long a;
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, armd paramarmd)
  {
    if (a()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("VIDEO_STORY_FROM_TYPE", paramInt2);
    localBundle.putInt("AECAMERA_MODE", 200);
    localBundle.putInt("ability_flag", 2);
    localBundle.putInt("edit_video_type", 10023);
    if (paramarmd != null)
    {
      localBundle.putBoolean("key_camera_prefer_id", paramarmd.jdField_a_of_type_Boolean);
      localBundle.putBoolean("key_has_countdown", paramarmd.b);
      localBundle.putBoolean("key_disable_face_detect", paramarmd.d);
      localBundle.putBoolean("key_need_check_sensitive", paramarmd.c);
      localBundle.putString("key_guide_image", paramarmd.jdField_a_of_type_JavaLangString);
    }
    QIMCameraCaptureActivity.a(paramActivity, localBundle, paramInt1);
    paramActivity.overridePendingTransition(2130772217, 2130772038);
  }
  
  public static void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if (a()) {
      return;
    }
    biwu.a().a("AECameraLauncher---launchAECameraUnit-begin");
    vwj localvwj = vwj.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("entrance_type", paramInt);
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (((!avsz.a()) && (localBundle.getInt("VIDEO_STORY_JUMP_TO_TYPE", 0) != 0)) || ((localBundle.getInt("AECAMERA_MODE") == 202) && (amfv.d()))) {
      avsz.a(1);
    }
    avsz.a();
    localvwj.a(paramActivity, localBundle, 20000);
    paramActivity.overridePendingTransition(2130772217, 2130772038);
    vei.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
    biwu.a().a("AECameraLauncher---launchAECameraUnit-end");
    biwu.a().a(false);
    biwu.a().c();
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (a()) {
      return;
    }
    vwj localvwj = vwj.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (((!avsz.a()) && (localBundle.getInt("VIDEO_STORY_JUMP_TO_TYPE", 0) != 0)) || ((localBundle.getInt("AECAMERA_MODE") == 202) && (amfv.d()))) {
      avsz.a(1);
    }
    localvwj.a(paramContext, localBundle);
    vei.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
  }
  
  private static boolean a()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birx
 * JD-Core Version:    0.7.0.1
 */