package com.tencent.luggage.wxa.ka;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$execute$task$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$c
  implements com.tencent.luggage.wxa.sj.g
{
  b$c(com.tencent.luggage.wxa.iu.b paramb, g paramg, JSONObject paramJSONObject, int paramInt, String paramString) {}
  
  @NotNull
  public String a()
  {
    return this.f;
  }
  
  public void run()
  {
    if (this.b.d())
    {
      this.c.a(this.b, this.d, this.e, (e)new a((e)new b.c.a(this)));
      return;
    }
    b.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.b.c
 * JD-Core Version:    0.7.0.1
 */