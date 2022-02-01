import android.support.annotation.NonNull;
import dov.com.qq.im.capture.text.EditTextPreView;

class bpjx
  implements bpvz
{
  bpjx(bpjo parambpjo) {}
  
  public void a(@NonNull bpwg parambpwg)
  {
    switch (parambpwg.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    int i = parambpwg.b;
    this.a.jdField_a_of_type_Bpiy.jdField_a_of_type_Int = i;
    this.a.c = i;
    if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof bork))
    {
      ((bork)this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem).a(i);
      this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.invalidate();
    }
    yqu.a("video_edit_text", "clk_color", 0, 0, new String[] { (String)wnh.a().a("EditVideoDTextFace.mSrcFrom"), parambpwg.jdField_a_of_type_JavaLangString, "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpjx
 * JD-Core Version:    0.7.0.1
 */