import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import com.tencent.ttpic.openapi.model.WMEditItem;

class blty
  implements View.OnFocusChangeListener
{
  blty(bltv parambltv, blud paramblud, WMEditItem paramWMEditItem) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bltv.a(this.jdField_a_of_type_Bltv, this.jdField_a_of_type_Blud.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
      this.jdField_a_of_type_Blud.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837693);
      this.jdField_a_of_type_Blud.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Blud.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blty
 * JD-Core Version:    0.7.0.1
 */