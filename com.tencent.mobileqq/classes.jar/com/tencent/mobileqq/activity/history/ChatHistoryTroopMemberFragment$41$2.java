package com.tencent.mobileqq.activity.history;

import akes;
import akfc;
import anyw;
import bhlk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;

public class ChatHistoryTroopMemberFragment$41$2
  implements Runnable
{
  public ChatHistoryTroopMemberFragment$41$2(akes paramakes, String paramString) {}
  
  public void run()
  {
    Object localObject = (anyw)this.jdField_a_of_type_Akes.a.b.getManager(51);
    TroopMemberInfo localTroopMemberInfo = bhlk.a().a(this.jdField_a_of_type_Akes.a.b, this.jdField_a_of_type_Akes.a.c, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_Akes.a.a(localTroopMemberInfo, (anyw)localObject);
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.41.2.1(this, (akfc)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.2
 * JD-Core Version:    0.7.0.1
 */