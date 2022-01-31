import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bipk
  implements View.OnFocusChangeListener
{
  bipk(biph parambiph, bipp parambipp, WMEditItem paramWMEditItem) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      biph.a(this.jdField_a_of_type_Biph, this.jdField_a_of_type_Bipp.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
      this.jdField_a_of_type_Bipp.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837634);
      this.jdField_a_of_type_Bipp.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Bipp.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bipk
 * JD-Core Version:    0.7.0.1
 */