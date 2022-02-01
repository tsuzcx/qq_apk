package com.tencent.luggage.wxa.ct;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.t;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

class a$1
  implements Function2<String, String, Unit>
{
  a$1(a parama) {}
  
  public Unit a(String paramString1, String paramString2)
  {
    junit.framework.a.a(t.a());
    if (!TextUtils.isEmpty(paramString2))
    {
      if (a.a(this.a)) {
        return Unit.INSTANCE;
      }
      a.b(this.a).stopLoading();
      this.a.a(paramString2);
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.a.1
 * JD-Core Version:    0.7.0.1
 */