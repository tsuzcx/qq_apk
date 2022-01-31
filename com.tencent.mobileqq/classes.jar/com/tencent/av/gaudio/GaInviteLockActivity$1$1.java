package com.tencent.av.gaudio;

import java.util.ArrayList;
import java.util.Iterator;
import lny;
import loh;

public class GaInviteLockActivity$1$1
  implements Runnable
{
  public GaInviteLockActivity$1$1(lny paramlny, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Lny.a.a != null)
    {
      GaInviteLockActivity.a(this.jdField_a_of_type_Lny.a).clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        loh localloh = (loh)localIterator.next();
        if (localloh.a != this.jdField_a_of_type_Lny.a.b) {
          GaInviteLockActivity.a(this.jdField_a_of_type_Lny.a).add(localloh);
        }
      }
      GaInviteLockActivity.a(this.jdField_a_of_type_Lny.a, "InviteMemberObserverWithoutCache" + GaInviteLockActivity.a(this.jdField_a_of_type_Lny.a).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.1.1
 * JD-Core Version:    0.7.0.1
 */