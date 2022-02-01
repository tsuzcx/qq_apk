import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.tencent.mobileqq.richmedia.capture.activity.CaptureQmcfSoDownloadActivity;
import mqq.app.AppActivity;
import org.json.JSONObject;

public class bdmy
{
  public static String a = "tribe_publish_TribePublishLauncher";
  
  public static Intent a(Activity paramActivity, AppInterface paramAppInterface, String paramString1, byte paramByte, String paramString2)
  {
    if ((paramActivity instanceof AppActivity))
    {
      AppActivity localAppActivity = (AppActivity)paramActivity;
      if (localAppActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        localAppActivity.requestPermissions(new bdmz(localAppActivity), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return null;
      }
    }
    if (ljo.b(paramActivity)) {
      return null;
    }
    if (a(paramActivity)) {
      return null;
    }
    boolean bool = body.b(paramAppInterface);
    if ((!bool) && (!NetworkUtil.isNetworkAvailable(paramActivity)))
    {
      QQToast.a(paramActivity, 2131717741, 0).a();
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "launchTakeVideoForTribe, videoSoUsable=" + bool);
    }
    paramAppInterface = new Bundle();
    paramAppInterface.putString("options", paramString1);
    paramAppInterface.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramAppInterface.putBoolean("PeakConstants.ARG_ALBUM", false);
    paramAppInterface.putInt("edit_video_type", 10012);
    paramAppInterface.putInt("entrance_type", 105);
    paramAppInterface.putInt("extra.busi_type", 11);
    paramAppInterface.putInt("edit_video_way", 9);
    paramAppInterface.putInt("key_camera_photo_edit_type", 1);
    paramAppInterface.putInt("key_camera_video_edit_type", 5);
    paramAppInterface.putInt("ability_flag", 3);
    if (bool)
    {
      paramActivity = QIMCameraCaptureActivity.a(paramActivity, paramAppInterface);
      if (!"barindex".equals(paramString2)) {
        break label315;
      }
    }
    label315:
    for (int i = 1;; i = 2)
    {
      bcef.b(null, "dc00899", "Grp_tribe", "", "video_shoot", "exp_findview", i, 0, "", "", "", "");
      return paramActivity;
      paramActivity = new Intent(paramActivity, CaptureQmcfSoDownloadActivity.class);
      paramActivity.putExtras(paramAppInterface);
      paramActivity.putExtra("pendingIntentClass", blih.class.getName());
      paramActivity.putExtra("pendingIntentRequest", paramByte);
      paramActivity.putExtra("pendingIntentAllWait", true);
      break;
    }
  }
  
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
  
  private static boolean a(Context paramContext)
  {
    boolean bool = false;
    if (!babd.a())
    {
      bfur.a(paramContext, 230).setMessage(amtj.a(2131714106)).setPositiveButton(2131694201, new bdna()).show();
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdmy
 * JD-Core Version:    0.7.0.1
 */