package com.tencent.luggage.wxa.fn;

import android.content.Context;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.fp.i;
import com.tencent.luggage.wxa.fp.i.a;
import com.tencent.luggage.wxa.ou.m;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.ui.base.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/wxacollection/MenuDelegateAddCollection;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseMenuDelegate;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "()V", "mIsCollectionAdded", "", "attachTo", "", "context", "Landroid/content/Context;", "pageView", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "appId", "", "performItemClick", "menuInfo", "Lcom/tencent/mm/plugin/appbrand/menu/MenuInfo;", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  extends com.tencent.luggage.wxa.nv.a<com.tencent.luggage.wxa.standalone_open_runtime.e>
{
  @Deprecated
  public static final a.a a = new a.a(null);
  private boolean b;
  
  static
  {
    com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.iy.a.class, (com.tencent.luggage.wxa.ba.b)i.a.a());
  }
  
  public a()
  {
    super(com.tencent.luggage.wxa.nu.b.m.ordinal());
  }
  
  @ExperimentalTime
  public void a(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.standalone_open_runtime.e parame, @NotNull g paramg, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(parame, "pageView");
    Intrinsics.checkParameterIsNotNull(paramg, "menu");
    Intrinsics.checkParameterIsNotNull(paramString, "appId");
    paramString = parame.f();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "pageView.runtime");
    paramString = paramString.j().b;
    parame = parame.f();
    Intrinsics.checkExpressionValueIsNotNull(parame, "pageView.runtime");
    int i = parame.ab();
    try
    {
      boolean bool = ((com.tencent.luggage.wxa.iy.a)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.iy.a.class)).a(paramString, i);
      if (bool) {
        paramContext = paramContext.getString(2131886903);
      } else {
        paramContext = paramContext.getString(2131886899);
      }
      if (bool) {
        i = 2130853712;
      } else {
        i = 2130853711;
      }
      this.b = bool;
      paramg.add(a(), (CharSequence)paramContext, i, 0, false);
      return;
    }
    catch (Throwable paramContext)
    {
      parame = new StringBuilder();
      parame.append("attachTo check isCollection(");
      parame.append(paramString);
      parame.append(',');
      parame.append(i);
      parame.append(") tr=");
      parame.append(paramContext);
      o.d("Luggage.MenuDelegateAddCollection", parame.toString());
    }
  }
  
  public void a(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.standalone_open_runtime.e parame, @Nullable String paramString, @Nullable com.tencent.luggage.wxa.nu.a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(parame, "pageView");
    paramString = parame.f();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "pageView.runtime");
    paramString = paramString.j().b;
    parama = parame.f();
    Intrinsics.checkExpressionValueIsNotNull(parama, "pageView.runtime");
    int i = parama.ab();
    boolean bool = com.tencent.luggage.wxa.pb.a.a(this.b, paramContext, paramString, i);
    if (this.b) {
      i = 25;
    } else {
      i = 24;
    }
    int k = 2;
    int j;
    if (bool) {
      j = 1;
    } else {
      j = 2;
    }
    m.a(m.a, (com.tencent.luggage.wxa.em.c)parame, i, null, 0L, j, 0, 44, null);
    if (bool)
    {
      this.b ^= true;
      paramContext = parame.f();
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "pageView.runtime");
      paramContext = paramContext.l();
      i = k;
      if (this.b) {
        i = 1;
      }
      paramContext.e = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fn.a
 * JD-Core Version:    0.7.0.1
 */