import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class bkzh
{
  public static int a(String paramString)
  {
    int i = 0;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        i = Integer.parseInt(paramString);
      }
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("TianshuSplashUtils", 1, "StringToInt exception" + paramString.toString());
    }
    return 0;
  }
  
  public static long a(String paramString)
  {
    long l = 0L;
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        l = Long.parseLong(paramString);
      }
      return l;
    }
    catch (Exception paramString)
    {
      QLog.e("TianshuSplashUtils", 1, "StringToLong exception" + paramString.toString());
    }
    return 0L;
  }
  
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("tianshu_splash_ad_pref_" + paramString, 0);
  }
  
  public static String a(String paramString)
  {
    return a(BaseApplicationImpl.getContext(), paramString).getString("tianshu_union_banner_current_", "");
  }
  
  public static Set<String> a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext, paramString).getString("tianshu_splash_ad_ids", "");
    paramString = new HashSet();
    if (!TextUtils.isEmpty(paramContext)) {
      paramString.addAll(Arrays.asList(paramContext.split(",")));
    }
    QLog.i("TianshuSplashUtils", 1, "getLocalTianshuAdIds frosm sp  adids =" + paramString);
    return paramString;
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
      paramContext.remove("tianshu_splash_ad_ids_with_showdate_with_priority_" + paramLong);
      paramContext.remove("tianshu_splash_ad_ids_with_showdate_with_priority_0");
      paramContext.apply();
      QLog.i("TianshuSplashUtils", 1, "cleanAllConfig ");
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("TianshuSplashUtils", 1, "cleanAllConfig exception" + paramContext.toString());
    }
  }
  
  public static void a(String paramString)
  {
    paramString = a(BaseApplicationImpl.getContext(), paramString).edit();
    paramString.remove("tianshu_union_banner_current_");
    paramString.apply();
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    try
    {
      blbx localblbx = new blbx();
      long l = System.currentTimeMillis() / 1000L;
      localblbx.b = (paramString1 + l);
      localblbx.d = paramInt;
      localblbx.jdField_e_of_type_Int = 1;
      localblbx.g = String.valueOf(paramString2);
      localblbx.jdField_a_of_type_Long = l;
      localblbx.jdField_a_of_type_Int = 1;
      localblbx.jdField_e_of_type_JavaLangString = "tianshu.150";
      localblbx.i = "";
      localblbx.l = paramString3;
      blbw.a().a(localblbx);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("TianshuSplashUtils", 1, "report exception" + paramString1.toString());
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    paramString2 = a(BaseApplicationImpl.getContext(), paramString2).edit();
    paramString2.putString("tianshu_union_banner_current_", paramString1);
    paramString2.apply();
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (1 == paramInt1)
    {
      l = DeviceInfoUtil.getSystemTotalMemory();
      if (paramInt3 != 0)
      {
        bool1 = bool2;
        if (Build.VERSION.SDK_INT <= paramInt3) {}
      }
      else
      {
        if ((l == 0L) || (paramInt2 == 0) || (l > paramInt2 * 1024 * 1024)) {
          break label139;
        }
        bool1 = bool2;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder("openDisabledLowerDevice ");
        localStringBuilder.append(" sdk_int:" + paramInt3);
        localStringBuilder.append(" mem:" + paramInt2);
        QLog.d("TianshuSplashUtils", 2, localStringBuilder.toString());
      }
    }
    label139:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        long l;
        StringBuilder localStringBuilder;
        return bool1;
        bool1 = false;
      }
    }
    QLog.d("TianshuSplashUtils", 2, "isDisabledLowerDevice false");
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return ("1".equals(paramString)) || ("2".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bkzh
 * JD-Core Version:    0.7.0.1
 */