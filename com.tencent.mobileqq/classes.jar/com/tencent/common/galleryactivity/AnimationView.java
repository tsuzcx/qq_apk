package com.tencent.common.galleryactivity;

import aagl;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import bjnf;

public class AnimationView
  extends View
{
  float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 3;
  long jdField_a_of_type_Long = 0L;
  private aagl jdField_a_of_type_Aagl;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  AccelerateDecelerateInterpolator jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
  bjnf jdField_a_of_type_Bjnf = new bjnf();
  public boolean a;
  float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 3;
  private long jdField_b_of_type_Long;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long = 350L;
  private Rect jdField_c_of_type_AndroidGraphicsRect;
  boolean jdField_c_of_type_Boolean = false;
  float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private Rect jdField_d_of_type_AndroidGraphicsRect;
  boolean jdField_d_of_type_Boolean = true;
  float jdField_e_of_type_Float;
  private int jdField_e_of_type_Int;
  private Rect jdField_e_of_type_AndroidGraphicsRect;
  private boolean jdField_e_of_type_Boolean;
  private Rect jdField_f_of_type_AndroidGraphicsRect = new Rect();
  private boolean jdField_f_of_type_Boolean;
  private Rect g = new Rect();
  
  public AnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_AndroidGraphicsRect = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.copyBounds();
    this.g = new Rect(0, 0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.g);
  }
  
  private void a(Canvas paramCanvas)
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return;
    case 1: 
      if ((this.jdField_a_of_type_AndroidGraphicsRect == null) || (this.jdField_b_of_type_AndroidGraphicsRect == null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
      {
        this.jdField_a_of_type_Int = 3;
        this.jdField_e_of_type_Boolean = false;
        if (this.jdField_a_of_type_Aagl != null) {
          this.jdField_a_of_type_Aagl.f();
        }
        super.onDraw(paramCanvas);
        return;
      }
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Int = 2;
      paramCanvas.save();
    case 2: 
      float f1 = (float)(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long) / (float)this.jdField_c_of_type_Long;
      if (f1 >= 1.0F) {
        this.jdField_a_of_type_Int = 3;
      }
      f1 = Math.min(f1, 1.0F);
      f1 = 1.0F - this.jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator.getInterpolation(f1);
      Rect localRect1 = this.jdField_a_of_type_AndroidGraphicsRect;
      Rect localRect2 = this.jdField_b_of_type_AndroidGraphicsRect;
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      localRect2 = new Rect(localRect2.left + arrayOfInt[0], localRect2.top + arrayOfInt[1], localRect2.right + arrayOfInt[0], localRect2.bottom + arrayOfInt[1]);
      int i = localRect2.width();
      int j = localRect2.height();
      float f2 = localRect1.width();
      float f3 = localRect1.height();
      float f4 = f2 / i;
      float f5 = f3 / j;
      paramCanvas.save();
      if (this.jdField_c_of_type_Int == 1)
      {
        paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f5) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f5) * f1);
        paramCanvas.scale(1.0F - (1.0F - f5) * f1, 1.0F - (1.0F - f5) * f1);
        if (this.jdField_a_of_type_Boolean)
        {
          f2 = (i - j) / 2.0F;
          paramCanvas.translate(-f2 * f1, 0.0F);
          paramCanvas.clipRect(localRect2.left - arrayOfInt[0] + f2 * f1, localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0] - f1 * f2, localRect2.bottom - arrayOfInt[1]);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        paramCanvas.restore();
        invalidate();
        return;
        paramCanvas.clipRect(localRect2.left - arrayOfInt[0], localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0] - f1 * (i - f2 / f5), localRect2.bottom - arrayOfInt[1]);
        continue;
        if (this.jdField_c_of_type_Int == 2)
        {
          paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f4) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f4) * f1);
          paramCanvas.scale(1.0F - (1.0F - f4) * f1, 1.0F - (1.0F - f4) * f1);
          if (this.jdField_a_of_type_Boolean)
          {
            f2 = (j - i) / 2.0F;
            paramCanvas.translate(0.0F, -f2 * f1);
            paramCanvas.clipRect(localRect2.left - arrayOfInt[0], localRect2.top - arrayOfInt[1] + f2 * f1, localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - f1 * f2);
          }
          else
          {
            paramCanvas.clipRect(localRect2.left - arrayOfInt[0], localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - f1 * (j - f3 / f4));
          }
        }
        else
        {
          paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f4) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f5) * f1);
          paramCanvas.scale(1.0F - (1.0F - f4) * f1, 1.0F - f1 * (1.0F - f5));
        }
      }
    }
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_a_of_type_Aagl != null) {
      this.jdField_a_of_type_Aagl.f();
    }
    paramCanvas.save();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    paramCanvas.restore();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_c_of_type_AndroidGraphicsRect);
  }
  
  private void b(Canvas paramCanvas)
  {
    switch (this.jdField_b_of_type_Int)
    {
    default: 
    case 1: 
      do
      {
        return;
        if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && (this.jdField_b_of_type_AndroidGraphicsRect != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
          break;
        }
        this.jdField_b_of_type_Int = 3;
        this.jdField_f_of_type_Boolean = false;
        super.onDraw(paramCanvas);
      } while (this.jdField_a_of_type_Aagl == null);
      this.jdField_a_of_type_Aagl.i();
      return;
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_b_of_type_Int = 2;
    case 2: 
      float f1 = (float)(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long) / (float)this.jdField_c_of_type_Long;
      if (f1 >= 1.0F) {
        this.jdField_b_of_type_Int = 3;
      }
      f1 = Math.min(f1, 1.0F);
      f1 = this.jdField_a_of_type_Bjnf.getInterpolation(f1);
      Rect localRect1 = this.jdField_a_of_type_AndroidGraphicsRect;
      Rect localRect2 = this.jdField_b_of_type_AndroidGraphicsRect;
      int[] arrayOfInt = new int[2];
      getLocationInWindow(arrayOfInt);
      localRect2 = new Rect(localRect2.left + arrayOfInt[0], localRect2.top + arrayOfInt[1], localRect2.right + arrayOfInt[0], localRect2.bottom + arrayOfInt[1]);
      int i = localRect2.right - localRect2.left;
      int j = localRect2.bottom - localRect2.top;
      float f2 = localRect1.right - localRect1.left + this.jdField_d_of_type_Int;
      float f3 = localRect1.bottom - localRect1.top + this.jdField_e_of_type_Int;
      float f4 = f2 / i;
      float f5 = f3 / j;
      paramCanvas.save();
      if (this.jdField_c_of_type_Int == 1)
      {
        paramCanvas.translate((localRect1.left - arrayOfInt[0] - this.jdField_d_of_type_Int - (localRect2.left - arrayOfInt[0]) * f5) * f1, (localRect1.top - arrayOfInt[1] - this.jdField_e_of_type_Int - (localRect2.top - arrayOfInt[1]) * f5) * f1);
        paramCanvas.scale(1.0F - (1.0F - f5) * f1, 1.0F - (1.0F - f5) * f1);
        if (this.jdField_a_of_type_Boolean)
        {
          f2 = (i - j) / 2.0F;
          paramCanvas.translate(-f2 * f1, 0.0F);
          paramCanvas.clipRect(localRect2.left - arrayOfInt[0] + f2 * f1, localRect2.top - arrayOfInt[1], localRect2.right - arrayOfInt[0] - f1 * f2, localRect2.bottom - arrayOfInt[1]);
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        paramCanvas.restore();
        invalidate();
        return;
        paramCanvas.clipRect(localRect2.left - arrayOfInt[0] + this.jdField_d_of_type_Int / (1.0F - (1.0F - f5) * f1) * f1, localRect2.top - arrayOfInt[1] + this.jdField_e_of_type_Int / (1.0F - (1.0F - f5) * f1) * f1, localRect2.right - arrayOfInt[0] - f1 * (i - f2 / f5), localRect2.bottom - arrayOfInt[1]);
        continue;
        if (this.jdField_c_of_type_Int == 2)
        {
          paramCanvas.translate((localRect1.left - arrayOfInt[0] - this.jdField_d_of_type_Int - (localRect2.left - arrayOfInt[0]) * f4) * f1, (localRect1.top - arrayOfInt[1] - this.jdField_e_of_type_Int - (localRect2.top - arrayOfInt[1]) * f4) * f1);
          paramCanvas.scale(1.0F - (1.0F - f4) * f1, 1.0F - (1.0F - f4) * f1);
          if (this.jdField_a_of_type_Boolean)
          {
            f2 = (j - i) / 2.0F;
            paramCanvas.translate(0.0F, -f2 * f1);
            paramCanvas.clipRect(localRect2.left - arrayOfInt[0], localRect2.top - arrayOfInt[1] + f2 * f1, localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - f1 * f2);
          }
          else
          {
            paramCanvas.clipRect(localRect2.left - arrayOfInt[0] + this.jdField_d_of_type_Int / (1.0F - (1.0F - f4) * f1) * f1, localRect2.top - arrayOfInt[1] + this.jdField_e_of_type_Int / (1.0F - (1.0F - f4) * f1) * f1, localRect2.right - arrayOfInt[0], localRect2.bottom - arrayOfInt[1] - f1 * (j - f3 / f4));
          }
        }
        else
        {
          paramCanvas.translate((localRect1.left - arrayOfInt[0] - (localRect2.left - arrayOfInt[0]) * f4) * f1, (localRect1.top - arrayOfInt[1] - (localRect2.top - arrayOfInt[1]) * f5) * f1);
          paramCanvas.scale(1.0F - (1.0F - f4) * f1, 1.0F - f1 * (1.0F - f5));
        }
      }
    }
    if (this.jdField_a_of_type_Aagl != null) {
      this.jdField_a_of_type_Aagl.i();
    }
    this.jdField_f_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(this.jdField_c_of_type_AndroidGraphicsRect);
  }
  
  private void c(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    float f1;
    if (this.jdField_a_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      this.jdField_e_of_type_Float = ((float)l / (float)this.jdField_c_of_type_Long);
      if (!this.jdField_d_of_type_Boolean) {
        break label468;
      }
      this.jdField_e_of_type_Float = this.jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator.getInterpolation(this.jdField_e_of_type_Float);
      f1 = 1.0F - this.jdField_e_of_type_Float;
      if (this.jdField_b_of_type_Boolean)
      {
        if (l > this.jdField_c_of_type_Long) {
          break label486;
        }
        this.jdField_a_of_type_Float = (this.jdField_d_of_type_AndroidGraphicsRect.top * f1 + this.jdField_e_of_type_AndroidGraphicsRect.top * this.jdField_e_of_type_Float);
        this.jdField_b_of_type_Float = (this.jdField_d_of_type_AndroidGraphicsRect.bottom * f1 + this.jdField_e_of_type_AndroidGraphicsRect.bottom * this.jdField_e_of_type_Float);
        this.jdField_c_of_type_Float = (this.jdField_d_of_type_AndroidGraphicsRect.left * f1 + this.jdField_e_of_type_AndroidGraphicsRect.left * this.jdField_e_of_type_Float);
        this.jdField_d_of_type_Float = (this.jdField_d_of_type_AndroidGraphicsRect.right * f1 + this.jdField_e_of_type_AndroidGraphicsRect.right * this.jdField_e_of_type_Float);
        this.jdField_f_of_type_AndroidGraphicsRect.set((int)this.jdField_c_of_type_Float, (int)this.jdField_a_of_type_Float, (int)this.jdField_d_of_type_Float, (int)this.jdField_b_of_type_Float);
        this.jdField_a_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.top * f1 + this.jdField_b_of_type_AndroidGraphicsRect.top * this.jdField_e_of_type_Float);
        this.jdField_b_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.bottom * f1 + this.jdField_b_of_type_AndroidGraphicsRect.bottom * this.jdField_e_of_type_Float);
        this.jdField_c_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.left * f1 + this.jdField_b_of_type_AndroidGraphicsRect.left * this.jdField_e_of_type_Float);
        this.jdField_d_of_type_Float = (this.jdField_a_of_type_AndroidGraphicsRect.right * f1 + this.jdField_b_of_type_AndroidGraphicsRect.right * this.jdField_e_of_type_Float);
        this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_Float, this.jdField_a_of_type_Float, this.jdField_d_of_type_Float, this.jdField_b_of_type_Float);
      }
    }
    for (;;)
    {
      f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / this.jdField_f_of_type_AndroidGraphicsRect.width();
      float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / this.jdField_f_of_type_AndroidGraphicsRect.height();
      paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRectF.left - this.jdField_f_of_type_AndroidGraphicsRect.left * f1, this.jdField_a_of_type_AndroidGraphicsRectF.top - this.jdField_f_of_type_AndroidGraphicsRect.top * f2);
      paramCanvas.scale(f1, f2);
      paramCanvas.clipRect(this.jdField_f_of_type_AndroidGraphicsRect);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      invalidate();
      paramCanvas.restore();
      return;
      label468:
      this.jdField_e_of_type_Float = this.jdField_a_of_type_Bjnf.getInterpolation(this.jdField_e_of_type_Float);
      break;
      label486:
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_Aagl != null) {
        if (this.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_Aagl.f();
        } else {
          this.jdField_a_of_type_Aagl.i();
        }
      }
    }
  }
  
  public void a(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.jdField_b_of_type_Int = 1;
    this.jdField_f_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_c_of_type_AndroidGraphicsRect = paramDrawable.copyBounds();
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect1;
    this.jdField_b_of_type_AndroidGraphicsRect = paramRect2;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    this.jdField_e_of_type_Int = paramInt3;
    this.jdField_c_of_type_Long = paramLong;
    if (this.jdField_a_of_type_Aagl != null) {
      this.jdField_a_of_type_Aagl.h();
    }
    invalidate();
  }
  
  public void a(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_c_of_type_AndroidGraphicsRect = paramDrawable.copyBounds();
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect1;
    this.jdField_b_of_type_AndroidGraphicsRect = paramRect2;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_c_of_type_Long = paramLong;
    if (this.jdField_a_of_type_Aagl != null) {
      this.jdField_a_of_type_Aagl.g();
    }
    invalidate();
  }
  
  public void a(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, long paramLong)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    paramRect3 = new Rect(paramRect3);
    paramRect3.offset(arrayOfInt[0], -arrayOfInt[1]);
    this.jdField_d_of_type_AndroidGraphicsRect = paramRect1;
    this.jdField_e_of_type_AndroidGraphicsRect = paramRect2;
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect3;
    this.jdField_b_of_type_AndroidGraphicsRect = paramRect4;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_c_of_type_Long = paramLong;
    a();
    if (this.jdField_a_of_type_Aagl != null) {
      this.jdField_a_of_type_Aagl.g();
    }
  }
  
  public void b(Drawable paramDrawable, Rect paramRect1, Rect paramRect2, Rect paramRect3, Rect paramRect4, long paramLong)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    int[] arrayOfInt = new int[2];
    getLocationInWindow(arrayOfInt);
    paramRect3 = new Rect(paramRect3);
    paramRect3.offset(arrayOfInt[0], -arrayOfInt[1]);
    this.jdField_d_of_type_AndroidGraphicsRect = paramRect2;
    this.jdField_e_of_type_AndroidGraphicsRect = paramRect1;
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect4;
    this.jdField_b_of_type_AndroidGraphicsRect = paramRect3;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_c_of_type_Long = paramLong;
    a();
    if (this.jdField_a_of_type_Aagl != null) {
      this.jdField_a_of_type_Aagl.h();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      c(paramCanvas);
      return;
    }
    if (this.jdField_e_of_type_Boolean)
    {
      a(paramCanvas);
      return;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public void setAnimationListener(aagl paramaagl)
  {
    this.jdField_a_of_type_Aagl = paramaagl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.AnimationView
 * JD-Core Version:    0.7.0.1
 */