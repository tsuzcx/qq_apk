import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.ttpic.openapi.model.WMEditItem;

class bnib
  implements View.OnClickListener
{
  bnib(bnhy parambnhy, bnih parambnih, WMEditItem paramWMEditItem) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).hideSoftInputFromWindow(bnhy.a(this.jdField_a_of_type_Bnhy).getWindowToken(), 0);
    bnhy.a(this.jdField_a_of_type_Bnhy).setTextColor(-1);
    bnhy.a(this.jdField_a_of_type_Bnhy, bnhy.a(this.jdField_a_of_type_Bnhy));
    bnhy.a(this.jdField_a_of_type_Bnhy, this.jdField_a_of_type_Bnih.a);
    if (bnlb.j(bnhy.a(this.jdField_a_of_type_Bnhy).getIntent())) {
      bnhy.a(this.jdField_a_of_type_Bnhy).setTextColor(bnhy.a(this.jdField_a_of_type_Bnhy).getResources().getColor(2131165269));
    }
    for (;;)
    {
      bnhy.a(this.jdField_a_of_type_Bnhy, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem);
      if (bnhy.a(this.jdField_a_of_type_Bnhy) != null) {
        bnhy.a(this.jdField_a_of_type_Bnhy).a(this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.itemType, this.jdField_a_of_type_ComTencentTtpicOpenapiModelWMEditItem.value, this.jdField_a_of_type_Bnih.a);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bnhy.a(this.jdField_a_of_type_Bnhy).setTextColor(bnhy.a(this.jdField_a_of_type_Bnhy).getResources().getColor(2131165270));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnib
 * JD-Core Version:    0.7.0.1
 */