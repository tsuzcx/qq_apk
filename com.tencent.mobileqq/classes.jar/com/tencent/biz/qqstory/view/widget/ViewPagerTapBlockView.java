package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.tencent.mobileqq.R.styleable;

public class ViewPagerTapBlockView
  extends View
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private int b;
  private int c;
  private int d;
  
  public ViewPagerTapBlockView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ViewPagerTapBlockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewPagerTapBlockView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.ViewPagerTapBlockView, paramInt, 0);
    int j = paramContext.getIndexCount();
    paramInt = i;
    if (paramInt < j)
    {
      i = paramContext.getIndex(paramInt);
      switch (i)
      {
      }
      for (;;)
      {
        paramInt += 1;
        break;
        this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(i, (int)TypedValue.applyDimension(1, 56.0F, getResources().getDisplayMetrics()));
        continue;
        this.b = paramContext.getDimensionPixelSize(i, (int)TypedValue.applyDimension(1, 3.0F, getResources().getDisplayMetrics()));
        continue;
        this.c = paramContext.getColor(i, -1);
        continue;
        this.d = paramContext.getDimensionPixelSize(i, (int)TypedValue.applyDimension(1, 0.0F, getResources().getDisplayMetrics()));
      }
    }
    paramContext.recycle();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
    paramCanvas.drawRect(this.d, 0.0F, this.jdField_a_of_type_Int + this.d, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setBlockColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setBlockWidth(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setOffset(int paramInt)
  {
    this.d = paramInt;
    invalidate();
  }
  
  public String toString()
  {
    return "ViewPagerTapBlockView width:" + this.jdField_a_of_type_Int + " | offset:" + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.ViewPagerTapBlockView
 * JD-Core Version:    0.7.0.1
 */