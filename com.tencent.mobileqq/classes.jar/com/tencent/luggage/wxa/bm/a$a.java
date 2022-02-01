package com.tencent.luggage.wxa.bm;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class a$a
  extends Drawable
{
  Paint a = new Paint(1);
  RectF b = new RectF();
  
  private a$a(a parama)
  {
    this.a.setColor(-12748166);
    this.a.setStyle(Paint.Style.FILL);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    float f1 = paramCanvas.getHeight() / 2.0F;
    RectF localRectF = this.b;
    localRectF.top = 0.0F;
    localRectF.left = 0.0F;
    float f2 = 2.0F * f1;
    localRectF.bottom = f2;
    localRectF.right = f2;
    paramCanvas.drawArc(localRectF, 90.0F, 180.0F, false, this.a);
    this.b.left = (paramCanvas.getWidth() - f2);
    localRectF = this.b;
    localRectF.top = 0.0F;
    localRectF.right = paramCanvas.getWidth();
    this.b.bottom = paramCanvas.getHeight();
    paramCanvas.drawArc(this.b, -90.0F, 180.0F, false, this.a);
    paramCanvas.drawRect(f1 - 1.0F, 0.0F, this.c.getWidth() - f1 + 1.0F, this.c.getHeight(), this.a);
  }
  
  public int getOpacity()
  {
    return -1;
  }
  
  public void setAlpha(@IntRange(from=0L, to=255L) int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bm.a.a
 * JD-Core Version:    0.7.0.1
 */