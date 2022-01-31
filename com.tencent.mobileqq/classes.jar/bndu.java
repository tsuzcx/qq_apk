import android.util.Property;

class bndu
  extends Property<bnds, Integer>
{
  bndu(bnds parambnds, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bnds parambnds)
  {
    if (parambnds != null) {
      return Integer.valueOf(bnds.b(parambnds));
    }
    return Integer.valueOf(255);
  }
  
  public void a(bnds parambnds, Integer paramInteger)
  {
    if (parambnds != null) {
      bnds.b(parambnds, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndu
 * JD-Core Version:    0.7.0.1
 */