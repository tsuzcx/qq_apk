import android.util.Property;

class bqww
  extends Property<bqwt, Float>
{
  bqww(bqwt parambqwt, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bqwt parambqwt)
  {
    if (parambqwt != null) {
      return Float.valueOf(bqwt.a(parambqwt));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bqwt parambqwt, Float paramFloat)
  {
    if (parambqwt != null) {
      bqwt.a(parambqwt, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqww
 * JD-Core Version:    0.7.0.1
 */