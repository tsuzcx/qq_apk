package com.tencent.av.ui;

import com.tencent.av.gaudio.Memberinfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class MultiIncomingCallsActivity$1$1
  implements Runnable
{
  MultiIncomingCallsActivity$1$1(MultiIncomingCallsActivity.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.b.b.s != null)
    {
      MultiIncomingCallsActivity.b(this.b.b).clear();
      Object localObject1 = this.a.iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Memberinfo)((Iterator)localObject1).next();
        if (((Memberinfo)localObject2).a != this.b.b.c) {
          MultiIncomingCallsActivity.b(this.b.b).add(localObject2);
        }
      }
      MultiIncomingCallsActivity.c(this.b.b);
      if (QLog.isColorLevel())
      {
        localObject1 = this.b.b.l;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("InviteMemberObserverWithoutCache mMemberChangeEventReceiver size:");
        ((StringBuilder)localObject2).append(MultiIncomingCallsActivity.b(this.b.b).size());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.1.1
 * JD-Core Version:    0.7.0.1
 */