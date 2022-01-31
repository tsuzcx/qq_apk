import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo.1;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import mqq.os.MqqHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class befc
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public static String a;
  private static volatile Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  private static boolean jdField_a_of_type_Boolean;
  private static String b;
  private static String c;
  private static String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QQDeviceInfo";
    jdField_a_of_type_Boolean = false;
  }
  
  private static int a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilMap == null) {}
    do
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_JavaUtilMap == null) {
          b();
        }
        if (jdField_a_of_type_JavaUtilMap == null) {
          return 4;
        }
      }
      if (jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
        break;
      }
    } while (!jdField_a_of_type_Boolean);
    throw new IllegalArgumentException("busiId not registed ,please first regist");
    paramString = (Integer)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {}
    for (int i = 4;; i = paramString.intValue()) {
      return i;
    }
  }
  
  private static int a(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static String a()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    String str2 = (String)baig.a(localBaseApplication, "0", "key_no_login_user_id", "");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "";
    }
    try
    {
      str2 = Settings.Secure.getString(localBaseApplication.getContentResolver(), "android_id");
      str1 = str2;
    }
    catch (Exception localException)
    {
      label42:
      break label42;
    }
    str2 = UUID.randomUUID().toString();
    str1 = MD5.toMD5(str1 + str2);
    baig.a(localBaseApplication, "0", false, "key_no_login_user_id", str1);
    return str1;
  }
  
  public static String a(String paramString)
  {
    return a(paramString, -1);
  }
  
  public static String a(String paramString, int paramInt)
  {
    int j = a(paramString);
    int i = paramInt;
    if (paramInt == -1) {
      i = j;
    }
    if (Build.VERSION.SDK_INT > 28) {
      if (i >= 5) {
        paramString = c();
      }
    }
    for (;;)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getIMEI, result = " + str);
      }
      return str;
      if ("huawei".equalsIgnoreCase(Build.MANUFACTURER))
      {
        paramString = d();
      }
      else
      {
        paramString = e();
        continue;
        paramString = f();
      }
    }
  }
  
  public static void a()
  {
    if ((Build.VERSION.SDK_INT <= 28) || (!"huawei".equalsIgnoreCase(Build.MANUFACTURER))) {}
    do
    {
      return;
      b = e("huawei_oaid");
    } while (!TextUtils.isEmpty(b));
    ThreadManager.getFileThreadHandler().post(new QQDeviceInfo.1());
  }
  
  public static String b(String paramString)
  {
    a(paramString);
    paramString = (TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone");
    try
    {
      paramString = paramString.getSubscriberId();
      return paramString;
    }
    catch (SecurityException paramString)
    {
      return "";
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static String b(String paramString, int paramInt)
  {
    return b(paramString);
  }
  
  private static void b()
  {
    localHashMap = new HashMap();
    Object localObject = BaseApplicationImpl.getContext();
    for (;;)
    {
      try
      {
        localObject = ((Context)localObject).getResources().getAssets().open("SensiveAuthorityFile.xml");
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput((InputStream)localObject, "utf-8");
        i = localXmlPullParser.getEventType();
      }
      catch (IOException localIOException)
      {
        XmlPullParser localXmlPullParser;
        String str1;
        String str2;
        localIOException.printStackTrace();
        jdField_a_of_type_JavaUtilMap = localHashMap;
        return;
        localIOException.close();
        continue;
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        localXmlPullParserException.printStackTrace();
        continue;
        int i = 4;
        continue;
        if (i == 1) {
          continue;
        }
        switch (i)
        {
        }
        continue;
      }
      i = localXmlPullParser.next();
      continue;
      if (localXmlPullParser.getName().equalsIgnoreCase("business"))
      {
        str1 = localXmlPullParser.getAttributeValue(null, "id");
        str2 = localXmlPullParser.getAttributeValue(null, "level");
        if (TextUtils.isEmpty(str2)) {
          continue;
        }
        i = a(str2, 4);
        localHashMap.put(str1, Integer.valueOf(i));
        if (QLog.isDevelopLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 4, "init sensitive au, busiId = " + str1 + "; level = " + i);
        }
      }
    }
  }
  
  private static void b(String paramString1, String paramString2)
  {
    BaseApplicationImpl.getContext().getSharedPreferences("authority", 4).edit().putString(paramString1, paramString2).apply();
  }
  
  private static String c()
  {
    return UserAction.getQIMEI();
  }
  
  public static String c(String paramString)
  {
    a(paramString);
    paramString = (WifiManager)BaseApplicationImpl.getContext().getSystemService("wifi");
    try
    {
      paramString = paramString.getConnectionInfo().getMacAddress();
      return paramString;
    }
    catch (Exception localException)
    {
      do
      {
        paramString = "";
      } while (!QLog.isDevelopLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, " getMacAddr exception = " + localException);
    }
    return "";
  }
  
  private static void c()
  {
    HashMap localHashMap = new HashMap();
    String str = jdField_a_of_type_JavaLangString + "_getHuaweiOaid";
    localHashMap.put("huawei_oaid", b);
    awrn.a(BaseApplicationImpl.getContext()).a(null, str, true, 0L, 0L, localHashMap, null);
  }
  
  private static String d()
  {
    Object localObject;
    if (!TextUtils.isEmpty(b)) {
      localObject = b;
    }
    for (;;)
    {
      c();
      return localObject;
      String str = e();
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "getHuaweiOaid, but huawei oaid is null, so use android id instead");
        localObject = str;
      }
    }
  }
  
  private static String e()
  {
    if (!TextUtils.isEmpty(c)) {
      return c;
    }
    c = e("android_id");
    if (TextUtils.isEmpty(c))
    {
      c = Settings.System.getString(BaseApplicationImpl.getContext().getContentResolver(), "android_id");
      b("android_id", c);
    }
    return c;
  }
  
  private static String e(String paramString)
  {
    String str = BaseApplicationImpl.getContext().getSharedPreferences("authority", 4).getString(paramString, "");
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "";
    }
    return paramString;
  }
  
  private static String f()
  {
    if (!TextUtils.isEmpty(d)) {
      return d;
    }
    d = e("imei");
    if (TextUtils.isEmpty(d)) {}
    for (;;)
    {
      try
      {
        localTelephonyManager = (TelephonyManager)BaseApplicationImpl.getContext().getSystemService("phone");
        if (Build.VERSION.SDK_INT >= 26) {
          continue;
        }
        d = localTelephonyManager.getDeviceId();
        b("imei", d);
      }
      catch (SecurityException localSecurityException)
      {
        TelephonyManager localTelephonyManager;
        d = "";
        continue;
      }
      catch (Throwable localThrowable)
      {
        d = "";
        continue;
      }
      return d;
      d = localTelephonyManager.getImei();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     befc
 * JD-Core Version:    0.7.0.1
 */