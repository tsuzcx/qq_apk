package com.tencent.mobileqq.activity;

import acjm;
import android.os.Bundle;
import android.os.Message;
import aspz;
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
    acjm.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    Iterator localIterator = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ChatMessage)localIterator.next();
      if ((localObject instanceof MessageForUniteGrayTip))
      {
        localObject = (MessageForUniteGrayTip)localObject;
        if (aspz.a((MessageForUniteGrayTip)localObject, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
        {
          Message localMessage = new Message();
          Bundle localBundle = new Bundle();
          localBundle.putLong("messageUniseq", ((MessageForUniteGrayTip)localObject).uniseq);
          localMessage.setData(localBundle);
          localMessage.what = 78;
          localMessage.arg1 = 0;
          this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.17
 * JD-Core Version:    0.7.0.1
 */