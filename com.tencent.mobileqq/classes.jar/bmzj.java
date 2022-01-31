import android.util.Property;

class bmzj
  extends Property<bmzg, Float>
{
  bmzj(bmzg parambmzg, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bmzg parambmzg)
  {
    if (parambmzg != null) {
      return Float.valueOf(bmzg.a(parambmzg));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bmzg parambmzg, Float paramFloat)
  {
    if (parambmzg != null) {
      bmzg.a(parambmzg, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzj
 * JD-Core Version:    0.7.0.1
 */