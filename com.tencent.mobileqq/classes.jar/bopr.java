import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bopr
  implements View.OnFocusChangeListener
{
  bopr(bopo parambopo, bopw parambopw, WMEditItem paramWMEditItem) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bopo.a(this.jdField_a_of_type_Bopo, this.jdField_a_of_type_Bopw.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
      this.jdField_a_of_type_Bopw.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837691);
      this.jdField_a_of_type_Bopw.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Bopw.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bopr
 * JD-Core Version:    0.7.0.1
 */