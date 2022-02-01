package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.os.Bundle;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.HasSourceMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

final class ReplyTextItemBuilder$5
  implements Runnable
{
  ReplyTextItemBuilder$5(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, ReplyTextItemBuilder.SourceMessagePulledCallBack paramSourceMessagePulledCallBack, Context paramContext, ChatThumbView paramChatThumbView) {}
  
  public void run()
  {
    int i = 0;
    Object localObject1;
    Object localObject4;
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof HasSourceMessage))
    {
      localObject1 = (HasSourceMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localObject4 = ((HasSourceMessage)localObject1).getSourceMsgInfo();
      bool = ((HasSourceMessage)localObject1).getHasPulledSourceMsg();
    }
    for (;;)
    {
      if (localObject4 == null) {
        return;
      }
      if (0 == 0) {}
      label452:
      Object localObject3;
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().c(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, ((MessageForReplyText.SourceMsgInfo)localObject4).mSourceMsgSeq);; localObject3 = null)
      {
        Object localObject5;
        if ((localObject1 == null) && (!bool) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin != null))
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof HasSourceMessage)) {
            ((HasSourceMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).setPulledSourceMsg();
          }
          Bundle localBundle = new Bundle();
          QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
          localObject5 = new ArrayList();
          int j = localQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
          localBundle.putInt("counter", j);
          localBundle.putBoolean("success", false);
          localQQMessageFacade.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(j), localObject5);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, ((MessageForReplyText.SourceMsgInfo)localObject4).mSourceMsgSeq, ((MessageForReplyText.SourceMsgInfo)localObject4).mSourceMsgSeq, true, localBundle, 0);
          localQQMessageFacade.b.put(UinTypeUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop), Boolean.valueOf(false));
          if (!NetworkUtil.g(BaseApplication.getContext())) {}
        }
        label458:
        label468:
        for (;;)
        {
          try
          {
            localObject5.wait(35000L);
            if ((((List)localObject5).size() <= 0) || (i >= ((List)localObject5).size())) {
              break label468;
            }
            if (((MessageRecord)((List)localObject5).get(i)).shmsgseq == ((MessageForReplyText.SourceMsgInfo)localObject4).mSourceMsgSeq)
            {
              localObject1 = (MessageRecord)((List)localObject5).get(i);
              if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 0) || ((!(localObject1 instanceof MessageForText)) && (!(localObject1 instanceof MessageForMixedMsg))) || (!((MessageRecord)localObject1).isLongMsg())) {
                break label458;
              }
              localObject5 = new StringBuilder();
              localObject4 = ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, (MessageRecord)localObject1, (StringBuilder)localObject5);
              if (localObject4 == null) {
                break label458;
              }
              if (localObject5 == null) {
                break label452;
              }
              localObject1 = ((StringBuilder)localObject5).toString();
              ThreadManager.getUIHandler().post(new ReplyTextItemBuilder.5.1(this, (MessageRecord)localObject4, (String)localObject1));
              return;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
            continue;
          }
          finally {}
          i += 1;
          continue;
          localObject3 = null;
          continue;
          localObject4 = localObject3;
          localObject3 = null;
        }
      }
      bool = false;
      localObject4 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */