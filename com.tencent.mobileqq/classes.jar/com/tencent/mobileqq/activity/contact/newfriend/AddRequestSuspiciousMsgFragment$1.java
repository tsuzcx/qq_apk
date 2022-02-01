package com.tencent.mobileqq.activity.contact.newfriend;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AddRequestSuspiciousMsgFragment$1
  extends FriendListObserver
{
  AddRequestSuspiciousMsgFragment$1(AddRequestSuspiciousMsgFragment paramAddRequestSuspiciousMsgFragment) {}
  
  public void onAgreeSuspiciousMsg(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddRequestSuspiciousMsgFragment", 2, "onAgreeSuspiciousMsg " + paramBoolean + " " + paramInt + " " + paramLong);
    }
    if ((AddRequestSuspiciousMsgFragment.a(this.a) != null) && (AddRequestSuspiciousMsgFragment.a(this.a).uin == paramLong))
    {
      AddRequestSuspiciousMsgFragment.a(this.a);
      if (paramBoolean)
      {
        QQToast.a(this.a.getActivity(), HardCodeUtil.a(2131699955), 0).a();
        AddRequestSuspiciousMsgFragment.b(this.a);
        this.a.getActivity().finish();
      }
    }
    else
    {
      return;
    }
    QQToast.a(this.a.getActivity(), HardCodeUtil.a(2131699956), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.AddRequestSuspiciousMsgFragment.1
 * JD-Core Version:    0.7.0.1
 */