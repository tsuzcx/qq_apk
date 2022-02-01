package com.tencent.av.gaudio;

import com.tencent.av.app.InviteMemberObserverWithoutCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class GaInviteLockActivity$1
  extends InviteMemberObserverWithoutCache
{
  GaInviteLockActivity$1(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  protected void a(long paramLong1, long paramLong2, ArrayList<Memberinfo> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveMemberList mMemberChangeEventReceiver size:");
      localStringBuilder.append(paramArrayList.size());
      QLog.d(str, 2, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().post(new GaInviteLockActivity.1.1(this, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.1
 * JD-Core Version:    0.7.0.1
 */