package com.tencent.device.file;

import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;

class DevShortVideoOperator$1
  implements Runnable
{
  DevShortVideoOperator$1(DevShortVideoOperator paramDevShortVideoOperator, ShortVideoUploadInfo paramShortVideoUploadInfo) {}
  
  public void run()
  {
    ShortVideoUploadInfo localShortVideoUploadInfo = this.a;
    Object localObject = null;
    int i;
    if (localShortVideoUploadInfo.g == 0)
    {
      localObject = this.this$0.a(localShortVideoUploadInfo);
      i = 1;
    }
    for (;;)
    {
      if (localObject == null)
      {
        return;
        if (localShortVideoUploadInfo.g == 1)
        {
          localObject = (MessageForShortVideo)localShortVideoUploadInfo.a;
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
          this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject, this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        ((DeviceMsgHandle)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(DeviceMsgHandle.e, this.a.h, Long.parseLong(this.a.c), ((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).istroop, 0);
        Logger.a(this.this$0.g, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
        return;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.file.DevShortVideoOperator.1
 * JD-Core Version:    0.7.0.1
 */