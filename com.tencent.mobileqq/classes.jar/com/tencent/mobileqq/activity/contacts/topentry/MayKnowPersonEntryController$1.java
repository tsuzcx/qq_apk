package com.tencent.mobileqq.activity.contacts.topentry;

import android.os.Message;
import com.tencent.util.WeakReferenceHandler;
import java.util.List;

class MayKnowPersonEntryController$1
  implements Runnable
{
  MayKnowPersonEntryController$1(MayKnowPersonEntryController paramMayKnowPersonEntryController) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(2);
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng != null)
    {
      List localList = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.b();
      this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
      Message.obtain(this.this$0.jdField_a_of_type_ComTencentUtilWeakReferenceHandler, 1, 0, 0, localList).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController.1
 * JD-Core Version:    0.7.0.1
 */