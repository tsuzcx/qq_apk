package com.tencent.luggage.wxa.pc;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.n;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import junit.framework.a;

public class m
{
  public static <T extends m.a> String a(Context paramContext, String paramString, T paramT)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Luggage.UserAgentUtil, appendUserAgent fail, context is null, stack = ");
    ((StringBuilder)localObject).append(af.c());
    localObject = ((StringBuilder)localObject).toString();
    boolean bool;
    if (paramContext != null) {
      bool = true;
    } else {
      bool = false;
    }
    a.a((String)localObject, bool);
    if (paramString == null)
    {
      paramContext = paramT.a();
    }
    else
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString);
      paramContext.append(paramT.a());
      paramContext = paramContext.toString();
    }
    paramString = new StringBuilder();
    paramString.append(paramContext);
    paramString.append(paramT.b());
    paramContext = paramString.toString();
    paramString = x.c(r.a());
    paramT = new StringBuilder();
    paramT.append(paramContext);
    paramT.append(" NetType/");
    paramT.append(paramString);
    paramContext = paramT.toString();
    paramString = new StringBuilder();
    paramString.append(paramContext);
    paramString.append(" Language/");
    paramString.append(n.a(r.a()));
    paramContext = paramString.toString();
    paramString = new StringBuilder();
    paramString.append(paramContext);
    paramString.append(" ABI/");
    if (a()) {
      paramContext = "arm64";
    } else {
      paramContext = "arm32";
    }
    paramString.append(paramContext);
    paramContext = paramString.toString();
    paramString = new StringBuilder();
    paramString.append("appendUserAgent, uaStr = ");
    paramString.append(paramContext);
    o.d("Luggage.UserAgentUtil", paramString.toString());
    return paramContext;
  }
  
  private static boolean a()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    String[] arrayOfString = Build.SUPPORTED_64_BIT_ABIS;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if ("arm64-v8a".equalsIgnoreCase(arrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pc.m
 * JD-Core Version:    0.7.0.1
 */