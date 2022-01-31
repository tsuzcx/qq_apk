import android.view.ViewParent;
import dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerBarLayout;

public class aoeo
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public aoeo(PickerBarLayout paramPickerBarLayout) {}
  
  public void a()
  {
    this.jdField_a_of_type_Int = PickerBarLayout.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout);
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.getParent() != null) && (this.jdField_a_of_type_Int == PickerBarLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout)))
    {
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.a = true;
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.getParent().requestDisallowInterceptTouchEvent(true);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.sendAccessibilityEvent(2);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout.a(PickerBarLayout.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSpeedpickerPickerBarLayout));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoeo
 * JD-Core Version:    0.7.0.1
 */