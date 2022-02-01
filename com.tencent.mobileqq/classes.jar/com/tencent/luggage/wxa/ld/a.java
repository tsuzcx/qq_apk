package com.tencent.luggage.wxa.ld;

import android.text.TextUtils;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.nz.p.c;
import java.util.HashMap;

public class a
  extends ah
{
  private static final int CTRL_INDEX = 530;
  private static final String NAME = "onLocalServiceEvent";
  private static a a = new a();
  
  public static void a(c paramc)
  {
    a(paramc, null, "stopScan");
  }
  
  public static void a(c paramc, p.c paramc1)
  {
    a(paramc, paramc1, "found");
  }
  
  private static void a(c paramc, p.c paramc1, String paramString)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("event", paramString);
      if ((TextUtils.equals(paramString, "found")) || (TextUtils.equals(paramString, "lost")) || (TextUtils.equals(paramString, "resolveFail")))
      {
        localHashMap.put("serviceType", paramc1.c);
        localHashMap.put("serviceName", paramc1.b);
        if (!TextUtils.equals(paramString, "resolveFail"))
        {
          localHashMap.put("ip", paramc1.d);
          localHashMap.put("port", Integer.valueOf(paramc1.e));
          localHashMap.put("attributes", paramc1.a);
        }
      }
      a.b(localHashMap).b(paramc).a();
      return;
    }
    finally {}
  }
  
  public static void b(c paramc, p.c paramc1)
  {
    a(paramc, paramc1, "lost");
  }
  
  public static void c(c paramc, p.c paramc1)
  {
    a(paramc, paramc1, "resolveFail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ld.a
 * JD-Core Version:    0.7.0.1
 */