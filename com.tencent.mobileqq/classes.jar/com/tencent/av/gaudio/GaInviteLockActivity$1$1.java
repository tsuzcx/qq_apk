package com.tencent.av.gaudio;

import java.util.ArrayList;
import java.util.Iterator;
import lod;
import lom;

public class GaInviteLockActivity$1$1
  implements Runnable
{
  public GaInviteLockActivity$1$1(lod paramlod, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Lod.a.a != null)
    {
      GaInviteLockActivity.a(this.jdField_a_of_type_Lod.a).clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        lom locallom = (lom)localIterator.next();
        if (locallom.a != this.jdField_a_of_type_Lod.a.b) {
          GaInviteLockActivity.a(this.jdField_a_of_type_Lod.a).add(locallom);
        }
      }
      GaInviteLockActivity.a(this.jdField_a_of_type_Lod.a, "InviteMemberObserverWithoutCache" + GaInviteLockActivity.a(this.jdField_a_of_type_Lod.a).size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.1.1
 * JD-Core Version:    0.7.0.1
 */