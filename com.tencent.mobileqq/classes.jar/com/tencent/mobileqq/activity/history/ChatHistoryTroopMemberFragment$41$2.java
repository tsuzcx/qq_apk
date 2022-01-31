package com.tencent.mobileqq.activity.history;

import ahyg;
import ahyq;
import aloz;
import bdbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;

public class ChatHistoryTroopMemberFragment$41$2
  implements Runnable
{
  public ChatHistoryTroopMemberFragment$41$2(ahyg paramahyg, String paramString) {}
  
  public void run()
  {
    Object localObject = (aloz)this.jdField_a_of_type_Ahyg.a.b.getManager(51);
    TroopMemberInfo localTroopMemberInfo = bdbx.a().a(this.jdField_a_of_type_Ahyg.a.b, this.jdField_a_of_type_Ahyg.a.c, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_Ahyg.a.a(localTroopMemberInfo, (aloz)localObject);
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.41.2.1(this, (ahyq)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.2
 * JD-Core Version:    0.7.0.1
 */