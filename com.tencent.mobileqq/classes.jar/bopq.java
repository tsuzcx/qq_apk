import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bopq
  implements View.OnClickListener
{
  bopq(bopo parambopo, bopw parambopw, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).hideSoftInputFromWindow(bopo.a(this.jdField_a_of_type_Bopo).getWindowToken(), 0);
    bopo.a(this.jdField_a_of_type_Bopo).setTextColor(-1);
    bopo.a(this.jdField_a_of_type_Bopo, bopo.a(this.jdField_a_of_type_Bopo));
    bopo.a(this.jdField_a_of_type_Bopo, this.jdField_a_of_type_Bopw.a);
    bopo.a(this.jdField_a_of_type_Bopo).setTextColor(-12339461);
    bopo.a(this.jdField_a_of_type_Bopo, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
    if (bopo.a(this.jdField_a_of_type_Bopo) != null) {
      bopo.a(this.jdField_a_of_type_Bopo).a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.value, this.jdField_a_of_type_Bopw.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bopq
 * JD-Core Version:    0.7.0.1
 */