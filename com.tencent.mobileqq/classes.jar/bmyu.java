import android.util.Property;

class bmyu
  extends Property<bmyp, Integer>
{
  bmyu(bmyp parambmyp, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bmyp parambmyp)
  {
    if (parambmyp != null) {
      return Integer.valueOf(bmyp.c(parambmyp));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bmyp parambmyp, Integer paramInteger)
  {
    if (parambmyp != null) {
      bmyp.c(parambmyp, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyu
 * JD-Core Version:    0.7.0.1
 */