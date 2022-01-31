import android.util.Property;

class bmyt
  extends Property<bmyp, Integer>
{
  bmyt(bmyp parambmyp, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bmyp parambmyp)
  {
    if (parambmyp != null) {
      return Integer.valueOf(bmyp.b(parambmyp));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bmyp parambmyp, Integer paramInteger)
  {
    if (parambmyp != null) {
      bmyp.b(parambmyp, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyt
 * JD-Core Version:    0.7.0.1
 */