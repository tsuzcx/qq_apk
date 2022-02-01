package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopChatPie$31
  implements Runnable
{
  TroopChatPie$31(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.this$0.i)) {}
    Object localObject;
    do
    {
      return;
      localObject = ((TroopManager)this.this$0.a.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.this$0.i);
    } while (localObject != null);
    String str1;
    String str2;
    if (QLog.isColorLevel())
    {
      str1 = this.this$0.b;
      str2 = this.this$0.i;
      if (localObject == null) {
        break label166;
      }
    }
    label166:
    for (boolean bool = true;; bool = false)
    {
      QLog.i(str1, 2, String.format("checkSelfInTroop %s %s", new Object[] { str2, Boolean.valueOf(bool) }));
      localObject = BaseApplicationImpl.getContext();
      if (localObject != null) {
        ThreadManager.getUIHandler().post(new TroopChatPie.31.1(this, (Context)localObject));
      }
      this.this$0.a.getMessageFacade().a(this.this$0.i, 1);
      this.this$0.a().post(new TroopChatPie.31.2(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.31
 * JD-Core Version:    0.7.0.1
 */