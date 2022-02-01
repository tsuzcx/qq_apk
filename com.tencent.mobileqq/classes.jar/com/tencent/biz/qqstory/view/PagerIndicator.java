package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.annotation.Nullable;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;

public class PagerIndicator
  extends LinearLayout
{
  public static final int[] a;
  protected int a;
  protected Drawable a;
  protected EmptySupportViewPager a;
  public final PagerIndicator.PageListener a;
  protected WeakReference<PagerIndicator.IndicatorAdapter> a;
  protected Queue<PagerIndicator.InnerImageView> a;
  protected int b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 16843161, 16843327, 16843245 };
  }
  
  public PagerIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagerIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_ComTencentBizQqstoryViewPagerIndicator$PageListener = new PagerIndicator.PageListener(this, null);
    super.setOrientation(0);
    super.setGravity(17);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt);
    if (paramContext.hasValue(0)) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(0);
    } else {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-7829368);
    }
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(1, this.jdField_a_of_type_Int);
    this.b = paramContext.getInt(2, this.b);
    paramContext.recycle();
    a(0, this.b);
    Log.d("PagerIndicator", "init");
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updatePoints : current item = ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", page count = ");
    ((StringBuilder)localObject).append(paramInt2);
    Log.d("PagerIndicator", ((StringBuilder)localObject).toString());
    int i = super.getChildCount();
    if (i > paramInt2)
    {
      i -= 1;
      for (;;)
      {
        if (i < paramInt2) {
          break label224;
        }
        localObject = super.getChildAt(i);
        if (!(localObject instanceof PagerIndicator.InnerImageView)) {
          break;
        }
        super.removeView((View)localObject);
        this.jdField_a_of_type_JavaUtilQueue.offer((PagerIndicator.InnerImageView)localObject);
        i -= 1;
      }
      throw new AndroidRuntimeException("find illegal child view, all child view should be InnerImageView");
    }
    if (paramInt2 > i) {
      while (i < paramInt2)
      {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams.setMargins(this.jdField_a_of_type_Int, 0, 0, 0);
        PagerIndicator.InnerImageView localInnerImageView = (PagerIndicator.InnerImageView)this.jdField_a_of_type_JavaUtilQueue.poll();
        localObject = localInnerImageView;
        if (localInnerImageView == null)
        {
          localObject = new PagerIndicator.InnerImageView(getContext());
          ((PagerIndicator.InnerImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable());
        }
        super.addView((View)localObject, i, localLayoutParams);
        i += 1;
      }
    }
    label224:
    i = 0;
    while (i < paramInt2)
    {
      localObject = super.getChildAt(i);
      if (paramInt1 == i) {
        ((View)localObject).setSelected(true);
      } else {
        ((View)localObject).setSelected(false);
      }
      i += 1;
    }
  }
  
  protected void a(int paramInt, @Nullable PagerIndicator.IndicatorAdapter paramIndicatorAdapter)
  {
    int i = 0;
    if (paramIndicatorAdapter != null) {
      paramInt = paramIndicatorAdapter.a(paramInt);
    } else {
      paramInt = 0;
    }
    if (paramIndicatorAdapter != null) {
      i = paramIndicatorAdapter.a();
    }
    a(paramInt, i);
  }
  
  public void setViewPager(@Nullable EmptySupportViewPager paramEmptySupportViewPager)
  {
    EmptySupportViewPager localEmptySupportViewPager = this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager;
    if (localEmptySupportViewPager != paramEmptySupportViewPager)
    {
      if (localEmptySupportViewPager != null)
      {
        localEmptySupportViewPager.removeOnPageChangeListener(this.jdField_a_of_type_ComTencentBizQqstoryViewPagerIndicator$PageListener);
        this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager = null;
      }
      if (paramEmptySupportViewPager != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager = paramEmptySupportViewPager;
        this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager.addOnPageChangeListener(this.jdField_a_of_type_ComTencentBizQqstoryViewPagerIndicator$PageListener);
      }
    }
  }
  
  public void setViewPagerAdapter(@Nullable PagerIndicator.IndicatorAdapter paramIndicatorAdapter)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {
      localObject = (PagerIndicator.IndicatorAdapter)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != paramIndicatorAdapter)
    {
      if (localObject != null)
      {
        ((PagerIndicator.IndicatorAdapter)localObject).unregisterDataSetObserver(this.jdField_a_of_type_ComTencentBizQqstoryViewPagerIndicator$PageListener);
        this.jdField_a_of_type_JavaLangRefWeakReference = null;
      }
      if (paramIndicatorAdapter != null)
      {
        paramIndicatorAdapter.registerDataSetObserver(this.jdField_a_of_type_ComTencentBizQqstoryViewPagerIndicator$PageListener);
        this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIndicatorAdapter);
      }
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager;
      if (localObject != null) {
        a(((EmptySupportViewPager)localObject).getCurrentItem(), paramIndicatorAdapter);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.PagerIndicator
 * JD-Core Version:    0.7.0.1
 */