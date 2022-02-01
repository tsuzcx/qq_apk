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
import com.tencent.mobileqq.qqui.R.styleable;

public class RatingBar
  extends LinearLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private RatingBar.OnRatingListener jdField_a_of_type_ComTencentAvWidgetRatingBar$OnRatingListener;
  private Object jdField_a_of_type_JavaLangObject;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  
  public RatingBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = 0;
    setOrientation(0);
    Object localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.aO);
    this.jdField_a_of_type_Float = ((TypedArray)localObject).getDimension(R.styleable.bm, 20.0F);
    this.jdField_a_of_type_Int = ((TypedArray)localObject).getInteger(R.styleable.bj, 5);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((TypedArray)localObject).getDrawable(R.styleable.bk);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = ((TypedArray)localObject).getDrawable(R.styleable.bl);
    ((TypedArray)localObject).recycle();
    while (i < this.jdField_a_of_type_Int)
    {
      localObject = a(paramContext, paramAttributeSet);
      ((ImageView)localObject).setOnClickListener(new RatingBar.1(this));
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
  
  public void setOnRatingListener(RatingBar.OnRatingListener paramOnRatingListener)
  {
    this.jdField_a_of_type_ComTencentAvWidgetRatingBar$OnRatingListener = paramOnRatingListener;
  }
  
  public void setStar(int paramInt, boolean paramBoolean)
  {
    int j = this.jdField_a_of_type_Int;
    int i = paramInt;
    if (paramInt > j) {
      i = j;
    }
    int k = 0;
    j = k;
    paramInt = i;
    if (i < 0)
    {
      paramInt = 0;
      j = k;
    }
    while (j < paramInt)
    {
      ((ImageView)getChildAt(j)).setImageDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
      if (paramBoolean)
      {
        ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 0.0F, 1.0F, 1.0F);
        getChildAt(j).startAnimation(localScaleAnimation);
      }
      j += 1;
    }
    i = this.jdField_a_of_type_Int - 1;
    while (i >= paramInt)
    {
      ((ImageView)getChildAt(i)).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      i -= 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.widget.RatingBar
 * JD-Core Version:    0.7.0.1
 */