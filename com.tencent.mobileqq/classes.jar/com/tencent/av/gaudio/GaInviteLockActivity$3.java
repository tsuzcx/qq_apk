package com.tencent.av.gaudio;

import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class GaInviteLockActivity$3
  extends GAudioUIObserver
{
  GaInviteLockActivity$3(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  protected void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt1, int paramInt2)
  {
    GaInviteLockActivity.a(this.b, paramLong, paramArrayList, paramInt1);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b.l, 2, "onMembersChange");
    }
    if (paramLong == this.b.b)
    {
      if (paramBoolean) {
        return;
      }
      if (((paramInt == 10) || (paramInt == 1)) && (this.b.isResume())) {
        GaInviteLockActivity.a(this.b, paramInt);
      }
    }
  }
  
  protected void g()
  {
    this.b.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.3
 * JD-Core Version:    0.7.0.1
 */