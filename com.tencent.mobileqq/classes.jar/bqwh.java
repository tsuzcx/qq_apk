import android.util.Property;

class bqwh
  extends Property<bqwc, Integer>
{
  bqwh(bqwc parambqwc, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bqwc parambqwc)
  {
    if (parambqwc != null) {
      return Integer.valueOf(bqwc.c(parambqwc));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bqwc parambqwc, Integer paramInteger)
  {
    if (parambqwc != null) {
      bqwc.c(parambqwc, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqwh
 * JD-Core Version:    0.7.0.1
 */