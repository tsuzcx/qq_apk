package com.tencent.mobileqq.activity.aio.rebuild;

import aejb;
import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class TroopChatPie$39
  implements Runnable
{
  public TroopChatPie$39(aejb paramaejb, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
    String str1;
    String str2;
    if (localObject == null) {
      if (QLog.isColorLevel())
      {
        str1 = this.this$0.jdField_a_of_type_JavaLangString;
        str2 = this.jdField_a_of_type_JavaLangString;
        if (localObject == null) {
          break label136;
        }
      }
    }
    label136:
    for (boolean bool = true;; bool = false)
    {
      QLog.i(str1, 2, String.format("checkSelfInTroop %s %s", new Object[] { str2, Boolean.valueOf(bool) }));
      localObject = BaseApplicationImpl.getContext();
      if (localObject != null) {
        ThreadManager.getUIHandler().post(new TroopChatPie.39.1(this, (Context)localObject));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, 1);
      this.this$0.a().post(new TroopChatPie.39.2(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.39
 * JD-Core Version:    0.7.0.1
 */