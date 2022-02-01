package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mm.plugin.appbrand.page.bi;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandCapsuleHomeButton;
import com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton;

public final class d
  extends FrameLayout
  implements bi, g
{
  private int b = 0;
  private AppBrandOptionButton c;
  private AppBrandCapsuleHomeButton d;
  private LinearLayout e;
  private View f;
  private View g;
  
  public d(@NonNull Context paramContext)
  {
    super(paramContext);
    LayoutInflater.from(paramContext).inflate(2131624208, this);
    this.c = ((AppBrandOptionButton)findViewById(2131427573));
    this.d = ((AppBrandCapsuleHomeButton)findViewById(2131427572));
    this.e = ((LinearLayout)findViewById(2131427569));
    this.f = findViewById(2131427571);
    this.c.setAccessibilityLabel(getContext().getString(2131886751));
    this.d.setAccessibilityLabel(getContext().getString(2131886747));
  }
  
  public void a()
  {
    View localView = this.g;
    if (localView != null) {
      localView.animate().cancel();
    }
    removeAllViews();
  }
  
  public boolean a(@NonNull Canvas paramCanvas)
  {
    draw(paramCanvas);
    return true;
  }
  
  View getCapsuleContentAreaView()
  {
    return this.e;
  }
  
  AppBrandCapsuleHomeButton getCapsuleHomeButton()
  {
    return this.d;
  }
  
  public AppBrandOptionButton getOptionBtn()
  {
    return this.c;
  }
  
  public void setHomeButtonOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.d.setOnClickListener(paramOnClickListener);
  }
  
  public void setOptionButtonOnClickListener(@Nullable View.OnClickListener paramOnClickListener)
  {
    this.c.setOnClickListener(paramOnClickListener);
  }
  
  public void setStyleColor(@ColorInt int paramInt)
  {
    if (paramInt == this.b) {
      return;
    }
    if (paramInt == -1)
    {
      this.b = -1;
      this.f.setBackgroundResource(2131165481);
      this.e.setBackgroundResource(2130838668);
      this.c.setColor(-1);
      this.d.setColor(-1);
    }
    else
    {
      this.b = -16777216;
      this.f.setBackgroundResource(2131165482);
      this.e.setBackgroundResource(2130838669);
      this.c.setColor(-16777216);
      this.d.setColor(-16777216);
    }
    View localView = this.g;
    if (localView != null)
    {
      localView.animate().cancel();
      removeView(this.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.d
 * JD-Core Version:    0.7.0.1
 */