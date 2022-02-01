import android.util.Property;

class bnrg
  extends Property<bnrd, Float>
{
  bnrg(bnrd parambnrd, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bnrd parambnrd)
  {
    if (parambnrd != null) {
      return Float.valueOf(bnrd.a(parambnrd));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bnrd parambnrd, Float paramFloat)
  {
    if (parambnrd != null) {
      bnrd.a(parambnrd, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrg
 * JD-Core Version:    0.7.0.1
 */