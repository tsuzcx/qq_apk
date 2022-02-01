package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ChatHistoryTroopMemberFragment$50
  implements Runnable
{
  ChatHistoryTroopMemberFragment$50(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void run()
  {
    try
    {
      localObject4 = this.this$0.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if (localObject4 == null) {
        break label177;
      }
      localObject1 = ((EntityManager)localObject4).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.this$0.c }, null, null, null, null);
      ((EntityManager)localObject4).close();
    }
    finally
    {
      for (;;)
      {
        Object localObject4;
        Object localObject1;
        for (;;)
        {
          throw localObject2;
        }
        label177:
        Object localObject3 = null;
      }
    }
    if (localObject1 != null)
    {
      localObject4 = new ArrayList(((List)localObject1).size());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((ArrayList)localObject4).add(((TroopMemberInfo)((Iterator)localObject1).next()).memberuin);
      }
      localObject1 = this.this$0.jdField_b_of_type_AndroidOsHandler.obtainMessage();
      ((Message)localObject1).what = 8;
      ((Message)localObject1).obj = new Object[] { Boolean.valueOf(this.this$0.d), localObject4 };
      this.this$0.jdField_b_of_type_AndroidOsHandler.sendMessage((Message)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.50
 * JD-Core Version:    0.7.0.1
 */