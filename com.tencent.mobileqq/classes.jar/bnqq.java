import android.util.Property;

class bnqq
  extends Property<bnqm, Integer>
{
  bnqq(bnqm parambnqm, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bnqm parambnqm)
  {
    if (parambnqm != null) {
      return Integer.valueOf(bnqm.b(parambnqm));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bnqm parambnqm, Integer paramInteger)
  {
    if (parambnqm != null) {
      bnqm.b(parambnqm, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqq
 * JD-Core Version:    0.7.0.1
 */