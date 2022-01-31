package com.tencent.mobileqq.activity;

import acab;
import acam;
import ajjj;
import babl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;

public class TroopMemberListActivity$40$2
  implements Runnable
{
  public TroopMemberListActivity$40$2(acab paramacab, String paramString) {}
  
  public void run()
  {
    Object localObject = (ajjj)this.jdField_a_of_type_Acab.a.app.getManager(51);
    TroopMemberInfo localTroopMemberInfo = babl.a().a(this.jdField_a_of_type_Acab.a.app, this.jdField_a_of_type_Acab.a.b, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_Acab.a.a(localTroopMemberInfo, (ajjj)localObject);
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.40.2.1(this, (acam)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.40.2
 * JD-Core Version:    0.7.0.1
 */