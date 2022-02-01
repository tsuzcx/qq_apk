package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.DisplayMetrics;
import androidx.annotation.RequiresApi;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.k.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaScreenAdaptiveContextThemeWrapper$WxaAdaptiveResources;", "Lcom/tencent/mm/ui/base/AdaptiveResources;", "resources", "Landroid/content/res/Resources;", "originalMetrics", "Landroid/util/DisplayMetrics;", "originalConfiguration", "Landroid/content/res/Configuration;", "factory", "Lcom/tencent/mm/ui/base/ScreenAdaptiveContextThemeWrapper$DisplayMetricsFactory;", "(Landroid/content/res/Resources;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;Lcom/tencent/mm/ui/base/ScreenAdaptiveContextThemeWrapper$DisplayMetricsFactory;)V", "getColor", "", "id", "theme", "Landroid/content/res/Resources$Theme;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class g$a
  extends a
{
  public g$a(@NotNull Resources paramResources, @NotNull DisplayMetrics paramDisplayMetrics, @NotNull Configuration paramConfiguration, @NotNull k.a parama)
  {
    super(paramResources, paramDisplayMetrics, paramConfiguration, parama);
  }
  
  public int getColor(int paramInt)
  {
    if (paramInt == 2131168376)
    {
      o.c("Luggage.WXA.WxaScreenAdaptiveContextThemeWrapper", "getColor: hack here! R.color.transparent -> Color.TRANSPARENT");
      return 0;
    }
    return super.getColor(paramInt);
  }
  
  @RequiresApi(api=23)
  public int getColor(int paramInt, @Nullable Resources.Theme paramTheme)
  {
    if (paramInt == 2131168376)
    {
      o.c("Luggage.WXA.WxaScreenAdaptiveContextThemeWrapper", "getColor: hack here! R.color.transparent -> Color.TRANSPARENT");
      return 0;
    }
    return super.getColor(paramInt, paramTheme);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.g.a
 * JD-Core Version:    0.7.0.1
 */