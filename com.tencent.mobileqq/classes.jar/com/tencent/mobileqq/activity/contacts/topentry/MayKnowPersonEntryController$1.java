package com.tencent.mobileqq.activity.contacts.topentry;

import ahpq;
import ahpy;
import android.os.Message;
import bhow;
import java.util.List;

public class MayKnowPersonEntryController$1
  implements Runnable
{
  public MayKnowPersonEntryController$1(ahpy paramahpy) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Bhow.removeMessages(2);
    if (this.this$0.jdField_a_of_type_Ahpq != null)
    {
      List localList = this.this$0.jdField_a_of_type_Ahpq.b();
      this.this$0.jdField_a_of_type_Bhow.removeMessages(1);
      Message.obtain(this.this$0.jdField_a_of_type_Bhow, 1, 0, 0, localList).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController.1
 * JD-Core Version:    0.7.0.1
 */