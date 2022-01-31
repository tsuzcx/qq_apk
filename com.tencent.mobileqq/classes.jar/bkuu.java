import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bkuu
  implements View.OnClickListener
{
  bkuu(bkus parambkus, bkva parambkva, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).hideSoftInputFromWindow(bkus.a(this.jdField_a_of_type_Bkus).getWindowToken(), 0);
    bkus.a(this.jdField_a_of_type_Bkus).setTextColor(-1);
    bkus.a(this.jdField_a_of_type_Bkus, bkus.a(this.jdField_a_of_type_Bkus));
    bkus.a(this.jdField_a_of_type_Bkus, this.jdField_a_of_type_Bkva.a);
    bkus.a(this.jdField_a_of_type_Bkus).setTextColor(-12339461);
    bkus.a(this.jdField_a_of_type_Bkus, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
    if (bkus.a(this.jdField_a_of_type_Bkus) != null) {
      bkus.a(this.jdField_a_of_type_Bkus).a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.value, this.jdField_a_of_type_Bkva.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkuu
 * JD-Core Version:    0.7.0.1
 */