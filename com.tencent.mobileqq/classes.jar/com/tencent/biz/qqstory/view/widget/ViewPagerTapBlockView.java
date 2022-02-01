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
    paramContext = paramContext.getTheme();
    int[] arrayOfInt = R.styleable.ViewPagerTapBlockView;
    int i = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, arrayOfInt, paramInt, 0);
    int j = paramContext.getIndexCount();
    paramInt = i;
    while (paramInt < j)
    {
      i = paramContext.getIndex(paramInt);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3) {
              this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(i, (int)TypedValue.applyDimension(1, 56.0F, getResources().getDisplayMetrics()));
            }
          }
          else {
            this.d = paramContext.getDimensionPixelSize(i, (int)TypedValue.applyDimension(1, 0.0F, getResources().getDisplayMetrics()));
          }
        }
        else {
          this.b = paramContext.getDimensionPixelSize(i, (int)TypedValue.applyDimension(1, 3.0F, getResources().getDisplayMetrics()));
        }
      }
      else {
        this.c = paramContext.getColor(i, -1);
      }
      paramInt += 1;
    }
    paramContext.recycle();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
    int i = this.d;
    paramCanvas.drawRect(i, 0.0F, this.jdField_a_of_type_Int + i, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ViewPagerTapBlockView width:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" | offset:");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.ViewPagerTapBlockView
 * JD-Core Version:    0.7.0.1
 */