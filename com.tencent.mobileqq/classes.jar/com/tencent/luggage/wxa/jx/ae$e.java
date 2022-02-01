package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jj.s;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"}, k=3, mv={1, 1, 16})
final class ae$e
  extends Lambda
  implements Function1<List<? extends s>, Unit>
{
  ae$e(int paramInt, ae.h paramh, WeakReference paramWeakReference, String paramString)
  {
    super(1);
  }
  
  public final void a(@NotNull List<s> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "list");
    ae.c();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Loader(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(").onUpdated, list.size:");
    localStringBuilder.append(paramList.size());
    o.d("Luggage.FULL.JsApiBatchGetContact", localStringBuilder.toString());
    if (!this.b.a(paramList).booleanValue()) {
      ae.b.a.a((b)this.c.get(), paramList, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ae.e
 * JD-Core Version:    0.7.0.1
 */