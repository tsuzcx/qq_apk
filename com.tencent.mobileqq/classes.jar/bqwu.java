import android.util.Property;

class bqwu
  extends Property<bqwt, Integer>
{
  bqwu(bqwt parambqwt, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bqwt parambqwt)
  {
    if (parambqwt != null) {
      return Integer.valueOf(bqwt.a(parambqwt));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bqwt parambqwt, Integer paramInteger)
  {
    if (parambqwt != null) {
      bqwt.a(parambqwt, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqwu
 * JD-Core Version:    0.7.0.1
 */