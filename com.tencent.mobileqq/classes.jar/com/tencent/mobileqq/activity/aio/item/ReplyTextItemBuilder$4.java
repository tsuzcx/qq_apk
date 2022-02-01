package com.tencent.mobileqq.activity.aio.item;

import agmk;
import agmv;
import android.content.Context;
import aqqh;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.os.MqqHandler;

public final class ReplyTextItemBuilder$4
  implements Runnable
{
  public ReplyTextItemBuilder$4(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, agmv paramagmv, Context paramContext, ChatThumbView paramChatThumbView) {}
  
  public void run()
  {
    Object localObject4 = null;
    Object localObject2;
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof aqqh))
    {
      localObject2 = (aqqh)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject1 = ((aqqh)localObject2).getSourceMsgInfo();
      ((aqqh)localObject2).getHasPulledSourceMsg();
    }
    for (;;)
    {
      if (localObject1 == null) {
        return;
      }
      if (0 == 0) {}
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().queryMsgItemByShmsgseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, ((MessageForReplyText.SourceMsgInfo)localObject1).mSourceMsgSeq);; localObject1 = null)
      {
        localObject2 = localObject1;
        Object localObject3 = localObject4;
        MessageRecord localMessageRecord;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 0) {
          if (!(localObject1 instanceof MessageForText))
          {
            localObject2 = localObject1;
            localObject3 = localObject4;
            if (!(localObject1 instanceof MessageForMixedMsg)) {}
          }
          else
          {
            localObject2 = localObject1;
            localObject3 = localObject4;
            if (((MessageRecord)localObject1).isLongMsg())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localMessageRecord = agmk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (MessageRecord)localObject1, localStringBuilder);
              localObject2 = localObject1;
              localObject3 = localObject4;
              if (localMessageRecord != null)
              {
                if (localStringBuilder == null) {
                  break label189;
                }
                localObject3 = localStringBuilder.toString();
                localObject2 = localMessageRecord;
              }
            }
          }
        }
        for (;;)
        {
          ThreadManager.getUIHandler().post(new ReplyTextItemBuilder.4.1(this, (MessageRecord)localObject2, (String)localObject3));
          return;
          label189:
          localObject2 = localMessageRecord;
          localObject3 = localObject4;
        }
      }
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */