import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bkuv
  implements View.OnFocusChangeListener
{
  bkuv(bkus parambkus, bkva parambkva, WMEditItem paramWMEditItem) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bkus.a(this.jdField_a_of_type_Bkus, this.jdField_a_of_type_Bkva.jdField_a_of_type_AndroidWidgetEditText, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
      this.jdField_a_of_type_Bkva.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130837640);
      this.jdField_a_of_type_Bkva.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_Bkva.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkuv
 * JD-Core Version:    0.7.0.1
 */