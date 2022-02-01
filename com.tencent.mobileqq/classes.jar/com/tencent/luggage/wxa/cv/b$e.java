package com.tencent.luggage.wxa.cv;

import com.tencent.luggage.wxa.qw.dy;
import com.tencent.luggage.wxa.qw.ed;
import com.tencent.luggage.wxa.qw.jf;
import com.tencent.luggage.wxa.ro.e.c;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JSAPIPreVerifyResponse;", "onTerminate"}, k=3, mv={1, 1, 16})
final class b$e<T>
  implements e.c<ed>
{
  b$e(b paramb, Function0 paramFunction0, Function1 paramFunction1) {}
  
  public final void a(@Nullable ed paramed)
  {
    if (paramed != null)
    {
      localObject = paramed.a;
      if ((localObject != null) && (((dy)localObject).a == 0) && (paramed.b != null))
      {
        paramed = paramed.b;
        Intrinsics.checkExpressionValueIsNotNull(paramed, "it.verify_info_list");
        paramed = ((Iterable)paramed).iterator();
        while (paramed.hasNext())
        {
          localObject = (jf)paramed.next();
          Map localMap = (Map)b.a(this.a);
          String str = ((jf)localObject).a;
          Intrinsics.checkExpressionValueIsNotNull(str, "info.jsapi_name");
          localMap.put(str, Integer.valueOf(((jf)localObject).b));
        }
        this.b.invoke();
        return;
      }
    }
    Object localObject = this.c;
    if (paramed != null)
    {
      paramed = paramed.a;
      if (paramed != null)
      {
        paramed = paramed.b;
        break label149;
      }
    }
    paramed = null;
    label149:
    ((Function1)localObject).invoke(paramed);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.b.e
 * JD-Core Version:    0.7.0.1
 */