package com.tencent.mobileqq.activity.history;

import afok;
import afou;
import ajjj;
import babl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;

public class ChatHistoryTroopMemberFragment$41$2
  implements Runnable
{
  public ChatHistoryTroopMemberFragment$41$2(afok paramafok, String paramString) {}
  
  public void run()
  {
    Object localObject = (ajjj)this.jdField_a_of_type_Afok.a.b.getManager(51);
    TroopMemberInfo localTroopMemberInfo = babl.a().a(this.jdField_a_of_type_Afok.a.b, this.jdField_a_of_type_Afok.a.c, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_Afok.a.a(localTroopMemberInfo, (ajjj)localObject);
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.41.2.1(this, (afou)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.2
 * JD-Core Version:    0.7.0.1
 */