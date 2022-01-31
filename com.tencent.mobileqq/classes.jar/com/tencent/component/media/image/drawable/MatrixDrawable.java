package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

public class MatrixDrawable
  extends DrawableContainer
{
  private final Matrix mMatrix = new Matrix();
  private final MatrixDrawable.MatrixState mState;
  
  public MatrixDrawable(Drawable paramDrawable)
  {
    this(paramDrawable, null);
  }
  
  public MatrixDrawable(Drawable paramDrawable, Matrix paramMatrix)
  {
    this.mState = new MatrixDrawable.MatrixState(paramDrawable, this);
    setConstantState(this.mState);
    setMatrix(paramMatrix);
  }
  
  private MatrixDrawable(MatrixDrawable.MatrixState paramMatrixState, Resources paramResources)
  {
    this.mState = new MatrixDrawable.MatrixState(paramMatrixState, this, paramResources);
    setConstantState(this.mState);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mMatrix.isIdentity())
    {
      super.draw(paramCanvas);
      return;
    }
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    paramCanvas.concat(this.mMatrix);
    super.draw(paramCanvas);
    paramCanvas.restoreToCount(i);
  }
  
  public Matrix getMatrix()
  {
    return this.mMatrix;
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
    if (((localMatrix == null) && (!this.mMatrix.isIdentity())) || ((localMatrix != null) && (!this.mMatrix.equals(localMatrix))))
    {
      this.mMatrix.set(localMatrix);
      invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.MatrixDrawable
 * JD-Core Version:    0.7.0.1
 */