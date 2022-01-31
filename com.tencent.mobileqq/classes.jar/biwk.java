import android.util.Property;

class biwk
  extends Property<biwc, Float>
{
  biwk(biwc parambiwc, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(biwc parambiwc)
  {
    if (parambiwc != null) {
      return Float.valueOf(biwc.d(parambiwc));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(biwc parambiwc, Float paramFloat)
  {
    if (parambiwc != null) {
      biwc.c(parambiwc, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwk
 * JD-Core Version:    0.7.0.1
 */