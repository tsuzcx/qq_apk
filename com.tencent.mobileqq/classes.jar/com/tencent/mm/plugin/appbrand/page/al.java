package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.luggage.wxa.ba.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/IAppBrandPreloadedWidgetProvider;", "Lcom/tencent/luggage/base/ICustomize;", "getPreloadedWidget", "WIDGET", "Landroid/view/View;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/view/View;", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public abstract interface al
  extends b
{
  @Nullable
  public abstract <WIDGET extends View> WIDGET a(@NotNull Class<WIDGET> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.al
 * JD-Core Version:    0.7.0.1
 */