import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bnof
  implements View.OnClickListener
{
  bnof(bnod parambnod, bnol parambnol, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).hideSoftInputFromWindow(bnod.a(this.jdField_a_of_type_Bnod).getWindowToken(), 0);
    bnod.a(this.jdField_a_of_type_Bnod).setTextColor(-1);
    bnod.a(this.jdField_a_of_type_Bnod, bnod.a(this.jdField_a_of_type_Bnod));
    bnod.a(this.jdField_a_of_type_Bnod, this.jdField_a_of_type_Bnol.a);
    bnod.a(this.jdField_a_of_type_Bnod).setTextColor(-12339461);
    bnod.a(this.jdField_a_of_type_Bnod, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
    if (bnod.a(this.jdField_a_of_type_Bnod) != null) {
      bnod.a(this.jdField_a_of_type_Bnod).a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.value, this.jdField_a_of_type_Bnol.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnof
 * JD-Core Version:    0.7.0.1
 */