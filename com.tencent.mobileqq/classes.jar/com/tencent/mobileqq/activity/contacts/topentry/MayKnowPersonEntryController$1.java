package com.tencent.mobileqq.activity.contacts.topentry;

import ajld;
import ajlq;
import android.os.Message;
import bkgm;
import java.util.List;

public class MayKnowPersonEntryController$1
  implements Runnable
{
  public MayKnowPersonEntryController$1(ajlq paramajlq) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_Bkgm.removeMessages(2);
    if (this.this$0.jdField_a_of_type_Ajld != null)
    {
      List localList = this.this$0.jdField_a_of_type_Ajld.b();
      this.this$0.jdField_a_of_type_Bkgm.removeMessages(1);
      Message.obtain(this.this$0.jdField_a_of_type_Bkgm, 1, 0, 0, localList).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController.1
 * JD-Core Version:    0.7.0.1
 */