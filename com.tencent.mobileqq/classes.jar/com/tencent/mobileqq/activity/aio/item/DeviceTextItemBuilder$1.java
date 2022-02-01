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
    ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceTextItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceTextItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceTextItemBuilder.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDeviceTextItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DeviceTextItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */