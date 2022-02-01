package com.tencent.luggage.wxa.lc;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ih.d;
import com.tencent.mm.msgsubscription.ui.a.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "invoke"}, k=3, mv={1, 1, 16})
final class b$e
  extends Lambda
  implements Function1<d, Boolean>
{
  b$e(List paramList)
  {
    super(1);
  }
  
  public final boolean a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "item");
    Iterator localIterator = ((Iterable)this.a).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      a.b localb = (a.b)localObject;
      if (TextUtils.equals((CharSequence)paramd.c(), (CharSequence)localb.d()))
      {
        paramd = localObject;
        break label69;
      }
    }
    paramd = null;
    label69:
    paramd = (a.b)paramd;
    if (paramd != null) {
      return paramd.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lc.b.e
 * JD-Core Version:    0.7.0.1
 */