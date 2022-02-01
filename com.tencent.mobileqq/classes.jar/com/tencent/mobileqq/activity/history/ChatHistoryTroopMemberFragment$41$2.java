package com.tencent.mobileqq.activity.history;

import ajvh;
import ajvr;
import anvk;
import bhdf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import mqq.os.MqqHandler;

public class ChatHistoryTroopMemberFragment$41$2
  implements Runnable
{
  public ChatHistoryTroopMemberFragment$41$2(ajvh paramajvh, String paramString) {}
  
  public void run()
  {
    Object localObject = (anvk)this.jdField_a_of_type_Ajvh.a.b.getManager(QQManagerFactory.FRIENDS_MANAGER);
    TroopMemberInfo localTroopMemberInfo = bhdf.a().a(this.jdField_a_of_type_Ajvh.a.b, this.jdField_a_of_type_Ajvh.a.c, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_Ajvh.a.a(localTroopMemberInfo, (anvk)localObject);
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.41.2.1(this, (ajvr)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.2
 * JD-Core Version:    0.7.0.1
 */