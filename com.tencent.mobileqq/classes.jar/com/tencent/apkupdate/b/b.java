package com.tencent.apkupdate.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.protocol.jce.Terminal;

public class b
{
  private static b a;
  private static String c = "";
  private static int d;
  private static Terminal e;
  private Context b;
  
  public static int a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramContext = paramContext.getPackageManager();
      try
      {
        int i = paramContext.getPackageInfo(paramString, 0).versionCode;
        return i;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return 0;
  }
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getPackageName();
    }
    return "";
  }
  
  public static byte c()
  {
    return (byte)(TextUtils.isEmpty(Proxy.getDefaultHost()) ^ true);
  }
  
  public static int c(Context paramContext)
  {
    if (paramContext != null)
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      try
      {
        int i = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
        return i;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return 0;
  }
  
  public static String f()
  {
    return c;
  }
  
  public static int i()
  {
    try
    {
      int i = d;
      d = i + 1;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static String j()
  {
    try
    {
      String str = (String)f.a("com.tencent.open.appcommon.js.AppInterface").a("getImei", new Object[0]).a();
      return str;
    }
    catch (Throwable localThrowable)
    {
      label23:
      break label23;
    }
    return "";
  }
  
  private static String k()
  {
    try
    {
      String str = (String)f.a("com.tencent.open.appcommon.js.AppInterface").a("getImsi", new Object[0]).a();
      return str;
    }
    catch (Throwable localThrowable)
    {
      label23:
      break label23;
    }
    return "";
  }
  
  private String l()
  {
    String str = "";
    try
    {
      WifiInfo localWifiInfo = ((WifiManager)this.b.getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo != null) {
        str = localWifiInfo.getMacAddress();
      }
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public final int a(String paramString)
  {
    Context localContext = this.b;
    if (localContext == null) {
      return 0;
    }
    try
    {
      paramString = localContext.getPackageManager().getApplicationInfo(paramString, 128);
      if ((paramString != null) && (paramString.metaData != null))
      {
        int i = paramString.metaData.getInt("com.tencent.android.qqdownloader.GRAY_CODE");
        return i;
      }
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  public final void a(Context paramContext)
  {
    this.b = paramContext;
    c = new e(paramContext).a();
  }
  
  public final Context b()
  {
    return this.b;
  }
  
  public final void b(String paramString)
  {
    if (paramString != null)
    {
      SharedPreferences localSharedPreferences = this.b.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
      if (localSharedPreferences != null) {
        localSharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", paramString).commit();
      }
    }
  }
  
  public final String d()
  {
    Context localContext = this.b;
    if (localContext == null) {
      return "";
    }
    return ((TelephonyManager)localContext.getSystemService("phone")).getNetworkOperator();
  }
  
  public final int e()
  {
    Object localObject = this.b;
    String str = "";
    if ((localObject != null) && (((Context)localObject).checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != -1))
    {
      localObject = ((ConnectivityManager)this.b.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject != null) {
        if (((NetworkInfo)localObject).getType() == 1)
        {
          str = "WIFI";
        }
        else
        {
          localObject = ((NetworkInfo)localObject).getExtraInfo();
          if (localObject != null) {
            str = ((String)localObject).toUpperCase();
          }
        }
      }
    }
    if (!TextUtils.isEmpty(str))
    {
      if (str.equals("WIFI")) {
        return 1;
      }
      if (str.equals("UN_DETECT")) {
        return 0;
      }
      if (str.equals("CMWAP")) {
        return 2;
      }
      if (str.equals("CMNET")) {
        return 3;
      }
      if (str.equals("UNIWAP")) {
        return 4;
      }
      if (str.equals("UNINET")) {
        return 5;
      }
      if (str.equals("WAP3G")) {
        return 6;
      }
      if (str.equals("NET3G")) {
        return 7;
      }
      if (str.equals("CTWAP")) {
        return 8;
      }
      if (str.equals("CTNET")) {
        return 9;
      }
    }
    return 10;
  }
  
  public final Terminal g()
  {
    for (;;)
    {
      try
      {
        if (e == null)
        {
          String str2 = Settings.Secure.getString(this.b.getContentResolver(), "android_id");
          Object localObject1 = this.b.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
          if (localObject1 == null) {
            break label130;
          }
          localObject1 = ((SharedPreferences)localObject1).getString("TMAssistantSDKPhoneGUID", "");
          try
          {
            Terminal localTerminal2 = new Terminal();
            e = localTerminal2;
            localTerminal2.androidId = str2;
            e.androidIdSdCard = ((String)localObject1);
            e.imei = j();
            e.imsi = k();
            e.macAdress = l();
          }
          finally
          {
            localObject2 = finally;
            throw localObject2;
          }
        }
        Terminal localTerminal1 = e;
        return localTerminal1;
      }
      finally {}
      label130:
      String str1 = "";
    }
  }
  
  public final String h()
  {
    SharedPreferences localSharedPreferences = this.b.getSharedPreferences("TMAssistantSDKSharedPreference", 0);
    if (localSharedPreferences != null) {
      return localSharedPreferences.getString("TMAssistantSDKPhoneGUID", "");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.b.b
 * JD-Core Version:    0.7.0.1
 */