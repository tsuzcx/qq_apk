package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.component.media.annotation.Public;

@Public
public class ScaleDrawable
  extends DrawableContainer
{
  private static final float PIVOT_DEFAULT_VALUE = 0.0F;
  private Matrix mDrawMatrix;
  private float mPivotXRate = 0.0F;
  private float mPivotYRate = 0.0F;
  private ScaleDrawable.ScaleState mScaleState;
  private int mScaleType;
  private Rect mTmpRect = new Rect();
  
  @Public
  public ScaleDrawable(Drawable paramDrawable)
  {
    this(paramDrawable, -1);
  }
  
  @Public
  public ScaleDrawable(Drawable paramDrawable, int paramInt)
  {
    this.mScaleState = new ScaleDrawable.ScaleState(paramDrawable, this);
    setConstantState(this.mScaleState);
    setScaleType(paramInt);
  }
  
  private ScaleDrawable(ScaleDrawable.ScaleState paramScaleState, Resources paramResources)
  {
    this.mScaleState = new ScaleDrawable.ScaleState(paramScaleState, this, paramResources);
    setConstantState(this.mScaleState);
  }
  
  public static void getMatrix(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2)
  {
    if (paramInt1 == -1)
    {
      if (paramMatrix != null) {
        paramMatrix.reset();
      }
      return;
    }
    Matrix localMatrix = paramMatrix;
    if (paramMatrix == null) {
      localMatrix = new Matrix();
    }
    float f2 = 0.0F;
    float f4 = 0.0F;
    float f1 = 0.0F;
    float f5 = 0.0F;
    float f3 = 0.0F;
    switch (paramInt1)
    {
    default: 
      return;
    case 10: 
      if (paramInt2 * paramInt5 > paramInt4 * paramInt3)
      {
        f2 = paramInt5;
        f1 = paramInt3;
      }
      else
      {
        f2 = paramInt4;
        f1 = paramInt2;
      }
      f1 = f2 / f1;
      f5 = paramInt4 * 0.5F;
      f2 = paramInt5 * 0.5F;
      paramInt1 = (int)(paramInt2 * f1);
      paramInt2 = (int)(paramInt3 * f1);
      paramFloat1 *= paramInt1;
      f4 = paramFloat2 * paramInt2;
      if ((paramInt1 > paramInt4) && (paramFloat1 > f5)) {
        paramFloat1 = Math.min(paramInt1 - paramInt4, paramFloat1 - f5);
      } else {
        paramFloat1 = 0.0F;
      }
      paramFloat2 = f3;
      if (paramInt2 > paramInt5)
      {
        paramFloat2 = f3;
        if (f4 > f2) {
          paramFloat2 = Math.min(paramInt2 - paramInt5, f4 - f2);
        }
      }
      localMatrix.setScale(f1, f1);
      localMatrix.postTranslate((int)(paramFloat1 + 0.5F) * -1, (int)(paramFloat2 + 0.5F) * -1);
      return;
    case 9: 
      paramFloat1 = paramInt5 - paramInt3;
      localMatrix.postTranslate((int)((paramInt4 - paramInt2) * 0.5F + 0.5F), (int)(paramFloat1 * 0.5F + 0.5F));
      return;
    case 8: 
      paramFloat1 = paramInt4 / paramInt2;
      paramFloat2 = paramInt5;
      f1 = paramInt3;
      localMatrix.setScale(paramFloat1, paramFloat1);
      localMatrix.postTranslate((int)0.5F, (int)((paramFloat2 - f1 * paramFloat1) * 0.5F + 0.5F));
      return;
    case 7: 
      paramFloat1 = paramInt4 / paramInt2;
      paramFloat2 = paramInt5;
      f1 = paramInt3;
      localMatrix.setScale(paramFloat1, paramFloat1);
      localMatrix.postTranslate((int)0.5F, (int)((paramFloat2 - f1 * paramFloat1) * 1.0F + 0.5F));
      return;
    case 5: 
      if (paramInt2 * paramInt5 > paramInt4 * paramInt3)
      {
        paramFloat2 = paramInt4 / paramInt2;
        paramFloat1 = (paramInt5 - paramInt3 * paramFloat2) * 1.0F;
        f1 = 0.0F;
      }
      else
      {
        paramFloat2 = paramInt5 / paramInt3;
        f1 = (paramInt4 - paramInt2 * paramFloat2) * 1.0F;
        paramFloat1 = f2;
      }
      localMatrix.setScale(paramFloat2, paramFloat2);
      localMatrix.postTranslate((int)(f1 + 0.5F), (int)(paramFloat1 + 0.5F));
    case 6: 
      paramFloat1 = paramInt4 / paramInt2;
      localMatrix.setScale(paramFloat1, paramFloat1);
      paramFloat1 = (int)0.5F;
      localMatrix.postTranslate(paramFloat1, paramFloat1);
      return;
    case 4: 
      if (paramInt2 * paramInt5 > paramInt4 * paramInt3)
      {
        paramFloat1 = paramInt4;
        paramFloat2 = paramInt2;
      }
      else
      {
        paramFloat1 = paramInt5;
        paramFloat2 = paramInt3;
      }
      paramFloat1 /= paramFloat2;
      localMatrix.setScale(paramFloat1, paramFloat1);
      localMatrix.postTranslate((int)0.5F, (int)0.5F);
      return;
    case 3: 
      if (paramInt2 * paramInt5 > paramInt4 * paramInt3)
      {
        paramFloat2 = paramInt4 / paramInt2;
        paramFloat1 = (paramInt5 - paramInt3 * paramFloat2) * 0.5F;
        f1 = 0.0F;
      }
      else
      {
        paramFloat2 = paramInt5 / paramInt3;
        f1 = (paramInt4 - paramInt2 * paramFloat2) * 0.5F;
        paramFloat1 = f4;
      }
      localMatrix.setScale(paramFloat2, paramFloat2);
      localMatrix.postTranslate((int)(f1 + 0.5F), (int)(paramFloat1 + 0.5F));
      return;
    case 2: 
      if (paramInt2 * paramInt5 > paramInt4 * paramInt3)
      {
        paramFloat2 = paramInt5 / paramInt3;
        f2 = (paramInt4 - paramInt2 * paramFloat2) * 1.0F;
        paramFloat1 = f1;
        f1 = f2;
      }
      else
      {
        paramFloat2 = paramInt4 / paramInt2;
        paramFloat1 = (paramInt5 - paramInt3 * paramFloat2) * 1.0F;
        f1 = 0.0F;
      }
      localMatrix.setScale(paramFloat2, paramFloat2);
      localMatrix.postTranslate((int)(f1 + 0.5F), (int)(paramFloat1 + 0.5F));
      return;
    case 1: 
      if (paramInt2 * paramInt5 > paramInt4 * paramInt3)
      {
        paramFloat1 = paramInt5;
        paramFloat2 = paramInt3;
      }
      else
      {
        paramFloat1 = paramInt4;
        paramFloat2 = paramInt2;
      }
      paramFloat1 /= paramFloat2;
      localMatrix.setScale(paramFloat1, paramFloat1);
      localMatrix.postTranslate((int)0.5F, (int)0.5F);
      return;
    }
    if (paramInt2 * paramInt5 > paramInt4 * paramInt3)
    {
      paramFloat2 = paramInt5 / paramInt3;
      f1 = (paramInt4 - paramInt2 * paramFloat2) * 0.5F;
      paramFloat1 = f5;
    }
    else
    {
      paramFloat2 = paramInt4 / paramInt2;
      paramFloat1 = (paramInt5 - paramInt3 * paramFloat2) * 0.5F;
      f1 = 0.0F;
    }
    localMatrix.setScale(paramFloat2, paramFloat2);
    localMatrix.postTranslate((int)(f1 + 0.5F), (int)(paramFloat1 + 0.5F));
  }
  
  private void updateDrawMatrix()
  {
    if (this.mDrawMatrix == null) {
      this.mDrawMatrix = new Matrix();
    }
    getMatrix(this.mDrawMatrix, this.mScaleType, getIntrinsicWidth(), getIntrinsicHeight(), getBounds().width(), getBounds().height(), this.mPivotXRate, this.mPivotYRate);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Matrix localMatrix = this.mDrawMatrix;
    if ((localMatrix != null) && (!localMatrix.isIdentity()))
    {
      int i = paramCanvas.getSaveCount();
      paramCanvas.save();
      paramCanvas.concat(localMatrix);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (this.mScaleState.canConstantState())
    {
      this.mScaleState.mChangingConfigurations = getChangingConfigurations();
      return this.mScaleState;
    }
    return null;
  }
  
  public Matrix getMatrix()
  {
    return this.mDrawMatrix;
  }
  
  public int getMinimumHeight()
  {
    return 0;
  }
  
  public int getMinimumWidth()
  {
    return 0;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    int i = getIntrinsicWidth();
    int j = getIntrinsicHeight();
    Rect localRect = paramRect;
    if (i > 0)
    {
      localRect = paramRect;
      if (j > 0)
      {
        localRect = this.mTmpRect;
        localRect.set(0, 0, i, j);
      }
    }
    super.onBoundsChange(localRect);
    updateDrawMatrix();
  }
  
  @Public
  public void setPivot(float paramFloat1, float paramFloat2)
  {
    if ((this.mPivotXRate != paramFloat1) || (this.mPivotYRate != paramFloat2))
    {
      this.mPivotXRate = paramFloat1;
      this.mPivotYRate = paramFloat2;
      updateDrawMatrix();
    }
  }
  
  @Public
  public void setScaleType(int paramInt)
  {
    if (this.mScaleType != paramInt)
    {
      this.mScaleType = paramInt;
      updateDrawMatrix();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.ScaleDrawable
 * JD-Core Version:    0.7.0.1
 */