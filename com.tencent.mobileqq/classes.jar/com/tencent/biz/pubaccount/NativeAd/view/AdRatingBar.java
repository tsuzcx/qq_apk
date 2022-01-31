package com.tencent.biz.pubaccount.NativeAd.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R.styleable;
import java.math.BigDecimal;

public class AdRatingBar
  extends LinearLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 1;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_b_of_type_Boolean = true;
  private float jdField_c_of_type_Float;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private float d;
  private float e;
  
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
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(Math.round(this.jdField_b_of_type_Float), Math.round(this.jdField_c_of_type_Float));
    if (!paramBoolean2) {
      localMarginLayoutParams.rightMargin = Math.round(this.e);
    }
    paramContext.setLayoutParams(localMarginLayoutParams);
    paramContext.setPadding(0, 0, Math.round(this.d), 0);
    if (paramBoolean1)
    {
      paramContext.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return paramContext;
    }
    paramContext.setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
    return paramContext;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    setOrientation(0);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AdRatingBar);
    try
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(7);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(4);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramAttributeSet.getDrawable(6);
      this.jdField_b_of_type_Float = paramAttributeSet.getDimension(12, 60.0F);
      this.jdField_c_of_type_Float = paramAttributeSet.getDimension(8, 120.0F);
      this.d = paramAttributeSet.getDimension(10, 0.0F);
      this.e = paramAttributeSet.getDimension(9, 0.0F);
      this.jdField_a_of_type_Int = paramAttributeSet.getInteger(13, 5);
      this.jdField_a_of_type_Float = paramAttributeSet.getFloat(1, 0.0F);
      this.jdField_a_of_type_Boolean = paramAttributeSet.getBoolean(0, true);
      paramAttributeSet.recycle();
      int i = 0;
      for (;;)
      {
        if (i >= this.jdField_a_of_type_Int) {
          break label185;
        }
        if (i != this.jdField_a_of_type_Int - 1) {
          break;
        }
        bool = true;
        addView(a(paramContext, this.jdField_b_of_type_Boolean, bool));
        i += 1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        continue;
        boolean bool = false;
      }
      label185:
      setStar(this.jdField_a_of_type_Float);
    }
  }
  
  public void setRatable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setClickable(paramBoolean);
      i += 1;
    }
  }
  
  public void setRating(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    setStar(paramFloat);
  }
  
  public void setStar(float paramFloat)
  {
    int j = (int)paramFloat;
    float f = new BigDecimal(Float.toString(paramFloat)).subtract(new BigDecimal(Integer.toString(j))).floatValue();
    if (j > this.jdField_a_of_type_Int)
    {
      paramFloat = this.jdField_a_of_type_Int;
      if (paramFloat >= 0.0F) {
        break label95;
      }
      paramFloat = 0.0F;
    }
    label95:
    for (;;)
    {
      i = 0;
      while (i < paramFloat)
      {
        ((ImageView)getChildAt(i)).setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        i += 1;
      }
      paramFloat = j;
      break;
    }
    if (f > 0.0F)
    {
      ((ImageView)getChildAt(j)).setImageDrawable(this.jdField_c_of_type_AndroidGraphicsDrawableDrawable);
      i = this.jdField_a_of_type_Int - 1;
      while (i >= 1.0F + paramFloat)
      {
        ((ImageView)getChildAt(i)).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        i -= 1;
      }
    }
    int i = this.jdField_a_of_type_Int - 1;
    while (i >= paramFloat)
    {
      ((ImageView)getChildAt(i)).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      i -= 1;
    }
  }
  
  public void setStarNum(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.view.AdRatingBar
 * JD-Core Version:    0.7.0.1
 */