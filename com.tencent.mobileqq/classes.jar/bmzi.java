import android.util.Property;

class bmzi
  extends Property<bmzg, Integer>
{
  bmzi(bmzg parambmzg, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bmzg parambmzg)
  {
    if (parambmzg != null) {
      return Integer.valueOf(bmzg.b(parambmzg));
    }
    return Integer.valueOf(255);
  }
  
  public void a(bmzg parambmzg, Integer paramInteger)
  {
    if (parambmzg != null) {
      bmzg.b(parambmzg, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzi
 * JD-Core Version:    0.7.0.1
 */