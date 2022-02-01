package com.tencent.av.ui;

import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MultiIncomingCallsActivity$3
  extends GAudioUIObserver
{
  MultiIncomingCallsActivity$3(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  protected void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onUserListALLUpdate");
    }
    MultiIncomingCallsActivity.a(this.a, paramLong, paramArrayList, paramInt1);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onMembersChange");
    }
    if (paramLong == this.a.a)
    {
      if (paramBoolean) {
        return;
      }
      if (((paramInt == 10) || (paramInt == 1)) && (this.a.isResume())) {
        MultiIncomingCallsActivity.a(this.a, paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.3
 * JD-Core Version:    0.7.0.1
 */