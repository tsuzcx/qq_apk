import android.util.Property;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.MarkDrawable;

public class aona
  extends Property
{
  public aona(MarkDrawable paramMarkDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(MarkDrawable paramMarkDrawable)
  {
    if (paramMarkDrawable != null) {
      return Integer.valueOf(MarkDrawable.a(paramMarkDrawable));
    }
    return Integer.valueOf(0);
  }
  
  public void a(MarkDrawable paramMarkDrawable, Integer paramInteger)
  {
    if (paramMarkDrawable != null) {
      MarkDrawable.a(paramMarkDrawable, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aona
 * JD-Core Version:    0.7.0.1
 */