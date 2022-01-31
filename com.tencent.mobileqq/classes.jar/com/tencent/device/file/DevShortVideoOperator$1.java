package com.tencent.device.file;

import aune;
import axew;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import ybq;
import ybs;
import yeu;

public class DevShortVideoOperator$1
  implements Runnable
{
  public DevShortVideoOperator$1(ybq paramybq, axew paramaxew) {}
  
  public void run()
  {
    axew localaxew = this.a;
    Object localObject = null;
    int i;
    if (localaxew.g == 0)
    {
      localObject = this.this$0.a(localaxew);
      i = 1;
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        if (localaxew.g == 1)
        {
          localObject = (MessageForShortVideo)localaxew.a;
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
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        ((yeu)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(yeu.e, this.a.h, Long.parseLong(this.a.c), ((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).istroop, 0);
        aune.a(this.this$0.g, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
        return;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DevShortVideoOperator.1
 * JD-Core Version:    0.7.0.1
 */