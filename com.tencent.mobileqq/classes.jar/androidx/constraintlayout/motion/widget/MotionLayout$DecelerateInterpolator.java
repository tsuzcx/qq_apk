package androidx.constraintlayout.motion.widget;

class MotionLayout$DecelerateInterpolator
  extends MotionInterpolator
{
  float currentP = 0.0F;
  float initalV = 0.0F;
  float maxA;
  
  MotionLayout$DecelerateInterpolator(MotionLayout paramMotionLayout) {}
  
  public void config(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.initalV = paramFloat1;
    this.currentP = paramFloat2;
    this.maxA = paramFloat3;
  }
  
  public float getInterpolation(float paramFloat)
  {
    float f2 = this.initalV;
    float f3;
    MotionLayout localMotionLayout;
    if (f2 > 0.0F)
    {
      f3 = this.maxA;
      f1 = paramFloat;
      if (f2 / f3 < paramFloat) {
        f1 = f2 / f3;
      }
      localMotionLayout = this.this$0;
      paramFloat = this.initalV;
      f2 = this.maxA;
      localMotionLayout.mLastVelocity = (paramFloat - f2 * f1);
      paramFloat = paramFloat * f1 - f2 * f1 * f1 / 2.0F;
    }
    for (float f1 = this.currentP;; f1 = this.currentP)
    {
      return paramFloat + f1;
      f3 = -f2;
      float f4 = this.maxA;
      f1 = paramFloat;
      if (f3 / f4 < paramFloat) {
        f1 = -f2 / f4;
      }
      localMotionLayout = this.this$0;
      paramFloat = this.initalV;
      f2 = this.maxA;
      localMotionLayout.mLastVelocity = (f2 * f1 + paramFloat);
      paramFloat = paramFloat * f1 + f2 * f1 * f1 / 2.0F;
    }
  }
  
  public float getVelocity()
  {
    return this.this$0.mLastVelocity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.widget.MotionLayout.DecelerateInterpolator
 * JD-Core Version:    0.7.0.1
 */