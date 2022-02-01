import android.util.Property;

class bqwf
  extends Property<bqwc, Integer>
{
  bqwf(bqwc parambqwc, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bqwc parambqwc)
  {
    if (parambqwc != null) {
      return Integer.valueOf(bqwc.a(parambqwc));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bqwc parambqwc, Integer paramInteger)
  {
    if (parambqwc != null) {
      bqwc.a(parambqwc, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqwf
 * JD-Core Version:    0.7.0.1
 */