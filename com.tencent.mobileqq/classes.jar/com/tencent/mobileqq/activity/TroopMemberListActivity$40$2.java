package com.tencent.mobileqq.activity;

import affx;
import afgi;
import anvk;
import bhdf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import mqq.os.MqqHandler;

public class TroopMemberListActivity$40$2
  implements Runnable
{
  public TroopMemberListActivity$40$2(affx paramaffx, String paramString) {}
  
  public void run()
  {
    Object localObject = (anvk)this.jdField_a_of_type_Affx.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    TroopMemberInfo localTroopMemberInfo = bhdf.a().a(this.jdField_a_of_type_Affx.a.app, this.jdField_a_of_type_Affx.a.b, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_Affx.a.a(localTroopMemberInfo, (anvk)localObject);
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.40.2.1(this, (afgi)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.40.2
 * JD-Core Version:    0.7.0.1
 */