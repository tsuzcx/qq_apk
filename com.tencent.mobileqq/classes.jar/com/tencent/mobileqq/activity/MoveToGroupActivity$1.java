package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class MoveToGroupActivity$1
  extends FriendListObserver
{
  MoveToGroupActivity$1(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  protected void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel())
    {
      paramGroupActionResp = new StringBuilder();
      paramGroupActionResp.append("onAddGroupResp isSuccess = ");
      paramGroupActionResp.append(paramBoolean);
      QLog.d("MoveToGroupActivity", 2, paramGroupActionResp.toString());
    }
    this.a.a(paramBoolean);
    MoveToGroupActivity.a(this.a, true);
  }
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if (this.a.isFinishing()) {
      return;
    }
    MoveToGroupActivity.a(this.a);
    if (paramString == null)
    {
      paramString = this.a;
      QQToast.a(paramString, paramString.getString(2131694223), 0).b(this.a.getTitleBarHeight());
    }
    else
    {
      paramString = this.a;
      QQToast.a(paramString, 2, paramString.getString(2131694225), 0).b(this.a.getTitleBarHeight());
    }
    MoveToGroupActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity.1
 * JD-Core Version:    0.7.0.1
 */