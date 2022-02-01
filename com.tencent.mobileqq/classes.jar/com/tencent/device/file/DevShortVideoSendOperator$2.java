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
    int j = ((ShortVideoUploadInfo)localObject).t;
    int i = 0;
    if (j == 0)
    {
      localObject = this.this$0.a((ShortVideoUploadInfo)localObject);
      i = 1;
    }
    else if (((ShortVideoUploadInfo)localObject).t == 1)
    {
      localObject = (MessageForShortVideo)((ShortVideoUploadInfo)localObject).s;
    }
    else
    {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    this.this$0.f = ((MessageRecord)localObject);
    if ((localObject instanceof MessageForDevShortVideo)) {
      ((MessageForDevShortVideo)localObject).videoFileStatus = 1002;
    }
    long l = System.currentTimeMillis();
    if (i != 0) {
      ((IMessageFacade)this.this$0.a.getRuntimeService(IMessageFacade.class)).addMessage((MessageRecord)localObject, this.this$0.a.getCurrentAccountUin());
    }
    ((DeviceMsgHandle)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(DeviceMsgHandle.e, this.a.l, Long.parseLong(this.a.e), ((MessageRecord)localObject).uniseq, ((MessageRecord)localObject).istroop, 0);
    localObject = this.this$0.e;
    String str = this.this$0.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Logger.a((String)localObject, str, "doSendShortVideo", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DevShortVideoSendOperator.2
 * JD-Core Version:    0.7.0.1
 */