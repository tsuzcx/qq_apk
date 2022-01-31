import android.util.Property;

class bknt
  extends Property<bknr, Integer>
{
  bknt(bknr parambknr, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bknr parambknr)
  {
    if (parambknr != null) {
      return Integer.valueOf(bknr.a(parambknr));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bknr parambknr, Integer paramInteger)
  {
    if (parambknr != null) {
      bknr.a(parambknr, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknt
 * JD-Core Version:    0.7.0.1
 */