package com.tencent.luggage.wxa.eb;

import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessageDispatcher;", "", "()V", "TAG", "", "runtimeList", "Ljava/util/ArrayList;", "Lcom/tencent/luggage/sdk/runtime/AppBrandRuntimeLU;", "Lkotlin/collections/ArrayList;", "dispatch", "", "message", "Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "register", "rt", "unregister", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b a = new b();
  private static final ArrayList<d> b = new ArrayList();
  
  public final void a(@NotNull a<? super d> parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "message");
    Iterator localIterator = ((Iterable)b).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (Intrinsics.areEqual(((d)localObject).aa(), parama.a())) {
        break label56;
      }
    }
    Object localObject = null;
    label56:
    localObject = (d)localObject;
    if (localObject != null)
    {
      parama.a((d)localObject);
      return;
    }
    o.c("Luggage.LuggageClientProcessMessageDispatcher", "dispatch: dispatch message[%s]appId[%s] fail", new Object[] { parama.getClass().getSimpleName(), parama.a() });
  }
  
  public final void a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    b.add(paramd);
  }
  
  public final void b(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    b.remove(paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eb.b
 * JD-Core Version:    0.7.0.1
 */