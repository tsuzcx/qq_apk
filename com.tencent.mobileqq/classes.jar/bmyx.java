import android.util.Property;

class bmyx
  extends Property<bmyp, Float>
{
  bmyx(bmyp parambmyp, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bmyp parambmyp)
  {
    if (parambmyp != null) {
      return Float.valueOf(bmyp.d(parambmyp));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bmyp parambmyp, Float paramFloat)
  {
    if (parambmyp != null) {
      bmyp.c(parambmyp, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyx
 * JD-Core Version:    0.7.0.1
 */