import android.util.Property;

class bnrf
  extends Property<bnrd, Integer>
{
  bnrf(bnrd parambnrd, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bnrd parambnrd)
  {
    if (parambnrd != null) {
      return Integer.valueOf(bnrd.b(parambnrd));
    }
    return Integer.valueOf(255);
  }
  
  public void a(bnrd parambnrd, Integer paramInteger)
  {
    if (parambnrd != null) {
      bnrd.b(parambnrd, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrf
 * JD-Core Version:    0.7.0.1
 */