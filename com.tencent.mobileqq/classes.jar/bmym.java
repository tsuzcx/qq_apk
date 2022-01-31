import android.util.Property;

class bmym
  extends Property<bmyl, Integer>
{
  bmym(bmyl parambmyl, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bmyl parambmyl)
  {
    if (parambmyl != null) {
      return Integer.valueOf(bmyl.a(parambmyl));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bmyl parambmyl, Integer paramInteger)
  {
    if (parambmyl != null) {
      bmyl.a(parambmyl, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmym
 * JD-Core Version:    0.7.0.1
 */