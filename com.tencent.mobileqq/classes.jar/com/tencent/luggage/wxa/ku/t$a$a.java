package com.tencent.luggage.wxa.ku;

import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.pd.l.a;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/file/JsApiLoadJsFiles$Companion$loadJsFiles$1", "Lcom/tencent/mm/plugin/appbrand/utils/JsValidationInjector$JsValidationInjectionCallback;", "onFailure", "", "ret", "", "onSuccess", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class t$a$a
  implements l.a
{
  t$a$a(boolean[] paramArrayOfBoolean, int paramInt, ValueCallback paramValueCallback) {}
  
  public void a(@Nullable String paramString)
  {
    this.a[this.b] = true;
    ValueCallback localValueCallback = this.c;
    if (localValueCallback != null) {
      localValueCallback.onReceiveValue(paramString);
    }
  }
  
  public void b(@Nullable String paramString)
  {
    this.a[this.b] = false;
    ValueCallback localValueCallback = this.c;
    if (localValueCallback != null) {
      localValueCallback.onReceiveValue(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.t.a.a
 * JD-Core Version:    0.7.0.1
 */