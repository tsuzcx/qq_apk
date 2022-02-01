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
    setId(2131373795);
    paramContext = paramContext.getResources();
    this.jdField_a_of_type_Float = paramContext.getDimension(2131297729);
    this.jdField_b_of_type_Float = paramContext.getDimension(2131297728);
    this.jdField_c_of_type_Float = paramContext.getDimension(2131297726);
    this.jdField_d_of_type_Float = paramContext.getDimension(2131297727);
    this.jdField_e_of_type_Float = paramContext.getDimension(2131297732);
    this.jdField_f_of_type_Float = paramContext.getDimension(2131297730);
    this.g = paramContext.getDimension(2131297733);
    this.h = paramContext.getDimension(2131297731);
    this.i = paramContext.getDimension(2131297734);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130842255);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130842256);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130842257);
    this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130842258);
    this.jdField_f_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130842260);
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable = paramContext.getDrawable(2130842259);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_Int, PorterDuff.Mode.SRC_ATOP);
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable.setBounds((int)(this.g - this.jdField_e_of_type_Float / 2.0F), (int)(this.jdField_b_of_type_Float / 2.0F), (int)(this.g + this.jdField_e_of_type_Float / 2.0F), (int)(this.jdField_b_of_type_Float / 2.0F + this.jdField_f_of_type_Float));
    this.jdField_f_of_type_AndroidGraphicsDrawableDrawable.setBounds((int)(this.g - this.jdField_e_of_type_Float / 2.0F), (int)(this.jdField_b_of_type_Float / 2.0F + this.jdField_f_of_type_Float + this.h), (int)(this.g + this.jdField_e_of_type_Float / 2.0F), (int)(this.jdField_b_of_type_Float / 2.0F + this.jdField_f_of_type_Float + this.h + this.jdField_e_of_type_Float));
    paramContext = DoodleLogic.a();
    this.jdField_a_of_type_Int = paramContext.jdField_a_of_type_Int;
    this.jdField_b_of_type_Int = paramContext.jdField_b_of_type_Int;
    this.j = paramContext.jdField_a_of_type_Float;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    float f1 = this.jdField_b_of_type_Float / 2.0F;
    f1 = this.jdField_f_of_type_Float;
    f1 = this.h / 2.0F;
    f1 = (this.j - this.jdField_b_of_type_Float / 2.0F) / this.jdField_f_of_type_Float;
    Bitmap localBitmap = ((BitmapDrawable)this.jdField_e_of_type_AndroidGraphicsDrawableDrawable).getBitmap();
    int k = MathUtils.a((int)(localBitmap.getHeight() * f1), 0, localBitmap.getHeight() - 1);
    this.jdField_a_of_type_Int = ((BitmapDrawable)this.jdField_e_of_type_AndroidGraphicsDrawableDrawable).getBitmap().getPixel(localBitmap.getWidth() / 2, k);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(this.jdField_a_of_type_Int, PorterDuff.Mode.SRC_ATOP);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = 1;
    invalidate();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    getHeight();
    this.jdField_e_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    float f1 = MathUtils.a(this.j, this.jdField_b_of_type_Float / 2.0F, this.jdField_b_of_type_Float / 2.0F + this.jdField_f_of_type_Float);
    Drawable localDrawable2;
    Drawable localDrawable1;
    switch (this.jdField_b_of_type_Int)
    {
    case 2: 
    default: 
      localDrawable2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localDrawable1 = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
    }
    for (;;)
    {
      localDrawable2.setBounds((int)(this.g - this.jdField_c_of_type_Float / 2.0F), (int)(f1 - this.jdField_c_of_type_Float / 2.0F), (int)(this.g + this.jdField_c_of_type_Float / 2.0F), (int)(this.jdField_c_of_type_Float / 2.0F + f1));
      localDrawable2.draw(paramCanvas);
      if (this.jdField_b_of_type_Int == 1) {
        paramCanvas.drawCircle(this.g, f1, this.jdField_d_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        localDrawable1.setBounds(0, (int)(f1 - this.jdField_b_of_type_Float / 2.0F), (int)this.jdField_a_of_type_Float, (int)(f1 + this.jdField_b_of_type_Float / 2.0F));
        localDrawable1.draw(paramCanvas);
      }
      return;
      localDrawable2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localDrawable1 = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable;
      continue;
      localDrawable2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      localDrawable1 = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return bool;
        bool = false;
        break;
        this.jdField_a_of_type_Boolean = bool;
        if (bool)
        {
          this.j = f2;
          a();
          return bool;
        }
      } while (!this.jdField_a_of_type_Boolean);
      this.j = f2;
      a();
      return bool;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.j = f2;
      a();
      paramMotionEvent = (DoodleSurfaceView)((View)getParent()).findViewById(2131373805);
      if (paramMotionEvent != null) {
        paramMotionEvent.setColor(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.j);
      }
    }
    this.jdField_a_of_type_Boolean = false;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.doodle.ColorPickerView
 * JD-Core Version:    0.7.0.1
 */