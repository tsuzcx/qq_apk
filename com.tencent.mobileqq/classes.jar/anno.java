import android.util.Property;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.GroundDrawable;

public class anno
  extends Property
{
  public anno(GroundDrawable paramGroundDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(GroundDrawable paramGroundDrawable)
  {
    if (paramGroundDrawable != null) {
      return Float.valueOf(GroundDrawable.a(paramGroundDrawable));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(GroundDrawable paramGroundDrawable, Float paramFloat)
  {
    if (paramGroundDrawable != null) {
      GroundDrawable.a(paramGroundDrawable, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anno
 * JD-Core Version:    0.7.0.1
 */