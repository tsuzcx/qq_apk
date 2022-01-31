import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bipj
  implements View.OnClickListener
{
  bipj(biph parambiph, bipp parambipp, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).hideSoftInputFromWindow(biph.a(this.jdField_a_of_type_Biph).getWindowToken(), 0);
    biph.a(this.jdField_a_of_type_Biph).setTextColor(-1);
    biph.a(this.jdField_a_of_type_Biph, biph.a(this.jdField_a_of_type_Biph));
    biph.a(this.jdField_a_of_type_Biph, this.jdField_a_of_type_Bipp.a);
    biph.a(this.jdField_a_of_type_Biph).setTextColor(-12339461);
    biph.a(this.jdField_a_of_type_Biph, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
    if (biph.a(this.jdField_a_of_type_Biph) != null) {
      biph.a(this.jdField_a_of_type_Biph).a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.value, this.jdField_a_of_type_Bipp.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipj
 * JD-Core Version:    0.7.0.1
 */