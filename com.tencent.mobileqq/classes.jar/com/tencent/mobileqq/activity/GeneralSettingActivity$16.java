package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import bdfe;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

class GeneralSettingActivity$16
  implements Runnable
{
  GeneralSettingActivity$16(GeneralSettingActivity paramGeneralSettingActivity, boolean paramBoolean1, int paramInt, CompoundButton paramCompoundButton, boolean paramBoolean2) {}
  
  public void run()
  {
    if (!((bdfe)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, true))
    {
      this.this$0.e(2131718614, 0);
      GeneralSettingActivity localGeneralSettingActivity = this.this$0;
      CompoundButton localCompoundButton = this.jdField_a_of_type_AndroidWidgetCompoundButton;
      if (!this.b) {}
      for (boolean bool = true;; bool = false)
      {
        localGeneralSettingActivity.a(localCompoundButton, bool);
        return;
      }
    }
    GeneralSettingActivity.a(this.this$0, true, this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.16
 * JD-Core Version:    0.7.0.1
 */