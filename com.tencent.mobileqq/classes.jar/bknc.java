import android.util.Property;

class bknc
  extends Property<bknb, Integer>
{
  bknc(bknb parambknb, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bknb parambknb)
  {
    if (parambknb != null) {
      return Integer.valueOf(bknb.a(parambknb));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bknb parambknb, Integer paramInteger)
  {
    if (parambknb != null) {
      bknb.a(parambknb, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknc
 * JD-Core Version:    0.7.0.1
 */