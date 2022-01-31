import android.util.Property;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.MarkDrawable;

public class aonc
  extends Property
{
  public aonc(MarkDrawable paramMarkDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(MarkDrawable paramMarkDrawable)
  {
    if (paramMarkDrawable != null) {
      return Float.valueOf(MarkDrawable.a(paramMarkDrawable));
    }
    return Float.valueOf(0.0F);
  }
  
  public void a(MarkDrawable paramMarkDrawable, Float paramFloat)
  {
    if (paramMarkDrawable != null) {
      MarkDrawable.a(paramMarkDrawable, paramFloat.floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aonc
 * JD-Core Version:    0.7.0.1
 */