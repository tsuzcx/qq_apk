import android.util.Property;

class bmzd
  extends Property<bmzb, Integer>
{
  bmzd(bmzb parambmzb, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bmzb parambmzb)
  {
    if (parambmzb != null) {
      return Integer.valueOf(bmzb.a(parambmzb));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bmzb parambmzb, Integer paramInteger)
  {
    if (parambmzb != null) {
      bmzb.a(parambmzb, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzd
 * JD-Core Version:    0.7.0.1
 */