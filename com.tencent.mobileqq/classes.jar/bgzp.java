import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bgzp
  implements View.OnClickListener
{
  bgzp(bgzn parambgzn, bgzv parambgzv, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).hideSoftInputFromWindow(bgzn.a(this.jdField_a_of_type_Bgzn).getWindowToken(), 0);
    bgzn.a(this.jdField_a_of_type_Bgzn).setTextColor(-1);
    bgzn.a(this.jdField_a_of_type_Bgzn, bgzn.a(this.jdField_a_of_type_Bgzn));
    bgzn.a(this.jdField_a_of_type_Bgzn, this.jdField_a_of_type_Bgzv.a);
    bgzn.a(this.jdField_a_of_type_Bgzn).setTextColor(-12339461);
    bgzn.a(this.jdField_a_of_type_Bgzn, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
    if (bgzn.a(this.jdField_a_of_type_Bgzn) != null) {
      bgzn.a(this.jdField_a_of_type_Bgzn).a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.value, this.jdField_a_of_type_Bgzv.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgzp
 * JD-Core Version:    0.7.0.1
 */