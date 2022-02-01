package com.tencent.luggage.wxa.fw;

import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.ny.e.a;
import com.tencent.luggage.wxa.ny.e.b;
import com.tencent.mm.plugin.appbrand.appcache.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "resultPkgList", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class a$b
  extends Lambda
  implements Function1<List<? extends e>, Unit>
{
  a$b(a parama)
  {
    super(1);
  }
  
  public final void a(@NotNull List<? extends e> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "resultPkgList");
    e.a locala = a.a(this.a);
    Object localObject = locala;
    if (!(locala instanceof e.b)) {
      localObject = null;
    }
    localObject = (e.b)localObject;
    if (localObject != null) {
      ((e.b)localObject).a((Function)new a.b.1(this, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fw.a.b
 * JD-Core Version:    0.7.0.1
 */