import android.util.Property;

class bnqu
  extends Property<bnqm, Float>
{
  bnqu(bnqm parambnqm, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bnqm parambnqm)
  {
    if (parambnqm != null) {
      return Float.valueOf(bnqm.d(parambnqm));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bnqm parambnqm, Float paramFloat)
  {
    if (parambnqm != null) {
      bnqm.c(parambnqm, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqu
 * JD-Core Version:    0.7.0.1
 */