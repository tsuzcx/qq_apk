package com.tencent.mobileqq.activity.history;

import aicv;
import aidf;
import alto;
import bdgg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;

public class ChatHistoryTroopMemberFragment$41$2
  implements Runnable
{
  public ChatHistoryTroopMemberFragment$41$2(aicv paramaicv, String paramString) {}
  
  public void run()
  {
    Object localObject = (alto)this.jdField_a_of_type_Aicv.a.b.getManager(51);
    TroopMemberInfo localTroopMemberInfo = bdgg.a().a(this.jdField_a_of_type_Aicv.a.b, this.jdField_a_of_type_Aicv.a.c, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_Aicv.a.a(localTroopMemberInfo, (alto)localObject);
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.41.2.1(this, (aidf)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.2
 * JD-Core Version:    0.7.0.1
 */