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
    this.this$0.m.removeMessages(2);
    if (this.this$0.j != null)
    {
      List localList = this.this$0.j.f();
      this.this$0.m.removeMessages(1);
      Message.obtain(this.this$0.m, 1, 0, 0, localList).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.MayKnowPersonEntryController.1
 * JD-Core Version:    0.7.0.1
 */