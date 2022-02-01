import android.util.Property;

class bnqs
  extends Property<bnqm, Float>
{
  bnqs(bnqm parambnqm, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bnqm parambnqm)
  {
    return Float.valueOf(bnqm.b(parambnqm));
  }
  
  public void a(bnqm parambnqm, Float paramFloat)
  {
    bnqm.a(parambnqm, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqs
 * JD-Core Version:    0.7.0.1
 */