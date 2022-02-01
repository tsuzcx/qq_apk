package com.tencent.mobileqq.activity.aio.core;

import acvv;
import android.os.Bundle;
import android.os.Message;
import aucg;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class BaseChatPie$17
  implements Runnable
{
  BaseChatPie$17(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    acvv.a(this.this$0.app, this.this$0.sessionInfo);
    Iterator localIterator = this.this$0.app.getMessageFacade().getAIOList(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ChatMessage)localIterator.next();
      if ((localObject instanceof MessageForUniteGrayTip))
      {
        localObject = (MessageForUniteGrayTip)localObject;
        if (aucg.a((MessageForUniteGrayTip)localObject, this.this$0.app))
        {
          Message localMessage = new Message();
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", ((MessageForUniteGrayTip)localObject).uniseq);
          localMessage.setData(localBundle);
          localMessage.what = 78;
          localMessage.arg1 = 0;
          this.this$0.uiHandler.sendMessage(localMessage);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.17
 * JD-Core Version:    0.7.0.1
 */