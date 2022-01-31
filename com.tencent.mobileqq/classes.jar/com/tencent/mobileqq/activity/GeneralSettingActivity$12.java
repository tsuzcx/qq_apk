package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import axmp;
import com.tencent.mobileqq.app.QQAppInterface;

class GeneralSettingActivity$12
  implements Runnable
{
  GeneralSettingActivity$12(GeneralSettingActivity paramGeneralSettingActivity, boolean paramBoolean1, int paramInt, CompoundButton paramCompoundButton, boolean paramBoolean2) {}
  
  public void run()
  {
    if (!((axmp)this.this$0.app.a(154)).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, true))
    {
      this.this$0.a(2131719399, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity.12
 * JD-Core Version:    0.7.0.1
 */