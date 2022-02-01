package com.tencent.luggage.ui;

import android.app.Presentation;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WmpfPresentationActivityHelper$WmpfPresentation;", "Landroid/app/Presentation;", "Lcom/tencent/luggage/ui/WmpfPresentationActivityHelper$PresentationLifeCycle;", "outerContext", "Landroid/content/Context;", "display", "Landroid/view/Display;", "rootView", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/Display;Landroid/view/ViewGroup;)V", "isForeground", "", "lifeCycle", "getLifeCycle", "()Lcom/tencent/luggage/ui/WmpfPresentationActivityHelper$PresentationLifeCycle;", "setLifeCycle", "(Lcom/tencent/luggage/ui/WmpfPresentationActivityHelper$PresentationLifeCycle;)V", "getRootView", "()Landroid/view/ViewGroup;", "onBackground", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onForeground", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
final class WmpfPresentationActivityHelper$c
  extends Presentation
  implements WmpfPresentationActivityHelper.a
{
  private boolean a;
  @Nullable
  private WmpfPresentationActivityHelper.a b;
  @Nullable
  private final ViewGroup c;
  
  public WmpfPresentationActivityHelper$c(@NotNull Context paramContext, @Nullable Display paramDisplay, @Nullable ViewGroup paramViewGroup)
  {
    super(paramContext, paramDisplay);
    this.c = paramViewGroup;
  }
  
  public void a()
  {
    WmpfPresentationActivityHelper.a locala = this.b;
    if (locala != null) {
      locala.a();
    }
    this.a = true;
  }
  
  public final void a(@Nullable WmpfPresentationActivityHelper.a parama)
  {
    this.b = parama;
  }
  
  public void b()
  {
    WmpfPresentationActivityHelper.a locala = this.b;
    if (locala != null) {
      locala.b();
    }
    this.a = false;
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    paramBundle = this.c;
    if (paramBundle != null) {
      setContentView((View)paramBundle);
    }
    if (getWindow() != null)
    {
      paramBundle = getWindow();
      if (paramBundle == null) {
        Intrinsics.throwNpe();
      }
      WmpfPresentationActivityHelper.a(paramBundle);
    }
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      int i;
      if (Build.VERSION.SDK_INT < 26) {
        i = 2002;
      } else {
        i = 2038;
      }
      paramBundle.setType(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WmpfPresentationActivityHelper.c
 * JD-Core Version:    0.7.0.1
 */