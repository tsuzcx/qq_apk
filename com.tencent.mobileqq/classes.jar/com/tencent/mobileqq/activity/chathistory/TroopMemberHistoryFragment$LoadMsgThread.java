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
    if (!this.this$0.isDetached())
    {
      long l1 = System.currentTimeMillis();
      Object localObject = this.this$0.a();
      Message localMessage = this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0, localObject);
      localMessage.arg1 = this.a;
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localMessage.arg2 = 10;
        if (QLog.isColorLevel())
        {
          long l2 = System.currentTimeMillis();
          localObject = TroopMemberHistoryFragment.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("More messages loaded. Costs ");
          localStringBuilder.append(l2 - l1);
          localStringBuilder.append(" ms.");
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
      }
      else
      {
        localMessage.arg2 = 11;
      }
      this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.LoadMsgThread
 * JD-Core Version:    0.7.0.1
 */