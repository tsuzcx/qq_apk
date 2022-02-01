package com.tencent.luggage.wxa.standalone_open_runtime;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.luggage.wxa.fm.c.a;
import com.tencent.luggage.wxa.fp.i;
import com.tencent.luggage.wxa.fp.i.a;
import com.tencent.luggage.wxa.fq.f;
import com.tencent.luggage.wxa.jx.c.b;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.ou.m;
import com.tencent.mm.plugin.appbrand.page.bm;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a.b;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.ui.base.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.contracts.ExperimentalContracts;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.Reflect;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "Lcom/tencent/luggage/standalone_ext/PageView;", "rendererClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewRenderer;", "(Ljava/lang/Class;)V", "attachCommonConfig", "", "config", "Lorg/json/JSONObject;", "createMenuInfoList", "", "Lcom/tencent/mm/plugin/appbrand/menu/MenuInfo;", "init", "context", "Landroid/content/Context;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "isGame", "", "onCreateActionSheetHeader", "Landroid/view/View;", "onShowPageActionSheet", "menuInfoList", "", "reportMenuStatus", "Companion", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public class e
  extends com.tencent.luggage.wxa.em.c
{
  public static final e.c c = new e.c(null);
  
  public e(@NotNull Class<? extends w> paramClass)
  {
    super(paramClass);
    if (f.a.d()) {
      bm.setWebContentsDebuggingEnabled(true);
    }
  }
  
  private final void aQ()
  {
    Object localObject1 = d(com.tencent.luggage.wxa.nu.b.d.ordinal());
    Object localObject2;
    Context localContext;
    String str;
    if ((localObject1 != null) && ((localObject1 instanceof com.tencent.luggage.wxa.fm.c)))
    {
      localObject1 = (com.tencent.luggage.wxa.fm.c)localObject1;
      localObject2 = ((com.tencent.luggage.wxa.fm.c)localObject1).a();
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      str = getAppId();
      Intrinsics.checkExpressionValueIsNotNull(str, "appId");
      if (((Boolean)((Function3)localObject2).invoke(localContext, this, str)).booleanValue())
      {
        localObject1 = ((com.tencent.luggage.wxa.fm.c)localObject1).b();
        localObject2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
        if (!((Boolean)((Function2)localObject1).invoke(localObject2, this)).booleanValue())
        {
          k = 1;
          break label135;
        }
      }
    }
    int k = 0;
    label135:
    localObject1 = d(com.tencent.luggage.wxa.nu.b.e.ordinal());
    if ((localObject1 != null) && ((localObject1 instanceof com.tencent.luggage.wxa.fm.c)))
    {
      localObject1 = (com.tencent.luggage.wxa.fm.c)localObject1;
      localObject2 = ((com.tencent.luggage.wxa.fm.c)localObject1).a();
      localContext = getContext();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
      str = getAppId();
      Intrinsics.checkExpressionValueIsNotNull(str, "appId");
      if (((Boolean)((Function3)localObject2).invoke(localContext, this, str)).booleanValue())
      {
        localObject1 = ((com.tencent.luggage.wxa.fm.c)localObject1).b();
        localObject2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
        if (!((Boolean)((Function2)localObject1).invoke(localObject2, this)).booleanValue())
        {
          m = 1;
          break label272;
        }
      }
    }
    int m = 0;
    label272:
    localObject1 = a.a.a((com.tencent.luggage.wxa.iu.d)f());
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "blinkHelper");
    int i;
    if (((com.tencent.mm.plugin.appbrand.page.capsulebar.a)localObject1).a() == a.b.b.ordinal()) {
      i = 1;
    } else if (((com.tencent.mm.plugin.appbrand.page.capsulebar.a)localObject1).a() == a.b.c.ordinal()) {
      i = 2;
    } else {
      i = 0;
    }
    localObject1 = d(com.tencent.luggage.wxa.nu.b.F.ordinal());
    if (localObject1 != null)
    {
      if ((localObject1 instanceof com.tencent.luggage.wxa.fm.c))
      {
        localObject1 = (com.tencent.luggage.wxa.fm.c)localObject1;
        localObject2 = ((com.tencent.luggage.wxa.fm.c)localObject1).a();
        localContext = getContext();
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        str = getAppId();
        Intrinsics.checkExpressionValueIsNotNull(str, "appId");
        if (((Boolean)((Function3)localObject2).invoke(localContext, this, str)).booleanValue())
        {
          localObject1 = ((com.tencent.luggage.wxa.fm.c)localObject1).b();
          localObject2 = getContext();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
          if (((Boolean)((Function2)localObject1).invoke(localObject2, this)).booleanValue()) {
            break label476;
          }
          j = 1;
          break label478;
        }
      }
      j = 2;
      break label478;
    }
    label476:
    int j = 0;
    label478:
    localObject1 = StringCompanionObject.INSTANCE;
    localObject1 = new Object[6];
    localObject1[0] = Integer.valueOf(k);
    localObject1[1] = Integer.valueOf(-1);
    localObject1[2] = Integer.valueOf(i);
    localObject1[3] = Integer.valueOf(m);
    localObject1[4] = Integer.valueOf(-1);
    localObject1[5] = Integer.valueOf(j);
    localObject1 = String.format("%d_%d_%d_%d_%d_%d", Arrays.copyOf((Object[])localObject1, localObject1.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
    m.a(m.a, (com.tencent.luggage.wxa.em.c)this, 28, (String)localObject1, 0L, 0, 0, 56, null);
  }
  
  public void a(@Nullable Context paramContext, @Nullable com.tencent.luggage.wxa.iu.d paramd)
  {
    super.a(paramContext, paramd);
    paramContext = f();
    if (paramContext != null)
    {
      a((c.b)new com.tencent.luggage.wxa.ff.c((com.tencent.luggage.wxa.fk.e)paramContext, (h)this));
      ah().setCloseButtonClickListener((View.OnClickListener)new e.p(this));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.wxa.standalone_open_runtime.runtime.WxaRuntime");
  }
  
  protected void a(@NotNull List<com.tencent.luggage.wxa.nu.a> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "menuInfoList");
    paramList = ae();
    Intrinsics.checkExpressionValueIsNotNull(paramList, "getMenuInfoList()");
    new com.tencent.luggage.wxa.fm.d(this, paramList).a();
    paramList = i.a.a();
    String str = getAppId();
    Intrinsics.checkExpressionValueIsNotNull(str, "appId");
    Object localObject = f();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "runtime");
    localObject = ((com.tencent.luggage.wxa.ed.d)localObject).j().b;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "runtime.initConfig.username");
    com.tencent.luggage.wxa.ed.d locald = f();
    Intrinsics.checkExpressionValueIsNotNull(locald, "runtime");
    paramList.a(str, (String)localObject, locald.ab());
    aQ();
  }
  
  public void a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "config");
    super.a(paramJSONObject);
    b.a.a(paramJSONObject);
  }
  
  @ExperimentalContracts
  @NotNull
  public List<com.tencent.luggage.wxa.nu.a> s()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = com.tencent.luggage.wxa.fm.c.a;
    Object localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject2 = l.d((Context)localObject2, 2131918167);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.getStringById(R.…ng.wxa_menu_share_appmsg)");
    localObject1 = c.a.a((c.a)localObject1, (String)localObject2, 2130853715, false, 0, com.tencent.luggage.wxa.nu.b.d.ordinal(), true, 4, null);
    ((com.tencent.luggage.wxa.fm.c)localObject1).b((Function3)new e.d((com.tencent.luggage.wxa.fm.c)localObject1, this));
    ((com.tencent.luggage.wxa.fm.c)localObject1).a((Function3)new e.e(this));
    localArrayList.add(localObject1);
    localObject1 = com.tencent.luggage.wxa.fm.c.a;
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject2 = l.d((Context)localObject2, 2131918164);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.getStringById(R.string.wxa_menu_moment)");
    localObject1 = c.a.a((c.a)localObject1, (String)localObject2, 2130853713, false, 0, com.tencent.luggage.wxa.nu.b.e.ordinal(), true, 4, null);
    ((com.tencent.luggage.wxa.fm.c)localObject1).b((Function3)new e.f(this));
    ((com.tencent.luggage.wxa.fm.c)localObject1).a((Function3)new e.g(this));
    localArrayList.add(localObject1);
    localArrayList.add(new com.tencent.luggage.wxa.nu.a((com.tencent.luggage.wxa.nv.a)new com.tencent.luggage.wxa.fn.a()));
    localObject1 = com.tencent.luggage.wxa.fm.c.a;
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject2 = l.d((Context)localObject2, 2131918166);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.getStringById(R.string.wxa_menu_setting)");
    localObject1 = c.a.a((c.a)localObject1, (String)localObject2, 2130853714, false, 0, 0, false, 56, null);
    ((com.tencent.luggage.wxa.fm.c)localObject1).b((Function3)new e.h(this));
    localArrayList.add(localObject1);
    localObject1 = com.tencent.luggage.wxa.fm.c.a;
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject2 = l.d((Context)localObject2, 2131918161);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.getStringById(R.string.wxa_menu_feedback)");
    localObject1 = c.a.a((c.a)localObject1, (String)localObject2, 2130853706, false, 0, 0, false, 56, null);
    ((com.tencent.luggage.wxa.fm.c)localObject1).b((Function3)new e.i(this));
    localArrayList.add(localObject1);
    localObject1 = com.tencent.luggage.wxa.fm.c.a;
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject2 = l.d((Context)localObject2, 2131890785);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.getStringById(R.…g.icons_outlined_refresh)");
    localObject1 = c.a.a((c.a)localObject1, (String)localObject2, 2130841199, false, 0, 0, false, 56, null);
    ((com.tencent.luggage.wxa.fm.c)localObject1).a((Function3)e.m.a);
    ((com.tencent.luggage.wxa.fm.c)localObject1).b((Function3)new e.j(this));
    localArrayList.add(localObject1);
    localObject1 = f();
    if (localObject1 != null) {
      localObject1 = ((com.tencent.luggage.wxa.ed.d)localObject1).i();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    int i = com.tencent.luggage.wxa.nw.a.c.a((com.tencent.luggage.wxa.do.d)localObject1);
    localObject2 = com.tencent.luggage.wxa.fm.c.a;
    Object localObject3 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "context");
    localObject3 = l.d((Context)localObject3, 2131891817);
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "context.getStringById(R.…am_actionsheet_copy_link)");
    localObject2 = c.a.a((c.a)localObject2, (String)localObject3, 2130838670, false, 0, com.tencent.luggage.wxa.nu.b.F.ordinal(), false, 40, null);
    ((com.tencent.luggage.wxa.fm.c)localObject2).b((Function3)e.n.a);
    ((com.tencent.luggage.wxa.fm.c)localObject2).a((Function2)new e.a((com.tencent.luggage.wxa.do.d)localObject1, i));
    ((com.tencent.luggage.wxa.fm.c)localObject2).a((Function3)new e.b((com.tencent.luggage.wxa.do.d)localObject1, i));
    localArrayList.add(localObject2);
    localObject1 = new com.tencent.luggage.wxa.fm.a();
    localArrayList.add(new com.tencent.luggage.wxa.nu.a(((com.tencent.luggage.wxa.fm.a)localObject1).a(), false, (com.tencent.luggage.wxa.nv.a)localObject1));
    localObject1 = com.tencent.luggage.wxa.fm.c.a;
    localObject2 = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context");
    localObject2 = l.d((Context)localObject2, 2131918160);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "context.getStringById(R.…ng.wxa_menu_enable_debug)");
    localObject1 = c.a.a((c.a)localObject1, (String)localObject2, 2130853705, false, 0, 0, false, 56, null);
    localObject2 = new com.tencent.luggage.wxa.nv.c();
    ((com.tencent.luggage.wxa.nv.c)localObject2).a((com.tencent.luggage.wxa.nv.b)new e.o());
    if (u()) {}
    try
    {
      ((com.tencent.luggage.wxa.nv.c)localObject2).a((com.tencent.luggage.wxa.nv.b)Reflect.on("com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools.SecondaryMenuDelegate_GameCpuProfiler").create().get());
    }
    catch (Exception localException)
    {
      label725:
      break label725;
    }
    if (f.a())
    {
      ((com.tencent.luggage.wxa.nv.c)localObject2).a((com.tencent.luggage.wxa.nv.b)new com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools.d());
      ((com.tencent.luggage.wxa.nv.c)localObject2).a((com.tencent.luggage.wxa.nv.b)new com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools.c());
      ((com.tencent.luggage.wxa.nv.c)localObject2).a((com.tencent.luggage.wxa.nv.b)new com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools.b());
      ((com.tencent.luggage.wxa.nv.c)localObject2).a((com.tencent.luggage.wxa.nv.b)new com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools.a());
    }
    ((com.tencent.luggage.wxa.fm.c)localObject1).a((Function3)new e.k(this));
    ((com.tencent.luggage.wxa.fm.c)localObject1).b((Function3)new e.l((com.tencent.luggage.wxa.nv.c)localObject2, this));
    localArrayList.add(localObject1);
    return (List)localArrayList;
  }
  
  @NotNull
  public View t()
  {
    Object localObject = getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
    localObject = new com.tencent.luggage.wxa.standalone_open_runtime.ui.c((Context)localObject);
    ((com.tencent.luggage.wxa.standalone_open_runtime.ui.c)localObject).setPage(this);
    return (View)localObject;
  }
  
  public final boolean u()
  {
    Object localObject = f();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "runtime");
    localObject = ((com.tencent.luggage.wxa.ed.d)localObject).j();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "runtime.initConfig");
    return ((com.tencent.luggage.wxa.do.c)localObject).g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e
 * JD-Core Version:    0.7.0.1
 */