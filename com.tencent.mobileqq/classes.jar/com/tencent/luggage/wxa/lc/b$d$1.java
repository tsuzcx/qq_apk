package com.tencent.luggage.wxa.lc;

import com.tencent.luggage.wxa.ih.c;
import com.tencent.mm.msgsubscription.ui.a;
import com.tencent.mm.msgsubscription.ui.a.b;
import com.tencent.mm.msgsubscription.ui.a.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$dealWithCgiResult$1$1", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "onEvent", "", "event", "", "resultData", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$d$1
  implements a.d
{
  b$d$1(Function3 paramFunction3) {}
  
  public void a(int paramInt, @NotNull List<a.b> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "resultData");
    List localList1 = (List)new ArrayList();
    localList1.addAll((Collection)paramList);
    if ((paramInt == 1) || (paramInt == 2) || (paramInt == 3)) {
      this.c.invoke(Integer.valueOf(paramInt), localList1, Boolean.valueOf(this.b.a.c().a()));
    }
    paramList = CollectionsKt.toList((Iterable)this.b.e.keySet());
    localList1 = (List)new ArrayList();
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((Number)((Iterator)localObject1).next()).intValue();
      localObject2 = (Integer)this.b.e.get(Integer.valueOf(i));
      if (localObject2 != null) {
        localList1.add(Integer.valueOf(((Number)localObject2).intValue()));
      }
    }
    localObject1 = this.b.a;
    Object localObject2 = this.b.a;
    List localList2 = (List)new ArrayList();
    localList2.addAll((Collection)this.b.b.c());
    localObject2 = b.a((b)localObject2, localList2, this.b.d);
    boolean bool = this.b.a.c().a();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          paramInt = 0;
        } else {
          paramInt = 3;
        }
      }
      else {
        paramInt = 2;
      }
    }
    else {
      paramInt = 1;
    }
    b.a((b)localObject1, (List)localObject2, bool, paramInt, CollectionsKt.joinToString$default((Iterable)paramList, (CharSequence)"#", null, null, 0, null, null, 62, null), CollectionsKt.joinToString$default((Iterable)localList1, (CharSequence)"#", null, null, 0, null, null, 62, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lc.b.d.1
 * JD-Core Version:    0.7.0.1
 */