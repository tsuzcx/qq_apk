package com.tencent.mobileqq.activity.history;

import agak;
import agau;
import ajxn;
import bbcp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;

public class ChatHistoryTroopMemberFragment$41$2
  implements Runnable
{
  public ChatHistoryTroopMemberFragment$41$2(agak paramagak, String paramString) {}
  
  public void run()
  {
    Object localObject = (ajxn)this.jdField_a_of_type_Agak.a.b.getManager(51);
    TroopMemberInfo localTroopMemberInfo = bbcp.a().a(this.jdField_a_of_type_Agak.a.b, this.jdField_a_of_type_Agak.a.c, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_Agak.a.a(localTroopMemberInfo, (ajxn)localObject);
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.41.2.1(this, (agau)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.2
 * JD-Core Version:    0.7.0.1
 */