import android.util.Property;

class bkny
  extends Property<bknw, Integer>
{
  bkny(bknw parambknw, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bknw parambknw)
  {
    if (parambknw != null) {
      return Integer.valueOf(bknw.b(parambknw));
    }
    return Integer.valueOf(255);
  }
  
  public void a(bknw parambknw, Integer paramInteger)
  {
    if (parambknw != null) {
      bknw.b(parambknw, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkny
 * JD-Core Version:    0.7.0.1
 */