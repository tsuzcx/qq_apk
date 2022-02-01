package com.tencent.mm.plugin.appbrand.jsapi.video.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;

public class AppBrandDotPercentIndicator
  extends LinearLayout
{
  private LayoutInflater a;
  private int b;
  
  public AppBrandDotPercentIndicator(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AppBrandDotPercentIndicator(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AppBrandDotPercentIndicator(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext);
  }
  
  public void setDotsNum(int paramInt)
  {
    if (paramInt <= 1) {
      paramInt = 8;
    }
    this.b = paramInt;
    removeAllViews();
    paramInt = 0;
    while (paramInt < this.b)
    {
      addView((ImageView)this.a.inflate(2131624210, this, false));
      paramInt += 1;
    }
  }
  
  public void setPercent(float paramFloat)
  {
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    paramFloat = f;
    if (f > 1.0F) {
      paramFloat = 1.0F;
    }
    int k = (int)Math.rint(this.b * paramFloat);
    int i = 0;
    o.f("MicroMsg.AppBrandDotPercentIndicator", "setPercent percent:%s dotsOnNum:%d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(k) });
    int j;
    for (;;)
    {
      j = i;
      if (i >= k) {
        break;
      }
      j = i;
      if (i >= getChildCount()) {
        break;
      }
      ((ImageView)getChildAt(i)).setImageResource(2130838664);
      i += 1;
    }
    while (j < getChildCount())
    {
      ((ImageView)getChildAt(j)).setImageResource(2130838663);
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator
 * JD-Core Version:    0.7.0.1
 */