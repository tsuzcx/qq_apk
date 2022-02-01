import android.util.Property;

class bqwv
  extends Property<bqwt, Integer>
{
  bqwv(bqwt parambqwt, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bqwt parambqwt)
  {
    if (parambqwt != null) {
      return Integer.valueOf(bqwt.b(parambqwt));
    }
    return Integer.valueOf(255);
  }
  
  public void a(bqwt parambqwt, Integer paramInteger)
  {
    if (parambqwt != null) {
      bqwt.b(parambqwt, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqwv
 * JD-Core Version:    0.7.0.1
 */