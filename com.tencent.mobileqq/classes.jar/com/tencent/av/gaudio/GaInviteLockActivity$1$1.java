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
      Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Memberinfo)((Iterator)localObject1).next();
        if (((Memberinfo)localObject2).a != this.jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$1.a.b) {
          GaInviteLockActivity.a(this.jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$1.a).add(localObject2);
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$1.a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("InviteMemberObserverWithoutCache");
      ((StringBuilder)localObject2).append(GaInviteLockActivity.a(this.jdField_a_of_type_ComTencentAvGaudioGaInviteLockActivity$1.a).size());
      GaInviteLockActivity.a((GaInviteLockActivity)localObject1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.1.1
 * JD-Core Version:    0.7.0.1
 */