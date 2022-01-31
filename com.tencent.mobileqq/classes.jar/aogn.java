import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import dov.com.qq.im.capture.text.DynamicTextItem;
import dov.com.qq.im.capture.text.EditTextPreView;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import mqq.os.MqqHandler;

public class aogn
  implements TextWatcher
{
  public aogn(EditTextDialog paramEditTextDialog) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = 49;
    if (this.a.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiEditTextDialog$EditTextDialogEventListener == null) {}
    do
    {
      return;
      if (this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem != null) {
        this.a.jdField_a_of_type_DovComQqImCaptureTextEditTextPreView.setText(this.a.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b(), paramCharSequence.toString());
      }
    } while (paramCharSequence.toString().length() <= 50);
    if (Character.isHighSurrogate(paramCharSequence.charAt(49))) {}
    for (;;)
    {
      paramCharSequence = paramCharSequence.subSequence(0, paramInt1).toString();
      this.a.jdField_a_of_type_AndroidWidgetEditText.setText(paramCharSequence);
      this.a.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.a.jdField_a_of_type_AndroidWidgetEditText.length());
      this.a.jdField_a_of_type_MqqOsMqqHandler.post(new aogo(this));
      return;
      paramInt1 = 50;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aogn
 * JD-Core Version:    0.7.0.1
 */