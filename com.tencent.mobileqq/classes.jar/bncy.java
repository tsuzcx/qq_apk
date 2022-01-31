import android.util.Property;

class bncy
  extends Property<bncx, Integer>
{
  bncy(bncx parambncx, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bncx parambncx)
  {
    if (parambncx != null) {
      return Integer.valueOf(bncx.a(parambncx));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bncx parambncx, Integer paramInteger)
  {
    if (parambncx != null) {
      bncx.a(parambncx, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bncy
 * JD-Core Version:    0.7.0.1
 */