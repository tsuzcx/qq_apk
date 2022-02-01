package com.tencent.magicbrush.ui;

import androidx.annotation.Keep;
import com.tencent.luggage.wxa.gk.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/MBViewManager;", "", "()V", "idGenerator", "", "listeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/ui/MBViewManager$Listener;", "viewContainer", "Ljava/util/HashMap;", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "Lkotlin/collections/HashMap;", "add", "", "view", "add$lib_magicbrush_nano_release", "addListener", "l", "addSurfaceListenerForAllViews", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "clear", "clear$lib_magicbrush_nano_release", "find", "virtualElementId", "findOrNull", "forEach", "fn", "Lkotlin/Function1;", "remove", "remove$lib_magicbrush_nano_release", "removeListener", "toString", "", "Listener", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
@Keep
public final class MBViewManager
{
  private int idGenerator;
  private final c<MBViewManager.a> listeners = new c();
  private final HashMap<Integer, i> viewContainer = new HashMap();
  
  public final void add$lib_magicbrush_nano_release(@NotNull i parami)
  {
    Intrinsics.checkParameterIsNotNull(parami, "view");
    Ref.IntRef localIntRef = new Ref.IntRef();
    try
    {
      int i = this.idGenerator;
      this.idGenerator = (i + 1);
      localIntRef.element = i;
      ((Map)this.viewContainer).put(Integer.valueOf(localIntRef.element), parami);
      Unit localUnit = Unit.INSTANCE;
      parami.setVirtualElementId$lib_magicbrush_nano_release(localIntRef.element);
      this.listeners.a((Function1)new MBViewManager.b(parami));
      return;
    }
    finally {}
  }
  
  public final void addListener(@NotNull MBViewManager.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "l");
    this.listeners.a(parama);
  }
  
  public final void addSurfaceListenerForAllViews(@NotNull i.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "l");
    this.listeners.a(new MBViewManager.c(paramc));
  }
  
  public final void clear$lib_magicbrush_nano_release()
  {
    try
    {
      this.viewContainer.clear();
      this.listeners.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  @NotNull
  public final i find(int paramInt)
  {
    try
    {
      Object localObject1 = this.viewContainer.get(Integer.valueOf(paramInt));
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = (i)localObject1;
      return localObject1;
    }
    finally {}
  }
  
  @Nullable
  public final i findOrNull(int paramInt)
  {
    try
    {
      i locali = (i)this.viewContainer.get(Integer.valueOf(paramInt));
      return locali;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void forEach(@NotNull Function1<? super i, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "fn");
    Object localObject1 = (List)new ArrayList();
    try
    {
      Object localObject2 = this.viewContainer.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        i locali = (i)((Iterator)localObject2).next();
        Intrinsics.checkExpressionValueIsNotNull(locali, "v");
        ((List)localObject1).add(locali);
      }
      localObject2 = Unit.INSTANCE;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramFunction1.invoke(((Iterator)localObject1).next());
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramFunction1;
    }
  }
  
  public final void remove$lib_magicbrush_nano_release(@NotNull i parami)
  {
    Intrinsics.checkParameterIsNotNull(parami, "view");
    try
    {
      int i = parami.getVirtualElementId();
      if (this.viewContainer.containsKey(Integer.valueOf(i)))
      {
        i locali = (i)this.viewContainer.remove(Integer.valueOf(i));
        this.listeners.a((Function1)new MBViewManager.d(parami));
        return;
      }
      parami = new Object[2];
      parami[0] = toString();
      parami[1] = Integer.valueOf(i);
      parami = String.format("VirtualElementId error. current [%s] request [%d]", Arrays.copyOf(parami, parami.length));
      Intrinsics.checkExpressionValueIsNotNull(parami, "java.lang.String.format(this, *args)");
      throw ((Throwable)new IllegalStateException(parami.toString()));
    }
    finally {}
  }
  
  public final void removeListener(@NotNull MBViewManager.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "l");
    this.listeners.b(parama);
  }
  
  @NotNull
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ViewManager(");
    ((StringBuilder)localObject1).append(hashCode());
    ((StringBuilder)localObject1).append(")");
    try
    {
      Set localSet = this.viewContainer.keySet();
      Intrinsics.checkExpressionValueIsNotNull(localSet, "viewContainer.keys");
      ((StringBuilder)localObject1).append(CollectionsKt.toIntArray((Collection)localSet));
      localObject1 = ((StringBuilder)localObject1).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "result.toString()");
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.MBViewManager
 * JD-Core Version:    0.7.0.1
 */