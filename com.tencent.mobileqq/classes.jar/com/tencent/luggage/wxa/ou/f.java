package com.tencent.luggage.wxa.ou;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.dq.c;
import com.tencent.luggage.wxa.dz.a;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.iu.g;
import com.tencent.luggage.wxa.jj.j;
import com.tencent.luggage.wxa.ov.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

public class f
{
  @NonNull
  public static Pair<Integer, String> a(@NonNull c paramc)
  {
    int j = f.1.a[com.tencent.luggage.wxa.iu.c.i(paramc.getAppId()).ordinal()];
    int i = 7;
    Object localObject2 = null;
    Object localObject1;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            Intent localIntent = b(paramc).b();
            localObject1 = localObject2;
            if (localIntent != null)
            {
              if (localIntent.getComponent() == null)
              {
                o.b("Luggage.Wxa.PVReportUtils", "onBackground, intent %s, get null cmp name", new Object[] { localIntent });
                paramc = "";
              }
              else
              {
                paramc = localIntent.getComponent().getClassName();
              }
              if ((!paramc.contains("WebViewUI")) && (!paramc.contains("WebviewMpUI")))
              {
                i = 8;
                paramc = af.a(com.tencent.luggage.wxa.qz.k.a(localIntent, "appbrand_report_key_target_activity"), paramc);
              }
              else
              {
                paramc = com.tencent.luggage.wxa.qz.k.a(localIntent, "appbrand_report_key_target_url");
                i = 10;
              }
              localObject1 = paramc;
            }
          }
          else
          {
            i = 9;
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(g.c(paramc.getAppId()).f);
            ((StringBuilder)localObject1).append(":");
            ((StringBuilder)localObject1).append(k.a(af.b(g.c(paramc.getAppId()).g)));
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        else
        {
          i = 6;
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = localObject2;
        if (paramc.b().a())
        {
          i = 5;
          localObject1 = localObject2;
        }
      }
    }
    else if (paramc.b().a())
    {
      i = 4;
      localObject1 = localObject2;
    }
    else
    {
      i = 3;
      localObject1 = localObject2;
    }
    return Pair.create(Integer.valueOf(i), localObject1);
  }
  
  public static String a(@Nullable j paramj)
  {
    if (paramj == null) {
      return null;
    }
    if ((1 != paramj.a) && (3 != paramj.a))
    {
      if (2 == paramj.a) {
        return paramj.f;
      }
      return "";
    }
    return paramj.b;
  }
  
  @NonNull
  private static com.tencent.luggage.wxa.ov.f b(@NonNull c paramc)
  {
    return paramc.f().k().getReporter();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ou.f
 * JD-Core Version:    0.7.0.1
 */