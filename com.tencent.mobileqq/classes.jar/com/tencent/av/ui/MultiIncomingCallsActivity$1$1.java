package com.tencent.av.ui;

import com.tencent.av.gaudio.Memberinfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class MultiIncomingCallsActivity$1$1
  implements Runnable
{
  MultiIncomingCallsActivity$1$1(MultiIncomingCallsActivity.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity$1.a.a != null)
    {
      MultiIncomingCallsActivity.a(this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity$1.a).clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Memberinfo localMemberinfo = (Memberinfo)localIterator.next();
        if (localMemberinfo.a != this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity$1.a.jdField_b_of_type_Long) {
          MultiIncomingCallsActivity.a(this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity$1.a).add(localMemberinfo);
        }
      }
      MultiIncomingCallsActivity.a(this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity$1.a);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity$1.a.jdField_b_of_type_JavaLangString, 2, "InviteMemberObserverWithoutCache mMemberChangeEventReceiver size:" + MultiIncomingCallsActivity.a(this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity$1.a).size());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.1.1
 * JD-Core Version:    0.7.0.1
 */