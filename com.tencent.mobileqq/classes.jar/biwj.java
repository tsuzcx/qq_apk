import android.util.Property;

class biwj
  extends Property<biwc, Float>
{
  biwj(biwc parambiwc, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(biwc parambiwc)
  {
    return Float.valueOf(biwc.c(parambiwc));
  }
  
  public void a(biwc parambiwc, Float paramFloat)
  {
    biwc.b(parambiwc, paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwj
 * JD-Core Version:    0.7.0.1
 */