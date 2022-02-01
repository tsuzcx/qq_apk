package com.tencent.biz.qqstory.storyHome.discover;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.view.PressDarkImageView;

public class RoundCornerImageView
  extends PressDarkImageView
{
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private boolean jdField_a_of_type_Boolean = false;
  private int b = Color.parseColor("#FFD5D5D5");
  private int c;
  private int d = 0;
  
  public RoundCornerImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.b);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(true);
    if (Build.VERSION.SDK_INT >= 16) {
      super.setLayerType(2, null);
    }
    while (Build.VERSION.SDK_INT < 14) {
      return;
    }
    super.setLayerType(1, null);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    int j = getHeight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    RectF localRectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + i, j - k - m + getPaddingTop());
    if (this.d > 0) {
      i = this.d;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(localRectF, i, i, Path.Direction.CCW);
      this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      super.draw(paramCanvas);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.b);
        if (this.c != 0) {
          this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.c);
        }
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(localRectF, i, i, Path.Direction.CCW);
        paramCanvas.drawRoundRect(localRectF, i, i, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      return;
      i /= 30;
    }
  }
  
  public void setBorder(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setColor(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("should not be less than 0");
    }
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */