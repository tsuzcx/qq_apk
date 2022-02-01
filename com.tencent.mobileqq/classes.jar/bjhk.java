import MWIFI.SCGet3rdCloudCheck;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.wifi.FreeWifiHelper.5;
import com.tencent.mobileqq.wifi.QWifiFloorFragment;
import com.tencent.mobileqq.wifi.QWifiListFragment;
import com.tencent.mobileqq.wifi.QWifiSecurityFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wifisdk.TMSDKCustomConfig;
import com.tencent.wifisdk.TMSDKWifiManager;
import com.wifisdk.ui.WifiSDKUIApi;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class bjhk
{
  private static volatile boolean a;
  private static volatile boolean b;
  private static boolean c;
  private static boolean d;
  private static boolean e;
  
  private static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, bjhv parambjhv, int paramInt)
  {
    paramActivity = new FreeWifiHelper.5(paramActivity, paramString1, paramString2, paramString3, paramString4, new bjho(paramInt, paramActivity, parambjhv), new bjhp(parambjhv, paramInt), new bjhq(parambjhv, paramInt), paramInt);
    paramString1 = Looper.getMainLooper();
    if (Thread.currentThread() == paramString1.getThread())
    {
      paramActivity.run();
      return;
    }
    new Handler(paramString1).post(paramActivity);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    QLog.i("WifiSdk", 2, "gotoWifiListPage");
    if (a(paramContext))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("uiapi_k101", paramInt);
      localIntent.putExtra("big_brother_source_key", "biz_src_wifi");
      PublicFragmentActivity.a(paramContext, localIntent, QWifiListFragment.class);
    }
  }
  
  private static void a(Context paramContext, int paramInt, ArrayList<Integer> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "gotoWifiSecurityPage");
    }
    if (a(paramContext))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("uiapi_k101", paramInt);
      if (paramArrayList != null) {
        localIntent.putIntegerArrayListExtra("uiapi_k100", paramArrayList);
      }
      localIntent.putExtra("big_brother_source_key", "biz_src_wifi");
      PublicFragmentActivity.a(paramContext, localIntent, QWifiSecurityFragment.class);
    }
  }
  
  public static void a(Context paramContext, SCGet3rdCloudCheck paramSCGet3rdCloudCheck)
  {
    try
    {
      if (!a(paramContext.getApplicationContext())) {
        return;
      }
      if (paramSCGet3rdCloudCheck.tipsType == 1)
      {
        c(paramContext, 3);
        b(paramContext, 398679);
        return;
      }
      if (paramSCGet3rdCloudCheck.tipsType != 2) {
        break label103;
      }
      if (!WifiSDKUIApi.isWiFiManagerExist()) {
        break label91;
      }
      WifiSDKUIApi.gotoWifiAppSecurityPage(paramContext);
    }
    catch (Exception paramContext)
    {
      while (QLog.isColorLevel())
      {
        QLog.i("WifiSdk", 2, "onClickWifiSecurityBanner exception: " + paramContext.getMessage());
        return;
        label91:
        a(paramContext, 4, paramSCGet3rdCloudCheck.safeTypeList);
      }
      label103:
      if (paramSCGet3rdCloudCheck.tipsType != 3) {
        return;
      }
      if (TextUtils.isEmpty(paramSCGet3rdCloudCheck.h5)) {
        break label136;
      }
      a(paramContext, paramSCGet3rdCloudCheck.h5);
      b(paramContext, 500147);
      return;
      label136:
      c(paramContext, 3);
      b(paramContext, 398679);
    }
    b(paramContext, 398681);
    return;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    QLog.i("WifiSdk", 2, "gotoH5");
    if (a(paramContext))
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.setFlags(268435456);
      localIntent.putExtra("big_brother_source_key", "biz_src_wifi");
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "registGuidIfNeed app: " + paramQQAppInterface);
    }
    if (paramQQAppInterface == null) {}
    String str;
    BaseApplication localBaseApplication;
    do
    {
      do
      {
        return;
        str = paramQQAppInterface.getCurrentAccountUin();
        localBaseApplication = paramQQAppInterface.getApp();
        localObject = bjia.a(localBaseApplication, str);
        if (QLog.isColorLevel()) {
          QLog.i("WifiSdk", 2, "registGuidIfNeed uin: " + str + " guid: " + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("WifiSdk", 2, "registGuidIfNeed uin: " + str + " guid is not null, do not regist");
      return;
      long l = bjia.c(localBaseApplication, str);
      if ((l == -1L) || (System.currentTimeMillis() - l >= 86400000L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("WifiSdk", 2, "registGuidIfNeed, dont regit guid, time limit");
    return;
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "registGuidIfNeed, start regist guid");
    }
    Object localObject = new aokz(paramQQAppInterface);
    aola localaola = new aola(paramQQAppInterface);
    localaola.a(new bjhm(paramQQAppInterface, localaola));
    paramQQAppInterface.addObserver(localaola);
    ((aokz)localObject).a(2);
    bjia.c(localBaseApplication, str, System.currentTimeMillis());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    String str = paramQQAppInterface.c();
    int j = bhsi.a(paramQQAppInterface.getApp(), "wifi_connect_config_version", str);
    if (QLog.isColorLevel()) {
      QLog.d("FreeWifiHelper", 2, String.format(Locale.getDefault(), "received wifi Config remote version: %d, localVersion: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    if (i != j)
    {
      bhsi.a(paramQQAppInterface.getApp(), "wifi_connect_config_version", str, i);
      paramConfig = arry.b(paramConfig, j, paramInt);
      if (!TextUtils.isEmpty(paramConfig))
      {
        QLog.d("WifiSdk", 2, "receiveAllConfigs|type: " + paramInt + ",content: " + paramConfig + ",version: " + i);
        try
        {
          paramConfig = new JSONObject(paramConfig);
          if (paramConfig.optInt("Wifi_file_and", 0) == 1)
          {
            bool = true;
            c = bool;
            if (paramConfig.optInt("Wifi_security_and", 0) != 1) {
              break label250;
            }
            bool = true;
            label193:
            d = bool;
            if (paramConfig.optInt("Wifi_PDV_and", 0) != 1) {
              break label256;
            }
          }
          label256:
          for (boolean bool = true;; bool = false)
          {
            e = bool;
            bhsi.a(paramQQAppInterface.getApp(), paramQQAppInterface.c(), c, d, e);
            a(paramQQAppInterface, false);
            return;
            bool = false;
            break;
            label250:
            bool = false;
            break label193;
          }
          a(paramQQAppInterface, true);
        }
        catch (JSONException paramConfig)
        {
          QLog.e("WifiSdk", 2, paramConfig, new Object[0]);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Object localObject;
    String str;
    if (paramBoolean)
    {
      localObject = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      str = paramQQAppInterface.getCurrentAccountUin();
      c = ((SharedPreferences)localObject).getBoolean("wifi_connect_switch_file_" + str, false);
      d = ((SharedPreferences)localObject).getBoolean("wifi_connect_switch_security_" + str, false);
      e = ((SharedPreferences)localObject).getBoolean("wifi_connect_switch_pdv_" + str, false);
    }
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "startCheck start, Conversation.sConversationResumeFlag: " + Conversation.b + ", file switch: " + c + ", security switch: " + d + ", pdv switch: " + e);
    }
    try
    {
      if (((d) || (e)) && (Conversation.b > 0L))
      {
        localObject = paramQQAppInterface.getApp();
        str = paramQQAppInterface.getCurrentAccountUin();
        long l1 = System.currentTimeMillis();
        long l2 = bjia.a((Context)localObject, str);
        long l3 = bjia.b((Context)localObject, str) * 60 * 60 * 1000L;
        if (QLog.isColorLevel()) {
          QLog.i("WifiSdk", 2, "startCheck, lastTime: " + l2 + " frequency: " + l3 + " nowTime: " + l1);
        }
        if ((l2 != -1L) && (l1 - l2 < l3))
        {
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.i("WifiSdk", 2, "startCheck end, time limited");
          return;
        }
        bjia.a((Context)localObject, str, l1);
        aokz localaokz = new aokz(paramQQAppInterface);
        aola localaola = new aola(paramQQAppInterface);
        localaola.a(new bjhl((Context)localObject, str, paramQQAppInterface, localaola));
        paramQQAppInterface.addObserver(localaola);
        localaokz.a(1);
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel())
      {
        QLog.i("WifiSdk", 2, "startCheck exception: " + paramQQAppInterface.getMessage());
        return;
        if (c) {
          b(paramQQAppInterface);
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    QLog.d("WifiSdk", 2, "WL_DEBUG reportClickEvent actionName = " + paramString);
    bdll.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static boolean a(Activity paramActivity, int paramInt, bjhv parambjhv)
  {
    QLog.i("WifiSdk", 2, "shouldOverrideDialog scene: " + paramInt + ", file switch: " + c);
    if ((!c) || (!a(paramActivity))) {}
    for (;;)
    {
      return true;
      String str1 = "";
      String str2 = "";
      int i;
      if (paramInt == 1)
      {
        str1 = paramActivity.getString(2131692374);
        str2 = paramActivity.getString(2131692377);
        i = 1;
      }
      while (i != 0)
      {
        String str5 = paramActivity.getString(2131692380);
        String str4 = bjia.a(paramActivity);
        String str3 = str4;
        if (TextUtils.isEmpty(str4)) {
          str3 = paramActivity.getString(2131692373);
        }
        QLog.i("WifiSdk", 2, "shouldOverrideDialog btn1Text: " + str3);
        a(paramActivity, str5, str1, str3, str2, parambjhv, paramInt);
        return false;
        if ((paramInt == 2) || (paramInt == 4))
        {
          str1 = paramActivity.getString(2131692376);
          str2 = paramActivity.getString(2131692379);
          i = 1;
        }
        else if (paramInt == 3)
        {
          str1 = paramActivity.getString(2131692375);
          str2 = paramActivity.getString(2131692378);
          i = 1;
        }
        else if (paramInt == 5)
        {
          str1 = paramActivity.getString(2131692329);
          str2 = paramActivity.getString(2131692379);
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = false;
    QLog.i("WifiSdk", 2, "init wifisdk. was: " + a);
    if (a) {
      return true;
    }
    if (b)
    {
      QLog.e("WifiSdk", 2, "wifisdk last init failed");
      return false;
    }
    try
    {
      if (QLog.isDebugVersion()) {
        TMSDKWifiManager.setEnableLog(true);
      }
      if (!TMSDKWifiManager.init(paramContext.getApplicationContext(), new TMSDKCustomConfig().setCustomToast(new bjhu()).setCustomInstaller(new bjht()).setCustomThreadPool(new bjhs()).setCustomReporter(new bjhr()))) {
        bool = true;
      }
      b = bool;
      WifiSDKUIApi.init(new bjhx(), new bjhy());
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QLog.e("WifiSdk", 2, "wifisdk init failed: " + paramContext.getMessage());
        b = true;
      }
    }
    if (!b) {
      a = true;
    }
    return a;
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    if (a(paramContext)) {
      WifiSDKUIApi.reportActionStat(paramInt);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "requestTargetJumpInfoIfNeed app: " + paramQQAppInterface);
    }
    if (paramQQAppInterface == null) {}
    String str;
    BaseApplication localBaseApplication;
    do
    {
      return;
      str = paramQQAppInterface.getCurrentAccountUin();
      localBaseApplication = paramQQAppInterface.getApp();
      long l = bjia.b(localBaseApplication, str);
      if ((l == -1L) || (System.currentTimeMillis() - l >= 86400000L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("WifiSdk", 2, "requestTargetJumpInfoIfNeed, dont request, time limit");
    return;
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "requestTargetJumpInfoIfNeed, start request");
    }
    aokz localaokz = new aokz(paramQQAppInterface);
    aola localaola = new aola(paramQQAppInterface);
    localaola.a(new bjhn(paramQQAppInterface, localaola));
    paramQQAppInterface.addObserver(localaola);
    localaokz.a(3);
    bjia.b(localBaseApplication, str, System.currentTimeMillis());
  }
  
  public static void c(Context paramContext, int paramInt)
  {
    if (!a(paramContext)) {
      return;
    }
    bjhz localbjhz = bjhz.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    if (QLog.isColorLevel()) {
      QLog.i("WifiSdk", 2, "dialog click, jumpType: " + localbjhz.jdField_a_of_type_Int + " jumpUrl: " + localbjhz.jdField_a_of_type_JavaLangString);
    }
    if (WifiSDKUIApi.isWiFiManagerExist())
    {
      if (localbjhz.jdField_a_of_type_Int == 4)
      {
        a(paramContext, paramInt);
        b(paramContext, 500105);
        return;
      }
      WifiSDKUIApi.gotoWifiAppConnectPage(paramContext);
      b(paramContext, 500101);
      return;
    }
    switch (localbjhz.jdField_a_of_type_Int)
    {
    case 4: 
    default: 
      a(paramContext, paramInt);
      b(paramContext, 500105);
      return;
    case 1: 
      a(paramContext, localbjhz.jdField_a_of_type_JavaLangString);
      b(paramContext, 500102);
      return;
    case 3: 
      a(paramContext, localbjhz.jdField_a_of_type_JavaLangString);
      b(paramContext, 500103);
      return;
    case 2: 
      a(paramContext, paramInt);
      b(paramContext, 500104);
      return;
    }
    QLog.i("WifiSdk", 2, "gotoWifiFloorPage");
    if (a(paramContext)) {
      PublicFragmentActivity.a(paramContext, new Intent(), QWifiFloorFragment.class);
    }
    b(paramContext, 500177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjhk
 * JD-Core Version:    0.7.0.1
 */