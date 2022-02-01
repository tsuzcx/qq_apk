package com.tencent.device.msg.data;

import abyz;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import java.util.concurrent.ConcurrentHashMap;

public class DeviceComnFileMsgProcessor$1
  implements Runnable
{
  public DeviceComnFileMsgProcessor$1(abyz paramabyz, MessageForDeviceFile paramMessageForDeviceFile) {}
  
  public void run()
  {
    if (abyz.a(this.this$0).containsKey(Long.valueOf(this.a.uSessionID)))
    {
      this.a.nFileStatus = 23;
      this.a.serial();
      abyz.a(this.this$0).a().a(this.a.frienduin, 9501, this.a.uniseq, this.a.msgData);
      abyz.a(this.this$0, this.a);
      abyz.a(this.this$0).remove(Long.valueOf(this.a.uSessionID));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.msg.data.DeviceComnFileMsgProcessor.1
 * JD-Core Version:    0.7.0.1
 */