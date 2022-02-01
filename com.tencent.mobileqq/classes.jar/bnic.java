import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bnic
  implements View.OnFocusChangeListener
{
  bnic(bnhy parambnhy, bnih parambnih, WMEditItem paramWMEditItem) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bnhy.a(this.jdField_a_of_type_Bnhy, this.jdField_a_of_type_Bnih.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
      this.jdField_a_of_type_Bnih.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837708);
      this.jdField_a_of_type_Bnih.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Bnih.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnic
 * JD-Core Version:    0.7.0.1
 */