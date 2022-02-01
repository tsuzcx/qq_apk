package com.tencent.mobileqq.activity;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;

class PermisionPrivacyActivity$9
  extends TroopSettingObserver
{
  PermisionPrivacyActivity$9(PermisionPrivacyActivity paramPermisionPrivacyActivity) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.a.f.a().setChecked(paramBoolean2);
      Object localObject = this.a.a;
      int i;
      if (paramBoolean2) {
        i = 2131693065;
      } else {
        i = 2131693066;
      }
      ((TextView)localObject).setText(i);
      localObject = this.a;
      SharedPreUtils.c((Context)localObject, ((PermisionPrivacyActivity)localObject).app.getCurrentAccountUin(), paramBoolean2);
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      QQToast.a(this.a, 1, HardCodeUtil.a(2131707926), 0).a();
      this.a.f.a().setChecked(paramBoolean2 ^ true);
      return;
    }
    PermisionPrivacyActivity localPermisionPrivacyActivity = this.a;
    SharedPreUtils.c(localPermisionPrivacyActivity, localPermisionPrivacyActivity.app.getCurrentAccountUin(), paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.9
 * JD-Core Version:    0.7.0.1
 */