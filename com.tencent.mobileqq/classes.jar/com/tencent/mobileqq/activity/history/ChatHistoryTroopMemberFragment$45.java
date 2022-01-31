package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import android.os.Message;
import aukp;
import aukq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ChatHistoryTroopMemberFragment$45
  implements Runnable
{
  ChatHistoryTroopMemberFragment$45(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject3 = this.this$0.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        if (localObject3 == null) {
          break label168;
        }
        Object localObject1 = ((aukp)localObject3).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.this$0.c }, null, null, null, null);
        ((aukp)localObject3).a();
        if (localObject1 == null) {
          break label165;
        }
        localObject3 = new ArrayList(((List)localObject1).size());
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ((ArrayList)localObject3).add(((TroopMemberInfo)((Iterator)localObject1).next()).memberuin);
          continue;
        }
        localMessage = this.this$0.jdField_b_of_type_AndroidOsHandler.obtainMessage();
      }
      finally {}
      localMessage.what = 8;
      localMessage.obj = new Object[] { Boolean.valueOf(this.this$0.d), localObject3 };
      this.this$0.jdField_b_of_type_AndroidOsHandler.sendMessage(localMessage);
      label165:
      return;
      label168:
      Message localMessage = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.45
 * JD-Core Version:    0.7.0.1
 */