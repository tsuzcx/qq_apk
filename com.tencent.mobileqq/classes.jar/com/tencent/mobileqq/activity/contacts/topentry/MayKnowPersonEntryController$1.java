package com.tencent.mobileqq.activity.contacts.topentry;

import afry;
import afsg;
import android.os.Message;
import bfob;
import java.util.List;

public class MayKnowPersonEntryController$1
  implements Runnable
{
  public MayKnowPersonEntryController$1(afsg paramafsg) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Bfob.removeMessages(2);
    if (this.this$0.jdField_a_of_type_Afry != null)
    {
      List localList = this.this$0.jdField_a_of_type_Afry.b();
      this.this$0.jdField_a_of_type_Bfob.removeMessages(1);
      Message.obtain(this.this$0.jdField_a_of_type_Bfob, 1, 0, 0, localList).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController.1
 * JD-Core Version:    0.7.0.1
 */