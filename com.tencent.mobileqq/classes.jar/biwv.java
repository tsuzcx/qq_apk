import android.util.Property;

class biwv
  extends Property<biwt, Integer>
{
  biwv(biwt parambiwt, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(biwt parambiwt)
  {
    if (parambiwt != null) {
      return Integer.valueOf(biwt.b(parambiwt));
    }
    return Integer.valueOf(255);
  }
  
  public void a(biwt parambiwt, Integer paramInteger)
  {
    if (parambiwt != null) {
      biwt.b(parambiwt, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwv
 * JD-Core Version:    0.7.0.1
 */