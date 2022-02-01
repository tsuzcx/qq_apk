package com.tencent.av.widget.stageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class StageEffectBg
  extends View
{
  static final double[] jdField_a_of_type_ArrayOfDouble = { 0.0D, 5.585053606381854D, 0.6981317007977318D, 4.188790204786391D, 2.094395102393195D, 3.403392041388943D, 2.879793265790644D, 3.141592653589793D };
  private static final float[] c = { 0.8F, 0.6F, 0.6F, 0.5F, 0.5F, 0.4F, 0.4F, 0.3F };
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Camera jdField_a_of_type_AndroidGraphicsCamera = new Camera();
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF(-300.0F, -300.0F, 300.0F, 300.0F);
  private float[] jdField_a_of_type_ArrayOfFloat;
  private float[] b;
  
  public StageEffectBg(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public StageEffectBg(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(1358954495);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(2.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeJoin(Paint.Join.ROUND);
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    this.b = new float[8];
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
    paramCanvas.drawOval(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(40, 40, Bitmap.Config.ARGB_8888);
      localObject = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setColor(-1638439);
      localPaint.setStyle(Paint.Style.FILL);
      localPaint.setMaskFilter(new BlurMaskFilter(10.0F, BlurMaskFilter.Blur.SOLID));
      ((Canvas)localObject).drawOval(new RectF(10.0F, 10.0F, 30.0F, 30.0F), localPaint);
    }
    Object localObject = new Matrix();
    int i = 0;
    while (i < 8)
    {
      ((Matrix)localObject).reset();
      int j = paramCanvas.save();
      paramCanvas.translate(this.jdField_a_of_type_ArrayOfFloat[(i * 2)], this.jdField_a_of_type_ArrayOfFloat[(i * 2 + 1)]);
      float f = this.b[i];
      paramCanvas.scale(f, f);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, -20.0F, -20.0F, null);
      paramCanvas.restoreToCount(j);
      i += 1;
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      paramInt2 = paramInt4 - paramInt2;
      paramInt1 = paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight();
      paramInt3 = getPaddingTop();
      paramInt4 = getPaddingBottom();
      float f3 = paramInt1 / 832.0F;
      float f1 = (paramInt2 - paramInt3 - paramInt4) / 444.0F;
      float f2;
      if (f1 >= f3) {
        f2 = getPaddingLeft() + paramInt1 / 2.0F;
      }
      float f4;
      for (f1 = (paramInt2 - f3 * 444.0F) / 2.0F + 96.770576F * f3;; f1 = f4)
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_a_of_type_AndroidGraphicsCamera.save();
        this.jdField_a_of_type_AndroidGraphicsCamera.rotateX(72.199997F);
        this.jdField_a_of_type_AndroidGraphicsCamera.getMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
        this.jdField_a_of_type_AndroidGraphicsCamera.restore();
        this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(f3, f3);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f2, f1);
        paramInt1 = 0;
        while (paramInt1 < 8)
        {
          double d = jdField_a_of_type_ArrayOfDouble[paramInt1];
          this.jdField_a_of_type_ArrayOfFloat[(paramInt1 * 2)] = ((float)(Math.sin(d) * 300.0D));
          this.jdField_a_of_type_ArrayOfFloat[(paramInt1 * 2 + 1)] = ((float)(Math.cos(d) * 300.0D));
          this.b[paramInt1] = (c[paramInt1] * f3);
          paramInt1 += 1;
        }
        f2 = getPaddingLeft() + paramInt1 / 2.0F;
        f4 = getPaddingTop() + 96.770576F * f1;
        f3 = f1;
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(this.jdField_a_of_type_ArrayOfFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.widget.stageview.StageEffectBg
 * JD-Core Version:    0.7.0.1
 */