package androidx.dynamicanimation.animation;

public abstract class FloatPropertyCompat<T>
{
  final String a;
  
  public FloatPropertyCompat(String paramString)
  {
    this.a = paramString;
  }
  
  public abstract float a(T paramT);
  
  public abstract void a(T paramT, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.dynamicanimation.animation.FloatPropertyCompat
 * JD-Core Version:    0.7.0.1
 */