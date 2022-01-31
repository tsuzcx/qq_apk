import android.util.Property;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.HintDrawable;

public class aoee
  extends Property
{
  public aoee(HintDrawable paramHintDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(HintDrawable paramHintDrawable)
  {
    if (paramHintDrawable != null) {
      return Float.valueOf(HintDrawable.a(paramHintDrawable));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(HintDrawable paramHintDrawable, Float paramFloat)
  {
    if (paramHintDrawable != null) {
      HintDrawable.a(paramHintDrawable, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoee
 * JD-Core Version:    0.7.0.1
 */