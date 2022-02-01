package com.tencent.av.gaudio;

import java.util.ArrayList;
import java.util.Iterator;
import lnm;
import lnv;

public class GaInviteLockActivity$1$1
  implements Runnable
{
  public GaInviteLockActivity$1$1(lnm paramlnm, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Lnm.a.a != null)
    {
      GaInviteLockActivity.a(this.jdField_a_of_type_Lnm.a).clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        lnv locallnv = (lnv)localIterator.next();
        if (locallnv.a != this.jdField_a_of_type_Lnm.a.b) {
          GaInviteLockActivity.a(this.jdField_a_of_type_Lnm.a).add(locallnv);
        }
      }
      GaInviteLockActivity.a(this.jdField_a_of_type_Lnm.a, "InviteMemberObserverWithoutCache" + GaInviteLockActivity.a(this.jdField_a_of_type_Lnm.a).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.1.1
 * JD-Core Version:    0.7.0.1
 */