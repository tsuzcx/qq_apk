import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import java.util.LinkedList;
import java.util.List;

public class blax
{
  private static long a;
  
  private static Bundle a(@Nullable Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = localBundle.getString("material_id");
    if (!TextUtils.isEmpty(paramBundle))
    {
      paramBundle = paramBundle.split("\\^");
      if (paramBundle.length == 2) {
        localBundle.putString("KEY_CURRENT_SELECT_ID", paramBundle[1]);
      }
    }
    localBundle.putInt("AECAMERA_MODE", 200);
    if (!localBundle.containsKey("VIDEO_STORY_FROM_TYPE")) {
      localBundle.putInt("VIDEO_STORY_FROM_TYPE", blat.x.a());
    }
    localBundle.putInt("VIDEO_STORY_JUMP_TO_TYPE", 1);
    localBundle.putInt("entrance_type", 120);
    localBundle.putInt("edit_video_type", 10026);
    localBundle.putInt("capture_intent_mode", 8);
    return localBundle;
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, atha paramatha)
  {
    if (b()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("VIDEO_STORY_FROM_TYPE", paramInt2);
    localBundle.putInt("AECAMERA_MODE", 200);
    localBundle.putInt("ability_flag", 2);
    localBundle.putInt("edit_video_type", 10023);
    if (paramatha != null)
    {
      localBundle.putBoolean("key_camera_prefer_id", paramatha.jdField_a_of_type_Boolean);
      localBundle.putBoolean("key_has_countdown", paramatha.b);
      localBundle.putBoolean("key_disable_face_detect", paramatha.d);
      localBundle.putBoolean("key_need_check_sensitive", paramatha.c);
      localBundle.putString("key_guide_image", paramatha.jdField_a_of_type_JavaLangString);
    }
    QIMCameraCaptureActivity.a(paramActivity, localBundle, paramInt1);
    paramActivity.overridePendingTransition(2130772233, 2130772038);
  }
  
  public static void a(Activity paramActivity, int paramInt, Bundle paramBundle)
  {
    if (b()) {
      return;
    }
    blfv.a().a("AECameraLauncher---launchAECameraUnit-begin");
    xpk localxpk = xpk.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("entrance_type", paramInt);
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (a(localBundle))
    {
      bljn.b("AECameraLauncher", "isOpenFrontFirst: true");
      axph.a(1);
    }
    axph.a();
    localxpk.a(paramActivity, localBundle, 20000);
    paramActivity.overridePendingTransition(2130772233, 2130772038);
    wxj.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
    blfv.a().a("AECameraLauncher---launchAECameraUnit-end");
    blfv.a().a(false);
    blfv.a().c();
  }
  
  public static void a(Activity paramActivity, @Nullable Bundle paramBundle)
  {
    bljn.a("AECameraLauncher", "[AE Profiler] launchAECameraFromCircle");
    paramBundle = a(paramBundle);
    xpk.a().a(paramActivity, paramBundle, 20000);
    paramActivity.overridePendingTransition(2130772233, 2130772038);
  }
  
  public static void a(Context paramContext, Bundle paramBundle)
  {
    if (b()) {
      return;
    }
    xpk localxpk = xpk.a();
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putInt("edit_video_type", 10023);
    localBundle.putInt("capture_intent_mode", 8);
    if (a(localBundle))
    {
      bljn.b("AECameraLauncher", "isOpenFrontFirst: true");
      axph.a(1);
    }
    localxpk.a(paramContext, localBundle);
    wxj.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
  }
  
  public static boolean a()
  {
    if (!azcr.a()) {}
    for (;;)
    {
      return false;
      if ((bnsn.b(blqh.a())) && (azkt.a(BaseApplicationImpl.getContext()) != 2)) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
    }
  }
  
  private static boolean a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return false;
    }
    if (!amrk.a(paramActivity)) {}
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
    if (((axph.a()) || (paramBundle.getInt("VIDEO_STORY_JUMP_TO_TYPE", 0) == 0)) && ((paramBundle.getInt("AECAMERA_MODE") != 202) || (!aobe.d())))
    {
      bool1 = bool2;
      if (paramBundle.getInt("AECAMERA_MODE") == 203)
      {
        bool1 = bool2;
        if (!aobe.d()) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
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
    bljo.a(paramActivity, new Intent().putExtras(paramBundle));
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
 * Qualified Name:     blax
 * JD-Core Version:    0.7.0.1
 */