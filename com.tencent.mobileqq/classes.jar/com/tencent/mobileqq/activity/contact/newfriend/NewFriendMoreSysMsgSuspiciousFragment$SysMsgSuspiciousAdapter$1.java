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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAgreeSuspiciousMsg ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      QQToast.makeText(NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.c(this.a), HardCodeUtil.a(2131905334), 0).show();
      NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.a(this.a, paramLong);
      this.a.d();
      return;
    }
    QQToast.makeText(NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.c(this.a), HardCodeUtil.a(2131905341), 0).show();
  }
  
  public void onSuspiciousDel(boolean paramBoolean, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSuspiciousDel ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramLong);
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      this.a.d();
    }
  }
  
  public void onSuspiciousGetList(boolean paramBoolean, int paramInt, ArrayList<SysSuspiciousMsg> paramArrayList, byte[] paramArrayOfByte, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSuspiciousGetList ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramObject);
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      if ((paramObject instanceof Integer))
      {
        paramInt = ((Integer)paramObject).intValue();
        NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.a(this.a).put(paramInt, paramArrayOfByte);
      }
      if (paramArrayList != null)
      {
        paramArrayOfByte = this.a;
        NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.a(paramArrayOfByte, NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.b(paramArrayOfByte) + paramArrayList.size());
      }
      this.a.d();
    }
  }
  
  public void onSuspiciousSendReadReport(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSuspiciousSendReadReport ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramInt);
      QLog.d("NewFriendMoreSysMsgSuspiciousFragment", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment.SysMsgSuspiciousAdapter.1
 * JD-Core Version:    0.7.0.1
 */