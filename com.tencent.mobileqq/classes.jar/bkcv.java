import android.support.annotation.NonNull;
import dov.com.qq.im.capture.text.EditTextPreView;

class bkcv
  implements bkox
{
  bkcv(bkcm parambkcm) {}
  
  public void a(@NonNull bkpe parambkpe)
  {
    switch (parambkpe.jdField_a_of_type_Int)
    {
    default: 
      return;
    }
    int i = parambkpe.b;
    this.a.jdField_a_of_type_Bkbw.jdField_a_of_type_Int = i;
    this.a.c = i;
    if ((this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem instanceof bjij))
    {
      ((bjij)this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem).a(i);
      this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.invalidate();
    }
    vei.a("video_edit_text", "clk_color", 0, 0, new String[] { (String)tau.a().a("EditVideoDTextFace.mSrcFrom"), parambkpe.jdField_a_of_type_JavaLangString, "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkcv
 * JD-Core Version:    0.7.0.1
 */