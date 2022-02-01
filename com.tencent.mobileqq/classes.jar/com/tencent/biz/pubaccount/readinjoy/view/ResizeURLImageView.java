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
  private boolean mBlockLayout;
  private Context mContext;
  private float mHeightWeight = 1.0F;
  private float mWidthWeight = 1.0F;
  
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
    this.mContext = paramContext;
    getResizeScale(paramAttributeSet);
  }
  
  private void getResizeScale(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ResizeURLImageView);
    this.mWidthWeight = paramAttributeSet.getFloat(1, 1.0F);
    this.mHeightWeight = paramAttributeSet.getFloat(0, 1.0F);
    paramAttributeSet.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((this.mWidthWeight == 1.0F) && (this.mHeightWeight != 1.0F)) {
      setMeasuredDimension(paramInt1, (int)(paramInt1 * this.mHeightWeight));
    }
    while ((this.mWidthWeight == 1.0F) || (this.mHeightWeight != 1.0F)) {
      return;
    }
    setMeasuredDimension((int)(paramInt2 * this.mWidthWeight), paramInt2);
  }
  
  public void requestLayout()
  {
    if (!this.mBlockLayout) {
      super.requestLayout();
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.mBlockLayout = true;
    super.setImageDrawable(null);
    super.setImageDrawable(paramDrawable);
    this.mBlockLayout = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView
 * JD-Core Version:    0.7.0.1
 */