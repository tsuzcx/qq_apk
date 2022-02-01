package com.tencent.mobileqq.activity.contact.newfriend;

import androidx.fragment.app.FragmentActivity;
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAgreeSuspiciousMsg ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramLong);
      QLog.d("AddRequestSuspiciousMsgFragment", 2, localStringBuilder.toString());
    }
    if ((AddRequestSuspiciousMsgFragment.a(this.a) != null) && (AddRequestSuspiciousMsgFragment.a(this.a).uin == paramLong))
    {
      AddRequestSuspiciousMsgFragment.b(this.a);
      if (paramBoolean)
      {
        QQToast.makeText(this.a.getActivity(), HardCodeUtil.a(2131898141), 0).show();
        AddRequestSuspiciousMsgFragment.c(this.a);
        this.a.getActivity().finish();
        return;
      }
      QQToast.makeText(this.a.getActivity(), HardCodeUtil.a(2131898142), 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.AddRequestSuspiciousMsgFragment.1
 * JD-Core Version:    0.7.0.1
 */