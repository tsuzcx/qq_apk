package com.tencent.gdtad.views.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class GdtCircle
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float c;
  
  public GdtCircle()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Bitmap.Config.ARGB_8888);
    }
    Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    paramDrawable.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramDrawable.draw(localCanvas);
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void a(Canvas paramCanvas, Drawable paramDrawable)
  {
    if ((paramCanvas == null) || (paramDrawable == null)) {
      return;
    }
    paramDrawable = new BitmapShader(a(paramDrawable), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(paramDrawable);
    paramCanvas.drawCircle(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.views.image.GdtCircle
 * JD-Core Version:    0.7.0.1
 */