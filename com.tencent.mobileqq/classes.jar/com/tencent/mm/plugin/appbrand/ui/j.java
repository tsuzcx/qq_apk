package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

public class j
  extends Drawable
{
  private Paint a;
  private Paint b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int[] h;
  private RectF i;
  
  private j(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.d = paramInt1;
    this.h = paramArrayOfInt;
    this.e = paramInt2;
    this.c = paramInt4;
    this.f = paramInt5;
    this.g = paramInt6;
    this.a = new Paint();
    this.a.setColor(0);
    this.a.setAntiAlias(true);
    this.a.setShadowLayer(paramInt4, paramInt5, paramInt6, paramInt3);
    this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    this.b = new Paint();
    this.b.setAntiAlias(true);
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    paramView.setLayerType(1, null);
    ViewCompat.setBackground(paramView, paramDrawable);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    Object localObject = this.h;
    if (localObject != null) {
      if (localObject.length == 1) {
        this.b.setColor(localObject[0]);
      } else {
        this.b.setShader(new LinearGradient(this.i.left, this.i.height() / 2.0F, this.i.right, this.i.height() / 2.0F, this.h, null, Shader.TileMode.CLAMP));
      }
    }
    if (this.d == 1)
    {
      localObject = this.i;
      int j = this.e;
      paramCanvas.drawRoundRect((RectF)localObject, j, j, this.a);
      localObject = this.i;
      j = this.e;
      paramCanvas.drawRoundRect((RectF)localObject, j, j, this.b);
      return;
    }
    paramCanvas.drawCircle(this.i.centerX(), this.i.centerY(), Math.min(this.i.width(), this.i.height()) / 2.0F, this.a);
    paramCanvas.drawCircle(this.i.centerX(), this.i.centerY(), Math.min(this.i.width(), this.i.height()) / 2.0F, this.b);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.a.setAlpha(paramInt);
  }
  
  public void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    int j = this.c;
    int k = this.f;
    float f1 = paramInt1 + j - k;
    paramInt1 = this.g;
    this.i = new RectF(f1, paramInt2 + j - paramInt1, paramInt3 - j - k, paramInt4 - j - paramInt1);
  }
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.j
 * JD-Core Version:    0.7.0.1
 */