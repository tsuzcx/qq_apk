package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import bieb;
import com.tencent.image.URLImageView;

public class RoundRectUrlImageView
  extends URLImageView
{
  private int jdField_a_of_type_Int;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  private int e;
  
  public RoundRectUrlImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundRectUrlImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoundRectUrlImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
  
  private void b()
  {
    Object localObject = getDrawable();
    if (localObject == null) {}
    do
    {
      int i;
      int j;
      do
      {
        return;
        i = ((Drawable)localObject).getIntrinsicWidth();
        j = ((Drawable)localObject).getIntrinsicHeight();
      } while ((i == this.d) && (j == this.e));
      this.d = i;
      this.e = j;
    } while ((this.d == 0) && (this.e == 0));
    if (this.d * this.c > this.b * this.e) {}
    for (float f = this.c / this.e;; f = this.b / this.d)
    {
      localObject = new Matrix();
      ((Matrix)localObject).setScale(f, f);
      setImageMatrix((Matrix)localObject);
      return;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    Integer localInteger = null;
    if (this.jdField_a_of_type_AndroidGraphicsPath != null)
    {
      localInteger = Integer.valueOf(paramCanvas.save());
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    super.dispatchDraw(paramCanvas);
    if (localInteger != null) {
      paramCanvas.restoreToCount(localInteger.intValue());
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    b();
    Integer localInteger = null;
    if (this.jdField_a_of_type_AndroidGraphicsPath != null)
    {
      localInteger = Integer.valueOf(paramCanvas.save());
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    super.onDraw(paramCanvas);
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
    b();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isClickable()) || (!isEnabled()) || (!this.jdField_a_of_type_Boolean)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      bieb.a(this);
      super.onTouchEvent(paramMotionEvent);
      return true;
      bieb.b(this);
    }
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
  
  public void setEnableEffect(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.RoundRectUrlImageView
 * JD-Core Version:    0.7.0.1
 */