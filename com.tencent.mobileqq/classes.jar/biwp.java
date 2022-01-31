import android.util.Property;

class biwp
  extends Property<biwo, Float>
{
  biwp(biwo parambiwo, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(biwo parambiwo)
  {
    if (parambiwo != null) {
      return Float.valueOf(biwo.a(parambiwo));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(biwo parambiwo, Float paramFloat)
  {
    if (parambiwo != null) {
      biwo.a(parambiwo, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwp
 * JD-Core Version:    0.7.0.1
 */