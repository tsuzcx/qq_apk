import android.util.Property;

class bknk
  extends Property<bknf, Integer>
{
  bknk(bknf parambknf, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bknf parambknf)
  {
    if (parambknf != null) {
      return Integer.valueOf(bknf.c(parambknf));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bknf parambknf, Integer paramInteger)
  {
    if (parambknf != null) {
      bknf.c(parambknf, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknk
 * JD-Core Version:    0.7.0.1
 */