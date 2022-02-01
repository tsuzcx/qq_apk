package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class ae$f
  extends Lambda
  implements Function0<Unit>
{
  ae$f(int paramInt, WeakReference paramWeakReference, String paramString)
  {
    super(0);
  }
  
  public final void a()
  {
    ae.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Loader(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(").onNoUpdate");
    o.d("Luggage.FULL.JsApiBatchGetContact", localStringBuilder.toString());
    ae.b.a.a((b)this.b.get(), null, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ae.f
 * JD-Core Version:    0.7.0.1
 */