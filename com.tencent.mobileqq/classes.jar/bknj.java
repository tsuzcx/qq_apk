import android.util.Property;

class bknj
  extends Property<bknf, Integer>
{
  bknj(bknf parambknf, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bknf parambknf)
  {
    if (parambknf != null) {
      return Integer.valueOf(bknf.b(parambknf));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bknf parambknf, Integer paramInteger)
  {
    if (parambknf != null) {
      bknf.b(parambknf, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknj
 * JD-Core Version:    0.7.0.1
 */