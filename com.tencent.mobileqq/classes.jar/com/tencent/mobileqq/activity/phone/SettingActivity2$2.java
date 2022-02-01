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
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.cancel();
    DialogUtil.a(this.b, 230, HardCodeUtil.a(2131911277), HardCodeUtil.a(2131911274), HardCodeUtil.a(2131911275), HardCodeUtil.a(2131898212), new SettingActivity2.2.1(this), new SettingActivity2.2.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.SettingActivity2.2
 * JD-Core Version:    0.7.0.1
 */