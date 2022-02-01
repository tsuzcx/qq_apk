package com.google.android.material.shape;

import android.graphics.Matrix;
import androidx.annotation.NonNull;
import java.util.BitSet;

class MaterialShapeDrawable$1
  implements ShapeAppearancePathProvider.PathListener
{
  MaterialShapeDrawable$1(MaterialShapeDrawable paramMaterialShapeDrawable) {}
  
  public void a(@NonNull ShapePath paramShapePath, Matrix paramMatrix, int paramInt)
  {
    MaterialShapeDrawable.a(this.a).set(paramInt, paramShapePath.a());
    MaterialShapeDrawable.a(this.a)[paramInt] = paramShapePath.a(paramMatrix);
  }
  
  public void b(@NonNull ShapePath paramShapePath, Matrix paramMatrix, int paramInt)
  {
    MaterialShapeDrawable.a(this.a).set(paramInt + 4, paramShapePath.a());
    MaterialShapeDrawable.b(this.a)[paramInt] = paramShapePath.a(paramMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.MaterialShapeDrawable.1
 * JD-Core Version:    0.7.0.1
 */