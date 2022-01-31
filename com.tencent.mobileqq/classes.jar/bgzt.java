import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.ttpic.openapi.model.WMElement;

class bgzt
  implements DialogInterface.OnClickListener
{
  bgzt(bgzn parambgzn, bgzv parambgzv, WMElement paramWMElement) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bgzv.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Bgzv.jdField_a_of_type_AndroidWidgetEditText.setText(this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMElement.getCheckInResetString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgzt
 * JD-Core Version:    0.7.0.1
 */