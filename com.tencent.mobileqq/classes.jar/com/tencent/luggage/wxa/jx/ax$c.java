package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.jh;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "response", "Lcom/tencent/mm/protocal/protobuf/VerifyPluginResponse;", "kotlin.jvm.PlatformType", "onTerminate"}, k=3, mv={1, 1, 16})
final class ax$c<T>
  implements e.c<jh>
{
  ax$c(ax paramax, String paramString, h paramh, int paramInt) {}
  
  public final void a(jh paramjh)
  {
    if (paramjh == null)
    {
      ax.c();
      paramjh = new StringBuilder();
      paramjh.append(this.b);
      paramjh.append(" null response");
      o.b("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", paramjh.toString());
      this.c.a(this.d, this.a.b("fail:internal error"));
      return;
    }
    int i;
    Object localObject2;
    StringBuilder localStringBuilder;
    if (paramjh.z.a != 0)
    {
      ax.c();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(" cgi failed, errCode = %d, errMsg = %s");
      o.b("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", ((StringBuilder)localObject1).toString(), new Object[] { Integer.valueOf(paramjh.z.a), paramjh.z.b });
      localObject1 = this.c;
      i = this.d;
      localObject2 = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail cgi fail Ret=");
      localStringBuilder.append(paramjh.z.a);
      ((h)localObject1).a(i, ((ax)localObject2).b(localStringBuilder.toString()));
      return;
    }
    Object localObject1 = new HashMap();
    try
    {
      ax.c();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(" cgi ok, dataSize[");
      ((StringBuilder)localObject2).append(paramjh.a.length());
      ((StringBuilder)localObject2).append(']');
      o.d("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", ((StringBuilder)localObject2).toString());
      ((Map)localObject1).put("data", new JSONObject(paramjh.a));
      this.c.a(this.d, this.a.a("ok", (Map)localObject1));
      return;
    }
    catch (Exception paramjh)
    {
      ax.c();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(" cgi ok but get exception[");
      ((StringBuilder)localObject1).append(paramjh);
      ((StringBuilder)localObject1).append(']');
      o.b("Luggage.WXA.FULLSDK.JsApiVerifyPlugin", ((StringBuilder)localObject1).toString());
      localObject1 = this.c;
      i = this.d;
      localObject2 = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail:internal error");
      localStringBuilder.append(' ');
      localStringBuilder.append(paramjh);
      ((h)localObject1).a(i, ((ax)localObject2).b(localStringBuilder.toString()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ax.c
 * JD-Core Version:    0.7.0.1
 */