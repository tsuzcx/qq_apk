package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;

class PermisionPrivacyActivity$9
  extends TroopBusinessObserver
{
  PermisionPrivacyActivity$9(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  public void onGetAutoAgreeInvite2GroupIn50Flag(boolean paramBoolean1, boolean paramBoolean2)
  {
    TextView localTextView;
    if (paramBoolean1)
    {
      this.a.f.a().setChecked(paramBoolean2);
      localTextView = this.a.a;
      if (!paramBoolean2) {
        break label59;
      }
    }
    label59:
    for (int i = 2131693105;; i = 2131693106)
    {
      localTextView.setText(i);
      SharedPreUtils.c(this.a, this.a.app.getCurrentAccountUin(), paramBoolean2);
      return;
    }
  }
  
  public void onSend0x4ff_86Rsp(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (!paramBoolean1)
    {
      QQToast.a(this.a, 1, HardCodeUtil.a(2131707903), 0).a();
      Switch localSwitch = this.a.f.a();
      if (!paramBoolean2) {}
      for (paramBoolean1 = bool;; paramBoolean1 = false)
      {
        localSwitch.setChecked(paramBoolean1);
        return;
      }
    }
    SharedPreUtils.c(this.a, this.a.app.getCurrentAccountUin(), paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.9
 * JD-Core Version:    0.7.0.1
 */