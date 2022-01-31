import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.ui.LocationDialogUtil.10;
import com.tencent.mobileqq.location.ui.LocationDialogUtil.11;
import com.tencent.mobileqq.location.ui.LocationDialogUtil.14;
import com.tencent.mobileqq.location.ui.LocationDialogUtil.16;
import com.tencent.mobileqq.location.ui.LocationDialogUtil.4;
import com.tencent.mobileqq.location.ui.LocationDialogUtil.5;
import com.tencent.mobileqq.location.ui.LocationDialogUtil.6;
import com.tencent.mobileqq.location.ui.LocationDialogUtil.7;
import com.tencent.mobileqq.location.ui.LocationDialogUtil.9;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class aqzw
{
  private static String a = "";
  
  public static bafb a(int paramInt, String paramString)
  {
    bafb localbafb = null;
    if (QLog.isColorLevel()) {
      QLog.d("LocationDialogUtil", 2, "showFloatExitConfirmDialog: invoked. ");
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      localbafb = babr.a(localBaseActivity, 230, null, localBaseActivity.getString(2131653718), 2131625271, 2131625665, new arab(), new arac(localBaseActivity, paramInt, paramString));
      paramString = new LocationDialogUtil.14(localBaseActivity, localbafb);
      ThreadManager.getUIHandlerV2().postDelayed(paramString, 500L);
    }
    return localbafb;
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity = new LocationDialogUtil.9(paramActivity);
    ThreadManager.getUIHandlerV2().postDelayed(paramActivity, 500L);
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationDialogUtil", 2, new Object[] { "showStartShareLocationDialog: invoked. ", "context = [" + paramActivity + "], uinType = [" + paramInt1 + "], frienduin = [" + paramString + "]" });
    }
    paramActivity = new LocationDialogUtil.6(paramActivity, paramInt1, paramString, paramInt2);
    ThreadManager.getUIHandlerV2().post(paramActivity);
  }
  
  static void a(Activity paramActivity, arbp paramarbp)
  {
    paramActivity = new LocationDialogUtil.4(paramActivity, paramarbp);
    ThreadManager.getUIHandlerV2().post(paramActivity);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    b(paramActivity, babr.a(paramActivity, 230, null, paramActivity.getResources().getString(2131628343), 2131625035, 2131629116, new aqzx(paramActivity, paramString1, paramString2, paramString3, paramLatLng1, paramLatLng2), new araf()));
  }
  
  public static void a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      return;
    }
    bbqn.b();
    bafb localbafb = babr.a(paramBaseActivity, 230, null, "位置共享将收起为小窗进行展示，请开启QQ悬浮窗权限以正常使用功能。", paramBaseActivity.getString(2131625035), paramBaseActivity.getString(2131629116), new arad(paramBaseActivity), null);
    localbafb.setCancelable(false);
    b(paramBaseActivity, localbafb);
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString)
  {
    LocationDialogUtil.5 local5 = new LocationDialogUtil.5(paramBaseActivity);
    ThreadManager.getUIHandlerV2().post(local5);
    aqzc.a(paramBaseActivity.app).a(paramInt2, paramString, paramInt1, 2);
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationDialogUtil", 2, new Object[] { "showEnterOtherRoomExitDialog: invoked. ", "activity = [" + paramBaseActivity + "], uinType = [" + paramInt1 + "], uin = [" + paramString + "], entryType = [" + paramInt2 + "]" });
    }
    if (paramInt2 == 1) {}
    for (String str = paramBaseActivity.getResources().getString(2131653716);; str = paramBaseActivity.getResources().getString(2131653715))
    {
      paramBaseActivity = new LocationDialogUtil.11(paramBaseActivity, str, paramInt1, paramString, paramInt2);
      ThreadManager.getUIHandlerV2().postDelayed(paramBaseActivity, 500L);
      return;
    }
  }
  
  public static boolean a(Activity paramActivity)
  {
    if ((paramActivity instanceof PublicFragmentActivity))
    {
      paramActivity = paramActivity.getIntent().getStringExtra("FRAGMENT_KEY");
      if (QLog.isColorLevel()) {
        QLog.d("LocationDialogUtil", 2, new Object[] { "activityIsShareOrPickFragment: invoked. ", " key: ", paramActivity });
      }
      if (("LocationShareFragment".equals(paramActivity)) || ("LocationPickFragment".equals(paramActivity))) {
        return true;
      }
    }
    return false;
  }
  
  private static void b(int paramInt, String paramString)
  {
    int i = 2;
    if (paramInt == 3) {
      i = 1;
    }
    for (;;)
    {
      awqx.b(null, "CliOper", "", "", paramString, paramString, i, 0, "", "0", "0", "");
      return;
      if (paramInt != 2) {
        i = 0;
      }
    }
  }
  
  public static void b(Activity paramActivity)
  {
    paramActivity = new LocationDialogUtil.10(paramActivity);
    ThreadManager.getUIHandlerV2().postDelayed(paramActivity, 500L);
  }
  
  private static void b(Activity paramActivity, bafb parambafb)
  {
    if (paramActivity != null) {}
    try
    {
      if (!paramActivity.isFinishing())
      {
        parambafb.show();
        a = String.valueOf(paramActivity.hashCode());
        if (QLog.isColorLevel()) {
          QLog.d("LocationDialogUtil", 2, new Object[] { "showSafely: invoked. ", " currentDialogActivityHash: ", a });
        }
      }
      return;
    }
    catch (Exception paramActivity)
    {
      QLog.e("LocationDialogUtil", 1, "showSafely: failed. ", paramActivity);
    }
  }
  
  public static void b(BaseActivity paramBaseActivity)
  {
    paramBaseActivity = new LocationDialogUtil.16(paramBaseActivity);
    ThreadManager.getUIHandlerV2().postDelayed(paramBaseActivity, 1000L);
  }
  
  static void b(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString)
  {
    LocationDialogUtil.7 local7 = new LocationDialogUtil.7(paramBaseActivity);
    ThreadManager.getUIHandlerV2().postDelayed(local7, 7000L);
    aqzc.a(paramBaseActivity.app).a(paramInt2, paramString, paramInt1, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqzw
 * JD-Core Version:    0.7.0.1
 */