import android.util.Property;

class bmzh
  extends Property<bmzg, Integer>
{
  bmzh(bmzg parambmzg, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bmzg parambmzg)
  {
    if (parambmzg != null) {
      return Integer.valueOf(bmzg.a(parambmzg));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bmzg parambmzg, Integer paramInteger)
  {
    if (parambmzg != null) {
      bmzg.a(parambmzg, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzh
 * JD-Core Version:    0.7.0.1
 */