package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import lnv;
import mez;

public class MultiIncomingCallsActivity$1$1
  implements Runnable
{
  public MultiIncomingCallsActivity$1$1(mez parammez, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Mez.a.a != null)
    {
      MultiIncomingCallsActivity.a(this.jdField_a_of_type_Mez.a).clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        lnv locallnv = (lnv)localIterator.next();
        if (locallnv.a != this.jdField_a_of_type_Mez.a.jdField_b_of_type_Long) {
          MultiIncomingCallsActivity.a(this.jdField_a_of_type_Mez.a).add(locallnv);
        }
      }
      MultiIncomingCallsActivity.a(this.jdField_a_of_type_Mez.a);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_Mez.a.jdField_b_of_type_JavaLangString, 2, "InviteMemberObserverWithoutCache mMemberChangeEventReceiver size:" + MultiIncomingCallsActivity.a(this.jdField_a_of_type_Mez.a).size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.1.1
 * JD-Core Version:    0.7.0.1
 */