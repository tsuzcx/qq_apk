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
import vov;

public class PagerIndicator
  extends LinearLayout
{
  public static final int[] a;
  protected int a;
  protected Drawable a;
  public EmptySupportViewPager a;
  protected WeakReference<PagerIndicator.IndicatorAdapter> a;
  protected Queue<PagerIndicator.InnerImageView> a;
  public final vov a;
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
    this.jdField_a_of_type_Vov = new vov(this, null);
    super.setOrientation(0);
    super.setGravity(17);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt);
    if (paramContext.hasValue(0)) {}
    for (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(0);; this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(-7829368))
    {
      this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(1, this.jdField_a_of_type_Int);
      this.b = paramContext.getInt(2, this.b);
      paramContext.recycle();
      a(0, this.b);
      Log.d("PagerIndicator", "init");
      return;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    Log.d("PagerIndicator", "updatePoints : current item = " + paramInt1 + ", page count = " + paramInt2);
    int i = super.getChildCount();
    Object localObject;
    if (i > paramInt2)
    {
      i -= 1;
      for (;;)
      {
        if (i < paramInt2) {
          break label208;
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
    label208:
    i = 0;
    if (i < paramInt2)
    {
      localObject = super.getChildAt(i);
      if (paramInt1 == i) {
        ((View)localObject).setSelected(true);
      }
      for (;;)
      {
        i += 1;
        break;
        ((View)localObject).setSelected(false);
      }
    }
  }
  
  public void a(int paramInt, @Nullable PagerIndicator.IndicatorAdapter paramIndicatorAdapter)
  {
    int i = 0;
    if (paramIndicatorAdapter != null) {}
    for (paramInt = paramIndicatorAdapter.a(paramInt);; paramInt = 0)
    {
      if (paramIndicatorAdapter != null) {
        i = paramIndicatorAdapter.a();
      }
      a(paramInt, i);
      return;
    }
  }
  
  public void setViewPager(@Nullable EmptySupportViewPager paramEmptySupportViewPager)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager != paramEmptySupportViewPager)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager.b(this.jdField_a_of_type_Vov);
        this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager = null;
      }
      if (paramEmptySupportViewPager != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager = paramEmptySupportViewPager;
        this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager.a(this.jdField_a_of_type_Vov);
      }
    }
  }
  
  public void setViewPagerAdapter(@Nullable PagerIndicator.IndicatorAdapter paramIndicatorAdapter)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (PagerIndicator.IndicatorAdapter localIndicatorAdapter = (PagerIndicator.IndicatorAdapter)this.jdField_a_of_type_JavaLangRefWeakReference.get();; localIndicatorAdapter = null)
    {
      if (localIndicatorAdapter != paramIndicatorAdapter)
      {
        if (localIndicatorAdapter != null)
        {
          localIndicatorAdapter.unregisterDataSetObserver(this.jdField_a_of_type_Vov);
          this.jdField_a_of_type_JavaLangRefWeakReference = null;
        }
        if (paramIndicatorAdapter != null)
        {
          paramIndicatorAdapter.registerDataSetObserver(this.jdField_a_of_type_Vov);
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIndicatorAdapter);
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager != null) {
          a(this.jdField_a_of_type_ComTencentBizQqstoryViewEmptySupportViewPager.getCurrentItem(), paramIndicatorAdapter);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.PagerIndicator
 * JD-Core Version:    0.7.0.1
 */