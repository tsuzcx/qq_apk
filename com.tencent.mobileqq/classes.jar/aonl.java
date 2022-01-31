import android.widget.ImageView;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.ContainerDrawable;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.HintDrawable;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer;

public class aonl
  implements Runnable
{
  public aonl(PickerContainer paramPickerContainer, String paramString) {}
  
  public void run()
  {
    HintDrawable localHintDrawable;
    if ((PickerContainer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer) != null) && (PickerContainer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer).a(this.jdField_a_of_type_JavaLangString)))
    {
      PickerContainer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer).stop();
      localHintDrawable = PickerContainer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer);
      if (PickerContainer.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer)) {
        break label167;
      }
    }
    label167:
    for (boolean bool = true;; bool = false)
    {
      localHintDrawable.a(bool);
      PickerContainer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer).a(1);
      PickerContainer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer).start();
      if (PickerContainer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer) != null) {
        PickerContainer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer).setVisibility(0);
      }
      if ((!PickerContainer.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer)) && (PickerContainer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer) != null))
      {
        PickerContainer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer).stop();
        PickerContainer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer).a(true);
        PickerContainer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer).a(1);
        PickerContainer.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerContainer).start();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aonl
 * JD-Core Version:    0.7.0.1
 */