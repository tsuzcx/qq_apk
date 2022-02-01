package com.tencent.luggage.wxa.gk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/utils/ListenerList;", "T", "", "()V", "listeners", "", "add", "", "l", "(Ljava/lang/Object;)V", "clear", "dispatch", "", "R", "block", "Lkotlin/Function1;", "dispatchNoThrow", "default", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "remove", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class c<T>
{
  private final List<T> a = (List)new ArrayList();
  
  @NotNull
  public final <R> List<R> a(@NotNull Function1<? super T, ? extends R> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    Object localObject1 = (List)new ArrayList();
    synchronized (this.a)
    {
      Object localObject2 = ((Iterable)this.a).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add(((Iterator)localObject2).next());
      }
      localObject2 = Unit.INSTANCE;
      ??? = (List)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ???.add(paramFunction1.invoke(((Iterator)localObject1).next()));
      }
      return ???;
    }
    for (;;)
    {
      throw paramFunction1;
    }
  }
  
  public final void a()
  {
    synchronized (this.a)
    {
      this.a.clear();
      Unit localUnit = Unit.INSTANCE;
      return;
    }
  }
  
  public final void a(T paramT)
  {
    synchronized (this.a)
    {
      this.a.add(paramT);
      return;
    }
  }
  
  public final void b(T paramT)
  {
    synchronized (this.a)
    {
      this.a.remove(paramT);
      return;
    }
  }
  
  public final void b(@NotNull Function1<? super T, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "block");
    a((Function1)new c.a(paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gk.c
 * JD-Core Version:    0.7.0.1
 */