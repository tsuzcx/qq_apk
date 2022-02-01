package com.tencent.av.gaudio;

import java.util.ArrayList;
import java.util.Iterator;

class GaInviteLockActivity$1$1
  implements Runnable
{
  GaInviteLockActivity$1$1(GaInviteLockActivity.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$1.a.a != null)
    {
      GaInviteLockActivity.a(this.jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$1.a).clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Memberinfo localMemberinfo = (Memberinfo)localIterator.next();
        if (localMemberinfo.a != this.jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$1.a.b) {
          GaInviteLockActivity.a(this.jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$1.a).add(localMemberinfo);
        }
      }
      GaInviteLockActivity.a(this.jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$1.a, "InviteMemberObserverWithoutCache" + GaInviteLockActivity.a(this.jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$1.a).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.1.1
 * JD-Core Version:    0.7.0.1
 */