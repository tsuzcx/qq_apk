package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DailyHeaderBackgroundImageView
  extends ImageView
{
  public DailyHeaderBackgroundImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DailyHeaderBackgroundImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DailyHeaderBackgroundImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getLeft();
    int j = getTop();
    paramCanvas.clipRect(i, j, getRight(), getBottom() - j);
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup.getChildCount() > 1)
    {
      paramInt1 = resolveSizeAndState(localViewGroup.getChildAt(1).getMeasuredHeight(), getMeasuredState(), 0);
      setMeasuredDimension(getMeasuredWidthAndState(), paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.DailyHeaderBackgroundImageView
 * JD-Core Version:    0.7.0.1
 */