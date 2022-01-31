import android.util.Property;

class bkng
  extends Property<bknf, Integer>
{
  bkng(bknf parambknf, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bknf parambknf)
  {
    if (parambknf != null) {
      return Integer.valueOf(bknf.a(parambknf));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bknf parambknf, Integer paramInteger)
  {
    if (parambknf != null) {
      bknf.a(parambknf, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkng
 * JD-Core Version:    0.7.0.1
 */