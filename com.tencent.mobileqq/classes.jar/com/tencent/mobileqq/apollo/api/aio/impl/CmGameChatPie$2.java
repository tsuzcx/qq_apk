package com.tencent.mobileqq.apollo.api.aio.impl;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.lightGame.CmGameTempSessionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class CmGameChatPie$2
  implements Handler.Callback
{
  CmGameChatPie$2(CmGameChatPie paramCmGameChatPie) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "[handleMessage] handle message mStoped = " + CmGameChatPie.a(this.a));
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      Object localObject = (IApolloManagerService)this.a.a.getRuntimeService(IApolloManagerService.class, "all");
      paramMessage = (String)paramMessage.obj;
      if (!CmGameChatPie.a(this.a)) {
        ((IApolloManagerService)localObject).getGameTempMsgHandler().e(paramMessage);
      }
      localObject = Message.obtain();
      ((Message)localObject).what = 1;
      ((Message)localObject).obj = paramMessage;
      CmGameChatPie.a(this.a).removeMessages(1);
      CmGameChatPie.a(this.a).sendMessageDelayed((Message)localObject, 30000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.2
 * JD-Core Version:    0.7.0.1
 */