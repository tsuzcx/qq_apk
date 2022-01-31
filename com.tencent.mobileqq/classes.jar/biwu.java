import android.util.Property;

class biwu
  extends Property<biwt, Integer>
{
  biwu(biwt parambiwt, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(biwt parambiwt)
  {
    if (parambiwt != null) {
      return Integer.valueOf(biwt.a(parambiwt));
    }
    return Integer.valueOf(0);
  }
  
  public void a(biwt parambiwt, Integer paramInteger)
  {
    if (parambiwt != null) {
      biwt.a(parambiwt, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwu
 * JD-Core Version:    0.7.0.1
 */