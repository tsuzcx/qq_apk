package com.tencent.device.msg.data;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import java.util.concurrent.ConcurrentHashMap;
import xvo;

public class DeviceComnFileMsgProcessor$1
  implements Runnable
{
  public DeviceComnFileMsgProcessor$1(xvo paramxvo, MessageForDeviceFile paramMessageForDeviceFile) {}
  
  public void run()
  {
    if (xvo.a(this.this$0).containsKey(Long.valueOf(this.a.uSessionID)))
    {
      this.a.nFileStatus = 23;
      this.a.serial();
      xvo.a(this.this$0).a().a(this.a.frienduin, 9501, this.a.uniseq, this.a.msgData);
      xvo.a(this.this$0, this.a);
      xvo.a(this.this$0).remove(Long.valueOf(this.a.uSessionID));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceComnFileMsgProcessor.1
 * JD-Core Version:    0.7.0.1
 */