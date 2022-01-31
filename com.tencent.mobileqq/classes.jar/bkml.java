import android.util.Property;

class bkml
  extends Property<bkmk, Integer>
{
  bkml(bkmk parambkmk, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bkmk parambkmk)
  {
    if (parambkmk != null) {
      return Integer.valueOf(bkmk.a(parambkmk));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bkmk parambkmk, Integer paramInteger)
  {
    if (parambkmk != null) {
      bkmk.a(parambkmk, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkml
 * JD-Core Version:    0.7.0.1
 */