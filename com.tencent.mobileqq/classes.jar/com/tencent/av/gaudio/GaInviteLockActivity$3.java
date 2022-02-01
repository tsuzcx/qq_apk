package com.tencent.av.gaudio;

import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class GaInviteLockActivity$3
  extends GAudioUIObserver
{
  GaInviteLockActivity$3(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt1, int paramInt2)
  {
    GaInviteLockActivity.a(this.a, paramLong, paramArrayList, paramInt1);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onMembersChange");
    }
    if ((paramLong != this.a.a) || (paramBoolean)) {}
    while (((paramInt != 10) && (paramInt != 1)) || (!this.a.isResume())) {
      return;
    }
    GaInviteLockActivity.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.3
 * JD-Core Version:    0.7.0.1
 */