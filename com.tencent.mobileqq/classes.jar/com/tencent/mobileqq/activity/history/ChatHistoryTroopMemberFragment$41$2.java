package com.tencent.mobileqq.activity.history;

import aizs;
import ajac;
import amsw;
import bfun;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import mqq.os.MqqHandler;

public class ChatHistoryTroopMemberFragment$41$2
  implements Runnable
{
  public ChatHistoryTroopMemberFragment$41$2(aizs paramaizs, String paramString) {}
  
  public void run()
  {
    Object localObject = (amsw)this.jdField_a_of_type_Aizs.a.b.getManager(51);
    TroopMemberInfo localTroopMemberInfo = bfun.a().a(this.jdField_a_of_type_Aizs.a.b, this.jdField_a_of_type_Aizs.a.c, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_Aizs.a.a(localTroopMemberInfo, (amsw)localObject);
      ThreadManager.getUIHandler().post(new ChatHistoryTroopMemberFragment.41.2.1(this, (ajac)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41.2
 * JD-Core Version:    0.7.0.1
 */