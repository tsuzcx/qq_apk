package com.tencent.device.msg.activities;

import aasi;
import aaux;
import aavk;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.QLog;

public class DevicePttItemBuilder$3
  implements Runnable
{
  public DevicePttItemBuilder$3(aaux paramaaux, MessageForPtt paramMessageForPtt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FileTrans", 2, "downloadPtt istroop" + this.a.istroop + " itemType " + this.a.itemType + " uniseq:" + this.a.uniseq);
    }
    aasi localaasi = ((aavk)this.this$0.a.getBusinessHandler(49)).a();
    if ((this.a instanceof MessageForDevPtt)) {
      localaasi.a((MessageForDevPtt)this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevicePttItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */