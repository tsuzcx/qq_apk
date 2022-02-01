package com.tencent.device.msg.data;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import java.util.concurrent.ConcurrentHashMap;

class DeviceComnFileMsgProcessor$1
  implements Runnable
{
  DeviceComnFileMsgProcessor$1(DeviceComnFileMsgProcessor paramDeviceComnFileMsgProcessor, MessageForDeviceFile paramMessageForDeviceFile) {}
  
  public void run()
  {
    if (DeviceComnFileMsgProcessor.a(this.this$0).containsKey(Long.valueOf(this.a.uSessionID)))
    {
      MessageForDeviceFile localMessageForDeviceFile = this.a;
      localMessageForDeviceFile.nFileStatus = 23;
      localMessageForDeviceFile.serial();
      DeviceComnFileMsgProcessor.b(this.this$0).getMessageFacade().a(this.a.frienduin, 9501, this.a.uniseq, this.a.msgData);
      DeviceComnFileMsgProcessor.a(this.this$0, this.a);
      DeviceComnFileMsgProcessor.a(this.this$0).remove(Long.valueOf(this.a.uSessionID));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceComnFileMsgProcessor.1
 * JD-Core Version:    0.7.0.1
 */