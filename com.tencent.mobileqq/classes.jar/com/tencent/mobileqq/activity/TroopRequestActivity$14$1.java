package com.tencent.mobileqq.activity;

import acli;
import ajxl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class TroopRequestActivity$14$1
  implements Runnable
{
  public TroopRequestActivity$14$1(acli paramacli, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Acli.a.app != null)
    {
      localObject = (ajxl)this.jdField_a_of_type_Acli.a.app.getManager(51);
      if (localObject != null)
      {
        localObject = ((ajxl)localObject).b(this.jdField_a_of_type_JavaLangString);
        if (localObject != null) {
          this.jdField_a_of_type_Acli.a.runOnUiThread(new TroopRequestActivity.14.1.1(this, (Card)localObject));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.14.1
 * JD-Core Version:    0.7.0.1
 */