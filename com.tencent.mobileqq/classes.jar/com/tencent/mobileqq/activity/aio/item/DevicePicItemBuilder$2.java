package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.device.msg.data.DeviceGroupChatMsgProcessor;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DevicePicItemBuilder$2
  implements ActionSheet.OnButtonClickListener
{
  DevicePicItemBuilder$2(DevicePicItemBuilder paramDevicePicItemBuilder, MessageForDeviceFile paramMessageForDeviceFile, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ("device_groupchat".equals(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile.extStr)) {
      ((DeviceMsgHandle)this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForDeviceFile);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemDevicePicItemBuilder.b();
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.DevicePicItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */