package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.tencent.luggage.wxa.qx.a;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/SimplifiedActionBarForPluginSplash;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/appbrand/widget/actionbar/IAppBrandActionBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBackBtn", "Landroid/widget/ImageView;", "mBackBtnClickListener", "Landroid/view/View$OnClickListener;", "mFixedHeight", "", "mForegroundColor", "mMainTitleView", "Landroid/widget/TextView;", "mProgressBar", "Landroid/widget/ProgressBar;", "mProgressLoadingDrawable", "Lcom/tencent/mm/plugin/appbrand/widget/CircleProgressDrawable;", "destroy", "", "getActionView", "Landroid/view/View;", "getBackgroundAlpha", "", "getBackgroundColor", "getCapsuleView", "getForegroundColor", "getMainTitle", "", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "resetForegroundStyle", "setBackButtonClickListener", "listener", "setBackgroundAlpha", "alpha", "setBackgroundColor", "color", "setCloseButtonClickListener", "setForegroundColor", "setForegroundStyle", "style", "", "setLoadingIconVisibility", "visible", "", "setMainTitle", "title", "setNavHidden", "hidden", "setOptionButtonClickListener", "showCapsuleArea", "show", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class k
  extends LinearLayout
  implements e
{
  private View.OnClickListener a;
  @ColorInt
  private int b = -16777216;
  private final int c;
  private final ImageView d;
  private final TextView e;
  private final ProgressBar f;
  private final CircleProgressDrawable g;
  
  public k(@NotNull Context paramContext)
  {
    super(paramContext);
    this.c = paramContext.getResources().getDimensionPixelSize(2131296297);
    setOrientation(0);
    setGravity(16);
    setLayoutParams(new ViewGroup.LayoutParams(-1, this.c));
    Object localObject = new ImageView(paramContext);
    ((ImageView)localObject).setPadding(paramContext.getResources().getDimensionPixelSize(2131296404), 0, paramContext.getResources().getDimensionPixelSize(2131296404), 0);
    ((ImageView)localObject).setBackgroundResource(2130837676);
    ((ImageView)localObject).setImageResource(2130837666);
    ((ImageView)localObject).setId(2131427578);
    ((ImageView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
    ((ImageView)localObject).setOnClickListener((View.OnClickListener)new k.a(this, paramContext));
    addView((View)localObject);
    this.d = ((ImageView)localObject);
    localObject = new TextView(paramContext);
    ((TextView)localObject).setTextSize(0, paramContext.getResources().getDimensionPixelSize(2131296256));
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setMaxLines(1);
    ((TextView)localObject).setGravity(16);
    ((TextView)localObject).setId(2131427582);
    ((TextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    addView((View)localObject);
    this.e = ((TextView)localObject);
    this.g = new CircleProgressDrawable(paramContext);
    localObject = new ProgressBar((Context)new ContextThemeWrapper(paramContext, 2131953184));
    int i = a.e(paramContext, 3);
    ((ProgressBar)localObject).setPadding(i, i, i, i);
    ((ProgressBar)localObject).setId(2131427575);
    i = a.e(paramContext, 24);
    ((ProgressBar)localObject).setLayoutParams(new ViewGroup.LayoutParams(i, i));
    ((ProgressBar)localObject).setIndeterminateDrawable((Drawable)this.g);
    addView((View)localObject);
    this.f = ((ProgressBar)localObject);
  }
  
  public void a()
  {
    this.g.c();
    removeAllViews();
    this.a = ((View.OnClickListener)null);
  }
  
  public void b()
  {
    this.d.setColorFilter(this.b, PorterDuff.Mode.SRC_ATOP);
    this.e.setTextColor(this.b);
    this.g.a(this.b);
    this.f.setIndeterminateDrawable((Drawable)this.g);
  }
  
  public void c(boolean paramBoolean) {}
  
  @NotNull
  public View getActionView()
  {
    return (View)this;
  }
  
  public double getBackgroundAlpha()
  {
    return 1.0D;
  }
  
  public int getBackgroundColor()
  {
    Drawable localDrawable = super.getBackground();
    Object localObject = localDrawable;
    if (!(localDrawable instanceof ColorDrawable)) {
      localObject = null;
    }
    localObject = (ColorDrawable)localObject;
    if (localObject != null) {
      return ((ColorDrawable)localObject).getColor();
    }
    return 0;
  }
  
  @Nullable
  public View getCapsuleView()
  {
    return null;
  }
  
  public int getForegroundColor()
  {
    return this.b;
  }
  
  @Nullable
  public CharSequence getMainTitle()
  {
    return this.e.getText();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.f.getVisibility() == 0) {
      this.g.b();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.g.c();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.c, 1073741824));
  }
  
  public void setBackButtonClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }
  
  public void setBackgroundAlpha(double paramDouble) {}
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (paramInt != 0)
    {
      setWillNotDraw(false);
      return;
    }
    setWillNotDraw(true);
  }
  
  public void setCloseButtonClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }
  
  public void setForegroundColor(int paramInt)
  {
    this.b = paramInt;
    b();
  }
  
  public void setForegroundStyle(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "style");
    setForegroundColor(e.a.a(paramString).c);
  }
  
  public void setLoadingIconVisibility(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.f.setVisibility(0);
      this.g.a();
      if (isAttachedToWindow()) {
        this.g.b();
      }
    }
    else
    {
      this.f.setVisibility(8);
      this.g.c();
    }
  }
  
  public void setMainTitle(@Nullable CharSequence paramCharSequence)
  {
    this.e.setText(paramCharSequence);
  }
  
  public void setNavHidden(boolean paramBoolean) {}
  
  public void setOptionButtonClickListener(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.k
 * JD-Core Version:    0.7.0.1
 */