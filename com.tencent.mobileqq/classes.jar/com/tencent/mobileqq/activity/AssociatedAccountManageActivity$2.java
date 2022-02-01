package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.widget.FormSwitchItem;
import mqq.os.MqqHandler;

class AssociatedAccountManageActivity$2
  extends CardObserver
{
  AssociatedAccountManageActivity$2(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void onSetSubaccountDisplayThirdQQ(boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = AssociatedAccountManageActivity.a(this.a).a();
    AssociatedAccountManageActivity.a(this.a).removeMessages(8193);
    AssociatedAccountManageActivity.a(this.a).sendEmptyMessage(8194);
    Object localObject = AssociatedAccountManageActivity.a(this.a).obtainMessage(8195);
    int i;
    if (paramBoolean)
    {
      i = 2;
      ((Message)localObject).arg1 = i;
      if (!paramBoolean) {
        break label134;
      }
      if (!bool2) {
        break label128;
      }
      i = 2131699213;
    }
    for (;;)
    {
      ((Message)localObject).arg2 = i;
      AssociatedAccountManageActivity.a(this.a).sendMessage((Message)localObject);
      if (!paramBoolean) {
        break label151;
      }
      AssociatedAccountManageActivity.a(this.a);
      SubAccountControll.a(this.a.app, bool2);
      return;
      i = 1;
      break;
      label128:
      i = 2131699212;
      continue;
      label134:
      if (bool2) {
        i = 2131719596;
      } else {
        i = 2131719595;
      }
    }
    label151:
    localObject = this.a;
    if (!bool2) {}
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      AssociatedAccountManageActivity.a((AssociatedAccountManageActivity)localObject, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.2
 * JD-Core Version:    0.7.0.1
 */