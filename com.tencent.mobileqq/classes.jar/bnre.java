import android.util.Property;

class bnre
  extends Property<bnrd, Integer>
{
  bnre(bnrd parambnrd, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bnrd parambnrd)
  {
    if (parambnrd != null) {
      return Integer.valueOf(bnrd.a(parambnrd));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bnrd parambnrd, Integer paramInteger)
  {
    if (parambnrd != null) {
      bnrd.a(parambnrd, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnre
 * JD-Core Version:    0.7.0.1
 */