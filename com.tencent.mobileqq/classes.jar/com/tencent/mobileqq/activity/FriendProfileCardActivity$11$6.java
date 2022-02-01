package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.phone.DenyRunnable.OnCancelAction;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.widget.QQToast;

class FriendProfileCardActivity$11$6
  implements DenyRunnable.OnCancelAction
{
  FriendProfileCardActivity$11$6(FriendProfileCardActivity.11 param11) {}
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQToast.a(this.a.a.getApplicationContext(), 1, HardCodeUtil.a(2131704917), 0).a();
      return;
    }
    paramContext = new Intent(this.a.a, GuideBindPhoneActivity.class);
    paramContext.putExtra("fromKeyForContactBind", 5);
    paramContext.putExtra("key_contact_name", this.a.a.a.a.k);
    paramContext.putExtra("key_contact_phone", this.a.a.a.a.a);
    this.a.a.startActivity(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.11.6
 * JD-Core Version:    0.7.0.1
 */