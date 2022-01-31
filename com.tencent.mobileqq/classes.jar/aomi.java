import android.util.Property;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.ContainerDrawable;

public class aomi
  extends Property
{
  public aomi(ContainerDrawable paramContainerDrawable, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Integer a(ContainerDrawable paramContainerDrawable)
  {
    if (paramContainerDrawable != null) {
      return Integer.valueOf(ContainerDrawable.a(paramContainerDrawable));
    }
    return Integer.valueOf(0);
  }
  
  public void a(ContainerDrawable paramContainerDrawable, Integer paramInteger)
  {
    if (paramContainerDrawable != null) {
      ContainerDrawable.a(paramContainerDrawable, paramInteger.intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aomi
 * JD-Core Version:    0.7.0.1
 */