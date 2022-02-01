package com.tencent.device.file;

import abhs;
import abhu;
import abkw;
import azjq;
import bcyj;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

public class DevShortVideoOperator$1
  implements Runnable
{
  public DevShortVideoOperator$1(abhs paramabhs, bcyj parambcyj) {}
  
  public void run()
  {
    bcyj localbcyj = this.a;
    Object localObject = null;
    int i;
    if (localbcyj.g == 0)
    {
      localObject = this.this$0.a(localbcyj);
      i = 1;
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        if (localbcyj.g == 1)
        {
          localObject = (MessageForShortVideo)localbcyj.a;
          i = 0;
        }
      }
      else
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
        if ((localObject instanceof MessageForDevShortVideo)) {
          ((MessageForDevShortVideo)localObject).videoFileStatus = 1002;
        }
        long l = System.currentTimeMillis();
        if (i != 0) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage((MessageRecord)localObject, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        ((abkw)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(abkw.e, this.a.h, Long.parseLong(this.a.c), ((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).istroop, 0);
        azjq.a(this.this$0.g, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
        return;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.file.DevShortVideoOperator.1
 * JD-Core Version:    0.7.0.1
 */