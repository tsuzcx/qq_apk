import android.util.Property;

class bndt
  extends Property<bnds, Integer>
{
  bndt(bnds parambnds, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bnds parambnds)
  {
    if (parambnds != null) {
      return Integer.valueOf(bnds.a(parambnds));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bnds parambnds, Integer paramInteger)
  {
    if (parambnds != null) {
      bnds.a(parambnds, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndt
 * JD-Core Version:    0.7.0.1
 */