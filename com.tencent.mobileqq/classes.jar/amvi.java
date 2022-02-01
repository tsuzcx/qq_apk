import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class amvi
{
  private static int jdField_a_of_type_Int;
  private static final SparseArray<Locale> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public static boolean a;
  private static boolean b;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(2052, Locale.SIMPLIFIED_CHINESE);
    jdField_a_of_type_AndroidUtilSparseArray.put(1033, Locale.US);
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 2052) {
      return amtj.a(2131693278);
    }
    if (paramInt == 1033) {
      return amtj.a(2131693277);
    }
    return "";
  }
  
  public static Locale a()
  {
    Locale localLocale2 = a(jdField_a_of_type_Int);
    Locale localLocale1 = localLocale2;
    if (localLocale2 == null) {
      localLocale1 = Locale.SIMPLIFIED_CHINESE;
    }
    a("queryCurrentLocale, currentLocale:" + localLocale1.toString());
    return localLocale1;
  }
  
  private static Locale a(int paramInt)
  {
    return (Locale)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public static void a(Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    a("initializeAppLocale, sCurrentLocaleId:" + jdField_a_of_type_Int);
    String str;
    if (jdField_a_of_type_Int == 0)
    {
      str = anxf.a(paramContext, "key_local_cache", "0");
      a("initializeAppLocale, localeIdStr:" + str);
      if (!"0".equals(str)) {
        break label182;
      }
      jdField_a_of_type_Int = 2052;
      anxf.a(paramContext, "key_local_cache", String.valueOf(jdField_a_of_type_Int));
      str = anxf.a(paramContext, "key_local_last", "0");
      if (!"0".equals(str)) {
        break label200;
      }
      if (jdField_a_of_type_Int == 2052) {
        break label195;
      }
    }
    for (;;)
    {
      b = bool1;
      anxf.a(paramContext, "key_local_last", String.valueOf(jdField_a_of_type_Int));
      a("initializeAppLocale, HwEngine.localeId:" + jdField_a_of_type_Int);
      com.tencent.mobileqq.highway.HwEngine.localeId = jdField_a_of_type_Int;
      mqq.app.AppActivity.localeId = jdField_a_of_type_Int;
      mqq.app.BaseActivity.localeId = jdField_a_of_type_Int;
      b(paramContext);
      return;
      label182:
      jdField_a_of_type_Int = Integer.parseInt(str.trim());
      break;
      label195:
      bool1 = false;
    }
    label200:
    if (Integer.parseInt(str) != jdField_a_of_type_Int) {}
    for (bool1 = bool2;; bool1 = false)
    {
      b = bool1;
      break;
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    a("setLocale , localeId = " + paramInt);
    anxf.a(paramContext, "key_local_last", String.valueOf(jdField_a_of_type_Int));
    anxf.a(paramContext, "key_local_cache", String.valueOf(paramInt));
    jdField_a_of_type_Int = paramInt;
    com.tencent.mobileqq.highway.HwEngine.localeId = jdField_a_of_type_Int;
    mqq.app.AppActivity.localeId = jdField_a_of_type_Int;
    mqq.app.BaseActivity.localeId = jdField_a_of_type_Int;
    b(paramContext, jdField_a_of_type_Int);
    a(paramContext, a(paramInt));
    if (b()) {
      anot.a().d(paramContext);
    }
  }
  
  public static void a(Context paramContext, Locale paramLocale)
  {
    if ((paramContext == null) || (paramLocale == null)) {
      return;
    }
    mqq.app.AppActivity.locale = paramLocale;
    mqq.app.BaseActivity.locale = paramLocale;
    com.tencent.mobileqq.pluginsdk.PluginProxyActivity.locale = paramLocale;
    paramContext = paramContext.getResources();
    Configuration localConfiguration = paramContext.getConfiguration();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo(paramContext.getDisplayMetrics());
    if (Build.VERSION.SDK_INT >= 24)
    {
      a("rconf locale set1:" + paramLocale.toString());
      paramLocale = new LocaleList(new Locale[] { paramLocale });
      LocaleList.setDefault(paramLocale);
      localConfiguration.setLocales(paramLocale);
    }
    for (;;)
    {
      paramContext.updateConfiguration(localConfiguration, paramContext.getDisplayMetrics());
      paramContext.getDisplayMetrics().setTo(localDisplayMetrics);
      return;
      a("rconf locale set2:" + paramLocale.toString());
      Locale.setDefault(paramLocale);
      localConfiguration.locale = paramLocale;
    }
  }
  
  public static void a(String paramString)
  {
    QLog.d("LocaleManager", 1, paramString);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Int == 2052;
  }
  
  public static boolean a(Locale paramLocale1, Locale paramLocale2)
  {
    if ((paramLocale1 == null) || (paramLocale2 == null)) {}
    boolean bool1;
    boolean bool2;
    do
    {
      return false;
      bool1 = paramLocale1.getLanguage().equals(paramLocale2.getLanguage());
      bool2 = paramLocale1.getCountry().equals(paramLocale2.getCountry());
    } while ((!bool1) || (!bool2));
    return true;
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext != null)
    {
      Object localObject = paramContext.getResources();
      if (localObject != null)
      {
        localObject = ((Resources)localObject).getConfiguration();
        a("tryApplyLocaleIfNeeded, resLocale:" + ((Configuration)localObject).locale.toString());
        Locale localLocale = a();
        if (!a(localLocale, ((Configuration)localObject).locale))
        {
          a("tryApplyLocaleIfNeeded, called tryApplyLocale");
          a(paramContext, localLocale);
        }
      }
      return;
    }
    a("called tryApplyLocaleIfNeeded, context null");
  }
  
  private static void b(Context paramContext, int paramInt)
  {
    int i = 0;
    try
    {
      SettingCloneUtil.writeValueForInt(paramContext, null, null, "qqsetting_locale_id", paramInt);
      a("updateMsfLocaleId, localeId:" + paramInt + ", time:" + System.currentTimeMillis());
      for (;;)
      {
        if ((i >= 3) || (SettingCloneUtil.readValueForInt(paramContext, null, null, "qqsetting_locale_id", 0) == paramInt))
        {
          if (SettingCloneUtil.readValueForInt(paramContext, null, null, "qqsetting_locale_id", 0) != paramInt) {
            a("updateMsfLocaleId, write failed, time:" + System.currentTimeMillis());
          }
          AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
          paramContext = new NewIntent(paramContext, BuiltInServlet.class);
          paramContext.putExtra("action", 2212);
          paramContext.putExtra("localeId", paramInt);
          localAppRuntime.startServlet(paramContext);
          return;
        }
        SettingCloneUtil.writeValueForInt(paramContext, null, null, "qqsetting_locale_id", paramInt);
        a("updateMsfLocaleId, write localeId:" + paramInt + ", time:" + System.currentTimeMillis());
        Thread.sleep(10L);
        i += 1;
      }
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("LocaleManager", 1, "updateMsfLocaleId error!", paramContext);
    }
  }
  
  public static boolean b()
  {
    return jdField_a_of_type_Int == 1033;
  }
  
  public static void c(Context paramContext)
  {
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    paramContext = null;
    if (localObject != null) {
      paramContext = ((ActivityManager)localObject).getRunningAppProcesses();
    }
    if (paramContext == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (!"com.tencent.mobileqq".equals(localRunningAppProcessInfo.processName))
        {
          Process.killProcess(localRunningAppProcessInfo.pid);
          a("process killed on locale update, pid:" + localRunningAppProcessInfo.pid + ", name:" + localRunningAppProcessInfo.processName);
        }
      }
      paramContext = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        localObject = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        Process.killProcess(((ActivityManager.RunningAppProcessInfo)localObject).pid);
        a("process killed on locale update, pid:" + ((ActivityManager.RunningAppProcessInfo)localObject).pid + ", name:" + ((ActivityManager.RunningAppProcessInfo)localObject).processName);
      }
    }
  }
  
  public static boolean c()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amvi
 * JD-Core Version:    0.7.0.1
 */