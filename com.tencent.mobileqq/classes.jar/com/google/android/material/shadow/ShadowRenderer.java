package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Shader.TileMode;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ShadowRenderer
{
  private static final int[] g = new int[3];
  private static final float[] h = { 0.0F, 0.5F, 1.0F };
  private static final int[] i = new int[4];
  private static final float[] j = { 0.0F, 0.0F, 0.5F, 1.0F };
  @NonNull
  private final Paint a = new Paint();
  @NonNull
  private final Paint b;
  @NonNull
  private final Paint c;
  private int d;
  private int e;
  private int f;
  private final Path k = new Path();
  private Paint l = new Paint();
  
  public ShadowRenderer()
  {
    this(-16777216);
  }
  
  public ShadowRenderer(int paramInt)
  {
    a(paramInt);
    this.l.setColor(0);
    this.b = new Paint(4);
    this.b.setStyle(Paint.Style.FILL);
    this.c = new Paint(this.b);
  }
  
  @NonNull
  public Paint a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    this.d = ColorUtils.setAlphaComponent(paramInt, 68);
    this.e = ColorUtils.setAlphaComponent(paramInt, 20);
    this.f = ColorUtils.setAlphaComponent(paramInt, 0);
    this.a.setColor(this.d);
  }
  
  public void a(@NonNull Canvas paramCanvas, @Nullable Matrix paramMatrix, @NonNull RectF paramRectF, int paramInt)
  {
    paramRectF.bottom += paramInt;
    paramRectF.offset(0.0F, -paramInt);
    int[] arrayOfInt = g;
    arrayOfInt[0] = this.f;
    arrayOfInt[1] = this.e;
    arrayOfInt[2] = this.d;
    this.c.setShader(new LinearGradient(paramRectF.left, paramRectF.top, paramRectF.left, paramRectF.bottom, g, h, Shader.TileMode.CLAMP));
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    paramCanvas.drawRect(paramRectF, this.c);
    paramCanvas.restore();
  }
  
  public void a(@NonNull Canvas paramCanvas, @Nullable Matrix paramMatrix, @NonNull RectF paramRectF, int paramInt, float paramFloat1, float paramFloat2)
  {
    int m;
    if (paramFloat2 < 0.0F) {
      m = 1;
    } else {
      m = 0;
    }
    Path localPath = this.k;
    if (m != 0)
    {
      localObject = i;
      localObject[0] = 0;
      localObject[1] = this.f;
      localObject[2] = this.e;
      localObject[3] = this.d;
    }
    else
    {
      localPath.rewind();
      localPath.moveTo(paramRectF.centerX(), paramRectF.centerY());
      localPath.arcTo(paramRectF, paramFloat1, paramFloat2);
      localPath.close();
      f1 = -paramInt;
      paramRectF.inset(f1, f1);
      localObject = i;
      localObject[0] = 0;
      localObject[1] = this.d;
      localObject[2] = this.e;
      localObject[3] = this.f;
    }
    float f1 = paramRectF.width() / 2.0F;
    if (f1 <= 0.0F) {
      return;
    }
    float f2 = 1.0F - paramInt / f1;
    float f3 = (1.0F - f2) / 2.0F;
    Object localObject = j;
    localObject[1] = f2;
    localObject[2] = (f3 + f2);
    this.b.setShader(new RadialGradient(paramRectF.centerX(), paramRectF.centerY(), f1, i, j, Shader.TileMode.CLAMP));
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    if (m == 0)
    {
      paramCanvas.clipPath(localPath, Region.Op.DIFFERENCE);
      paramCanvas.drawPath(localPath, this.l);
    }
    paramCanvas.drawArc(paramRectF, paramFloat1, paramFloat2, true, this.b);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shadow.ShadowRenderer
 * JD-Core Version:    0.7.0.1
 */