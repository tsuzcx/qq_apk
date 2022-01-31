import android.util.Property;

class bkno
  extends Property<bknf, Integer>
{
  bkno(bknf parambknf, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bknf parambknf)
  {
    if (parambknf != null) {
      return Integer.valueOf(bknf.d(parambknf));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bknf parambknf, Integer paramInteger)
  {
    if (parambknf != null) {
      bknf.d(parambknf, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkno
 * JD-Core Version:    0.7.0.1
 */