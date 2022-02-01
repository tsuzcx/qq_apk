package com.tencent.luggage.wxa.ka;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AntiReentrantAuthListenerImpl;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "listener", "(Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;)V", "mCalled", "", "onAuthResult", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  implements e
{
  private boolean a;
  private final e b;
  
  public a(@Nullable e parame)
  {
    this.b = parame;
  }
  
  public void a()
  {
    if (this.a) {
      return;
    }
    e locale = this.b;
    if (locale != null) {
      locale.a();
    }
    this.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.a
 * JD-Core Version:    0.7.0.1
 */