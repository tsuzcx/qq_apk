package com.tencent.mobileqq.activity;

import android.os.Handler;
import awgf;
import awgg;
import bdeu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ChatSettingForTroop$23
  implements Runnable
{
  ChatSettingForTroop$23(ChatSettingForTroop paramChatSettingForTroop) {}
  
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
        localObject1 = ((awgf)localObject2).a(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.this$0.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin }, null, null, null, null);
        ((awgf)localObject2).a();
      }
    } while (localObject1 == null);
    Object localObject2 = new ArrayList(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject1).next();
      if (bdeu.d(localTroopMemberInfo.memberuin)) {
        ((ArrayList)localObject2).add(localTroopMemberInfo.memberuin);
      }
    }
    this.this$0.jdField_a_of_type_AndroidOsHandler.post(new ChatSettingForTroop.23.1(this, (ArrayList)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.23
 * JD-Core Version:    0.7.0.1
 */