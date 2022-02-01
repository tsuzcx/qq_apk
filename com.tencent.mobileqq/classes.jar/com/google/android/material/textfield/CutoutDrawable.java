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
  private int jdField_a_of_type_Int;
  @NonNull
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  @NonNull
  private final RectF jdField_a_of_type_AndroidGraphicsRectF;
  
  CutoutDrawable()
  {
    this(null);
  }
  
  CutoutDrawable(@Nullable ShapeAppearanceModel paramShapeAppearanceModel)
  {
    super(paramShapeAppearanceModel);
    b();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
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
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
  }
  
  private void b(@NonNull Canvas paramCanvas)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.jdField_a_of_type_Int = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
      return;
    }
    this.jdField_a_of_type_Int = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null, 31);
  }
  
  private void c(@NonNull Canvas paramCanvas)
  {
    if (!a(getCallback())) {
      paramCanvas.restoreToCount(this.jdField_a_of_type_Int);
    }
  }
  
  void a()
  {
    a(0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat1 != this.jdField_a_of_type_AndroidGraphicsRectF.left) || (paramFloat2 != this.jdField_a_of_type_AndroidGraphicsRectF.top) || (paramFloat3 != this.jdField_a_of_type_AndroidGraphicsRectF.right) || (paramFloat4 != this.jdField_a_of_type_AndroidGraphicsRectF.bottom))
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      invalidateSelf();
    }
  }
  
  void a(@NonNull RectF paramRectF)
  {
    a(paramRectF.left, paramRectF.top, paramRectF.right, paramRectF.bottom);
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty() ^ true;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    a(paramCanvas);
    super.draw(paramCanvas);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    c(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.textfield.CutoutDrawable
 * JD-Core Version:    0.7.0.1
 */