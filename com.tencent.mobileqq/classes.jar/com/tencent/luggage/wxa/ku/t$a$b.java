package com.tencent.luggage.wxa.ku;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.dq.d.a;
import com.tencent.luggage.wxa.pd.l.b;
import com.tencent.mm.appbrand.v8.n.c;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion$loadJsFiles$2", "Lcom/tencent/mm/plugin/appbrand/utils/JsValidationInjector$JsValidationInjectionCallbackV8Ex;", "condition", "", "ret", "", "countdownAndCallback", "", "onFailure", "onResult", "details", "Lcom/tencent/mm/appbrand/v8/V8ContextEngine$ExecuteDetails;", "onSuccess", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class t$a$b
  implements l.b
{
  private int f = 2;
  private String g;
  
  t$a$b(ValueCallback paramValueCallback, boolean[] paramArrayOfBoolean, int paramInt, d.a parama, Object[] paramArrayOfObject) {}
  
  private final void a()
  {
    this.f -= 1;
    if (this.f == 0)
    {
      ValueCallback localValueCallback = this.a;
      if (localValueCallback != null) {
        localValueCallback.onReceiveValue(this.g);
      }
    }
  }
  
  public void a(@Nullable n.c paramc)
  {
    if ((paramc != null) && (paramc.sourceLength > 0)) {
      this.d.c = paramc.sourceLength;
    }
    this.e[this.c] = paramc;
    a();
  }
  
  public void a(@Nullable String paramString)
  {
    this.b[this.c] = true;
    this.g = paramString;
    a();
  }
  
  public void b(@Nullable String paramString)
  {
    this.b[this.c] = false;
    this.g = paramString;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.t.a.b
 * JD-Core Version:    0.7.0.1
 */