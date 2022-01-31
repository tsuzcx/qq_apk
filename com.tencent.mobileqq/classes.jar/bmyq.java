import android.util.Property;

class bmyq
  extends Property<bmyp, Float>
{
  bmyq(bmyp parambmyp, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bmyp parambmyp)
  {
    if (parambmyp != null) {
      return Float.valueOf(bmyp.a(parambmyp));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bmyp parambmyp, Float paramFloat)
  {
    if (parambmyp != null) {
      bmyp.a(parambmyp, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyq
 * JD-Core Version:    0.7.0.1
 */