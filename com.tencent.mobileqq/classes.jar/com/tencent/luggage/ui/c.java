package com.tencent.luggage.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.luggage.wxa.rc.a;
import com.tencent.mm.plugin.appbrand.page.bf.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUILoadingSplash;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WxaRuntimeDecorWidgetFactory;", "Lcom/tencent/mm/plugin/appbrand/page/PageDecorWidgetFactory$DefaultFactory;", "()V", "widgetClassesForPersistentContext", "", "Ljava/lang/Class;", "Landroid/view/View;", "[Ljava/lang/Class;", "onCreateWidget", "WIDGET", "context", "Landroid/content/Context;", "clazz", "(Landroid/content/Context;Ljava/lang/Class;)Landroid/view/View;", "obtainPersistentContextWrapper", "Lcom/tencent/luggage/ui/WxaRuntimePersistentContextWrapper;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c
  extends bf.a
{
  private final Class<? extends View>[] a = { com.tencent.mm.plugin.appbrand.page.capsulebar.c.class, com.tencent.mm.plugin.appbrand.widget.actionbar.d.class, AppBrandUILoadingSplash.class };
  
  private final d a(@NotNull Context paramContext)
  {
    if ((paramContext instanceof d)) {
      return (d)paramContext;
    }
    Activity localActivity = a.a(paramContext);
    if (localActivity != null) {
      paramContext = (Context)localActivity;
    }
    paramContext = d.a(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "WxaRuntimePersistentCont…vityOrNull(this) ?: this)");
    return paramContext;
  }
  
  public <WIDGET extends View> WIDGET a(@NotNull Context paramContext, @NotNull Class<WIDGET> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    if (ArraysKt.contains(this.a, paramClass)) {
      return super.a((Context)a(paramContext), paramClass);
    }
    return super.a(paramContext, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.c
 * JD-Core Version:    0.7.0.1
 */