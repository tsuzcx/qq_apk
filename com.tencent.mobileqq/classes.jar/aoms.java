import android.util.Property;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.GroundDrawable;

public class aoms
  extends Property
{
  public aoms(GroundDrawable paramGroundDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(GroundDrawable paramGroundDrawable)
  {
    if (paramGroundDrawable != null) {
      return Float.valueOf(GroundDrawable.d(paramGroundDrawable));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(GroundDrawable paramGroundDrawable, Float paramFloat)
  {
    if (paramGroundDrawable != null) {
      GroundDrawable.c(paramGroundDrawable, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoms
 * JD-Core Version:    0.7.0.1
 */