package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.DimenRes;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.mm.plugin.appbrand.page.be;
import com.tencent.mm.plugin.appbrand.page.bf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dimenPX", "", "resId", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "getExpectedSize", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Size;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public class l
  implements h
{
  private final d a;
  
  public l(@NotNull d paramd)
  {
    this.a = paramd;
  }
  
  public final int a(@DimenRes int paramInt)
  {
    return c().getResources().getDimensionPixelSize(paramInt);
  }
  
  @NotNull
  public h.a a()
  {
    return new h.a(0, (a(2131296297) - a(2131296766)) / 2, a(2131296751), 0);
  }
  
  @NotNull
  public h.b b()
  {
    Resources localResources = c().getResources();
    Intrinsics.checkExpressionValueIsNotNull(localResources, "context.resources");
    return new h.b(MathKt.roundToInt(localResources.getDisplayMetrics().density * 96), a(2131296766));
  }
  
  @NotNull
  public Context c()
  {
    Object localObject1 = this.a.ah();
    if (localObject1 != null)
    {
      localObject1 = (Context)localObject1;
    }
    else
    {
      localObject1 = this.a.ag();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "rt.appContext");
    }
    bf localbf = this.a.a(be.a);
    Object localObject2 = localObject1;
    if (localbf != null)
    {
      localObject2 = new View((Context)localObject1);
      localbf.a((Context)localObject1, localObject2.getClass());
      localObject2 = ((View)localObject2).getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "workaround.context");
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.l
 * JD-Core Version:    0.7.0.1
 */