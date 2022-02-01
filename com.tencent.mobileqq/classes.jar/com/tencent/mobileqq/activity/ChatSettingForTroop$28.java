package com.tencent.mobileqq.activity;

import android.os.Handler;
import bhbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ChatSettingForTroop$28
  implements Runnable
{
  ChatSettingForTroop$28(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    Object localObject1 = null;
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) || (this.this$0.jdField_a_of_type_AndroidOsHandler == null)) {}
    do
    {
      return;
      localObject2 = this.this$0.app.getEntityManagerFactory().createEntityManager();
      if (localObject2 != null)
      {
        localObject1 = ((EntityManager)localObject2).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin }, null, null, null, null);
        ((EntityManager)localObject2).close();
      }
    } while (localObject1 == null);
    Object localObject2 = new ArrayList(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject1).next();
      if (bhbx.d(localTroopMemberInfo.memberuin)) {
        ((ArrayList)localObject2).add(localTroopMemberInfo.memberuin);
      }
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.post(new ChatSettingForTroop.28.1(this, (ArrayList)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.28
 * JD-Core Version:    0.7.0.1
 */