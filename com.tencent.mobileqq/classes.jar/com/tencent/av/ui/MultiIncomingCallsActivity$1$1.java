package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import lnl;
import mei;

public class MultiIncomingCallsActivity$1$1
  implements Runnable
{
  public MultiIncomingCallsActivity$1$1(mei parammei, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Mei.a.a != null)
    {
      MultiIncomingCallsActivity.a(this.jdField_a_of_type_Mei.a).clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        lnl locallnl = (lnl)localIterator.next();
        if (locallnl.a != this.jdField_a_of_type_Mei.a.jdField_b_of_type_Long) {
          MultiIncomingCallsActivity.a(this.jdField_a_of_type_Mei.a).add(locallnl);
        }
      }
      MultiIncomingCallsActivity.a(this.jdField_a_of_type_Mei.a);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_Mei.a.jdField_b_of_type_JavaLangString, 2, "InviteMemberObserverWithoutCache mMemberChangeEventReceiver size:" + MultiIncomingCallsActivity.a(this.jdField_a_of_type_Mei.a).size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.1.1
 * JD-Core Version:    0.7.0.1
 */