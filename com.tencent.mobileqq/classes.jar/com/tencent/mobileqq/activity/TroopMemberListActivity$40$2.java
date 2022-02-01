package com.tencent.mobileqq.activity;

import afvt;
import afwe;
import anyw;
import bhlk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;

public class TroopMemberListActivity$40$2
  implements Runnable
{
  public TroopMemberListActivity$40$2(afvt paramafvt, String paramString) {}
  
  public void run()
  {
    Object localObject = (anyw)this.jdField_a_of_type_Afvt.a.app.getManager(51);
    TroopMemberInfo localTroopMemberInfo = bhlk.a().a(this.jdField_a_of_type_Afvt.a.app, this.jdField_a_of_type_Afvt.a.b, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_Afvt.a.a(localTroopMemberInfo, (anyw)localObject);
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.40.2.1(this, (afwe)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.40.2
 * JD-Core Version:    0.7.0.1
 */