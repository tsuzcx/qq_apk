package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;

class GeneralSettingActivity$17
  implements Runnable
{
  GeneralSettingActivity$17(GeneralSettingActivity paramGeneralSettingActivity, boolean paramBoolean1, int paramInt, CompoundButton paramCompoundButton, boolean paramBoolean2) {}
  
  public void run()
  {
    if (!((SimpleUIHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, true))
    {
      this.this$0.e(2131718856, 0);
      this.this$0.a(this.jdField_a_of_type_AndroidWidgetCompoundButton, this.b ^ true);
      return;
    }
    GeneralSettingActivity localGeneralSettingActivity = this.this$0;
    GeneralSettingActivity.a(localGeneralSettingActivity, true, localGeneralSettingActivity.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.17
 * JD-Core Version:    0.7.0.1
 */