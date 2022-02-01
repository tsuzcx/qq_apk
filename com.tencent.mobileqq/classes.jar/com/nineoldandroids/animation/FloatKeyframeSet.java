package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

class FloatKeyframeSet
  extends KeyframeSet
{
  private float deltaValue;
  private boolean firstTime = true;
  private float firstValue;
  private float lastValue;
  
  public FloatKeyframeSet(Keyframe.FloatKeyframe... paramVarArgs)
  {
    super(paramVarArgs);
  }
  
  public FloatKeyframeSet clone()
  {
    ArrayList localArrayList = this.mKeyframes;
    int j = this.mKeyframes.size();
    Keyframe.FloatKeyframe[] arrayOfFloatKeyframe = new Keyframe.FloatKeyframe[j];
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        return new FloatKeyframeSet(arrayOfFloatKeyframe);
      }
      arrayOfFloatKeyframe[i] = ((Keyframe.FloatKeyframe)((Keyframe)localArrayList.get(i)).clone());
      i += 1;
    }
  }
  
  public float getFloatValue(float paramFloat)
  {
    float f1;
    if (this.mNumKeyframes == 2)
    {
      if (this.firstTime)
      {
        this.firstTime = false;
        this.firstValue = ((Keyframe.FloatKeyframe)this.mKeyframes.get(0)).getFloatValue();
        this.lastValue = ((Keyframe.FloatKeyframe)this.mKeyframes.get(1)).getFloatValue();
        this.deltaValue = (this.lastValue - this.firstValue);
      }
      f1 = paramFloat;
      if (this.mInterpolator != null) {
        f1 = this.mInterpolator.getInterpolation(paramFloat);
      }
      if (this.mEvaluator == null) {
        return this.firstValue + f1 * this.deltaValue;
      }
      return ((Number)this.mEvaluator.evaluate(f1, Float.valueOf(this.firstValue), Float.valueOf(this.lastValue))).floatValue();
    }
    Keyframe.FloatKeyframe localFloatKeyframe;
    float f2;
    float f3;
    float f4;
    float f5;
    if (paramFloat <= 0.0F)
    {
      localObject = (Keyframe.FloatKeyframe)this.mKeyframes.get(0);
      localFloatKeyframe = (Keyframe.FloatKeyframe)this.mKeyframes.get(1);
      f2 = ((Keyframe.FloatKeyframe)localObject).getFloatValue();
      f3 = localFloatKeyframe.getFloatValue();
      f4 = ((Keyframe.FloatKeyframe)localObject).getFraction();
      f5 = localFloatKeyframe.getFraction();
      localObject = localFloatKeyframe.getInterpolator();
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f4) / (f5 - f4);
      if (this.mEvaluator == null) {
        return f2 + paramFloat * (f3 - f2);
      }
      return ((Number)this.mEvaluator.evaluate(paramFloat, Float.valueOf(f2), Float.valueOf(f3))).floatValue();
    }
    if (paramFloat >= 1.0F)
    {
      localObject = (Keyframe.FloatKeyframe)this.mKeyframes.get(this.mNumKeyframes - 2);
      localFloatKeyframe = (Keyframe.FloatKeyframe)this.mKeyframes.get(this.mNumKeyframes - 1);
      f2 = ((Keyframe.FloatKeyframe)localObject).getFloatValue();
      f3 = localFloatKeyframe.getFloatValue();
      f4 = ((Keyframe.FloatKeyframe)localObject).getFraction();
      f5 = localFloatKeyframe.getFraction();
      localObject = localFloatKeyframe.getInterpolator();
      f1 = paramFloat;
      if (localObject != null) {
        f1 = ((Interpolator)localObject).getInterpolation(paramFloat);
      }
      paramFloat = (f1 - f4) / (f5 - f4);
      if (this.mEvaluator == null) {
        return f2 + paramFloat * (f3 - f2);
      }
      return ((Number)this.mEvaluator.evaluate(paramFloat, Float.valueOf(f2), Float.valueOf(f3))).floatValue();
    }
    Object localObject = (Keyframe.FloatKeyframe)this.mKeyframes.get(0);
    int i = 1;
    for (;;)
    {
      if (i >= this.mNumKeyframes) {
        return ((Number)((Keyframe)this.mKeyframes.get(this.mNumKeyframes - 1)).getValue()).floatValue();
      }
      localFloatKeyframe = (Keyframe.FloatKeyframe)this.mKeyframes.get(i);
      if (paramFloat < localFloatKeyframe.getFraction())
      {
        Interpolator localInterpolator = localFloatKeyframe.getInterpolator();
        f1 = paramFloat;
        if (localInterpolator != null) {
          f1 = localInterpolator.getInterpolation(paramFloat);
        }
        paramFloat = (f1 - ((Keyframe.FloatKeyframe)localObject).getFraction()) / (localFloatKeyframe.getFraction() - ((Keyframe.FloatKeyframe)localObject).getFraction());
        f1 = ((Keyframe.FloatKeyframe)localObject).getFloatValue();
        f2 = localFloatKeyframe.getFloatValue();
        if (this.mEvaluator == null) {
          return f1 + paramFloat * (f2 - f1);
        }
        return ((Number)this.mEvaluator.evaluate(paramFloat, Float.valueOf(f1), Float.valueOf(f2))).floatValue();
      }
      i += 1;
      localObject = localFloatKeyframe;
    }
  }
  
  public Object getValue(float paramFloat)
  {
    return Float.valueOf(getFloatValue(paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nineoldandroids.animation.FloatKeyframeSet
 * JD-Core Version:    0.7.0.1
 */