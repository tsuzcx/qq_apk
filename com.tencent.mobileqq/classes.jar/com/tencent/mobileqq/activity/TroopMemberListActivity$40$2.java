package com.tencent.mobileqq.activity;

import ackj;
import acku;
import ajxl;
import bbdd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;

public class TroopMemberListActivity$40$2
  implements Runnable
{
  public TroopMemberListActivity$40$2(ackj paramackj, String paramString) {}
  
  public void run()
  {
    Object localObject = (ajxl)this.jdField_a_of_type_Ackj.a.app.getManager(51);
    TroopMemberInfo localTroopMemberInfo = bbdd.a().a(this.jdField_a_of_type_Ackj.a.app, this.jdField_a_of_type_Ackj.a.b, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_Ackj.a.a(localTroopMemberInfo, (ajxl)localObject);
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.40.2.1(this, (acku)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.40.2
 * JD-Core Version:    0.7.0.1
 */