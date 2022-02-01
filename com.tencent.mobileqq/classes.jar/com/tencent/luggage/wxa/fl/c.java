package com.tencent.luggage.wxa.fl;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.cx.q;
import com.tencent.luggage.wxa.dc.t;
import com.tencent.luggage.wxa.hv.h;
import com.tencent.luggage.wxa.nl.g;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.ah;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.appcache.ac;
import com.tencent.mm.plugin.appbrand.appcache.n;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public class c
  implements a
{
  private static void a(String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return;
      }
      try
      {
        JSONObject localJSONObject = h.a(paramString2);
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          String str = localJSONObject.optString((String)localObject);
          localObject = new n(paramString1, (String)localObject);
          ac.a().a(((n)localObject).toString(), paramInt, str, t.a);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        o.a("WMPF.Debugger.ForceOpenAppNotify", localThrowable, "processSubUrlsAndSave appId[%s], json[%s]", new Object[] { paramString1, paramString2 });
      }
    }
  }
  
  @NonNull
  public String a()
  {
    return "ForceOpenAppNotify";
  }
  
  public void a(@NonNull Intent paramIntent, @NonNull String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = ah.a(paramString, "sysmsg", null);
    if (localObject == null)
    {
      o.b("WMPF.Debugger.ForceOpenAppNotify", "parsedKV is null, return");
      return;
    }
    paramIntent = (String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppID");
    paramString = (String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.UserName");
    int i = af.a((String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.VersionType"), -1);
    af.a((String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.AppVersion"), -1);
    paramString = (String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.Path");
    String str1 = (String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.URL");
    String str2 = (String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.MD5");
    String str3 = (String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.ExtJsonInfo");
    String str4 = (String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.SubUrls");
    localObject = (String)((Map)localObject).get(".sysmsg.ForceOpenAppNotify.OpenAppInfo.WithoutCodeLibUrls");
    if (i < 0) {
      return;
    }
    if (TextUtils.isEmpty(paramIntent)) {
      return;
    }
    if (i != 0)
    {
      if (ac.a().a(paramIntent, i, str1, str2)) {
        b.b(paramIntent, i);
      }
      a(paramIntent, str4, i);
      g.a().a(paramIntent, i, str3);
    }
    localObject = new com.tencent.luggage.wxa.ew.b();
    ((com.tencent.luggage.wxa.ew.b)localObject).a = paramIntent;
    ((com.tencent.luggage.wxa.ew.b)localObject).d = paramString;
    ((com.tencent.luggage.wxa.ew.b)localObject).e = i;
    q.a(r.a(), (com.tencent.luggage.wxa.ew.b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fl.c
 * JD-Core Version:    0.7.0.1
 */