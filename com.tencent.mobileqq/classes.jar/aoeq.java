import android.util.Property;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;

public class aoeq
  extends Property
{
  public aoeq(PickerContainer paramPickerContainer, Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public Float a(PickerContainer paramPickerContainer)
  {
    if (paramPickerContainer != null) {
      return PickerContainer.a(paramPickerContainer);
    }
    return Float.valueOf(1.0F);
  }
  
  public void a(PickerContainer paramPickerContainer, Float paramFloat)
  {
    if (paramPickerContainer != null) {
      PickerContainer.a(paramPickerContainer, paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoeq
 * JD-Core Version:    0.7.0.1
 */