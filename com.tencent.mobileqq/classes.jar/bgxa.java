import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;

public class bgxa
{
  private static long a;
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (a()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("VIDEO_STORY_FROM_TYPE", paramInt2);
    localBundle.putInt("AECAMERA_MODE", 200);
    localBundle.putInt("ability_flag", 2);
    localBundle.putInt("edit_video_type", 10023);
    auto.a(1);
    QIMCameraCaptureActivity.a(paramActivity, localBundle, paramInt1);
    paramActivity.overridePendingTransition(2130772217, 2130772038);
  }
  
  public static void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if (a()) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("CameraLaunchPerf", 4, "receiveClick time=" + System.currentTimeMillis());
    }
    vjq localvjq = vjq.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("entrance_type", paramInt);
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (((!auto.a()) && (localBundle.getInt("VIDEO_STORY_JUMP_TO_TYPE", 0) != 0)) || ((localBundle.getInt("AECAMERA_MODE") == 202) && (alrg.d()))) {
      auto.a(1);
    }
    auto.a();
    localvjq.a(paramActivity, localBundle, 20000);
    paramActivity.overridePendingTransition(2130772217, 2130772038);
    urp.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (a()) {
      return;
    }
    vjq localvjq = vjq.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (((!auto.a()) && (localBundle.getInt("VIDEO_STORY_JUMP_TO_TYPE", 0) != 0)) || ((localBundle.getInt("AECAMERA_MODE") == 202) && (alrg.d()))) {
      auto.a(1);
    }
    localvjq.a(paramContext, localBundle);
    urp.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
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
 * Qualified Name:     bgxa
 * JD-Core Version:    0.7.0.1
 */