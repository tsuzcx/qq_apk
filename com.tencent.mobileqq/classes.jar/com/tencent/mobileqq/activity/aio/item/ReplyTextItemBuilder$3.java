package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HasSourceMessage;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.os.MqqHandler;

final class ReplyTextItemBuilder$3
  implements Runnable
{
  ReplyTextItemBuilder$3(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, ReplyTextItemBuilder.SourceMessagePulledCallBack paramSourceMessagePulledCallBack, Context paramContext, ChatThumbView paramChatThumbView) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    boolean bool = localObject1 instanceof HasSourceMessage;
    Object localObject2 = null;
    if (bool) {
      localObject1 = ((HasSourceMessage)localObject1).getSourceMsgInfo();
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return;
    }
    List localList = this.b.getMessageFacade().c(this.a.frienduin, this.a.istroop, ((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgTime, ((MessageForReplyText.SourceMsgInfo)localObject1).origUid);
    localObject1 = localObject2;
    if (localList != null)
    {
      localObject1 = localObject2;
      if (localList.size() > 0) {
        localObject1 = (MessageRecord)localList.get(0);
      }
    }
    ThreadManager.getUIHandler().post(new ReplyTextItemBuilder.3.1(this, (MessageRecord)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */