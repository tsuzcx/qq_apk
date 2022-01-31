import android.util.Property;

class bknx
  extends Property<bknw, Integer>
{
  bknx(bknw parambknw, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(bknw parambknw)
  {
    if (parambknw != null) {
      return Integer.valueOf(bknw.a(parambknw));
    }
    return Integer.valueOf(0);
  }
  
  public void a(bknw parambknw, Integer paramInteger)
  {
    if (parambknw != null) {
      bknw.a(parambknw, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bknx
 * JD-Core Version:    0.7.0.1
 */