package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.oq.j;
import com.tencent.luggage.wxa.qz.o;
import org.jetbrains.annotations.NotNull;

public class c
  extends f
{
  @Nullable
  private Integer a;
  @Nullable
  private Integer b;
  @Nullable
  private Float c;
  @Nullable
  private Integer d;
  
  public c(@NonNull @NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(View paramView)
  {
    if (this.c == null) {
      return;
    }
    if (Math.abs(paramView.getScaleX() - this.c.floatValue()) >= 0.01F)
    {
      paramView.setScaleX(this.c.floatValue());
      paramView.setScaleY(this.c.floatValue());
    }
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    super.addView(paramView, paramInt);
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    super.addView(paramView, paramInt1, paramInt2);
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    a(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramLayoutParams);
    a(paramView);
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1;
    int j = paramInt3;
    if (this.b != null)
    {
      Integer localInteger = this.a;
      i = paramInt1;
      j = paramInt3;
      if (localInteger != null)
      {
        if (localInteger.intValue() > 0) {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(this.a.intValue(), 1073741824);
        }
        i = paramInt1;
        j = paramInt3;
        if (this.b.intValue() > 0)
        {
          j = View.MeasureSpec.makeMeasureSpec(this.b.intValue(), 1073741824);
          i = paramInt1;
        }
      }
    }
    super.measureChildWithMargins(paramView, i, paramInt2, j, paramInt4);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.a;
    int m;
    int n;
    if ((localObject != null) && (this.b != null))
    {
      m = (paramInt3 - paramInt1) / 2 - ((Integer)localObject).intValue() / 2;
      n = (paramInt4 - paramInt2) / 2 - this.b.intValue() / 2;
    }
    else
    {
      m = 0;
      n = 0;
    }
    localObject = this.d;
    int i1;
    if (localObject == null) {
      i1 = 17;
    } else {
      i1 = ((Integer)localObject).intValue();
    }
    int i3 = getChildCount();
    int i2 = 0;
    while (i2 < i3)
    {
      localObject = getChildAt(i2);
      if (((View)localObject).getVisibility() != 8)
      {
        paramInt3 = ((View)localObject).getMeasuredWidth();
        int k = ((View)localObject).getMeasuredHeight();
        int j;
        int i;
        if (i1 != 17)
        {
          if (i1 != 80)
          {
            paramInt3 = paramInt1 + paramInt3;
            o.c("Luggage.WXA.AppBrandCenterInsideRuntimeFrameLayout", "onLayout: unhandled gravity[%d], good luck~", new Object[] { Integer.valueOf(i1) });
            j = paramInt1;
            k = paramInt2 + k;
            i = paramInt2;
          }
          else
          {
            paramInt3 = paramInt1 + paramInt3;
            i = paramInt4 - k;
            j = paramInt1;
            k = paramInt4;
          }
        }
        else
        {
          j = paramInt1 + m;
          i = paramInt2 + n;
          paramInt3 += j;
          k += i;
        }
        ((View)localObject).layout(j, i, paramInt3, k);
      }
      i2 += 1;
    }
  }
  
  public void setWxaLayoutParams(j paramj)
  {
    this.a = Integer.valueOf(paramj.width);
    this.b = Integer.valueOf(paramj.height);
    this.c = Float.valueOf(paramj.a());
    this.d = Integer.valueOf(paramj.gravity);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      a(getChildAt(i));
      i += 1;
    }
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c
 * JD-Core Version:    0.7.0.1
 */