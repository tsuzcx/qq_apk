package com.tencent.mobileqq.activity.chathistory;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class TroopMemberHistoryFragment$LoadMsgThread
  implements Runnable
{
  private int a;
  
  private TroopMemberHistoryFragment$LoadMsgThread(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    long l1;
    Message localMessage;
    if (!this.this$0.isDetached())
    {
      l1 = System.currentTimeMillis();
      List localList = this.this$0.a();
      localMessage = this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0, localList);
      localMessage.arg1 = this.a;
      if ((localList != null) && (!localList.isEmpty())) {
        break label83;
      }
      localMessage.arg2 = 11;
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
      label83:
      localMessage.arg2 = 10;
      if (QLog.isColorLevel())
      {
        long l2 = System.currentTimeMillis();
        QLog.d(TroopMemberHistoryFragment.jdField_a_of_type_JavaLangString, 2, "More messages loaded. Costs " + (l2 - l1) + " ms.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.LoadMsgThread
 * JD-Core Version:    0.7.0.1
 */