package com.tencent.mobileqq.activity;

import afgy;
import anvk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class TroopRequestActivity$15$1
  implements Runnable
{
  public TroopRequestActivity$15$1(afgy paramafgy, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Afgy.a.app != null)
    {
      localObject = (anvk)this.jdField_a_of_type_Afgy.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (localObject != null)
      {
        localObject = ((anvk)localObject).b(this.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_Afgy.a.runOnUiThread(new TroopRequestActivity.15.1.1(this, (Card)localObject));
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      Object localObject;
      return;
    }
    QLog.d("Q.systemmsg.TroopRequestActivity", 2, "onUpdateFriendInfo app is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.15.1
 * JD-Core Version:    0.7.0.1
 */