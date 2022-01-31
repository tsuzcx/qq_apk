import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.openapi.model.WMEditItem;

class biqa
  implements View.OnClickListener
{
  biqa(bipy parambipy, biqg parambiqg, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).hideSoftInputFromWindow(bipy.a(this.jdField_a_of_type_Bipy).getWindowToken(), 0);
    bipy.a(this.jdField_a_of_type_Bipy).setTextColor(-1);
    bipy.a(this.jdField_a_of_type_Bipy, bipy.a(this.jdField_a_of_type_Bipy));
    bipy.a(this.jdField_a_of_type_Bipy, this.jdField_a_of_type_Biqg.a);
    bipy.a(this.jdField_a_of_type_Bipy).setTextColor(-12339461);
    bipy.a(this.jdField_a_of_type_Bipy, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
    if (bipy.a(this.jdField_a_of_type_Bipy) != null) {
      bipy.a(this.jdField_a_of_type_Bipy).a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.value, this.jdField_a_of_type_Biqg.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biqa
 * JD-Core Version:    0.7.0.1
 */