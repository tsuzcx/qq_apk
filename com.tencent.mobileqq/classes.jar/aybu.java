import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import org.json.JSONObject;

public class aybu
{
  public static String a = "tribe_publish_TribePublishLauncher";
  
  public static JSONObject a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("options");
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "getTribeJsonExtra option: " + paramBundle);
      }
      try
      {
        paramBundle = new JSONObject(paramBundle);
        return paramBundle;
      }
      catch (Exception paramBundle)
      {
        if (QLog.isColorLevel()) {
          QLog.e(a, 2, "getTribeJsonExtra: " + paramBundle);
        }
      }
    }
    return null;
  }
  
  public static void a(UiApiPlugin paramUiApiPlugin, Activity paramActivity, AppInterface paramAppInterface, String paramString1, byte paramByte, String paramString2)
  {
    if (kzy.b(paramActivity)) {}
    while (a(paramActivity)) {
      return;
    }
    boolean bool = bjlp.b(paramAppInterface);
    if ((!bool) && (!badq.g(paramActivity)))
    {
      bbmy.a(paramActivity, 2131652956, 0).a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "launchTakeVideoForTribe, videoSoUsable=" + bool);
    }
    paramUiApiPlugin.f();
    paramAppInterface = new Bundle();
    paramAppInterface.putBoolean("flow_camera_video_mode", true);
    paramAppInterface.putBoolean("flow_camera_capture_mode", false);
    paramAppInterface.putString("options", paramString1);
    paramAppInterface.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramAppInterface.putInt("edit_video_type", 10012);
    if (bool)
    {
      paramUiApiPlugin.startActivityForResult(QIMCameraCaptureActivity.a(paramActivity, paramAppInterface), paramByte);
      if (!"barindex".equals(paramString2)) {
        break label240;
      }
    }
    label240:
    for (int i = 1;; i = 2)
    {
      awqx.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "exp_findview", i, 0, "", "", "", "");
      return;
      paramActivity = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
      paramActivity.putExtras(paramAppInterface);
      paramActivity.putExtra("pendingIntentClass", bheu.class.getName());
      paramActivity.putExtra("pendingIntentRequest", paramByte);
      paramActivity.putExtra("pendingIntentAllWait", true);
      paramUiApiPlugin.startActivityForResult(paramActivity, paramByte);
      break;
    }
  }
  
  private static boolean a(Context paramContext)
  {
    boolean bool = false;
    if (!autt.a())
    {
      babr.a(paramContext, 230).setMessage(ajjy.a(2131649300)).setPositiveButton(2131629116, new aybv()).show();
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aybu
 * JD-Core Version:    0.7.0.1
 */