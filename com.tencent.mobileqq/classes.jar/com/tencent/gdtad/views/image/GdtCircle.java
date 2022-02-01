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
  Bitmap a;
  private int b = 0;
  private int c = 0;
  private float d = 0.0F;
  private float e = 0.0F;
  private float f = 0.0F;
  private Paint g = new Paint();
  
  public GdtCircle()
  {
    this.g.setAntiAlias(true);
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    if (this.a == null) {
      this.a = Bitmap.createBitmap(this.b, this.c, Bitmap.Config.ARGB_8888);
    }
    Canvas localCanvas = new Canvas(this.a);
    paramDrawable.setBounds(0, 0, this.b, this.c);
    paramDrawable.draw(localCanvas);
    return this.a;
  }
  
  public void a(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.d = paramFloat1;
    this.e = paramFloat2;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void a(Canvas paramCanvas, Drawable paramDrawable)
  {
    if (paramCanvas != null)
    {
      if (paramDrawable == null) {
        return;
      }
      paramDrawable = new BitmapShader(a(paramDrawable), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
      this.g.setShader(paramDrawable);
      paramCanvas.drawCircle(this.d, this.e, this.f, this.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.image.GdtCircle
 * JD-Core Version:    0.7.0.1
 */