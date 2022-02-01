package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

class CutoutDrawable
  extends MaterialShapeDrawable
{
  @NonNull
  private final Paint a = new Paint(1);
  @NonNull
  private final RectF b;
  private int c;
  
  CutoutDrawable()
  {
    this(null);
  }
  
  CutoutDrawable(@Nullable ShapeAppearanceModel paramShapeAppearanceModel)
  {
    super(paramShapeAppearanceModel);
    c();
    this.b = new RectF();
  }
  
  private void a(@NonNull Canvas paramCanvas)
  {
    Drawable.Callback localCallback = getCallback();
    if (a(localCallback))
    {
      paramCanvas = (View)localCallback;
      if (paramCanvas.getLayerType() != 2) {
        paramCanvas.setLayerType(2, null);
      }
    }
    else
    {
      b(paramCanvas);
    }
  }
  
  private boolean a(Drawable.Callback paramCallback)
  {
    return paramCallback instanceof View;
  }
  
  private void b(@NonNull Canvas paramCanvas)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.c = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
      return;
    }
    this.c = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
  }
  
  private void c()
  {
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    this.a.setColor(-1);
    this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
  }
  
  private void c(@NonNull Canvas paramCanvas)
  {
    if (!a(getCallback())) {
      paramCanvas.restoreToCount(this.c);
    }
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat1 != this.b.left) || (paramFloat2 != this.b.top) || (paramFloat3 != this.b.right) || (paramFloat4 != this.b.bottom))
    {
      this.b.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      invalidateSelf();
    }
  }
  
  void a(@NonNull RectF paramRectF)
  {
    a(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
  }
  
  boolean a()
  {
    return this.b.isEmpty() ^ true;
  }
  
  void b()
  {
    a(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    a(paramCanvas);
    super.draw(paramCanvas);
    paramCanvas.drawRect(this.b, this.a);
    c(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.CutoutDrawable
 * JD-Core Version:    0.7.0.1
 */