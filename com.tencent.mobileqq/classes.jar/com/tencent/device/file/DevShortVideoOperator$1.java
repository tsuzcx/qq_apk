package com.tencent.device.file;

import abvx;
import abvz;
import abzb;
import azpw;
import bcyf;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

public class DevShortVideoOperator$1
  implements Runnable
{
  public DevShortVideoOperator$1(abvx paramabvx, bcyf parambcyf) {}
  
  public void run()
  {
    bcyf localbcyf = this.a;
    Object localObject = null;
    int i;
    if (localbcyf.g == 0)
    {
      localObject = this.this$0.a(localbcyf);
      i = 1;
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        if (localbcyf.g == 1)
        {
          localObject = (MessageForShortVideo)localbcyf.a;
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
        ((abzb)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(49)).a().a(abzb.e, this.a.h, Long.parseLong(this.a.c), ((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).istroop, 0);
        azpw.a(this.this$0.g, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
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