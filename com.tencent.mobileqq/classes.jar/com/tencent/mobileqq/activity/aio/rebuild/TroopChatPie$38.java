package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopChatPie$38
  implements Runnable
{
  TroopChatPie$38(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.this$0.j)) {}
    Object localObject;
    do
    {
      return;
      localObject = ((TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.this$0.j);
    } while (localObject != null);
    String str1;
    String str2;
    if (QLog.isColorLevel())
    {
      str1 = this.this$0.jdField_a_of_type_JavaLangString;
      str2 = this.this$0.j;
      if (localObject == null) {
        break label165;
      }
    }
    label165:
    for (boolean bool = true;; bool = false)
    {
      QLog.i(str1, 2, String.format("checkSelfInTroop %s %s", new Object[] { str2, Boolean.valueOf(bool) }));
      localObject = BaseApplicationImpl.getContext();
      if (localObject != null) {
        ThreadManager.getUIHandler().post(new TroopChatPie.38.1(this, (Context)localObject));
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.j, 1);
      this.this$0.a().post(new TroopChatPie.38.2(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.38
 * JD-Core Version:    0.7.0.1
 */