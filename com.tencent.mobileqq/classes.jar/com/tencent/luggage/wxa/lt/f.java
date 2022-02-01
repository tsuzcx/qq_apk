package com.tencent.luggage.wxa.lt;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public final class f
  extends a<com.tencent.luggage.wxa.jx.h>
{
  public static final int CTRL_INDEX = 108;
  public static final String NAME = "reportRealtimeAction";
  
  private com.tencent.luggage.wxa.dq.c a(com.tencent.luggage.wxa.jx.c paramc)
  {
    if ((paramc instanceof com.tencent.luggage.wxa.dq.c)) {
      return (com.tencent.luggage.wxa.dq.c)paramc;
    }
    return (com.tencent.luggage.wxa.dq.c)((com.tencent.luggage.wxa.iu.h)paramc).e(com.tencent.luggage.wxa.dq.c.class);
  }
  
  private void a(@NonNull d paramd, @Nullable com.tencent.luggage.wxa.dq.c paramc, @NonNull JSONObject paramJSONObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void a(com.tencent.luggage.wxa.jx.h paramh, JSONObject paramJSONObject, int paramInt)
  {
    try
    {
      a((d)paramh.q(), a(paramh), paramJSONObject);
      paramh.a(paramInt, b("ok"));
      return;
    }
    catch (Exception paramJSONObject)
    {
      o.b("MicroMsg.JsApiReportRealtimeAction", "report by service(%s), e = %s", new Object[] { paramh.getAppId(), paramJSONObject });
      paramh.a(paramInt, b("fail:internal error"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lt.f
 * JD-Core Version:    0.7.0.1
 */