package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopChatPie$35
  implements Runnable
{
  TroopChatPie$35(TroopChatPie paramTroopChatPie) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.this$0.e)) {}
    Object localObject;
    do
    {
      return;
      localObject = ((TroopManager)this.this$0.app.getManager(52)).b(this.this$0.e);
    } while (localObject != null);
    String str1;
    String str2;
    if (QLog.isColorLevel())
    {
      str1 = this.this$0.tag;
      str2 = this.this$0.e;
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
        ThreadManager.getUIHandler().post(new TroopChatPie.35.1(this, (Context)localObject));
      }
      this.this$0.app.getMessageFacade().clearHistory(this.this$0.e, 1);
      this.this$0.getUIHandler().post(new TroopChatPie.35.2(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.35
 * JD-Core Version:    0.7.0.1
 */