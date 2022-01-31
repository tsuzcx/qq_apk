import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import mqq.app.AppActivity;
import org.json.JSONObject;

public class bbae
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
        localAppActivity.requestPermissions(new bbaf(localAppActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
      }
    }
    while ((lmm.b(paramActivity)) || (a(paramActivity))) {
      return;
    }
    boolean bool = bnob.b(paramAppInterface);
    if ((!bool) && (!bdee.g(paramActivity)))
    {
      QQToast.a(paramActivity, 2131719266, 0).a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "launchTakeVideoForTribe, videoSoUsable=" + bool);
    }
    paramUiApiPlugin.g();
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
      azmj.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "exp_findview", i, 0, "", "", "", "");
      return;
      paramActivity = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
      paramActivity.putExtras(paramAppInterface);
      paramActivity.putExtra("pendingIntentClass", bkjw.class.getName());
      paramActivity.putExtra("pendingIntentRequest", paramByte);
      paramActivity.putExtra("pendingIntentAllWait", true);
      paramUiApiPlugin.startActivityForResult(paramActivity, paramByte);
      break;
    }
  }
  
  private static boolean a(Context paramContext)
  {
    boolean bool = false;
    if (!axld.a())
    {
      bdcd.a(paramContext, 230).setMessage(alpo.a(2131715472)).setPositiveButton(2131694951, new bbag()).show();
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbae
 * JD-Core Version:    0.7.0.1
 */