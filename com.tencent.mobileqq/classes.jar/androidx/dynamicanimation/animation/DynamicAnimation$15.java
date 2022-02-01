package androidx.dynamicanimation.animation;

class DynamicAnimation$15
  extends FloatPropertyCompat
{
  DynamicAnimation$15(DynamicAnimation paramDynamicAnimation, String paramString, FloatValueHolder paramFloatValueHolder)
  {
    super(paramString);
  }
  
  public float getValue(Object paramObject)
  {
    return this.val$floatValueHolder.getValue();
  }
  
  public void setValue(Object paramObject, float paramFloat)
  {
    this.val$floatValueHolder.setValue(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.DynamicAnimation.15
 * JD-Core Version:    0.7.0.1
 */