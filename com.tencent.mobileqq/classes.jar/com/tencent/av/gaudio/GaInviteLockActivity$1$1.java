package com.tencent.av.gaudio;

import java.util.ArrayList;
import java.util.Iterator;
import lqb;
import lqk;

public class GaInviteLockActivity$1$1
  implements Runnable
{
  public GaInviteLockActivity$1$1(lqb paramlqb, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Lqb.a.a != null)
    {
      GaInviteLockActivity.a(this.jdField_a_of_type_Lqb.a).clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        lqk locallqk = (lqk)localIterator.next();
        if (locallqk.a != this.jdField_a_of_type_Lqb.a.b) {
          GaInviteLockActivity.a(this.jdField_a_of_type_Lqb.a).add(locallqk);
        }
      }
      GaInviteLockActivity.a(this.jdField_a_of_type_Lqb.a, "InviteMemberObserverWithoutCache" + GaInviteLockActivity.a(this.jdField_a_of_type_Lqb.a).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.1.1
 * JD-Core Version:    0.7.0.1
 */