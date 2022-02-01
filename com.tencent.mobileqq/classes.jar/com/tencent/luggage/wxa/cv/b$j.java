package com.tencent.luggage.wxa.cv;

import com.tencent.luggage.wxa.qw.dw;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onInterrupt"}, k=3, mv={1, 1, 16})
final class b$j<T>
  implements e.a<Object>
{
  b$j(dw paramdw) {}
  
  public final void a(Object paramObject)
  {
    b.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doSetJSAuth get exception:");
    if (paramObject != null) {
      paramObject = paramObject.toString();
    } else {
      paramObject = null;
    }
    localStringBuilder.append(paramObject);
    localStringBuilder.append(" with api:");
    localStringBuilder.append(this.a.c);
    localStringBuilder.append(", url:");
    localStringBuilder.append(this.a.a);
    o.b("Luggage.STANDALONE.HTMLWebViewJsApiPermissionController", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.b.j
 * JD-Core Version:    0.7.0.1
 */