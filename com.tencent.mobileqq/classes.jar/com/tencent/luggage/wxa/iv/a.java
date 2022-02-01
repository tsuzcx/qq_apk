package com.tencent.luggage.wxa.iv;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ad/AppBrandActionBarWithCapsule;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "actionBar", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;", "(Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandActionBar;)V", "capsuleBarImplView", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandCapsuleBarImplView;", "destroy", "", "getActionView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBackgroundAlpha", "", "getBackgroundColor", "", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "getOptionButton", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/AppBrandOptionButton;", "getParent", "Landroid/view/ViewParent;", "resetForegroundStyle", "setBackButtonClickListener", "listener", "Landroid/view/View$OnClickListener;", "setBackgroundAlpha", "alpha", "setBackgroundColor", "color", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", "isBlack", "", "style", "", "setFullscreenMode", "fullscreen", "setLoadingIconVisibility", "visible", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "showCapsuleArea", "show", "showNavArea", "showTitleArea", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class a
  implements e
{
  private final b a;
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a.setOptionButtonClickListener(paramOnClickListener);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a.setFullscreenMode(paramBoolean);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.a.setForegroundStyle(paramBoolean);
  }
  
  public void c(boolean paramBoolean)
  {
    this.a.c(paramBoolean);
  }
  
  public View getActionView()
  {
    return this.a.getActionView();
  }
  
  public int getBackgroundColor()
  {
    return this.a.getBackgroundColor();
  }
  
  public void setBackButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.setBackButtonClickListener(paramOnClickListener);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.a.setBackgroundColor(paramInt);
  }
  
  public void setCloseButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.setCloseButtonClickListener(paramOnClickListener);
  }
  
  public void setForegroundColor(int paramInt)
  {
    this.a.setForegroundColor(paramInt);
  }
  
  public void setForegroundStyle(String paramString)
  {
    this.a.setForegroundStyle(paramString);
  }
  
  public void setLoadingIconVisibility(boolean paramBoolean)
  {
    this.a.setLoadingIconVisibility(paramBoolean);
  }
  
  public void setMainTitle(CharSequence paramCharSequence)
  {
    this.a.setMainTitle(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iv.a
 * JD-Core Version:    0.7.0.1
 */