package com.tencent.mm.plugin.appbrand.widget.music;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.r;

public class a
  extends Drawable
{
  private Paint a;
  private Drawable b;
  private RectF c;
  private float d;
  private int e = com.tencent.luggage.wxa.qx.a.d(r.a(), 2131296336);
  
  public a(Drawable paramDrawable)
  {
    this.b = paramDrawable;
    this.a = new Paint(1);
    this.a.setColor(r.d().getColor(2131166376));
  }
  
  public void a(float paramFloat)
  {
    this.d = paramFloat;
    invalidateSelf();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Drawable localDrawable = this.b;
    Rect localRect = localDrawable.getBounds();
    int i = localRect.right;
    int j = localRect.left;
    int k = localRect.bottom;
    int m = localRect.top;
    float f1 = i - j;
    float f2 = k - m;
    i = paramCanvas.save();
    paramCanvas.rotate(this.d, f1 * 0.5F + localRect.left, f2 * 0.5F + localRect.top);
    paramCanvas.drawOval(this.c, this.a);
    localDrawable.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public int getIntrinsicHeight()
  {
    return this.e;
  }
  
  public int getIntrinsicWidth()
  {
    return this.e;
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      return localDrawable.getOpacity();
    }
    return -2;
  }
  
  public void setAlpha(int paramInt)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      localDrawable.setAlpha(paramInt);
    }
    this.a.setAlpha(paramInt);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Drawable localDrawable = this.b;
    if (localDrawable != null) {
      localDrawable.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    this.c = new RectF(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.music.a
 * JD-Core Version:    0.7.0.1
 */