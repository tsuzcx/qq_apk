import android.util.Property;

class bndo
  extends Property<bndn, Float>
{
  bndo(bndn parambndn, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bndn parambndn)
  {
    if (parambndn != null) {
      return Float.valueOf(bndn.a(parambndn));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bndn parambndn, Float paramFloat)
  {
    if (parambndn != null) {
      bndn.a(parambndn, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bndo
 * JD-Core Version:    0.7.0.1
 */