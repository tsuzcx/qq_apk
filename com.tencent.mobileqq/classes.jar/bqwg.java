import android.util.Property;

class bqwg
  extends Property<bqwc, Integer>
{
  bqwg(bqwc parambqwc, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bqwc parambqwc)
  {
    if (parambqwc != null) {
      return Integer.valueOf(bqwc.b(parambqwc));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bqwc parambqwc, Integer paramInteger)
  {
    if (parambqwc != null) {
      bqwc.b(parambqwc, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqwg
 * JD-Core Version:    0.7.0.1
 */