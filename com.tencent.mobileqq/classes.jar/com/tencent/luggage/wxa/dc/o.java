package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.jj.u;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.lt;
import com.tencent.luggage.wxa.qw.lv;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.ro.d;
import java.util.concurrent.TimeUnit;

public class o
{
  public static lv a(String paramString1, String paramString2)
  {
    com.tencent.luggage.wxa.qz.o.e("Luggage.WxaAttrSync", "sync wxa app, appId=%s", new Object[] { paramString1 });
    Object localObject = new lt();
    ((lt)localObject).a = paramString2;
    ((lt)localObject).b = u.a().b(paramString1);
    ((lt)localObject).c = paramString1;
    paramString2 = new lv[1];
    paramString2[0] = null;
    localObject = (lv)((b)com.tencent.luggage.wxa.ba.e.a(b.class)).a("/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync", paramString1, (a)localObject, lv.class);
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.WxaAttrSync", "sync %s, fail", new Object[] { paramString1 });
      return null;
    }
    com.tencent.luggage.wxa.qz.o.d("Luggage.WxaAttrSync", "sync %s wxaAttrSyncResponse errCode:%d errMsg:%s", new Object[] { paramString1, Integer.valueOf(((lv)localObject).z.a), ((lv)localObject).z.b });
    paramString2[0] = localObject;
    u.a().a(paramString1, (lv)localObject);
    return paramString2[0];
  }
  
  public static boolean a(String paramString)
  {
    return af.b(u.a().c(paramString)) >= TimeUnit.MINUTES.toSeconds(5L);
  }
  
  public static lv b(String paramString)
  {
    return a(paramString, "");
  }
  
  public static com.tencent.luggage.wxa.ro.e<lv> b(String paramString1, String paramString2)
  {
    lt locallt = new lt();
    locallt.a = paramString2;
    locallt.b = u.a().b(paramString1);
    locallt.c = paramString1;
    return ((b)com.tencent.luggage.wxa.ba.e.a(b.class)).b("/cgi-bin/mmbiz-bin/wxaattr/wxaattrsync", paramString1, locallt, lv.class).a(new o.1(paramString1, paramString2));
  }
  
  public static com.tencent.luggage.wxa.ro.e<lv> c(String paramString)
  {
    return b(paramString, "");
  }
  
  public static com.tencent.luggage.wxa.ro.e<lv> d(String paramString)
  {
    return b("", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.o
 * JD-Core Version:    0.7.0.1
 */