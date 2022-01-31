import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;

public class anho
  implements Runnable
{
  public anho(EditTextDialog paramEditTextDialog) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b();
    if (EditTextDialog.a(this.a) != 1) {
      this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), true);
    }
    this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anho
 * JD-Core Version:    0.7.0.1
 */