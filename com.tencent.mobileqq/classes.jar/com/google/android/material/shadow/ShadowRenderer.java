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
  private static final float[] jdField_a_of_type_ArrayOfFloat;
  private static final int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private static final float[] jdField_b_of_type_ArrayOfFloat = { 0.0F, 0.0F, 0.5F, 1.0F };
  private static final int[] jdField_b_of_type_ArrayOfInt;
  private int jdField_a_of_type_Int;
  @NonNull
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  private int jdField_b_of_type_Int;
  @NonNull
  private final Paint jdField_b_of_type_AndroidGraphicsPaint;
  private int jdField_c_of_type_Int;
  @NonNull
  private final Paint jdField_c_of_type_AndroidGraphicsPaint;
  private Paint d = new Paint();
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { 0.0F, 0.5F, 1.0F };
    jdField_b_of_type_ArrayOfInt = new int[4];
  }
  
  public ShadowRenderer()
  {
    this(-16777216);
  }
  
  public ShadowRenderer(int paramInt)
  {
    a(paramInt);
    this.d.setColor(0);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(4);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  @NonNull
  public Paint a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = ColorUtils.setAlphaComponent(paramInt, 68);
    this.jdField_b_of_type_Int = ColorUtils.setAlphaComponent(paramInt, 20);
    this.jdField_c_of_type_Int = ColorUtils.setAlphaComponent(paramInt, 0);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
  }
  
  public void a(@NonNull Canvas paramCanvas, @Nullable Matrix paramMatrix, @NonNull RectF paramRectF, int paramInt)
  {
    paramRectF.bottom += paramInt;
    paramRectF.offset(0.0F, -paramInt);
    int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
    arrayOfInt[0] = this.jdField_c_of_type_Int;
    arrayOfInt[1] = this.jdField_b_of_type_Int;
    arrayOfInt[2] = this.jdField_a_of_type_Int;
    this.jdField_c_of_type_AndroidGraphicsPaint.setShader(new LinearGradient(paramRectF.left, paramRectF.top, paramRectF.left, paramRectF.bottom, jdField_a_of_type_ArrayOfInt, jdField_a_of_type_ArrayOfFloat, Shader.TileMode.CLAMP));
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    paramCanvas.drawRect(paramRectF, this.jdField_c_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
  
  public void a(@NonNull Canvas paramCanvas, @Nullable Matrix paramMatrix, @NonNull RectF paramRectF, int paramInt, float paramFloat1, float paramFloat2)
  {
    int i;
    if (paramFloat2 < 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    if (i != 0)
    {
      localObject = jdField_b_of_type_ArrayOfInt;
      localObject[0] = 0;
      localObject[1] = this.jdField_c_of_type_Int;
      localObject[2] = this.jdField_b_of_type_Int;
      localObject[3] = this.jdField_a_of_type_Int;
    }
    else
    {
      localPath.rewind();
      localPath.moveTo(paramRectF.centerX(), paramRectF.centerY());
      localPath.arcTo(paramRectF, paramFloat1, paramFloat2);
      localPath.close();
      f1 = -paramInt;
      paramRectF.inset(f1, f1);
      localObject = jdField_b_of_type_ArrayOfInt;
      localObject[0] = 0;
      localObject[1] = this.jdField_a_of_type_Int;
      localObject[2] = this.jdField_b_of_type_Int;
      localObject[3] = this.jdField_c_of_type_Int;
    }
    float f1 = paramRectF.width() / 2.0F;
    if (f1 <= 0.0F) {
      return;
    }
    float f2 = 1.0F - paramInt / f1;
    float f3 = (1.0F - f2) / 2.0F;
    Object localObject = jdField_b_of_type_ArrayOfFloat;
    localObject[1] = f2;
    localObject[2] = (f3 + f2);
    this.jdField_b_of_type_AndroidGraphicsPaint.setShader(new RadialGradient(paramRectF.centerX(), paramRectF.centerY(), f1, jdField_b_of_type_ArrayOfInt, jdField_b_of_type_ArrayOfFloat, Shader.TileMode.CLAMP));
    paramCanvas.save();
    paramCanvas.concat(paramMatrix);
    if (i == 0)
    {
      paramCanvas.clipPath(localPath, Region.Op.DIFFERENCE);
      paramCanvas.drawPath(localPath, this.d);
    }
    paramCanvas.drawArc(paramRectF, paramFloat1, paramFloat2, true, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shadow.ShadowRenderer
 * JD-Core Version:    0.7.0.1
 */