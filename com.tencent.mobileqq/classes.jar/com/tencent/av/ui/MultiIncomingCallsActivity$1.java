package com.tencent.av.ui;

import com.tencent.av.app.InviteMemberObserverWithoutCache;
import com.tencent.av.gaudio.Memberinfo;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class MultiIncomingCallsActivity$1
  extends InviteMemberObserverWithoutCache
{
  MultiIncomingCallsActivity$1(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  protected void a(long paramLong1, long paramLong2, ArrayList<Memberinfo> paramArrayList)
  {
    if (MultiIncomingCallsActivity.a(this.b) != null)
    {
      ThreadManager.getUIHandler().removeCallbacks(MultiIncomingCallsActivity.a(this.b));
      MultiIncomingCallsActivity.a(this.b, null);
    }
    MultiIncomingCallsActivity.a(this.b, new MultiIncomingCallsActivity.1.1(this, paramArrayList));
    ThreadManager.getUIHandler().post(MultiIncomingCallsActivity.a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.1
 * JD-Core Version:    0.7.0.1
 */