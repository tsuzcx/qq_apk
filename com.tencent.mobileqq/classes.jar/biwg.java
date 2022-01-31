import android.util.Property;

class biwg
  extends Property<biwc, Integer>
{
  biwg(biwc parambiwc, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(biwc parambiwc)
  {
    if (parambiwc != null) {
      return Integer.valueOf(biwc.b(parambiwc));
    }
    return Integer.valueOf(0);
  }
  
  public void a(biwc parambiwc, Integer paramInteger)
  {
    if (parambiwc != null) {
      biwc.b(parambiwc, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwg
 * JD-Core Version:    0.7.0.1
 */