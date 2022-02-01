import android.support.annotation.NonNull;
import dov.com.qq.im.capture.text.EditTextPreView;

class bqls
  implements bqxu
{
  bqls(bqlj parambqlj) {}
  
  public void a(@NonNull bqyb parambqyb)
  {
    switch (parambqyb.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    int i = parambqyb.b;
    this.a.jdField_a_of_type_Bqkt.jdField_a_of_type_Int = i;
    this.a.c = i;
    if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof bptf))
    {
      ((bptf)this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem).a(i);
      this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.invalidate();
    }
    yup.a("video_edit_text", "clk_color", 0, 0, new String[] { (String)wrc.a().a("EditVideoDTextFace.mSrcFrom"), parambqyb.jdField_a_of_type_JavaLangString, "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqls
 * JD-Core Version:    0.7.0.1
 */