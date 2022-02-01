package com.tencent.av.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R.styleable;
import mva;
import mvb;

public class RatingBar
  extends LinearLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Object jdField_a_of_type_JavaLangObject;
  private mvb jdField_a_of_type_Mvb;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public RatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RatingBar);
    this.jdField_a_of_type_Float = ((TypedArray)localObject).getDimension(11, 20.0F);
    this.jdField_a_of_type_Int = ((TypedArray)localObject).getInteger(2, 5);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((TypedArray)localObject).getDrawable(3);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((TypedArray)localObject).getDrawable(5);
    ((TypedArray)localObject).recycle();
    while (i < this.jdField_a_of_type_Int)
    {
      localObject = a(paramContext, paramAttributeSet);
      ((ImageView)localObject).setOnClickListener(new mva(this));
      addView((View)localObject);
      i += 1;
    }
  }
  
  private ImageView a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = new ImageView(paramContext);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.jdField_a_of_type_Float), Math.round(this.jdField_a_of_type_Float)));
    paramContext.setPadding(0, 0, 0, 0);
    paramContext.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    paramContext.setMaxWidth(10);
    paramContext.setMaxHeight(10);
    return paramContext;
  }
  
  public void setBindObject(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void setClickable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnRatingListener(mvb parammvb)
  {
    this.jdField_a_of_type_Mvb = parammvb;
  }
  
  public void setStar(int paramInt, boolean paramBoolean)
  {
    if (paramInt > this.jdField_a_of_type_Int) {
      paramInt = this.jdField_a_of_type_Int;
    }
    int i;
    for (;;)
    {
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      paramInt = 0;
      while (paramInt < i)
      {
        ((ImageView)getChildAt(paramInt)).setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        if (paramBoolean)
        {
          ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 0.0F, 1.0F, 1.0F);
          getChildAt(paramInt).startAnimation(localScaleAnimation);
        }
        paramInt += 1;
      }
    }
    paramInt = this.jdField_a_of_type_Int - 1;
    while (paramInt >= i)
    {
      ((ImageView)getChildAt(paramInt)).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      paramInt -= 1;
    }
  }
  
  public void setStarCount(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setStarEmptyDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setStarFillDrawable(Drawable paramDrawable)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setStarImageSize(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.widget.RatingBar
 * JD-Core Version:    0.7.0.1
 */