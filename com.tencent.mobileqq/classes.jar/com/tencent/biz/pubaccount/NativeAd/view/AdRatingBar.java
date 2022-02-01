package com.tencent.biz.pubaccount.NativeAd.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.kandian.ad.api.R.styleable;
import java.math.BigDecimal;

public class AdRatingBar
  extends LinearLayout
{
  private boolean a;
  private int b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private Drawable h;
  private Drawable i;
  private Drawable j;
  private int k = 1;
  private boolean l = true;
  
  public AdRatingBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdRatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public AdRatingBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private ImageView a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = new ImageView(paramContext);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(Math.round(this.d), Math.round(this.e));
    if (!paramBoolean2) {
      localMarginLayoutParams.rightMargin = Math.round(this.g);
    }
    paramContext.setLayoutParams(localMarginLayoutParams);
    paramContext.setPadding(0, 0, Math.round(this.f), 0);
    if (paramBoolean1)
    {
      paramContext.setImageDrawable(this.h);
      return paramContext;
    }
    paramContext.setImageDrawable(this.i);
    return paramContext;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    setOrientation(0);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.g);
    try
    {
      this.j = paramAttributeSet.getDrawable(R.styleable.l);
      this.h = paramAttributeSet.getDrawable(R.styleable.j);
      this.i = paramAttributeSet.getDrawable(R.styleable.k);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    this.d = paramAttributeSet.getDimension(R.styleable.p, 60.0F);
    this.e = paramAttributeSet.getDimension(R.styleable.m, 120.0F);
    this.f = paramAttributeSet.getDimension(R.styleable.o, 0.0F);
    this.g = paramAttributeSet.getDimension(R.styleable.n, 0.0F);
    this.b = paramAttributeSet.getInteger(R.styleable.q, 5);
    this.c = paramAttributeSet.getFloat(R.styleable.i, 0.0F);
    this.a = paramAttributeSet.getBoolean(R.styleable.h, true);
    paramAttributeSet.recycle();
    int m = 0;
    for (;;)
    {
      int n = this.b;
      if (m >= n) {
        break;
      }
      boolean bool;
      if (m == n - 1) {
        bool = true;
      } else {
        bool = false;
      }
      addView(a(paramContext, this.l, bool));
      m += 1;
    }
    setStar(this.c);
  }
  
  public void setRatable(boolean paramBoolean)
  {
    this.a = paramBoolean;
    int m = 0;
    while (m < getChildCount())
    {
      getChildAt(m).setClickable(paramBoolean);
      m += 1;
    }
  }
  
  public void setRating(float paramFloat)
  {
    this.c = paramFloat;
    setStar(paramFloat);
  }
  
  public void setStar(float paramFloat)
  {
    int n = (int)paramFloat;
    float f2 = new BigDecimal(Float.toString(paramFloat)).subtract(new BigDecimal(Integer.toString(n))).floatValue();
    int m = this.b;
    if (n > m) {
      paramFloat = m;
    } else {
      paramFloat = n;
    }
    float f1 = paramFloat;
    if (paramFloat < 0.0F) {
      f1 = 0.0F;
    }
    m = 0;
    while (m < f1)
    {
      ((ImageView)getChildAt(m)).setImageDrawable(this.i);
      m += 1;
    }
    if (f2 > 0.0F)
    {
      ((ImageView)getChildAt(n)).setImageDrawable(this.j);
      m = this.b - 1;
      while (m >= 1.0F + f1)
      {
        ((ImageView)getChildAt(m)).setImageDrawable(this.h);
        m -= 1;
      }
    }
    m = this.b - 1;
    while (m >= f1)
    {
      ((ImageView)getChildAt(m)).setImageDrawable(this.h);
      m -= 1;
    }
  }
  
  public void setStarNum(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.AdRatingBar
 * JD-Core Version:    0.7.0.1
 */