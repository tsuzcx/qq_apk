import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bkzb
  implements View.OnClickListener
{
  bkzb(bkyz parambkyz, bkzh parambkzh, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).hideSoftInputFromWindow(bkyz.a(this.jdField_a_of_type_Bkyz).getWindowToken(), 0);
    bkyz.a(this.jdField_a_of_type_Bkyz).setTextColor(-1);
    bkyz.a(this.jdField_a_of_type_Bkyz, bkyz.a(this.jdField_a_of_type_Bkyz));
    bkyz.a(this.jdField_a_of_type_Bkyz, this.jdField_a_of_type_Bkzh.a);
    bkyz.a(this.jdField_a_of_type_Bkyz).setTextColor(-12339461);
    bkyz.a(this.jdField_a_of_type_Bkyz, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
    if (bkyz.a(this.jdField_a_of_type_Bkyz) != null) {
      bkyz.a(this.jdField_a_of_type_Bkyz).a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.value, this.jdField_a_of_type_Bkzh.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzb
 * JD-Core Version:    0.7.0.1
 */