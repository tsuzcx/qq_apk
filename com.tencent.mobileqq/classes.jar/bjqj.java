import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import dov.com.qq.im.ptv.LightVideoSoDownloadFragment;
import dov.com.qq.im.ptv.PtvCameraCaptureActivity;
import dov.com.qq.im.ptv.PtvSoDownloadActivity;

public class bjqj
{
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Bundle paramBundle, int paramInt)
  {
    if (paramQQAppInterface.c()) {
      bcpw.a(paramActivity, 0, 2131719576, 0).a();
    }
    while (a(paramActivity, paramQQAppInterface)) {
      return;
    }
    bctn.a(BaseApplicationImpl.getContext(), 51);
    boolean bool = a(paramQQAppInterface);
    paramQQAppInterface = paramBundle;
    if (paramBundle == null) {
      paramQQAppInterface = new Bundle();
    }
    paramBundle = bjoz.class.getName();
    if (bool)
    {
      PtvCameraCaptureActivity.a(paramActivity, paramBundle, paramQQAppInterface, paramInt);
      return;
    }
    paramQQAppInterface.putInt("flow_camera_show_mode_style", 0);
    paramQQAppInterface.putBoolean("flow_camera_show_panel", false);
    paramQQAppInterface.putLong("ACTIVITY_START_TIME", System.currentTimeMillis());
    paramQQAppInterface = PtvSoDownloadActivity.a(paramActivity, paramBundle, paramQQAppInterface);
    paramQQAppInterface.putExtra("PTV_pendingIntentRequest", paramInt);
    PublicTransFragmentActivity.b(paramActivity, paramQQAppInterface, LightVideoSoDownloadFragment.class, paramInt);
  }
  
  private static boolean a()
  {
    if ((Build.MODEL.equals("ASUS_Z00ADB")) && (Build.VERSION.SDK_INT == 21)) {}
    while ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("M040")) && (Build.VERSION.SDK_INT == 19)) {
      return false;
    }
    return true;
  }
  
  private static boolean a(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = false;
    boolean bool3 = VideoEnvironment.c(paramQQAppInterface);
    boolean bool4 = avtc.a();
    boolean bool2 = a();
    if ((!bool3) || (!bool4) || (!bool2))
    {
      veg.b("CaptureUtils", "checkApiVersionDialog false");
      bbcv.a(paramContext, 230).setMessage(ajyc.a(2131708727)).setPositiveButton(2131694793, new bjqk()).show();
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    return (ShortVideoUtils.a(paramAppInterface)) && (axlc.a(BaseApplicationImpl.getContext()) == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjqj
 * JD-Core Version:    0.7.0.1
 */