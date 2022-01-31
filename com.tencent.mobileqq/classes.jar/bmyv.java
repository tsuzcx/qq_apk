import android.util.Property;

class bmyv
  extends Property<bmyp, Float>
{
  bmyv(bmyp parambmyp, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bmyp parambmyp)
  {
    return Float.valueOf(bmyp.b(parambmyp));
  }
  
  public void a(bmyp parambmyp, Float paramFloat)
  {
    bmyp.a(parambmyp, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyv
 * JD-Core Version:    0.7.0.1
 */