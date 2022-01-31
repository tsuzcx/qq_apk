import android.util.Property;

class biwf
  extends Property<biwc, Integer>
{
  biwf(biwc parambiwc, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(biwc parambiwc)
  {
    if (parambiwc != null) {
      return Integer.valueOf(biwc.a(parambiwc));
    }
    return Integer.valueOf(0);
  }
  
  public void a(biwc parambiwc, Integer paramInteger)
  {
    if (parambiwc != null) {
      biwc.a(parambiwc, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwf
 * JD-Core Version:    0.7.0.1
 */