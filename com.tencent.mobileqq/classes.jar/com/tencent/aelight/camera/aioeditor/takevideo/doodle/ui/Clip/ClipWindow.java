package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import java.lang.reflect.Array;

public class ClipWindow
  implements ClipConstant
{
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_a_of_type_Boolean = false;
  private float[][] jdField_a_of_type_Array2dOfFloat = (float[][])Array.newInstance(Float.TYPE, new int[] { 2, 4 });
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_b_of_type_Boolean = true;
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_c_of_type_Boolean = false;
  private RectF jdField_d_of_type_AndroidGraphicsRectF = new RectF();
  private boolean jdField_d_of_type_Boolean = false;
  private float[] jdField_d_of_type_ArrayOfFloat = new float[16];
  private float[] e = new float[32];
  
  public ClipWindow()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.SQUARE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(201326592);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(24.0F);
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    c(true);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramFloat1, paramFloat2);
    ClipUtils.a(this.jdField_d_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsRectF, 60.0F);
    this.jdField_c_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
  }
  
  public RectF a()
  {
    return this.jdField_c_of_type_AndroidGraphicsRectF;
  }
  
  public RectF a(float paramFloat1, float paramFloat2)
  {
    RectF localRectF = new RectF(this.jdField_a_of_type_AndroidGraphicsRectF);
    localRectF.offset(paramFloat1, paramFloat2);
    return localRectF;
  }
  
  public ClipConstant.Anchor a(float paramFloat1, float paramFloat2)
  {
    if ((ClipConstant.Anchor.isCohesionContains(this.jdField_a_of_type_AndroidGraphicsRectF, -48.0F, paramFloat1, paramFloat2)) && (!ClipConstant.Anchor.isCohesionContains(this.jdField_a_of_type_AndroidGraphicsRectF, 48.0F, paramFloat1, paramFloat2)))
    {
      Object localObject = ClipConstant.Anchor.cohesion(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F);
      int i = 0;
      int k;
      for (int j = 0; i < localObject.length; j = k)
      {
        k = j;
        if (Math.abs(localObject[i] - new float[] { paramFloat1, paramFloat2 }[(i >> 1)]) < 48.0F) {
          k = j | 1 << i;
        }
        i += 1;
      }
      localObject = ClipConstant.Anchor.valueOf(j);
      if (localObject != null) {
        this.jdField_d_of_type_Boolean = false;
      }
      return localObject;
    }
    return null;
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(this.jdField_b_of_type_AndroidGraphicsRectF.left + (this.jdField_c_of_type_AndroidGraphicsRectF.left - this.jdField_b_of_type_AndroidGraphicsRectF.left) * paramFloat, this.jdField_b_of_type_AndroidGraphicsRectF.top + (this.jdField_c_of_type_AndroidGraphicsRectF.top - this.jdField_b_of_type_AndroidGraphicsRectF.top) * paramFloat, this.jdField_b_of_type_AndroidGraphicsRectF.right + (this.jdField_c_of_type_AndroidGraphicsRectF.right - this.jdField_b_of_type_AndroidGraphicsRectF.right) * paramFloat, this.jdField_b_of_type_AndroidGraphicsRectF.bottom + (this.jdField_c_of_type_AndroidGraphicsRectF.bottom - this.jdField_b_of_type_AndroidGraphicsRectF.bottom) * paramFloat);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.jdField_d_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramFloat1, paramFloat2 * 1.0F);
    if (!this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty())
    {
      ClipUtils.a(this.jdField_d_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsRectF);
      this.jdField_c_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width();
    int k = 0;
    float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.height();
    int i = 0;
    int j;
    Object localObject;
    while (i < this.jdField_a_of_type_Array2dOfFloat.length)
    {
      j = 0;
      for (;;)
      {
        localObject = this.jdField_a_of_type_Array2dOfFloat;
        if (j >= localObject[i].length) {
          break;
        }
        localObject[i][j] = (new float[] { f1, f2 }[i] * jdField_a_of_type_ArrayOfFloat[j]);
        j += 1;
      }
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = this.jdField_d_of_type_ArrayOfFloat;
      j = k;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = this.jdField_a_of_type_Array2dOfFloat[(i & 0x1)][(1935858840 >>> (i << 1) & 0x3)];
      i += 1;
    }
    for (;;)
    {
      localObject = this.e;
      if (j >= localObject.length) {
        break;
      }
      localObject[j] = (this.jdField_a_of_type_Array2dOfFloat[(j & 0x1)][(179303760 >>> j & 0x1)] + jdField_c_of_type_ArrayOfFloat[(jdField_a_of_type_ArrayOfByte[j] & 0x3)] + jdField_b_of_type_ArrayOfFloat[(jdField_a_of_type_ArrayOfByte[j] >> 2)]);
      j += 1;
    }
    paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRectF.left, this.jdField_a_of_type_AndroidGraphicsRectF.top);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-2130706433);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(3.0F);
    paramCanvas.drawLines(this.jdField_d_of_type_ArrayOfFloat, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.translate(-this.jdField_a_of_type_AndroidGraphicsRectF.left, -this.jdField_a_of_type_AndroidGraphicsRectF.top);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(5.0F);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_b_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRectF.left, this.jdField_a_of_type_AndroidGraphicsRectF.top);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(10.0F);
    paramCanvas.drawLines(this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a(RectF paramRectF, float paramFloat)
  {
    RectF localRectF = new RectF();
    this.jdField_a_of_type_AndroidGraphicsMatrix.setRotate(paramFloat, paramRectF.centerX(), paramRectF.centerY());
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF, paramRectF);
    b(localRectF.width(), localRectF.height());
  }
  
  public void a(ClipConstant.Anchor paramAnchor, float paramFloat1, float paramFloat2)
  {
    paramAnchor.moveFrame(this.jdField_d_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsRectF, paramFloat1, paramFloat2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
    this.jdField_c_of_type_AndroidGraphicsRectF.set(this.jdField_a_of_type_AndroidGraphicsRectF);
    ClipUtils.a(this.jdField_d_of_type_AndroidGraphicsRectF, this.jdField_c_of_type_AndroidGraphicsRectF, 60.0F);
    boolean bool = this.jdField_c_of_type_AndroidGraphicsRectF.equals(this.jdField_b_of_type_AndroidGraphicsRectF) ^ true;
    this.jdField_d_of_type_Boolean = bool;
    return bool;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip.ClipWindow
 * JD-Core Version:    0.7.0.1
 */