import android.util.Property;

class bndp
  extends Property<bndn, Integer>
{
  bndp(bndn parambndn, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bndn parambndn)
  {
    if (parambndn != null) {
      return Integer.valueOf(bndn.a(parambndn));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bndn parambndn, Integer paramInteger)
  {
    if (parambndn != null) {
      bndn.a(parambndn, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndp
 * JD-Core Version:    0.7.0.1
 */