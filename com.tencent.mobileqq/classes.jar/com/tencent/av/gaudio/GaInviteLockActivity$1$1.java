package com.tencent.av.gaudio;

import java.util.ArrayList;
import java.util.Iterator;

class GaInviteLockActivity$1$1
  implements Runnable
{
  GaInviteLockActivity$1$1(GaInviteLockActivity.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.b.b.N != null)
    {
      GaInviteLockActivity.a(this.b.b).clear();
      Object localObject1 = this.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Memberinfo)((Iterator)localObject1).next();
        if (((Memberinfo)localObject2).a != this.b.b.c) {
          GaInviteLockActivity.a(this.b.b).add(localObject2);
        }
      }
      localObject1 = this.b.b;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("InviteMemberObserverWithoutCache");
      ((StringBuilder)localObject2).append(GaInviteLockActivity.a(this.b.b).size());
      GaInviteLockActivity.a((GaInviteLockActivity)localObject1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.1.1
 * JD-Core Version:    0.7.0.1
 */