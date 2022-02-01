package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "errMsg", "", "invoke"}, k=3, mv={1, 1, 16})
final class ae$g
  extends Lambda
  implements Function1<String, Unit>
{
  ae$g(ae paramae, int paramInt, WeakReference paramWeakReference)
  {
    super(1);
  }
  
  public final void a(@Nullable String paramString)
  {
    ae.c();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Loader(");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(").onError, errMsg:");
    ((StringBuilder)localObject1).append(paramString);
    o.b("Luggage.FULL.JsApiBatchGetContact", ((StringBuilder)localObject1).toString());
    localObject1 = (b)this.c.get();
    if (localObject1 != null)
    {
      int j = this.b;
      ae localae = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fail");
      Object localObject2 = (CharSequence)paramString;
      int i;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0)
      {
        paramString = "";
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(':');
        ((StringBuilder)localObject2).append(paramString);
        paramString = ((StringBuilder)localObject2).toString();
      }
      localStringBuilder.append(paramString);
      ((b)localObject1).a(j, localae.b(localStringBuilder.toString()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ae.g
 * JD-Core Version:    0.7.0.1
 */