import android.util.Property;

class biww
  extends Property<biwt, Float>
{
  biww(biwt parambiwt, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(biwt parambiwt)
  {
    if (parambiwt != null) {
      return Float.valueOf(biwt.a(parambiwt));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(biwt parambiwt, Float paramFloat)
  {
    if (parambiwt != null) {
      biwt.a(parambiwt, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biww
 * JD-Core Version:    0.7.0.1
 */