import android.util.Property;

class biwh
  extends Property<biwc, Integer>
{
  biwh(biwc parambiwc, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(biwc parambiwc)
  {
    if (parambiwc != null) {
      return Integer.valueOf(biwc.c(parambiwc));
    }
    return Integer.valueOf(0);
  }
  
  public void a(biwc parambiwc, Integer paramInteger)
  {
    if (parambiwc != null) {
      biwc.c(parambiwc, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwh
 * JD-Core Version:    0.7.0.1
 */