package com.tencent.luggage.wxa.pd;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.pc.l.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.HashSet;
import java.util.Set;

public final class d
{
  private static final Set<Object> a = new HashSet();
  private static final char[] b = { 60, 62, 34, 39, 38, 32, 39 };
  private static final String[] c = { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;" };
  
  @Deprecated
  public static l.a a()
  {
    return l.a();
  }
  
  public static String a(@StringRes int paramInt, Object... paramVarArgs)
  {
    return r.d().getString(paramInt, paramVarArgs);
  }
  
  @NonNull
  public static String a(ComponentName paramComponentName)
  {
    if (paramComponentName == null) {
      return "[UNKNOWN]";
    }
    PackageManager localPackageManager = r.a().getPackageManager();
    if (localPackageManager == null) {
      return "[UNKNOWN]";
    }
    try
    {
      paramComponentName = localPackageManager.getActivityInfo(paramComponentName, 128);
      if (paramComponentName != null)
      {
        paramComponentName = paramComponentName.taskAffinity;
        return paramComponentName;
      }
    }
    catch (Exception paramComponentName)
    {
      o.b("MicroMsg.AppBrandUtil", "getActivityTaskAffinity e = %s", new Object[] { paramComponentName });
    }
    return "[UNKNOWN]";
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.replace(' ', '\n').replace(' ', '\n');
  }
  
  public static void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    a.remove(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.d
 * JD-Core Version:    0.7.0.1
 */