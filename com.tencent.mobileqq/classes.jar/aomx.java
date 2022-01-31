import android.util.Property;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.HintDrawable;

public class aomx
  extends Property
{
  public aomx(HintDrawable paramHintDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(HintDrawable paramHintDrawable)
  {
    if (paramHintDrawable != null) {
      return Integer.valueOf(HintDrawable.a(paramHintDrawable));
    }
    return Integer.valueOf(0);
  }
  
  public void a(HintDrawable paramHintDrawable, Integer paramInteger)
  {
    if (paramHintDrawable != null) {
      HintDrawable.a(paramHintDrawable, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aomx
 * JD-Core Version:    0.7.0.1
 */