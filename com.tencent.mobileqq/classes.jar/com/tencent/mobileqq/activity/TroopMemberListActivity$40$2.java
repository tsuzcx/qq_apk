package com.tencent.mobileqq.activity;

import aeom;
import aeox;
import amsw;
import bfun;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import mqq.os.MqqHandler;

public class TroopMemberListActivity$40$2
  implements Runnable
{
  public TroopMemberListActivity$40$2(aeom paramaeom, String paramString) {}
  
  public void run()
  {
    Object localObject = (amsw)this.jdField_a_of_type_Aeom.a.app.getManager(51);
    TroopMemberInfo localTroopMemberInfo = bfun.a().a(this.jdField_a_of_type_Aeom.a.app, this.jdField_a_of_type_Aeom.a.b, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_Aeom.a.a(localTroopMemberInfo, (amsw)localObject);
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.40.2.1(this, (aeox)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.40.2
 * JD-Core Version:    0.7.0.1
 */