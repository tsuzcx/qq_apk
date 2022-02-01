package com.tencent.mobileqq.activity.aio.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceText;

class DeviceTextItemBuilder$1
  implements DialogInterface.OnClickListener
{
  DeviceTextItemBuilder$1(DeviceTextItemBuilder paramDeviceTextItemBuilder, MessageForDeviceText paramMessageForDeviceText) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((DeviceMsgHandle)this.b.d.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a(this.b.d, this.b.e, this.b.f, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceTextItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */