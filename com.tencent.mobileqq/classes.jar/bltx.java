import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bltx
  implements View.OnClickListener
{
  bltx(bltv parambltv, blud paramblud, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).hideSoftInputFromWindow(bltv.a(this.jdField_a_of_type_Bltv).getWindowToken(), 0);
    bltv.a(this.jdField_a_of_type_Bltv).setTextColor(-1);
    bltv.a(this.jdField_a_of_type_Bltv, bltv.a(this.jdField_a_of_type_Bltv));
    bltv.a(this.jdField_a_of_type_Bltv, this.jdField_a_of_type_Blud.a);
    bltv.a(this.jdField_a_of_type_Bltv).setTextColor(-12339461);
    bltv.a(this.jdField_a_of_type_Bltv, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
    if (bltv.a(this.jdField_a_of_type_Bltv) != null) {
      bltv.a(this.jdField_a_of_type_Bltv).a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.value, this.jdField_a_of_type_Blud.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bltx
 * JD-Core Version:    0.7.0.1
 */