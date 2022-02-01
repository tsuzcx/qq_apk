package androidx.transition;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.View;

class ChangeTransform$PathAnimatorMatrix
{
  private final Matrix mMatrix = new Matrix();
  private float mTranslationX;
  private float mTranslationY;
  private final float[] mValues;
  private final View mView;
  
  ChangeTransform$PathAnimatorMatrix(View paramView, float[] paramArrayOfFloat)
  {
    this.mView = paramView;
    this.mValues = ((float[])paramArrayOfFloat.clone());
    paramView = this.mValues;
    this.mTranslationX = paramView[2];
    this.mTranslationY = paramView[5];
    setAnimationMatrix();
  }
  
  private void setAnimationMatrix()
  {
    float[] arrayOfFloat = this.mValues;
    arrayOfFloat[2] = this.mTranslationX;
    arrayOfFloat[5] = this.mTranslationY;
    this.mMatrix.setValues(arrayOfFloat);
    ViewUtils.setAnimationMatrix(this.mView, this.mMatrix);
  }
  
  Matrix getMatrix()
  {
    return this.mMatrix;
  }
  
  void setTranslation(PointF paramPointF)
  {
    this.mTranslationX = paramPointF.x;
    this.mTranslationY = paramPointF.y;
    setAnimationMatrix();
  }
  
  void setValues(float[] paramArrayOfFloat)
  {
    System.arraycopy(paramArrayOfFloat, 0, this.mValues, 0, paramArrayOfFloat.length);
    setAnimationMatrix();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ChangeTransform.PathAnimatorMatrix
 * JD-Core Version:    0.7.0.1
 */