package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HasSourceMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.os.MqqHandler;

final class ReplyTextItemBuilder$4
  implements Runnable
{
  ReplyTextItemBuilder$4(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, ReplyTextItemBuilder.SourceMessagePulledCallBack paramSourceMessagePulledCallBack, Context paramContext, ChatThumbView paramChatThumbView) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    boolean bool = localObject1 instanceof HasSourceMessage;
    Object localObject3 = null;
    if (bool)
    {
      localObject2 = (HasSourceMessage)localObject1;
      localObject1 = ((HasSourceMessage)localObject2).getSourceMsgInfo();
      ((HasSourceMessage)localObject2).getHasPulledSourceMsg();
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return;
    }
    MessageRecord localMessageRecord2 = this.b.getMessageFacade().c(this.a.frienduin, this.a.istroop, ((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgSeq);
    Object localObject2 = localMessageRecord2;
    localObject1 = localObject3;
    if (this.a.istroop != 0) {
      if (!(localMessageRecord2 instanceof MessageForText))
      {
        localObject2 = localMessageRecord2;
        localObject1 = localObject3;
        if (!(localMessageRecord2 instanceof MessageForMixedMsg)) {}
      }
      else
      {
        localObject2 = localMessageRecord2;
        localObject1 = localObject3;
        if (localMessageRecord2.isLongMsg())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          MessageRecord localMessageRecord1 = ReplyTextItemBuilder.a(this.b, this.a, localMessageRecord2, localStringBuilder);
          localObject2 = localMessageRecord2;
          localObject1 = localObject3;
          if (localMessageRecord1 != null)
          {
            localObject1 = localStringBuilder.toString();
            localObject2 = localMessageRecord1;
          }
        }
      }
    }
    ThreadManager.getUIHandler().post(new ReplyTextItemBuilder.4.1(this, (MessageRecord)localObject2, (String)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */