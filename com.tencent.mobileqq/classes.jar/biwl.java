import android.util.Property;

class biwl
  extends Property<biwc, Integer>
{
  biwl(biwc parambiwc, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(biwc parambiwc)
  {
    if (parambiwc != null) {
      return Integer.valueOf(biwc.d(parambiwc));
    }
    return Integer.valueOf(0);
  }
  
  public void a(biwc parambiwc, Integer paramInteger)
  {
    if (parambiwc != null) {
      biwc.d(parambiwc, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwl
 * JD-Core Version:    0.7.0.1
 */