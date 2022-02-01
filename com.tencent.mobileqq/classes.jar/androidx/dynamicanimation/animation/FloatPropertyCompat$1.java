package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

final class FloatPropertyCompat$1
  extends FloatPropertyCompat<T>
{
  FloatPropertyCompat$1(String paramString, FloatProperty paramFloatProperty)
  {
    super(paramString);
  }
  
  public float getValue(T paramT)
  {
    return ((Float)this.val$property.get(paramT)).floatValue();
  }
  
  public void setValue(T paramT, float paramFloat)
  {
    this.val$property.setValue(paramT, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.FloatPropertyCompat.1
 * JD-Core Version:    0.7.0.1
 */