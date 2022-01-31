package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import azhx;
import com.tencent.mobileqq.app.QQAppInterface;

class GeneralSettingActivity$13
  implements Runnable
{
  GeneralSettingActivity$13(GeneralSettingActivity paramGeneralSettingActivity, boolean paramBoolean1, int paramInt, CompoundButton paramCompoundButton, boolean paramBoolean2) {}
  
  public void run()
  {
    if (!((azhx)this.this$0.app.a(154)).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, true))
    {
      this.this$0.e(2131719896, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.13
 * JD-Core Version:    0.7.0.1
 */