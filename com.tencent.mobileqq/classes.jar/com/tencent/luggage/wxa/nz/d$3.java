package com.tencent.luggage.wxa.nz;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.luggage.wxa.pd.p;
import com.tencent.luggage.wxa.pd.p.a;
import com.tencent.luggage.wxa.pd.p.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

class d$3
  implements Runnable
{
  d$3(d paramd, String paramString1, com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, d.a parama, int paramInt, Map paramMap, ArrayList paramArrayList, String paramString2) {}
  
  public void run()
  {
    if (this.i.b(this.a))
    {
      o.c("MicroMsg.AppBrandNetworkRequest", "try request but already abort, taskId:%s, appId:%s", new Object[] { this.a, d.a(this.i) });
      return;
    }
    if (p.a(this.b.getJsRuntime(), this.c, (p.a)this.b.b(p.a.class)) == p.b.b)
    {
      this.d.a("fail", "convert native buffer parameter fail. native buffer exceed size limit.");
      return;
    }
    String str = j.c(this.c.optString("url"));
    ??? = this.c.opt("data");
    ??? = this.c.optString("method");
    Object localObject3 = ???;
    if (af.c((String)???)) {
      localObject3 = "GET";
    }
    if (TextUtils.isEmpty(str))
    {
      this.d.a("fail", "url is null");
      return;
    }
    if ((!URLUtil.isHttpsUrl(str)) && (!URLUtil.isHttpUrl(str)))
    {
      this.d.a("fail", "request protocol must be http or https");
      return;
    }
    if ((??? != null) && (d.a(this.i, (String)localObject3))) {
      if ((??? instanceof String)) {
        ??? = ((String)???).getBytes(StandardCharsets.UTF_8);
      }
    }
    for (;;)
    {
      break;
      if ((??? instanceof ByteBuffer)) {
        ??? = com.tencent.luggage.wxa.pc.c.a((ByteBuffer)???);
      } else {
        ??? = new byte[0];
      }
    }
    synchronized (d.d(this.i))
    {
      o.d("MicroMsg.AppBrandNetworkRequest", "lm:mRequestTaskList.size() :%d,mMaxRequestConcurrent:%d", new Object[] { Integer.valueOf(d.d(this.i).size()), Integer.valueOf(d.e(this.i)) });
      if (d.d(this.i).size() >= d.e(this.i))
      {
        this.d.a("fail", "max connected");
        o.d("MicroMsg.AppBrandNetworkRequest", "max connected mRequestTaskList.size():%d,mMaxRequestConcurrent:%d", new Object[] { Integer.valueOf(d.d(this.i).size()), Integer.valueOf(d.e(this.i)) });
        return;
      }
      boolean bool1 = this.c.optBoolean("enableHttp2", false);
      boolean bool2 = this.c.optBoolean("enableQuic", false);
      boolean bool3 = this.c.optBoolean("enableCache", false);
      boolean bool4 = this.c.optBoolean("enableProfile", true);
      o.d("MicroMsg.AppBrandNetworkRequest", "request taskId %s, method %s,timeout %s, useHttp2 %b, useQuic %b, useMemoryCache %b, useProfile %b, url %s ", new Object[] { this.a, localObject3, Integer.valueOf(this.e), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool4), str });
      localObject3 = new e(str, (byte[])???, this.e, this.d, (String)localObject3, bool1, bool2, bool3);
      ((e)localObject3).a(this.f);
      ((e)localObject3).a(this.g);
      ((e)localObject3).d(this.h);
      ((e)localObject3).e(this.c.optString("responseType", "text"));
      ((e)localObject3).c(bool1);
      ((e)localObject3).b(bool2);
      ((e)localObject3).d(bool3);
      ((e)localObject3).e(bool4);
      synchronized (d.d(this.i))
      {
        o.d("MicroMsg.AppBrandNetworkRequest", "lm:request mRequestTaskList.add, appId(%s) taskId(%s)", new Object[] { d.a(this.i), this.a });
        d.d(this.i).add(localObject3);
        ((e)localObject3).b(this.a);
        o.d("MicroMsg.AppBrandNetworkRequest", "lm:request %s ,url %s", new Object[] { this.a, str });
        if (d.f(this.i))
        {
          d.b(this.i, (e)localObject3);
          return;
        }
        d.c(this.i, (e)localObject3);
        return;
      }
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.d.3
 * JD-Core Version:    0.7.0.1
 */