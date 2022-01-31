package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import pmr;

public class MatrixDrawable
  extends DrawableContainer
{
  private final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private final pmr jdField_a_of_type_Pmr;
  
  public MatrixDrawable(Drawable paramDrawable)
  {
    this(paramDrawable, null);
  }
  
  public MatrixDrawable(Drawable paramDrawable, Matrix paramMatrix)
  {
    this.jdField_a_of_type_Pmr = new pmr(paramDrawable, this);
    setConstantState(this.jdField_a_of_type_Pmr);
    setMatrix(paramMatrix);
  }
  
  private MatrixDrawable(pmr parampmr, Resources paramResources)
  {
    this.jdField_a_of_type_Pmr = new pmr(parampmr, this, paramResources);
    setConstantState(this.jdField_a_of_type_Pmr);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsMatrix.isIdentity())
    {
      super.draw(paramCanvas);
      return;
    }
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.concat(this.jdField_a_of_type_AndroidGraphicsMatrix);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public Matrix getMatrix()
  {
    return this.jdField_a_of_type_AndroidGraphicsMatrix;
  }
  
  public void setMatrix(Matrix paramMatrix)
  {
    Matrix localMatrix = paramMatrix;
    if (paramMatrix != null)
    {
      localMatrix = paramMatrix;
      if (paramMatrix.isIdentity()) {
        localMatrix = null;
      }
    }
    if (((localMatrix == null) && (!this.jdField_a_of_type_AndroidGraphicsMatrix.isIdentity())) || ((localMatrix != null) && (!this.jdField_a_of_type_AndroidGraphicsMatrix.equals(localMatrix))))
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.set(localMatrix);
      invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.MatrixDrawable
 * JD-Core Version:    0.7.0.1
 */