package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.device.file.DevVideoMsgProcessor;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class DeviceMsgChatPie$4
  implements DialogInterface.OnClickListener
{
  DeviceMsgChatPie$4(DeviceMsgChatPie paramDeviceMsgChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    DevVideoMsgProcessor.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.a.d);
    this.a.d = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.4
 * JD-Core Version:    0.7.0.1
 */