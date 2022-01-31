import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import mqq.app.AppActivity;
import org.json.JSONObject;

public class azcf
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
    if ((paramActivity instanceof AppActivity))
    {
      AppActivity localAppActivity = (AppActivity)paramActivity;
      if (localAppActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
        localAppActivity.requestPermissions(new azcg(localAppActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
      }
    }
    while ((lkj.b(paramActivity)) || (a(paramActivity))) {
      return;
    }
    boolean bool = blcr.b(paramAppInterface);
    if ((!bool) && (!bbfj.g(paramActivity)))
    {
      bcql.a(paramActivity, 2131718792, 0).a();
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
        break label287;
      }
    }
    label287:
    for (int i = 1;; i = 2)
    {
      axqy.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "exp_findview", i, 0, "", "", "", "");
      return;
      paramActivity = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
      paramActivity.putExtras(paramAppInterface);
      paramActivity.putExtra("pendingIntentClass", biib.class.getName());
      paramActivity.putExtra("pendingIntentRequest", paramByte);
      paramActivity.putExtra("pendingIntentAllWait", true);
      paramUiApiPlugin.startActivityForResult(paramActivity, paramByte);
      break;
    }
  }
  
  private static boolean a(Context paramContext)
  {
    boolean bool = false;
    if (!avte.a())
    {
      bbdj.a(paramContext, 230).setMessage(ajya.a(2131715100)).setPositiveButton(2131694794, new azch()).show();
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azcf
 * JD-Core Version:    0.7.0.1
 */