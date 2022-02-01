import android.util.Property;

class bnqp
  extends Property<bnqm, Integer>
{
  bnqp(bnqm parambnqm, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bnqm parambnqm)
  {
    if (parambnqm != null) {
      return Integer.valueOf(bnqm.a(parambnqm));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bnqm parambnqm, Integer paramInteger)
  {
    if (parambnqm != null) {
      bnqm.a(parambnqm, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqp
 * JD-Core Version:    0.7.0.1
 */