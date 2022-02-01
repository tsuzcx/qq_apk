package com.tencent.mobileqq.activity.aio.item;

import com.tencent.device.msg.data.DevSingleStructMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

class DeviceSingleStructBuilder$2
  implements FMDialogUtil.FMDialogInterface
{
  DeviceSingleStructBuilder$2(DeviceSingleStructBuilder paramDeviceSingleStructBuilder, MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct) {}
  
  public void a()
  {
    ((DeviceMsgHandle)this.b.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).c().b(this.a);
    DeviceSingleStructBuilder.b(this.b, this.a);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceSingleStructBuilder.2
 * JD-Core Version:    0.7.0.1
 */