package com.tencent.acstat.a.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.Log;
import com.tencent.acstat.common.d;
import org.json.JSONObject;

public class i
{
  static void a(String paramString)
  {
    Log.i("MID", paramString);
  }
  
  static void a(Throwable paramThrowable)
  {
    Log.w("MID", paramThrowable);
  }
  
  static void a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (b(paramString2)) {
      paramJSONObject.put(paramString1, paramString2);
    }
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName());
      if (i == 0) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramContext)
    {
      Log.e("MID", "checkPermission error", paramContext);
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() != 0);
  }
  
  public static boolean c(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() >= 40);
  }
  
  static String d(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (Build.VERSION.SDK_INT < 8);
    try
    {
      str = new String(d.b(Base64.decode(paramString.getBytes("UTF-8"), 0)), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MID", "decode error", localThrowable);
    }
    return paramString;
  }
  
  static String e(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (Build.VERSION.SDK_INT < 8);
    try
    {
      str = new String(Base64.encode(d.a(paramString.getBytes("UTF-8")), 0), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
      return str;
    }
    catch (Throwable localThrowable)
    {
      Log.w("MID", "encode error", localThrowable);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.a.a.i
 * JD-Core Version:    0.7.0.1
 */