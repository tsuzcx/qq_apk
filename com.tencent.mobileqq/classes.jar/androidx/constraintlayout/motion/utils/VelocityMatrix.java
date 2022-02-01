package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;

public class VelocityMatrix
{
  private static String TAG = "VelocityMatrix";
  float mDRotate;
  float mDScaleX;
  float mDScaleY;
  float mDTranslateX;
  float mDTranslateY;
  float mRotate;
  
  public void applyTransform(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    paramFloat1 = (paramFloat1 - 0.5F) * 2.0F;
    paramFloat2 = (paramFloat2 - 0.5F) * 2.0F;
    float f3 = this.mDTranslateX;
    float f4 = this.mDTranslateY;
    float f5 = this.mDScaleX;
    float f6 = this.mDScaleY;
    float f8 = (float)Math.toRadians(this.mRotate);
    float f7 = (float)Math.toRadians(this.mDRotate);
    double d3 = -paramInt1 * paramFloat1;
    double d2 = f8;
    double d4 = Math.sin(d2);
    Double.isNaN(d3);
    double d1 = paramInt2 * paramFloat2;
    double d5 = Math.cos(d2);
    Double.isNaN(d1);
    f8 = (float)(d3 * d4 - d5 * d1);
    d3 = paramInt1 * paramFloat1;
    d4 = Math.cos(d2);
    Double.isNaN(d3);
    d2 = Math.sin(d2);
    Double.isNaN(d1);
    float f9 = (float)(d3 * d4 - d1 * d2);
    paramArrayOfFloat[0] = (f1 + f3 + f5 * paramFloat1 + f8 * f7);
    paramArrayOfFloat[1] = (f2 + f4 + f6 * paramFloat2 + f7 * f9);
  }
  
  public void clear()
  {
    this.mDRotate = 0.0F;
    this.mDTranslateY = 0.0F;
    this.mDTranslateX = 0.0F;
    this.mDScaleY = 0.0F;
    this.mDScaleX = 0.0F;
  }
  
  public void setRotationVelocity(KeyCycleOscillator paramKeyCycleOscillator, float paramFloat)
  {
    if (paramKeyCycleOscillator != null) {
      this.mDRotate = paramKeyCycleOscillator.getSlope(paramFloat);
    }
  }
  
  public void setRotationVelocity(SplineSet paramSplineSet, float paramFloat)
  {
    if (paramSplineSet != null)
    {
      this.mDRotate = paramSplineSet.getSlope(paramFloat);
      this.mRotate = paramSplineSet.get(paramFloat);
    }
  }
  
  public void setScaleVelocity(KeyCycleOscillator paramKeyCycleOscillator1, KeyCycleOscillator paramKeyCycleOscillator2, float paramFloat)
  {
    if ((paramKeyCycleOscillator1 == null) && (paramKeyCycleOscillator2 == null)) {
      return;
    }
    if (paramKeyCycleOscillator1 == null) {
      this.mDScaleX = paramKeyCycleOscillator1.getSlope(paramFloat);
    }
    if (paramKeyCycleOscillator2 == null) {
      this.mDScaleY = paramKeyCycleOscillator2.getSlope(paramFloat);
    }
  }
  
  public void setScaleVelocity(SplineSet paramSplineSet1, SplineSet paramSplineSet2, float paramFloat)
  {
    if (paramSplineSet1 != null) {
      this.mDScaleX = paramSplineSet1.getSlope(paramFloat);
    }
    if (paramSplineSet2 != null) {
      this.mDScaleY = paramSplineSet2.getSlope(paramFloat);
    }
  }
  
  public void setTranslationVelocity(KeyCycleOscillator paramKeyCycleOscillator1, KeyCycleOscillator paramKeyCycleOscillator2, float paramFloat)
  {
    if (paramKeyCycleOscillator1 != null) {
      this.mDTranslateX = paramKeyCycleOscillator1.getSlope(paramFloat);
    }
    if (paramKeyCycleOscillator2 != null) {
      this.mDTranslateY = paramKeyCycleOscillator2.getSlope(paramFloat);
    }
  }
  
  public void setTranslationVelocity(SplineSet paramSplineSet1, SplineSet paramSplineSet2, float paramFloat)
  {
    if (paramSplineSet1 != null) {
      this.mDTranslateX = paramSplineSet1.getSlope(paramFloat);
    }
    if (paramSplineSet2 != null) {
      this.mDTranslateY = paramSplineSet2.getSlope(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.constraintlayout.motion.utils.VelocityMatrix
 * JD-Core Version:    0.7.0.1
 */