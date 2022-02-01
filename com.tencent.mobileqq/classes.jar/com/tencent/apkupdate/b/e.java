package com.tencent.apkupdate.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;

public final class e
{
  private static String b = "NA";
  private Context a = null;
  
  public e(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static StringBuffer a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (TextUtils.isEmpty(paramString))
    {
      localStringBuffer.append("NA");
      return localStringBuffer;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if ((paramString[i] > ' ') && (paramString[i] != '/') && (paramString[i] != '_') && (paramString[i] != '&') && (paramString[i] != '|') && (paramString[i] != '-')) {
        localStringBuffer.append(paramString[i]);
      }
      i += 1;
    }
    return localStringBuffer;
  }
  
  public final String a()
  {
    d locald = new d();
    locald.c("100");
    locald.d("");
    locald.e(b);
    StringBuffer localStringBuffer = new StringBuffer();
    String str = Build.VERSION.RELEASE;
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "NA";
    }
    localStringBuffer.append((String)localObject);
    localStringBuffer.append("_");
    localStringBuffer.append(Build.VERSION.SDK_INT);
    locald.f(localStringBuffer.toString());
    locald.b(this.a.getResources().getDisplayMetrics().heightPixels);
    locald.a(this.a.getResources().getDisplayMetrics().widthPixels);
    locald.c(0);
    localObject = new StringBuffer();
    ((StringBuffer)localObject).append(a(Build.BRAND));
    ((StringBuffer)localObject).append("_");
    ((StringBuffer)localObject).append(a(Build.MODEL));
    locald.a(((StringBuffer)localObject).toString());
    locald.b("100");
    localObject = new StringBuilder(" qua :");
    ((StringBuilder)localObject).append(locald.a());
    Log.i("vivianliao", ((StringBuilder)localObject).toString());
    return locald.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.apkupdate.b.e
 * JD-Core Version:    0.7.0.1
 */