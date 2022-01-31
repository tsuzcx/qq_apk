import android.util.Property;

class bmzc
  extends Property<bmzb, Float>
{
  bmzc(bmzb parambmzb, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bmzb parambmzb)
  {
    if (parambmzb != null) {
      return Float.valueOf(bmzb.a(parambmzb));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bmzb parambmzb, Float paramFloat)
  {
    if (parambmzb != null) {
      bmzb.a(parambmzb, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzc
 * JD-Core Version:    0.7.0.1
 */