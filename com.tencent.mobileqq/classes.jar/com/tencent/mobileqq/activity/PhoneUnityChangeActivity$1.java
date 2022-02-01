package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PhoneUnityChangeActivity$1
  implements ActionSheet.OnButtonClickListener
{
  PhoneUnityChangeActivity$1(PhoneUnityChangeActivity paramPhoneUnityChangeActivity) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.f.cancel();
    if (this.a.e == null)
    {
      paramView = this.a;
      paramView.e = DialogUtil.a(paramView, 230, HardCodeUtil.a(2131905851), HardCodeUtil.a(2131905841), HardCodeUtil.a(2131905830), HardCodeUtil.a(2131898212), new PhoneUnityChangeActivity.1.1(this), new PhoneUnityChangeActivity.1.2(this));
    }
    if ((this.a.e != null) && (!this.a.e.isShowing()) && (!this.a.isFinishing())) {
      this.a.e.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityChangeActivity.1
 * JD-Core Version:    0.7.0.1
 */