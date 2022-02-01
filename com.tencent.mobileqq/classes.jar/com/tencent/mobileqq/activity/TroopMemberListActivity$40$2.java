package com.tencent.mobileqq.activity;

import afmp;
import afna;
import anmw;
import bglj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;

public class TroopMemberListActivity$40$2
  implements Runnable
{
  public TroopMemberListActivity$40$2(afmp paramafmp, String paramString) {}
  
  public void run()
  {
    Object localObject = (anmw)this.jdField_a_of_type_Afmp.a.app.getManager(51);
    TroopMemberInfo localTroopMemberInfo = bglj.a().a(this.jdField_a_of_type_Afmp.a.app, this.jdField_a_of_type_Afmp.a.b, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_Afmp.a.a(localTroopMemberInfo, (anmw)localObject);
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.40.2.1(this, (afna)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.40.2
 * JD-Core Version:    0.7.0.1
 */