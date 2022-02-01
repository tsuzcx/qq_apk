package com.tencent.device.file;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;

class DevShortVideoSendOperator$2
  implements Runnable
{
  DevShortVideoSendOperator$2(DevShortVideoSendOperator paramDevShortVideoSendOperator, ShortVideoUploadInfo paramShortVideoUploadInfo) {}
  
  public void run()
  {
    Object localObject = this.a;
    int j = ((ShortVideoUploadInfo)localObject).g;
    int i = 0;
    if (j == 0)
    {
      localObject = this.this$0.a((ShortVideoUploadInfo)localObject);
      i = 1;
    }
    else if (((ShortVideoUploadInfo)localObject).g == 1)
    {
      localObject = (MessageForShortVideo)((ShortVideoUploadInfo)localObject).a;
    }
    else
    {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = ((MessageRecord)localObject);
    if ((localObject instanceof MessageForDevShortVideo)) {
      ((MessageForDevShortVideo)localObject).videoFileStatus = 1002;
    }
    long l = System.currentTimeMillis();
    if (i != 0) {
      ((IMessageFacade)this.this$0.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IMessageFacade.class)).addMessage((MessageRecord)localObject, this.this$0.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin());
    }
    ((DeviceMsgHandle)this.this$0.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(DeviceMsgHandle.e, this.a.h, Long.parseLong(this.a.c), ((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).istroop, 0);
    localObject = this.this$0.b;
    String str = this.this$0.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Logger.a((String)localObject, str, "doSendShortVideo", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.file.DevShortVideoSendOperator.2
 * JD-Core Version:    0.7.0.1
 */