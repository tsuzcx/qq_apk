package com.tencent.device.msg.activities;

import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.qphone.base.util.QLog;

class DevicePttItemBuilder$3
  implements Runnable
{
  DevicePttItemBuilder$3(DevicePttItemBuilder paramDevicePttItemBuilder, MessageForPtt paramMessageForPtt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadPtt istroop");
      ((StringBuilder)localObject).append(this.a.istroop);
      ((StringBuilder)localObject).append(" itemType ");
      ((StringBuilder)localObject).append(this.a.itemType);
      ((StringBuilder)localObject).append(" uniseq:");
      ((StringBuilder)localObject).append(this.a.uniseq);
      QLog.d("FileTrans", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ((DeviceMsgHandle)this.this$0.d.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a();
    MessageForPtt localMessageForPtt = this.a;
    if ((localMessageForPtt instanceof MessageForDevPtt)) {
      ((DeviceAVFileMsgObserver)localObject).a((MessageForDevPtt)localMessageForPtt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevicePttItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */