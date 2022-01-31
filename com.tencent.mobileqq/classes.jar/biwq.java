import android.util.Property;

class biwq
  extends Property<biwo, Integer>
{
  biwq(biwo parambiwo, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(biwo parambiwo)
  {
    if (parambiwo != null) {
      return Integer.valueOf(biwo.a(parambiwo));
    }
    return Integer.valueOf(0);
  }
  
  public void a(biwo parambiwo, Integer paramInteger)
  {
    if (parambiwo != null) {
      biwo.a(parambiwo, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwq
 * JD-Core Version:    0.7.0.1
 */