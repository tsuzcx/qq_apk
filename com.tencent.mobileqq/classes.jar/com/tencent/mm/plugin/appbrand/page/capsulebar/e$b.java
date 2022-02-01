package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.page.u;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContextMapImpl;", "", "(Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;)V", "sparseArray", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager$PageContext;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarManager;", "get", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "getOrCreate", "remove", "set", "", "context", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
final class e$b
{
  private final SparseArray<e.a> b = new SparseArray();
  
  @Nullable
  public final e.a a(@NotNull u paramu)
  {
    Intrinsics.checkParameterIsNotNull(paramu, "page");
    return (e.a)this.b.get(paramu.hashCode(), null);
  }
  
  public final void a(@NotNull u paramu, @NotNull e.a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramu, "page");
    Intrinsics.checkParameterIsNotNull(parama, "context");
    this.b.put(paramu.hashCode(), parama);
  }
  
  @NotNull
  public final e.a b(@NotNull u paramu)
  {
    Intrinsics.checkParameterIsNotNull(paramu, "page");
    e.a locala = (e.a)this.b.get(paramu.hashCode(), null);
    if (locala != null) {
      return locala;
    }
    locala = new e.a(this.a, paramu);
    a(paramu, locala);
    return locala;
  }
  
  @Nullable
  public final e.a c(@NotNull u paramu)
  {
    Intrinsics.checkParameterIsNotNull(paramu, "page");
    int i = this.b.indexOfKey(paramu.hashCode());
    if (i >= 0)
    {
      paramu = (e.a)this.b.valueAt(i);
      this.b.removeAt(i);
      return paramu;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.e.b
 * JD-Core Version:    0.7.0.1
 */