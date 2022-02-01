package com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.luggage.wxa.nv.b;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.plugin.appbrand.appcache.v;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/menu/devtools/SecondaryMenuDelegate_ShowDebugInfo;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseSecondaryMenuDelegate;", "Lcom/tencent/luggage/sdk/jsapi/component/AppBrandPageViewLU;", "()V", "getTitle", "", "context", "Landroid/content/Context;", "pageView", "appId", "performItemClick", "", "shouldShow", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  implements b<com.tencent.luggage.wxa.dq.c>
{
  public boolean a(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.dq.c paramc, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    return true;
  }
  
  @NotNull
  public String b(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.dq.c paramc, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    return "显示调试信息";
  }
  
  public void c(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.dq.c paramc, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "pageView");
    Object localObject2 = paramc.A();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "pageView.libReader!!");
    paramString = paramc.f();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "pageView.runtime");
    Object localObject1 = paramString.i().S;
    LinkedList localLinkedList = new LinkedList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n                [process] ");
    paramString = r.c();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "MMApplicationContext.getProcessName()");
    String str = r.b();
    Intrinsics.checkExpressionValueIsNotNull(str, "MMApplicationContext.getPackageName()");
    localStringBuilder.append(StringsKt.replaceFirst$default(paramString, str, "", false, 4, null));
    localStringBuilder.append("\n                [lib.src] ");
    if ((localObject2 instanceof com.tencent.mm.plugin.appbrand.appcache.c)) {
      paramString = "asset";
    } else {
      paramString = "network";
    }
    localStringBuilder.append(paramString);
    localStringBuilder.append("\n                [lib.ver_cli] ");
    localStringBuilder.append(((n)localObject2).c());
    localStringBuilder.append("\n                [lib.ver_sdk] ");
    localStringBuilder.append(((n)localObject2).b());
    localStringBuilder.append("\n            ");
    localLinkedList.add(StringsKt.trimIndent(localStringBuilder.toString()));
    paramString = paramc.f();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "pageView.runtime");
    if (!paramString.t())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("\n                    [app.page.url] ");
      ((StringBuilder)localObject2).append(paramc.an());
      ((StringBuilder)localObject2).append("\n                    [app.lazy_code_loading] ");
      ((StringBuilder)localObject2).append(((s)paramc.b(s.class)).a());
      ((StringBuilder)localObject2).append("\n                    [app.separated_plugins] ");
      paramString = ((af)localObject1).f;
      boolean bool;
      if ((paramString != null) && (!paramString.a())) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append("\n                    [app.pkg_enc_version] ");
      localObject1 = ad.b((com.tencent.luggage.wxa.iu.d)paramc.f());
      paramString = (String)localObject1;
      if (!(localObject1 instanceof h)) {
        paramString = null;
      }
      paramString = (h)paramString;
      if (paramString != null)
      {
        paramString = paramString.a(paramc.an());
        if (paramString != null)
        {
          i = paramString.d();
          break label396;
        }
      }
      i = -1;
      label396:
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("\n                ");
      localLinkedList.add(StringsKt.trimIndent(((StringBuilder)localObject2).toString()));
    }
    paramString = new TextView(paramContext);
    paramString.setText((CharSequence)CollectionsKt.joinToString$default((Iterable)localLinkedList, (CharSequence)"\n", null, null, 0, null, null, 62, null));
    paramString.setGravity(19);
    paramString.setTextSize(1, 10.0F);
    paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramString.setTextColor(paramContext.getResources().getColor(2131166595));
    paramString.setTypeface(Typeface.MONOSPACE);
    int i = paramContext.getResources().getDimensionPixelSize(2131296368);
    paramString.setPadding(i, i, i, i);
    paramString.setMovementMethod(ScrollingMovementMethod.getInstance());
    new MMAlertDialog.Builder(paramc.getContext()).setView((View)paramString).setCancelable(false).setPositiveBtnText(2131886911).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools.a
 * JD-Core Version:    0.7.0.1
 */