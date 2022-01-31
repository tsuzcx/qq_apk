import android.util.Property;

class biwi
  extends Property<biwc, Float>
{
  biwi(biwc parambiwc, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(biwc parambiwc)
  {
    return Float.valueOf(biwc.b(parambiwc));
  }
  
  public void a(biwc parambiwc, Float paramFloat)
  {
    biwc.a(parambiwc, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwi
 * JD-Core Version:    0.7.0.1
 */