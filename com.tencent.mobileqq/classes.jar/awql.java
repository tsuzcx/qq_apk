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

public class awql
{
  private static String a = "";
  
  public static bhpc a(int paramInt, String paramString)
  {
    bhpc localbhpc = null;
    if (QLog.isColorLevel()) {
      QLog.d("LocationDialogUtil", 2, "showFloatExitConfirmDialog: invoked. ");
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      localbhpc = bhlq.a(localBaseActivity, 230, null, localBaseActivity.getString(2131718252), 2131690728, 2131691095, new awqq(), new awqr(localBaseActivity, paramInt, paramString));
      paramString = new LocationDialogUtil.14(localBaseActivity, localbhpc);
      ThreadManager.getUIHandlerV2().postDelayed(paramString, 500L);
    }
    return localbhpc;
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
  
  static void a(Activity paramActivity, awsk paramawsk)
  {
    paramActivity = new LocationDialogUtil.4(paramActivity, paramawsk);
    ThreadManager.getUIHandlerV2().post(paramActivity);
  }
  
  public static void a(Activity paramActivity, bhpc parambhpc)
  {
    if (paramActivity != null) {}
    try
    {
      if (!paramActivity.isFinishing())
      {
        parambhpc.show();
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
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    a(paramActivity, bhlq.a(paramActivity, 230, null, paramActivity.getResources().getString(2131693408), 2131690580, 2131694098, new awqm(paramActivity, paramString1, paramString2, paramString3, paramLatLng1, paramLatLng2), new awqu()));
  }
  
  public static void a(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      return;
    }
    bjfq.b();
    bhpc localbhpc = bhlq.a(paramBaseActivity, 230, null, "位置共享将收起为小窗进行展示，请开启QQ悬浮窗权限以正常使用功能。", paramBaseActivity.getString(2131690580), paramBaseActivity.getString(2131694098), new awqs(paramBaseActivity), null);
    localbhpc.setCancelable(false);
    a(paramBaseActivity, localbhpc);
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString)
  {
    LocationDialogUtil.5 local5 = new LocationDialogUtil.5(paramBaseActivity);
    ThreadManager.getUIHandlerV2().post(local5);
    awpq.a(paramBaseActivity.app).a(paramInt2, paramString, paramInt1, 2);
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationDialogUtil", 2, new Object[] { "showEnterOtherRoomExitDialog: invoked. ", "activity = [" + paramBaseActivity + "], uinType = [" + paramInt1 + "], uin = [" + paramString + "], entryType = [" + paramInt2 + "]" });
    }
    if (paramInt2 == 1) {}
    for (String str = paramBaseActivity.getResources().getString(2131718250);; str = paramBaseActivity.getResources().getString(2131718249))
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
      bdll.b(null, "CliOper", "", "", paramString, paramString, i, 0, "", "0", "0", "");
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
    if (QLog.isColorLevel()) {
      QLog.d("LocationDialogUtil", 2, new Object[] { "showRoomJoinLimitedDialog: invoked. showRoomJoinLimitedDialog#post ", " runnable: ", paramActivity });
    }
  }
  
  public static void b(BaseActivity paramBaseActivity)
  {
    paramBaseActivity = new LocationDialogUtil.16(paramBaseActivity);
    ThreadManager.getUIHandlerV2().postDelayed(paramBaseActivity, 1000L);
  }
  
  static void b(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, String paramString)
  {
    paramBaseActivity = new LocationDialogUtil.7(paramBaseActivity);
    ThreadManager.getUIHandlerV2().postDelayed(paramBaseActivity, 7000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awql
 * JD-Core Version:    0.7.0.1
 */