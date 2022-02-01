package com.tencent.luggage.wxa.jj;

import android.content.SharedPreferences.Editor;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.om.a;
import com.tencent.luggage.wxa.on.h;
import com.tencent.luggage.wxa.qz.w;

public final class n
{
  private static final w a = w.a("com.tencent.mm.plugin.appbrand.config.AppDebugInfoHelper");
  
  public static void a(String paramString, boolean paramBoolean)
  {
    w localw = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_AppDebugEnabled");
    localw.putBoolean(localStringBuilder.toString(), paramBoolean).commit();
  }
  
  public static boolean a(d paramd)
  {
    a locala = (a)paramd.a(a.class, false);
    if (locala == null) {
      return false;
    }
    if (paramd.u()) {
      return false;
    }
    return locala.b;
  }
  
  public static boolean a(String paramString)
  {
    w localw = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_AppDebugEnabled");
    return localw.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static boolean b(String paramString)
  {
    return ((h)e.a(h.class)).a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.n
 * JD-Core Version:    0.7.0.1
 */