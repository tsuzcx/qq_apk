package com.tencent.device.msg.data;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;

class DeviceMsgHandle$3
  implements Runnable
{
  DeviceMsgHandle$3(DeviceMsgHandle paramDeviceMsgHandle, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    DeviceMsgHandle.a(this.this$0).getMsgCache().a(this.a.frienduin, this.a.istroop, this.a.uniseq);
    DeviceMsgHandle.a(this.this$0).getMessageFacade().a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceMsgHandle.3
 * JD-Core Version:    0.7.0.1
 */