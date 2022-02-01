package com.tencent.mobileqq.activity.contacts.topentry;

import ajwm;
import ajwz;
import android.os.Message;
import blhq;
import java.util.List;

public class MayKnowPersonEntryController$1
  implements Runnable
{
  public MayKnowPersonEntryController$1(ajwz paramajwz) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Blhq.removeMessages(2);
    if (this.this$0.jdField_a_of_type_Ajwm != null)
    {
      List localList = this.this$0.jdField_a_of_type_Ajwm.b();
      this.this$0.jdField_a_of_type_Blhq.removeMessages(1);
      Message.obtain(this.this$0.jdField_a_of_type_Blhq, 1, 0, 0, localList).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController.1
 * JD-Core Version:    0.7.0.1
 */