package com.tencent.av.gaudio;

import java.util.ArrayList;
import java.util.Iterator;
import lnp;
import lny;

public class GaInviteLockActivity$1$1
  implements Runnable
{
  public GaInviteLockActivity$1$1(lnp paramlnp, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Lnp.a.a != null)
    {
      GaInviteLockActivity.a(this.jdField_a_of_type_Lnp.a).clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        lny locallny = (lny)localIterator.next();
        if (locallny.a != this.jdField_a_of_type_Lnp.a.b) {
          GaInviteLockActivity.a(this.jdField_a_of_type_Lnp.a).add(locallny);
        }
      }
      GaInviteLockActivity.a(this.jdField_a_of_type_Lnp.a, "InviteMemberObserverWithoutCache" + GaInviteLockActivity.a(this.jdField_a_of_type_Lnp.a).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.1.1
 * JD-Core Version:    0.7.0.1
 */