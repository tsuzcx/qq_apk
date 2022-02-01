package androidx.constraintlayout.motion.utils;

import android.util.Log;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

public class StopLogic
  extends MotionInterpolator
{
  private boolean mBackwards = false;
  private float mLastPosition;
  private int mNumberOfStages;
  private float mStage1Duration;
  private float mStage1EndPosition;
  private float mStage1Velocity;
  private float mStage2Duration;
  private float mStage2EndPosition;
  private float mStage2Velocity;
  private float mStage3Duration;
  private float mStage3EndPosition;
  private float mStage3Velocity;
  private float mStartPosition;
  private String mType;
  
  private float calcY(float paramFloat)
  {
    float f1 = this.mStage1Duration;
    float f2;
    if (paramFloat <= f1)
    {
      f2 = this.mStage1Velocity;
      return f2 * paramFloat + (this.mStage2Velocity - f2) * paramFloat * paramFloat / (f1 * 2.0F);
    }
    int i = this.mNumberOfStages;
    if (i == 1) {
      return this.mStage1EndPosition;
    }
    paramFloat -= f1;
    f1 = this.mStage2Duration;
    float f3;
    if (paramFloat < f1)
    {
      f2 = this.mStage1EndPosition;
      f3 = this.mStage2Velocity;
      return f2 + f3 * paramFloat + (this.mStage3Velocity - f3) * paramFloat * paramFloat / (f1 * 2.0F);
    }
    if (i == 2) {
      return this.mStage2EndPosition;
    }
    paramFloat -= f1;
    f1 = this.mStage3Duration;
    if (paramFloat < f1)
    {
      f2 = this.mStage2EndPosition;
      f3 = this.mStage3Velocity;
      return f2 + f3 * paramFloat - f3 * paramFloat * paramFloat / (f1 * 2.0F);
    }
    return this.mStage3EndPosition;
  }
  
  private void setup(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    float f1 = paramFloat1;
    if (paramFloat1 == 0.0F) {
      f1 = 1.0E-004F;
    }
    this.mStage1Velocity = f1;
    paramFloat1 = f1 / paramFloat3;
    float f2 = paramFloat1 * f1 / 2.0F;
    if (f1 < 0.0F)
    {
      paramFloat1 = (float)Math.sqrt((paramFloat2 - -f1 / paramFloat3 * f1 / 2.0F) * paramFloat3);
      if (paramFloat1 < paramFloat4)
      {
        this.mType = "backward accelerate, decelerate";
        this.mNumberOfStages = 2;
        this.mStage1Velocity = f1;
        this.mStage2Velocity = paramFloat1;
        this.mStage3Velocity = 0.0F;
        this.mStage1Duration = ((paramFloat1 - f1) / paramFloat3);
        this.mStage2Duration = (paramFloat1 / paramFloat3);
        this.mStage1EndPosition = ((f1 + paramFloat1) * this.mStage1Duration / 2.0F);
        this.mStage2EndPosition = paramFloat2;
        this.mStage3EndPosition = paramFloat2;
        return;
      }
      this.mType = "backward accelerate cruse decelerate";
      this.mNumberOfStages = 3;
      this.mStage1Velocity = f1;
      this.mStage2Velocity = paramFloat4;
      this.mStage3Velocity = paramFloat4;
      this.mStage1Duration = ((paramFloat4 - f1) / paramFloat3);
      this.mStage3Duration = (paramFloat4 / paramFloat3);
      paramFloat1 = (f1 + paramFloat4) * this.mStage1Duration / 2.0F;
      paramFloat3 = this.mStage3Duration * paramFloat4 / 2.0F;
      this.mStage2Duration = ((paramFloat2 - paramFloat1 - paramFloat3) / paramFloat4);
      this.mStage1EndPosition = paramFloat1;
      this.mStage2EndPosition = (paramFloat2 - paramFloat3);
      this.mStage3EndPosition = paramFloat2;
      return;
    }
    if (f2 >= paramFloat2)
    {
      this.mType = "hard stop";
      paramFloat1 = 2.0F * paramFloat2 / f1;
      this.mNumberOfStages = 1;
      this.mStage1Velocity = f1;
      this.mStage2Velocity = 0.0F;
      this.mStage1EndPosition = paramFloat2;
      this.mStage1Duration = paramFloat1;
      return;
    }
    f2 = paramFloat2 - f2;
    float f3 = f2 / f1;
    if (f3 + paramFloat1 < paramFloat5)
    {
      this.mType = "cruse decelerate";
      this.mNumberOfStages = 2;
      this.mStage1Velocity = f1;
      this.mStage2Velocity = f1;
      this.mStage3Velocity = 0.0F;
      this.mStage1EndPosition = f2;
      this.mStage2EndPosition = paramFloat2;
      this.mStage1Duration = f3;
      this.mStage2Duration = paramFloat1;
      return;
    }
    paramFloat1 = (float)Math.sqrt(paramFloat3 * paramFloat2 + f1 * f1 / 2.0F);
    paramFloat5 = (paramFloat1 - f1) / paramFloat3;
    this.mStage1Duration = paramFloat5;
    f2 = paramFloat1 / paramFloat3;
    this.mStage2Duration = f2;
    if (paramFloat1 < paramFloat4)
    {
      this.mType = "accelerate decelerate";
      this.mNumberOfStages = 2;
      this.mStage1Velocity = f1;
      this.mStage2Velocity = paramFloat1;
      this.mStage3Velocity = 0.0F;
      this.mStage1Duration = paramFloat5;
      this.mStage2Duration = f2;
      this.mStage1EndPosition = ((f1 + paramFloat1) * this.mStage1Duration / 2.0F);
      this.mStage2EndPosition = paramFloat2;
      return;
    }
    this.mType = "accelerate cruse decelerate";
    this.mNumberOfStages = 3;
    this.mStage1Velocity = f1;
    this.mStage2Velocity = paramFloat4;
    this.mStage3Velocity = paramFloat4;
    this.mStage1Duration = ((paramFloat4 - f1) / paramFloat3);
    this.mStage3Duration = (paramFloat4 / paramFloat3);
    paramFloat1 = (f1 + paramFloat4) * this.mStage1Duration / 2.0F;
    paramFloat3 = this.mStage3Duration * paramFloat4 / 2.0F;
    this.mStage2Duration = ((paramFloat2 - paramFloat1 - paramFloat3) / paramFloat4);
    this.mStage1EndPosition = paramFloat1;
    this.mStage2EndPosition = (paramFloat2 - paramFloat3);
    this.mStage3EndPosition = paramFloat2;
  }
  
  public void config(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.mStartPosition = paramFloat1;
    boolean bool;
    if (paramFloat1 > paramFloat2) {
      bool = true;
    } else {
      bool = false;
    }
    this.mBackwards = bool;
    if (this.mBackwards)
    {
      setup(-paramFloat3, paramFloat1 - paramFloat2, paramFloat5, paramFloat6, paramFloat4);
      return;
    }
    setup(paramFloat3, paramFloat2 - paramFloat1, paramFloat5, paramFloat6, paramFloat4);
  }
  
  public void debug(String paramString1, String paramString2, float paramFloat)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" ===== ");
    ((StringBuilder)localObject).append(this.mType);
    Log.v(paramString1, ((StringBuilder)localObject).toString());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    if (this.mBackwards) {
      localObject = "backwards";
    } else {
      localObject = "forward ";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(" time = ");
    localStringBuilder.append(paramFloat);
    localStringBuilder.append("  stages ");
    localStringBuilder.append(this.mNumberOfStages);
    Log.v(paramString1, localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" dur ");
    ((StringBuilder)localObject).append(this.mStage1Duration);
    ((StringBuilder)localObject).append(" vel ");
    ((StringBuilder)localObject).append(this.mStage1Velocity);
    ((StringBuilder)localObject).append(" pos ");
    ((StringBuilder)localObject).append(this.mStage1EndPosition);
    Log.v(paramString1, ((StringBuilder)localObject).toString());
    if (this.mNumberOfStages > 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" dur ");
      ((StringBuilder)localObject).append(this.mStage2Duration);
      ((StringBuilder)localObject).append(" vel ");
      ((StringBuilder)localObject).append(this.mStage2Velocity);
      ((StringBuilder)localObject).append(" pos ");
      ((StringBuilder)localObject).append(this.mStage2EndPosition);
      Log.v(paramString1, ((StringBuilder)localObject).toString());
    }
    if (this.mNumberOfStages > 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" dur ");
      ((StringBuilder)localObject).append(this.mStage3Duration);
      ((StringBuilder)localObject).append(" vel ");
      ((StringBuilder)localObject).append(this.mStage3Velocity);
      ((StringBuilder)localObject).append(" pos ");
      ((StringBuilder)localObject).append(this.mStage3EndPosition);
      Log.v(paramString1, ((StringBuilder)localObject).toString());
    }
    float f = this.mStage1Duration;
    if (paramFloat <= f)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("stage 0");
      Log.v(paramString1, ((StringBuilder)localObject).toString());
      return;
    }
    int i = this.mNumberOfStages;
    if (i == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("end stage 0");
      Log.v(paramString1, ((StringBuilder)localObject).toString());
      return;
    }
    paramFloat -= f;
    f = this.mStage2Duration;
    if (paramFloat < f)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" stage 1");
      Log.v(paramString1, ((StringBuilder)localObject).toString());
      return;
    }
    if (i == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("end stage 1");
      Log.v(paramString1, ((StringBuilder)localObject).toString());
      return;
    }
    if (paramFloat - f < this.mStage3Duration)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(" stage 2");
      Log.v(paramString1, ((StringBuilder)localObject).toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" end stage 2");
    Log.v(paramString1, ((StringBuilder)localObject).toString());
  }
  
  public float getInterpolation(float paramFloat)
  {
    float f = calcY(paramFloat);
    this.mLastPosition = paramFloat;
    if (this.mBackwards) {
      return this.mStartPosition - f;
    }
    return this.mStartPosition + f;
  }
  
  public float getVelocity()
  {
    if (this.mBackwards) {
      return -getVelocity(this.mLastPosition);
    }
    return getVelocity(this.mLastPosition);
  }
  
  public float getVelocity(float paramFloat)
  {
    float f1 = this.mStage1Duration;
    float f2;
    if (paramFloat <= f1)
    {
      f2 = this.mStage1Velocity;
      return f2 + (this.mStage2Velocity - f2) * paramFloat / f1;
    }
    int i = this.mNumberOfStages;
    if (i == 1) {
      return 0.0F;
    }
    paramFloat -= f1;
    f1 = this.mStage2Duration;
    if (paramFloat < f1)
    {
      f2 = this.mStage2Velocity;
      return f2 + (this.mStage3Velocity - f2) * paramFloat / f1;
    }
    if (i == 2) {
      return this.mStage2EndPosition;
    }
    paramFloat -= f1;
    f1 = this.mStage3Duration;
    if (paramFloat < f1)
    {
      f2 = this.mStage3Velocity;
      return f2 - paramFloat * f2 / f1;
    }
    return this.mStage3EndPosition;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.constraintlayout.motion.utils.StopLogic
 * JD-Core Version:    0.7.0.1
 */