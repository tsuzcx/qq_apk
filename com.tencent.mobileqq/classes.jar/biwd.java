import android.util.Property;

class biwd
  extends Property<biwc, Float>
{
  biwd(biwc parambiwc, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(biwc parambiwc)
  {
    if (parambiwc != null) {
      return Float.valueOf(biwc.a(parambiwc));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(biwc parambiwc, Float paramFloat)
  {
    if (parambiwc != null) {
      biwc.a(parambiwc, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwd
 * JD-Core Version:    0.7.0.1
 */