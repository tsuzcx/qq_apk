package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import lqk;
import mgz;

public class MultiIncomingCallsActivity$1$1
  implements Runnable
{
  public MultiIncomingCallsActivity$1$1(mgz parammgz, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Mgz.a.a != null)
    {
      MultiIncomingCallsActivity.a(this.jdField_a_of_type_Mgz.a).clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        lqk locallqk = (lqk)localIterator.next();
        if (locallqk.a != this.jdField_a_of_type_Mgz.a.jdField_b_of_type_Long) {
          MultiIncomingCallsActivity.a(this.jdField_a_of_type_Mgz.a).add(locallqk);
        }
      }
      MultiIncomingCallsActivity.a(this.jdField_a_of_type_Mgz.a);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_Mgz.a.jdField_b_of_type_JavaLangString, 2, "InviteMemberObserverWithoutCache mMemberChangeEventReceiver size:" + MultiIncomingCallsActivity.a(this.jdField_a_of_type_Mgz.a).size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.1.1
 * JD-Core Version:    0.7.0.1
 */