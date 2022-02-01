package com.tencent.av.gaudio;

import java.util.ArrayList;
import java.util.Iterator;
import lnc;
import lnl;

public class GaInviteLockActivity$1$1
  implements Runnable
{
  public GaInviteLockActivity$1$1(lnc paramlnc, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Lnc.a.a != null)
    {
      GaInviteLockActivity.a(this.jdField_a_of_type_Lnc.a).clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        lnl locallnl = (lnl)localIterator.next();
        if (locallnl.a != this.jdField_a_of_type_Lnc.a.b) {
          GaInviteLockActivity.a(this.jdField_a_of_type_Lnc.a).add(locallnl);
        }
      }
      GaInviteLockActivity.a(this.jdField_a_of_type_Lnc.a, "InviteMemberObserverWithoutCache" + GaInviteLockActivity.a(this.jdField_a_of_type_Lnc.a).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.1.1
 * JD-Core Version:    0.7.0.1
 */