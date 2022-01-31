import android.util.Property;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.GroundDrawable;

public class aoeb
  extends Property
{
  public aoeb(GroundDrawable paramGroundDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(GroundDrawable paramGroundDrawable)
  {
    if (paramGroundDrawable != null) {
      return Integer.valueOf(GroundDrawable.d(paramGroundDrawable));
    }
    return Integer.valueOf(0);
  }
  
  public void a(GroundDrawable paramGroundDrawable, Integer paramInteger)
  {
    if (paramGroundDrawable != null) {
      GroundDrawable.d(paramGroundDrawable, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoeb
 * JD-Core Version:    0.7.0.1
 */