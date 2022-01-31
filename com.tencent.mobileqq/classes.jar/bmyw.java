import android.util.Property;

class bmyw
  extends Property<bmyp, Float>
{
  bmyw(bmyp parambmyp, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bmyp parambmyp)
  {
    return Float.valueOf(bmyp.c(parambmyp));
  }
  
  public void a(bmyp parambmyp, Float paramFloat)
  {
    bmyp.b(parambmyp, paramFloat.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyw
 * JD-Core Version:    0.7.0.1
 */