import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.agent.AuthorityActivity;
import com.tencent.open.agent.PublicFragmentActivityForOpenSDK;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class bfii
{
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    float f2 = paramContext.getResources().getDisplayMetrics().density;
    int i = paramBitmap.getWidth();
    float f1 = f2;
    if (i > 0)
    {
      f1 = f2;
      if (i < paramInt1 * f2) {
        f1 = i / paramInt1;
      }
    }
    paramInt1 = (int)(paramInt1 * f1);
    paramInt2 = (int)(f1 * paramInt2);
    return bdhj.a(paramBitmap, paramInt1, paramInt1, paramInt2);
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("platform", "1");
    localBundle.putString("result", paramString1);
    localBundle.putString("code", paramString2);
    localBundle.putString("tmcost", paramString3);
    localBundle.putString("rate", paramString4);
    localBundle.putString("cmd", paramString5);
    localBundle.putString("uin", paramString6);
    localBundle.putString("appid", paramString7);
    localBundle.putString("share_type", paramString8);
    localBundle.putString("detail", paramString9);
    localBundle.putString("os_ver", Build.VERSION.RELEASE);
    localBundle.putString("network", bflk.a(bfbm.a().a()));
    localBundle.putString("apn", bflk.b(bfbm.a().a()));
    localBundle.putString("model_name", Build.MODEL);
    localBundle.putString("qq_ver", bfbm.a().c());
    return localBundle;
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("uin", paramString1);
    localBundle.putString("openid", paramString2);
    localBundle.putString("report_type", paramString3);
    localBundle.putString("act_type", paramString4);
    localBundle.putString("via", "2");
    localBundle.putString("app_id", paramString5);
    localBundle.putString("result", paramString6);
    localBundle.putString("type", paramString7);
    localBundle.putString("login_status", paramString8);
    localBundle.putString("need_user_auth", paramString9);
    localBundle.putString("to_uin", paramString10);
    localBundle.putString("to_type", paramString11);
    return localBundle;
  }
  
  public static String a(Activity paramActivity)
  {
    if (paramActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.i("AuthorityUtil", 2, "getSrcPackageName activity is null");
      }
    }
    do
    {
      return null;
      paramActivity = paramActivity.getIntent().getBundleExtra("key_params");
      if (paramActivity != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("AuthorityUtil", 2, "getSrcPackageName bundle is null");
    return null;
    return paramActivity.getString("packagename");
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    bflp.b("AuthorityUtil", "getOpenId uin = " + paramString1 + ", appid = " + paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return bfrh.a(paramContext, "uin_openid_store").getString(paramString2 + ":" + paramString1, null);
  }
  
  public static String a(Intent paramIntent, String paramString)
  {
    try
    {
      paramIntent = paramIntent.getStringExtra(paramString);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      QLog.e("AuthorityUtil", 1, "getStringExtra :", paramIntent);
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return "0";
      }
      paramString = paramString.substring(paramString.length() - 4);
      return paramString;
    }
    catch (Exception paramString) {}
    return "0";
  }
  
  public static void a(AppRuntime paramAppRuntime, String paramString)
  {
    QLog.d("AuthorityUtil", 1, new Object[] { "syncLoginAccount-", a(paramString) });
    Object localObject = paramAppRuntime.getApplication().getAllAccounts();
    if (localObject != null) {
      if (((List)localObject).size() >= 8) {
        QLog.d("AuthorityUtil", 1, new Object[] { "syncLoginAccount-max count=", Integer.valueOf(((List)localObject).size()) });
      }
    }
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramString.equals(((SimpleAccount)((Iterator)localObject).next()).getUin()))
        {
          QLog.d("AuthorityUtil", 1, "syncLoginAccount-exist!!!");
          return;
        }
      }
      azqs.b(null, "dc00898", "", "", "0X800AC2F", "0X800AC2F", 0, 0, "", "", "", "");
      QLog.d("AuthorityUtil", 1, new Object[] { "同步互联账户=0X800AC2F uin=", a(paramString) });
      MsfSdkUtils.addLoginSimpleAccount(paramString, true);
      paramAppRuntime.getApplication().setSortAccountList(MsfSdkUtils.getLoginedAccountList());
      paramAppRuntime = paramAppRuntime.getApplication().getAllAccounts();
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.iterator();
        while (paramAppRuntime.hasNext())
        {
          paramString = (SimpleAccount)paramAppRuntime.next();
          QLog.d("AuthorityUtil", 1, "after syncLoginAccount " + a(paramString.getUin()));
        }
      }
    }
  }
  
  public static boolean a(Activity paramActivity)
  {
    return ((paramActivity instanceof AuthorityActivity)) || ((paramActivity instanceof PublicFragmentActivityForOpenSDK));
  }
  
  public static boolean a(String paramString, AppRuntime paramAppRuntime)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AuthorityUtil", 1, "hasA2 false, currentAccount empty");
      return false;
    }
    if (paramAppRuntime == null)
    {
      QLog.e("AuthorityUtil", 1, "hasA2 false appInterface is null");
      return false;
    }
    paramAppRuntime = (TicketManager)paramAppRuntime.getManager(2);
    if (paramAppRuntime == null)
    {
      QLog.e("AuthorityUtil", 1, "hasA2 false TicketManager is null");
      return false;
    }
    if (!TextUtils.isEmpty(paramAppRuntime.getA2(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("AuthorityUtil", 1, "hasA2 uin=" + a(paramString) + "  " + bool);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfii
 * JD-Core Version:    0.7.0.1
 */