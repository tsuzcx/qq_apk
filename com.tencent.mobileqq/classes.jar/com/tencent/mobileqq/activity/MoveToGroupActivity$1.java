package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class MoveToGroupActivity$1
  extends FriendListObserver
{
  MoveToGroupActivity$1(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MoveToGroupActivity", 2, "onAddGroupResp isSuccess = " + paramBoolean);
    }
    this.a.a(paramBoolean);
    MoveToGroupActivity.a(this.a, true);
  }
  
  public void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if (this.a.isFinishing()) {
      return;
    }
    MoveToGroupActivity.a(this.a);
    if (paramString == null) {
      QQToast.a(this.a, this.a.getString(2131694258), 0).b(this.a.getTitleBarHeight());
    }
    for (;;)
    {
      MoveToGroupActivity.b(this.a);
      return;
      QQToast.a(this.a, 2, this.a.getString(2131694260), 0).b(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity.1
 * JD-Core Version:    0.7.0.1
 */