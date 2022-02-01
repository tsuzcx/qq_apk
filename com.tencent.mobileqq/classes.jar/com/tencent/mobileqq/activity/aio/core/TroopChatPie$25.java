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

class TroopChatPie$25
  implements Runnable
{
  TroopChatPie$25(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.this$0.cn)) {
      return;
    }
    Object localObject = ((TroopManager)this.this$0.d.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.this$0.cn);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        String str1 = this.this$0.c;
        String str2 = this.this$0.cn;
        boolean bool = false;
        if (localObject != null) {
          bool = true;
        }
        QLog.i(str1, 2, String.format("checkSelfInTroop %s %s", new Object[] { str2, Boolean.valueOf(bool) }));
      }
      localObject = BaseApplicationImpl.getContext();
      if (localObject != null) {
        ThreadManager.getUIHandler().post(new TroopChatPie.25.1(this, (Context)localObject));
      }
      this.this$0.d.getMessageFacade().c(this.this$0.cn, 1);
      this.this$0.j().post(new TroopChatPie.25.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.25
 * JD-Core Version:    0.7.0.1
 */