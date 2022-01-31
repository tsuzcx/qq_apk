package com.tencent.device.msg.activities;

import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.QLog;
import zux;
import zxm;
import zxz;

public class DevicePttItemBuilder$3
  implements Runnable
{
  public DevicePttItemBuilder$3(zxm paramzxm, MessageForPtt paramMessageForPtt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTrans", 2, "downloadPtt istroop" + this.a.istroop + " itemType " + this.a.itemType + " uniseq:" + this.a.uniseq);
    }
    zux localzux = ((zxz)this.this$0.a.a(49)).a();
    if ((this.a instanceof MessageForDevPtt)) {
      localzux.a((MessageForDevPtt)this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevicePttItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */