import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;

public class birg
{
  private static long a;
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, armb paramarmb)
  {
    if (a()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("VIDEO_STORY_FROM_TYPE", paramInt2);
    localBundle.putInt("AECAMERA_MODE", 200);
    localBundle.putInt("ability_flag", 2);
    localBundle.putInt("edit_video_type", 10023);
    if (paramarmb != null)
    {
      localBundle.putBoolean("key_camera_prefer_id", paramarmb.jdField_a_of_type_Boolean);
      localBundle.putBoolean("key_has_countdown", paramarmb.b);
      localBundle.putBoolean("key_disable_face_detect", paramarmb.d);
      localBundle.putBoolean("key_need_check_sensitive", paramarmb.c);
      localBundle.putString("key_guide_image", paramarmb.jdField_a_of_type_JavaLangString);
    }
    QIMCameraCaptureActivity.a(paramActivity, localBundle, paramInt1);
    paramActivity.overridePendingTransition(2130772217, 2130772038);
  }
  
  public static void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if (a()) {
      return;
    }
    biwd.a().a("AECameraLauncher---launchAECameraUnit-begin");
    vwm localvwm = vwm.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("entrance_type", paramInt);
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (((!avsx.a()) && (localBundle.getInt("VIDEO_STORY_JUMP_TO_TYPE", 0) != 0)) || ((localBundle.getInt("AECAMERA_MODE") == 202) && (amfw.d()))) {
      avsx.a(1);
    }
    avsx.a();
    localvwm.a(paramActivity, localBundle, 20000);
    paramActivity.overridePendingTransition(2130772217, 2130772038);
    vel.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
    biwd.a().a("AECameraLauncher---launchAECameraUnit-end");
    biwd.a().a(false);
    biwd.a().c();
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (a()) {
      return;
    }
    vwm localvwm = vwm.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (((!avsx.a()) && (localBundle.getInt("VIDEO_STORY_JUMP_TO_TYPE", 0) != 0)) || ((localBundle.getInt("AECAMERA_MODE") == 202) && (amfw.d()))) {
      avsx.a(1);
    }
    localvwm.a(paramContext, localBundle);
    vel.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
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
 * Qualified Name:     birg
 * JD-Core Version:    0.7.0.1
 */