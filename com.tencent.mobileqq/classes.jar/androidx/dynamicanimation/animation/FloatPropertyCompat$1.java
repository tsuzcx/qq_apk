package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

final class FloatPropertyCompat$1
  extends FloatPropertyCompat<T>
{
  public float a(T paramT)
  {
    return ((Float)this.a.get(paramT)).floatValue();
  }
  
  public void a(T paramT, float paramFloat)
  {
    this.a.setValue(paramT, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.FloatPropertyCompat.1
 * JD-Core Version:    0.7.0.1
 */