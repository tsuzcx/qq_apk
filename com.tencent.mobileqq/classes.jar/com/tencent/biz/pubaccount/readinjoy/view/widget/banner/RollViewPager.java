package com.tencent.biz.pubaccount.readinjoy.view.widget.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import bfui;
import com.tencent.mobileqq.R.styleable;
import tjw;
import tjx;
import tjy;

public class RollViewPager
  extends ViewPager
{
  private static String jdField_a_of_type_JavaLangString = "BannerAdapter";
  protected float a;
  protected int a;
  private ViewPager.PageTransformer jdField_a_of_type_AndroidSupportV4ViewViewPager$PageTransformer;
  protected tjw a;
  private tjx jdField_a_of_type_Tjx;
  private tjy jdField_a_of_type_Tjy;
  protected float b;
  private int b;
  protected float c;
  protected float d;
  private float e = 1.0F;
  private float f = 1.0F;
  
  public RollViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RollViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RollViewPager);
    this.e = paramAttributeSet.getFloat(1, 1.0F);
    this.f = paramAttributeSet.getFloat(0, 1.0F);
    paramAttributeSet.recycle();
    this.jdField_a_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    int j = getCurrentItem();
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$PageTransformer != null)
    {
      int i = paramInt;
      if (paramInt < 0) {
        i = getChildCount();
      }
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$PageTransformer.transformPage(paramView, i - j);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = false;
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = Math.abs(f1 - this.c);
    float f4 = Math.abs(f2 - this.d);
    switch (paramMotionEvent.getAction())
    {
    default: 
      return bool2;
    case 0: 
    case 261: 
      this.jdField_b_of_type_Int = this.jdField_a_of_type_Tjw.a();
      requestDisallowInterceptTouchEvent(true);
      this.c = f1;
      this.jdField_a_of_type_Float = f1;
      this.d = f2;
      this.jdField_b_of_type_Float = f2;
      if (this.jdField_a_of_type_Tjx != null) {
        this.jdField_a_of_type_Tjx.a(0);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    case 2: 
      if (this.jdField_b_of_type_Int <= 1)
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        bool1 = bool3;
      }
      for (;;)
      {
        this.c = f1;
        this.d = f2;
        return bool1;
        if ((f3 < f4) && (Math.abs(f2 - this.jdField_b_of_type_Float) > this.jdField_a_of_type_Int)) {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
        for (;;)
        {
          if ((f3 <= f4) || (Math.abs(f1 - this.jdField_a_of_type_Float) <= this.jdField_a_of_type_Int)) {
            break label280;
          }
          bool1 = super.dispatchTouchEvent(paramMotionEvent);
          break;
          getParent().requestDisallowInterceptTouchEvent(true);
        }
        label280:
        requestDisallowInterceptTouchEvent(false);
        bool1 = bool3;
      }
    }
    requestDisallowInterceptTouchEvent(false);
    bool2 = super.dispatchTouchEvent(paramMotionEvent);
    if ((Math.abs(f1 - this.jdField_a_of_type_Float) < this.jdField_a_of_type_Int) && (Math.abs(f2 - this.jdField_b_of_type_Float) < this.jdField_a_of_type_Int))
    {
      requestDisallowInterceptTouchEvent(false);
      performClick();
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.jdField_a_of_type_Tjx == null) {
        break;
      }
      this.jdField_a_of_type_Tjx.a(1);
      return bool1;
      if (this.jdField_a_of_type_Tjy != null) {
        this.jdField_a_of_type_Tjy.c();
      }
      bool1 = bool2;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      bfui.a("avatarWallViewPager", "ote_pointerindex_out_of_range", paramMotionEvent.toString(), "", "", "");
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((this.e == 1.0F) && (this.f != 1.0F))
    {
      paramInt2 = (int)(paramInt1 * this.f);
      getLayoutParams().height = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
      setMeasuredDimension(paramInt1, paramInt2);
    }
    while ((this.e == 1.0F) || (this.f != 1.0F)) {
      return;
    }
    paramInt1 = (int)(paramInt2 * this.e);
    getLayoutParams().width = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      bfui.a("avatarWallViewPager", "te_pointerindex_out_of_range", paramMotionEvent.toString(), "", "", "");
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    super.setAdapter(paramPagerAdapter);
    this.jdField_a_of_type_Tjw = ((tjw)paramPagerAdapter);
  }
  
  public void setOnTouchStateChangeListener(tjx paramtjx)
  {
    this.jdField_a_of_type_Tjx = paramtjx;
  }
  
  public void setOnUserFling(tjy paramtjy)
  {
    this.jdField_a_of_type_Tjy = paramtjy;
  }
  
  public void setPageTransformer(boolean paramBoolean, ViewPager.PageTransformer paramPageTransformer)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$PageTransformer = paramPageTransformer;
    super.setPageTransformer(paramBoolean, paramPageTransformer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager
 * JD-Core Version:    0.7.0.1
 */