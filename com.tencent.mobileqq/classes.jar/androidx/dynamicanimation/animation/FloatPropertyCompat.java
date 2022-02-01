package androidx.dynamicanimation.animation;

import android.util.FloatProperty;
import androidx.annotation.RequiresApi;

public abstract class FloatPropertyCompat<T>
{
  final String mPropertyName;
  
  public FloatPropertyCompat(String paramString)
  {
    this.mPropertyName = paramString;
  }
  
  @RequiresApi(24)
  public static <T> FloatPropertyCompat<T> createFloatPropertyCompat(FloatProperty<T> paramFloatProperty)
  {
    return new FloatPropertyCompat.1(paramFloatProperty.getName(), paramFloatProperty);
  }
  
  public abstract float getValue(T paramT);
  
  public abstract void setValue(T paramT, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.dynamicanimation.animation.FloatPropertyCompat
 * JD-Core Version:    0.7.0.1
 */