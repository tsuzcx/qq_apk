package com.tencent.mobileqq.activity.contacts.topentry;

import afsa;
import afsi;
import android.os.Message;
import bfnk;
import java.util.List;

public class MayKnowPersonEntryController$1
  implements Runnable
{
  public MayKnowPersonEntryController$1(afsi paramafsi) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Bfnk.removeMessages(2);
    if (this.this$0.jdField_a_of_type_Afsa != null)
    {
      List localList = this.this$0.jdField_a_of_type_Afsa.b();
      this.this$0.jdField_a_of_type_Bfnk.removeMessages(1);
      Message.obtain(this.this$0.jdField_a_of_type_Bfnk, 1, 0, 0, localList).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController.1
 * JD-Core Version:    0.7.0.1
 */