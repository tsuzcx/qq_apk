package com.tencent.luggage.wxa.standalone_open_runtime.container;

import com.tencent.luggage.wxa.da.e;
import com.tencent.luggage.wxa.da.f;
import com.tencent.luggage.wxa.ea.c;
import com.tencent.luggage.wxa.ea.c.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/container/WxaContainerTaskList;", "", "()V", "TAG", "", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getWxaStaticProcesses", "Ljava/util/ArrayList;", "Lcom/tencent/luggage/launch/task/WxaMiniProgramProcess;", "Lkotlin/collections/ArrayList;", "init", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  private static final AtomicBoolean b = new AtomicBoolean(false);
  
  @NotNull
  public final ArrayList<e> a()
  {
    return CollectionsKt.arrayListOf(new e[] { new e(WxaContainerActivity0.class, WxaContainerActivity0.class), new e(WxaContainerActivity1.class, WxaContainerActivity1.class), new e(WxaContainerActivity2.class, WxaContainerActivity2.class), new e(WxaContainerActivity3.class, WxaContainerActivity3.class), new e(WxaContainerActivity4.class, WxaContainerActivity4.class) });
  }
  
  public final void b()
  {
    if (b.getAndSet(true)) {
      return;
    }
    o.d("Luggage.WXA.WxaContainerTaskList", "init task manager at [%s]", new Object[] { r.c() });
    c.a locala = c.c;
    Object[] arrayOfObject = ((Collection)a()).toArray(new e[0]);
    if (arrayOfObject != null)
    {
      locala.b((c)new f((e[])arrayOfObject));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.container.a
 * JD-Core Version:    0.7.0.1
 */