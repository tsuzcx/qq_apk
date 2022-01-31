package com.tencent.mobileqq.activity;

import aebt;
import aece;
import aloz;
import bdbx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopMemberInfo;
import mqq.os.MqqHandler;

public class TroopMemberListActivity$40$2
  implements Runnable
{
  public TroopMemberListActivity$40$2(aebt paramaebt, String paramString) {}
  
  public void run()
  {
    Object localObject = (aloz)this.jdField_a_of_type_Aebt.a.app.getManager(51);
    TroopMemberInfo localTroopMemberInfo = bdbx.a().a(this.jdField_a_of_type_Aebt.a.app, this.jdField_a_of_type_Aebt.a.b, this.jdField_a_of_type_JavaLangString);
    if ((localTroopMemberInfo != null) && (localObject != null))
    {
      localObject = this.jdField_a_of_type_Aebt.a.a(localTroopMemberInfo, (aloz)localObject);
      ThreadManager.getUIHandler().post(new TroopMemberListActivity.40.2.1(this, (aece)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.40.2
 * JD-Core Version:    0.7.0.1
 */