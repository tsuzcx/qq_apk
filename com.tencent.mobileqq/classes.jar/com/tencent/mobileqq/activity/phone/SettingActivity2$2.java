package com.tencent.mobileqq.activity.phone;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class SettingActivity2$2
  implements ActionSheet.OnButtonClickListener
{
  SettingActivity2$2(SettingActivity2 paramSettingActivity2, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhoneSettingActivity2, 230, HardCodeUtil.a(2131713807), HardCodeUtil.a(2131713804), HardCodeUtil.a(2131713805), HardCodeUtil.a(2131713803), new SettingActivity2.2.1(this), new SettingActivity2.2.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.2
 * JD-Core Version:    0.7.0.1
 */