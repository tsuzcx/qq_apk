package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;
import com.tencent.mobileqq.R.styleable;

public class ResizeURLImageView
  extends ZImageView
{
  private float jdField_a_of_type_Float = 1.0F;
  private Context jdField_a_of_type_AndroidContentContext;
  private float b = 1.0F;
  private boolean d;
  
  public ResizeURLImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ResizeURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ResizeURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = this.jdField_a_of_type_AndroidContentContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ResizeURLImageView);
    this.jdField_a_of_type_Float = paramAttributeSet.getFloat(0, 1.0F);
    this.b = paramAttributeSet.getFloat(1, 1.0F);
    paramAttributeSet.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((this.jdField_a_of_type_Float == 1.0F) && (this.b != 1.0F)) {
      setMeasuredDimension(paramInt1, (int)(paramInt1 * this.b));
    }
    while ((this.jdField_a_of_type_Float == 1.0F) || (this.b != 1.0F)) {
      return;
    }
    setMeasuredDimension((int)(paramInt2 * this.jdField_a_of_type_Float), paramInt2);
  }
  
  public void requestLayout()
  {
    if (!this.d) {
      super.requestLayout();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.d = true;
    super.setImageDrawable(null);
    super.setImageDrawable(paramDrawable);
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView
 * JD-Core Version:    0.7.0.1
 */