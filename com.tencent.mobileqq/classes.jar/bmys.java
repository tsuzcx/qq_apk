import android.util.Property;

class bmys
  extends Property<bmyp, Integer>
{
  bmys(bmyp parambmyp, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bmyp parambmyp)
  {
    if (parambmyp != null) {
      return Integer.valueOf(bmyp.a(parambmyp));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bmyp parambmyp, Integer paramInteger)
  {
    if (parambmyp != null) {
      bmyp.a(parambmyp, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmys
 * JD-Core Version:    0.7.0.1
 */