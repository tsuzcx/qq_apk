package com.tencent.av.gaudio;

import java.util.ArrayList;
import java.util.Iterator;
import ldm;
import ldv;

public class GaInviteLockActivity$1$1
  implements Runnable
{
  public GaInviteLockActivity$1$1(ldm paramldm, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ldm.a.a != null)
    {
      GaInviteLockActivity.a(this.jdField_a_of_type_Ldm.a).clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ldv localldv = (ldv)localIterator.next();
        if (localldv.a != this.jdField_a_of_type_Ldm.a.b) {
          GaInviteLockActivity.a(this.jdField_a_of_type_Ldm.a).add(localldv);
        }
      }
      GaInviteLockActivity.a(this.jdField_a_of_type_Ldm.a, "InviteMemberObserverWithoutCache" + GaInviteLockActivity.a(this.jdField_a_of_type_Ldm.a).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.1.1
 * JD-Core Version:    0.7.0.1
 */