package com.tencent.av.gaudio;

import java.util.ArrayList;
import java.util.Iterator;
import lmy;
import lnh;

public class GaInviteLockActivity$1$1
  implements Runnable
{
  public GaInviteLockActivity$1$1(lmy paramlmy, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Lmy.a.a != null)
    {
      GaInviteLockActivity.a(this.jdField_a_of_type_Lmy.a).clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        lnh locallnh = (lnh)localIterator.next();
        if (locallnh.a != this.jdField_a_of_type_Lmy.a.b) {
          GaInviteLockActivity.a(this.jdField_a_of_type_Lmy.a).add(locallnh);
        }
      }
      GaInviteLockActivity.a(this.jdField_a_of_type_Lmy.a, "InviteMemberObserverWithoutCache" + GaInviteLockActivity.a(this.jdField_a_of_type_Lmy.a).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.1.1
 * JD-Core Version:    0.7.0.1
 */