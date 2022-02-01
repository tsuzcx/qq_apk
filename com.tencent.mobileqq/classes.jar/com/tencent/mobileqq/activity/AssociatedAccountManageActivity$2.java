package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.subaccount.SubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi.CardObserverCallback;
import com.tencent.mobileqq.widget.FormSwitchItem;
import mqq.os.MqqHandler;

class AssociatedAccountManageActivity$2
  implements ISubAccountApi.CardObserverCallback
{
  AssociatedAccountManageActivity$2(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void a(boolean paramBoolean)
  {
    boolean bool = AssociatedAccountManageActivity.access$200(this.a).a();
    AssociatedAccountManageActivity.access$300(this.a).removeMessages(8193);
    AssociatedAccountManageActivity.access$300(this.a).sendEmptyMessage(8194);
    Message localMessage = AssociatedAccountManageActivity.access$300(this.a).obtainMessage(8195);
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    localMessage.arg1 = i;
    if (paramBoolean)
    {
      if (bool) {
        i = 2131699317;
      } else {
        i = 2131699316;
      }
    }
    else if (bool) {
      i = 2131719315;
    } else {
      i = 2131719314;
    }
    localMessage.arg2 = i;
    AssociatedAccountManageActivity.access$300(this.a).sendMessage(localMessage);
    if (paramBoolean)
    {
      AssociatedAccountManageActivity.access$400(this.a);
      SubAccountControllUtil.a(this.a.app, bool);
      return;
    }
    AssociatedAccountManageActivity.access$500(this.a, bool ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.2
 * JD-Core Version:    0.7.0.1
 */