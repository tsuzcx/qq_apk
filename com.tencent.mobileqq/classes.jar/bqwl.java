import android.util.Property;

class bqwl
  extends Property<bqwc, Integer>
{
  bqwl(bqwc parambqwc, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bqwc parambqwc)
  {
    if (parambqwc != null) {
      return Integer.valueOf(bqwc.d(parambqwc));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bqwc parambqwc, Integer paramInteger)
  {
    if (parambqwc != null) {
      bqwc.d(parambqwc, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqwl
 * JD-Core Version:    0.7.0.1
 */