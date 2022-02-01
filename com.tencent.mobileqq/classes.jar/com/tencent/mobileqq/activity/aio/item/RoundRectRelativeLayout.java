package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.widget.RelativeLayout;

public class RoundRectRelativeLayout
  extends RelativeLayout
{
  private int jdField_a_of_type_Int;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private int b;
  private int c;
  private int d = 0;
  
  public RoundRectRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.addRect(0.0F, 0.0F, this.b, this.c, Path.Direction.CCW);
      return;
    }
    int i = Math.min(this.jdField_a_of_type_Int * 2, Math.min(this.b, this.c)) / 2;
    this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(new RectF(0.0F, 0.0F, this.b, this.c), i, i, Path.Direction.CCW);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Integer localInteger = null;
    if (this.jdField_a_of_type_AndroidGraphicsPath != null)
    {
      localInteger = Integer.valueOf(paramCanvas.save());
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    paramCanvas.drawColor(this.d);
    super.dispatchDraw(paramCanvas);
    if (localInteger != null) {
      paramCanvas.restoreToCount(localInteger.intValue());
    }
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    if ((paramInt1 == this.b) && (paramInt2 == this.c)) {
      return;
    }
    this.b = paramInt1;
    this.c = paramInt2;
    a();
  }
  
  public void setAllRadius(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (this.jdField_a_of_type_Int == i) {
      return;
    }
    this.jdField_a_of_type_Int = i;
    a();
    invalidate();
  }
  
  public void setBgColor(int paramInt)
  {
    if (this.d == paramInt) {
      return;
    }
    this.d = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.RoundRectRelativeLayout
 * JD-Core Version:    0.7.0.1
 */