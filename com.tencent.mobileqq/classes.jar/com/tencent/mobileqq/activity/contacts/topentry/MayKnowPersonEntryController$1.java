package com.tencent.mobileqq.activity.contacts.topentry;

import afgd;
import afgl;
import android.os.Message;
import befq;
import java.util.List;

public class MayKnowPersonEntryController$1
  implements Runnable
{
  public MayKnowPersonEntryController$1(afgl paramafgl) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Befq.removeMessages(2);
    if (this.this$0.jdField_a_of_type_Afgd != null)
    {
      List localList = this.this$0.jdField_a_of_type_Afgd.b();
      this.this$0.jdField_a_of_type_Befq.removeMessages(1);
      Message.obtain(this.this$0.jdField_a_of_type_Befq, 1, 0, 0, localList).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController.1
 * JD-Core Version:    0.7.0.1
 */