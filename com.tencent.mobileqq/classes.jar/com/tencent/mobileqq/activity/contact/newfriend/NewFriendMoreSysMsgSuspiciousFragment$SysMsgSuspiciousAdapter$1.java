package com.tencent.mobileqq.activity.contact.newfriend;

import android.util.SparseArray;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter$1
  extends FriendListObserver
{
  NewFriendMoreSysMsgSuspiciousFragment$SysMsgSuspiciousAdapter$1(NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter paramSysMsgSuspiciousAdapter) {}
  
  public void onAgreeSuspiciousMsg(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onAgreeSuspiciousMsg " + paramBoolean + " " + paramInt);
    }
    if (paramBoolean)
    {
      QQToast.a(NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.a(this.a), HardCodeUtil.a(2131707494), 0).a();
      NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.a(this.a, paramLong);
      this.a.d();
      return;
    }
    QQToast.a(NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.a(this.a), HardCodeUtil.a(2131707501), 0).a();
  }
  
  public void onSuspiciousDel(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onSuspiciousDel " + paramBoolean + " " + paramInt + " " + paramLong);
    }
    if (paramBoolean) {
      this.a.d();
    }
  }
  
  public void onSuspiciousGetList(boolean paramBoolean, int paramInt, ArrayList<SysSuspiciousMsg> paramArrayList, byte[] paramArrayOfByte, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onSuspiciousGetList " + paramBoolean + " " + paramInt + " " + paramObject);
    }
    if (paramBoolean)
    {
      if ((paramObject instanceof Integer))
      {
        paramInt = ((Integer)paramObject).intValue();
        NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.a(this.a).put(paramInt, paramArrayOfByte);
      }
      if (paramArrayList != null) {
        NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.a(this.a, NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.a(this.a) + paramArrayList.size());
      }
      this.a.d();
    }
  }
  
  public void onSuspiciousSendReadReport(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, "onSuspiciousSendReadReport " + paramBoolean + " " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.1
 * JD-Core Version:    0.7.0.1
 */