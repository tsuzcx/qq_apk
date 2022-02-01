package com.tencent.biz.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;

class ViewFinderView
  extends View
{
  protected double a;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  Rect jdField_a_of_type_AndroidGraphicsRect;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843410);
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130843427);
  protected int c;
  protected int d = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
  
  public ViewFinderView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1275068416);
  }
  
  protected void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Boolean = true;
      invalidate();
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect);
    this.c = (paramInt4 - paramInt2 - this.d);
    double d1 = this.c;
    Double.isNaN(d1);
    this.jdField_a_of_type_Double = (d1 / 5000.0D);
    this.jdField_a_of_type_AndroidGraphicsRect = localRect;
    invalidate();
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Rect localRect = this.jdField_a_of_type_AndroidGraphicsRect;
    if ((localRect != null) && (localRect.width() != 0) && (localRect.height() != 0))
    {
      paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Int, localRect.top, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, localRect.top, localRect.left, localRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(localRect.right, localRect.top, this.jdField_a_of_type_Int, localRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawRect(0.0F, localRect.bottom, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      if (this.jdField_a_of_type_Boolean)
      {
        double d1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
        double d2 = this.jdField_a_of_type_Double;
        Double.isNaN(d1);
        int i = (int)(d1 * d2) % this.c;
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(localRect.left, localRect.top + i, localRect.right, localRect.top + i + this.d);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        postInvalidateDelayed(20L, localRect.left, localRect.top, localRect.right, localRect.bottom);
      }
    }
    else
    {
      paramCanvas.drawRect(0.0F, 0.0F, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    invalidate();
  }
  
  public void postInvalidateDelayed(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      super.postInvalidateDelayed(paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    postDelayed(new ViewFinderView.1(this, paramInt1, paramInt2, paramInt3, paramInt4), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.ViewFinderView
 * JD-Core Version:    0.7.0.1
 */