package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.utils.FileUtils;

class DeviceMsgChatPie$3
  implements DialogInterface.OnClickListener
{
  DeviceMsgChatPie$3(DeviceMsgChatPie paramDeviceMsgChatPie) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    FileUtils.e(this.a.f);
    this.a.f = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.3
 * JD-Core Version:    0.7.0.1
 */