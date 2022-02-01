import android.util.Property;

class bqwk
  extends Property<bqwc, Float>
{
  bqwk(bqwc parambqwc, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(bqwc parambqwc)
  {
    if (parambqwc != null) {
      return Float.valueOf(bqwc.d(parambqwc));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(bqwc parambqwc, Float paramFloat)
  {
    if (parambqwc != null) {
      bqwc.c(parambqwc, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqwk
 * JD-Core Version:    0.7.0.1
 */