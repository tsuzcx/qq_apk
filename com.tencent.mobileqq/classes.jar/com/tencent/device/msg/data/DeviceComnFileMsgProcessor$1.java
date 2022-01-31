package com.tencent.device.msg.data;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import java.util.concurrent.ConcurrentHashMap;
import zxx;

public class DeviceComnFileMsgProcessor$1
  implements Runnable
{
  public DeviceComnFileMsgProcessor$1(zxx paramzxx, MessageForDeviceFile paramMessageForDeviceFile) {}
  
  public void run()
  {
    if (zxx.a(this.this$0).containsKey(Long.valueOf(this.a.uSessionID)))
    {
      this.a.nFileStatus = 23;
      this.a.serial();
      zxx.a(this.this$0).a().a(this.a.frienduin, 9501, this.a.uniseq, this.a.msgData);
      zxx.a(this.this$0, this.a);
      zxx.a(this.this$0).remove(Long.valueOf(this.a.uSessionID));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceComnFileMsgProcessor.1
 * JD-Core Version:    0.7.0.1
 */