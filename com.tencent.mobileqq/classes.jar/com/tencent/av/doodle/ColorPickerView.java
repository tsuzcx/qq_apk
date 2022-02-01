package com.tencent.av.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ColorPickerView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -65536;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 1;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  private float jdField_c_of_type_Float;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
  private float jdField_d_of_type_Float;
  private Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable = null;
  private float jdField_e_of_type_Float;
  private Drawable jdField_e_of_type_AndroidGraphicsDrawableDrawable = null;
  private float jdField_f_of_type_Float;
  private Drawable jdField_f_of_type_AndroidGraphicsDrawableDrawable = null;
  private float g;
  private float h;
  private float i;
  private float j = -1.0F;
  
  public ColorPickerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ColorPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ColorPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setId(2131373367);
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_Float = paramContext.getDimension(2131297720);
    this.jdField_b_of_type_Float = paramContext.getDimension(2131297719);
    this.jdField_c_of_type_Float = paramContext.getDimension(2131297717);
    this.jdField_d_of_type_Float = paramContext.getDimension(2131297718);
    this.jdField_e_of_type_Float = paramContext.getDimension(2131297723);
    this.jdField_f_of_type_Float = paramContext.getDimension(2131297721);
    this.g = paramContext.getDimension(2131297724);
    this.h = paramContext.getDimension(2131297722);
    this.i = paramContext.getDimension(2131297725);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130842153);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130842154);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130842155);
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130842156);
    this.jdField_f_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130842158);
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130842157);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_Int, PorterDuff.Mode.SRC_ATOP);
    paramContext = this.jdField_e_of_type_AndroidGraphicsDrawableDrawable;
    float f1 = this.g;
    float f2 = this.jdField_e_of_type_Float;
    int k = (int)(f1 - f2 / 2.0F);
    float f3 = this.jdField_b_of_type_Float;
    paramContext.setBounds(k, (int)(f3 / 2.0F), (int)(f1 + f2 / 2.0F), (int)(f3 / 2.0F + this.jdField_f_of_type_Float));
    paramContext = this.jdField_f_of_type_AndroidGraphicsDrawableDrawable;
    f1 = this.g;
    f2 = this.jdField_e_of_type_Float;
    k = (int)(f1 - f2 / 2.0F);
    f3 = this.jdField_b_of_type_Float;
    float f4 = f3 / 2.0F;
    float f5 = this.jdField_f_of_type_Float;
    float f6 = this.h;
    paramContext.setBounds(k, (int)(f4 + f5 + f6), (int)(f1 + f2 / 2.0F), (int)(f3 / 2.0F + f5 + f6 + f2));
    paramContext = DoodleLogic.a();
    this.jdField_a_of_type_Int = paramContext.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramContext.jdField_b_of_type_Int;
    this.j = paramContext.jdField_a_of_type_Float;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    float f1 = this.jdField_b_of_type_Float;
    float f2 = this.jdField_f_of_type_Float;
    float f3 = this.h;
    f1 = (this.j - f1 / 2.0F) / f2;
    Bitmap localBitmap = ((BitmapDrawable)this.jdField_e_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
    int k = MathUtils.a((int)(f1 * localBitmap.getHeight()), 0, localBitmap.getHeight() - 1);
    this.jdField_a_of_type_Int = ((BitmapDrawable)this.jdField_e_of_type_AndroidGraphicsDrawableDrawable).getBitmap().getPixel(localBitmap.getWidth() / 2, k);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_Int, PorterDuff.Mode.SRC_ATOP);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = 1;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    getHeight();
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    float f1 = this.j;
    float f2 = this.jdField_b_of_type_Float;
    f1 = MathUtils.a(f1, f2 / 2.0F, f2 / 2.0F + this.jdField_f_of_type_Float);
    int k = this.jdField_b_of_type_Int;
    Drawable localDrawable1;
    Drawable localDrawable2;
    if (k != 1)
    {
      if (k != 3)
      {
        localDrawable1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localDrawable2 = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      }
      else
      {
        localDrawable1 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        localDrawable2 = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
      }
    }
    else
    {
      localDrawable1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localDrawable2 = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
    }
    f2 = this.g;
    float f3 = this.jdField_c_of_type_Float;
    localDrawable1.setBounds((int)(f2 - f3 / 2.0F), (int)(f1 - f3 / 2.0F), (int)(f2 + f3 / 2.0F), (int)(f3 / 2.0F + f1));
    localDrawable1.draw(paramCanvas);
    if (this.jdField_b_of_type_Int == 1) {
      paramCanvas.drawCircle(this.g, f1, this.jdField_d_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      f2 = this.jdField_b_of_type_Float;
      localDrawable2.setBounds(0, (int)(f1 - f2 / 2.0F), (int)this.jdField_a_of_type_Float, (int)(f1 + f2 / 2.0F));
      localDrawable2.draw(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = this.g - this.jdField_c_of_type_Float / 2.0F;
    boolean bool;
    if ((f1 > f3) && (f1 < f3 + this.i)) {
      bool = true;
    } else {
      bool = false;
    }
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2) {
          return bool;
        }
      }
      else
      {
        if (this.jdField_a_of_type_Boolean)
        {
          this.j = f2;
          a();
          paramMotionEvent = (DoodleSurfaceView)((View)getParent()).findViewById(2131373377);
          if (paramMotionEvent != null) {
            paramMotionEvent.setColor(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.j);
          }
        }
        this.jdField_a_of_type_Boolean = false;
        return bool;
      }
    }
    else
    {
      this.jdField_a_of_type_Boolean = bool;
      if (bool)
      {
        this.j = f2;
        a();
        return bool;
      }
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.j = f2;
      a();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.doodle.ColorPickerView
 * JD-Core Version:    0.7.0.1
 */