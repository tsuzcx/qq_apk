package com.tencent.mobileqq.activity.richmedia;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.camera.utils.CameraUtils;

public class NewFlowCameraOperator
{
  public static boolean a = false;
  private static int jdField_b_of_type_Int;
  private int jdField_a_of_type_Int = 90;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  
  private static int a()
  {
    int j = jdField_b_of_type_Int;
    int i = j;
    if (j == 0)
    {
      jdField_b_of_type_Int = (int)BaseApplicationImpl.getApplication().getResources().getDimension(2131298135);
      i = jdField_b_of_type_Int;
    }
    return i;
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 > paramInt3) {
      return paramInt3;
    }
    if (paramInt1 < paramInt2) {
      return paramInt2;
    }
    return paramInt1;
  }
  
  public Rect a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3)
  {
    int i = Float.valueOf(a() * paramFloat3).intValue();
    int k = (int)paramFloat1;
    int j = i / 2;
    paramInt1 = a(k - j, 0, paramInt1 - i);
    paramInt2 = a((int)paramFloat2 - j, 0, paramInt2 - i);
    RectF localRectF = new RectF(paramInt1, paramInt2, paramInt1 + i, paramInt2 + i);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect(localRectF);
    return new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
    CameraUtils.a(this.jdField_b_of_type_AndroidGraphicsMatrix, jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, paramInt3, paramInt4, paramInt1, paramInt2);
    this.jdField_b_of_type_AndroidGraphicsMatrix.invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  public void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewFlowCameraOperator
 * JD-Core Version:    0.7.0.1
 */