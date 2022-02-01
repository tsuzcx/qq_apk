import android.util.Property;

class bnqn
  extends Property<bnqm, Float>
{
  bnqn(bnqm parambnqm, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bnqm parambnqm)
  {
    if (parambnqm != null) {
      return Float.valueOf(bnqm.a(parambnqm));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bnqm parambnqm, Float paramFloat)
  {
    if (parambnqm != null) {
      bnqm.a(parambnqm, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqn
 * JD-Core Version:    0.7.0.1
 */