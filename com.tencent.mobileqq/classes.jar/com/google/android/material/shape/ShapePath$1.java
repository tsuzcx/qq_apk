package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.Iterator;
import java.util.List;

class ShapePath$1
  extends ShapePath.ShadowCompatOperation
{
  ShapePath$1(ShapePath paramShapePath, List paramList, Matrix paramMatrix) {}
  
  public void a(Matrix paramMatrix, ShadowRenderer paramShadowRenderer, int paramInt, Canvas paramCanvas)
  {
    paramMatrix = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramMatrix.hasNext()) {
      ((ShapePath.ShadowCompatOperation)paramMatrix.next()).a(this.jdField_a_of_type_AndroidGraphicsMatrix, paramShadowRenderer, paramInt, paramCanvas);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.ShapePath.1
 * JD-Core Version:    0.7.0.1
 */