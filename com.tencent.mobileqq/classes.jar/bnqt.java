import android.util.Property;

class bnqt
  extends Property<bnqm, Float>
{
  bnqt(bnqm parambnqm, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bnqm parambnqm)
  {
    return Float.valueOf(bnqm.c(parambnqm));
  }
  
  public void a(bnqm parambnqm, Float paramFloat)
  {
    bnqm.b(parambnqm, paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqt
 * JD-Core Version:    0.7.0.1
 */