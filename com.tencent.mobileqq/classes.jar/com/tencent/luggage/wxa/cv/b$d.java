package com.tencent.luggage.wxa.cv;

import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class b$d<T>
  implements e.a<Object>
{
  b$d(m paramm, String paramString, Function0 paramFunction0) {}
  
  public final void a(Object paramObject)
  {
    b.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doJSAuthVerify get exception:");
    if (paramObject != null) {
      paramObject = paramObject.toString();
    } else {
      paramObject = null;
    }
    localStringBuilder.append(paramObject);
    localStringBuilder.append(" with api:");
    localStringBuilder.append(this.a.d());
    localStringBuilder.append(", url:");
    localStringBuilder.append(this.b);
    o.b("Luggage.STANDALONE.HTMLWebViewJsApiPermissionController", localStringBuilder.toString());
    this.c.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.b.d
 * JD-Core Version:    0.7.0.1
 */