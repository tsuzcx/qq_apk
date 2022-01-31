package com.tencent.mobileqq.activity.aio.item;

import adys;
import android.content.Context;
import anie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.os.MqqHandler;

public final class ReplyTextItemBuilder$3
  implements Runnable
{
  public ReplyTextItemBuilder$3(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, adys paramadys, Context paramContext, ChatThumbView paramChatThumbView) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof anie)) {}
    for (Object localObject = ((anie)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).getSourceMsgInfo();; localObject = null)
    {
      if (localObject == null) {
        return;
      }
      if (0 == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, ((MessageForReplyText.SourceMsgInfo)localObject).mSourceMsgTime, ((MessageForReplyText.SourceMsgInfo)localObject).origUid);
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          localObject = (MessageRecord)((List)localObject).get(0);
        }
      }
      for (;;)
      {
        ThreadManager.getUIHandler().post(new ReplyTextItemBuilder.3.1(this, (MessageRecord)localObject));
        return;
        localObject = null;
        continue;
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */