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
    DevVideoMsgProcessor.a(this.a.d, this.a.f, this.a.ah.b, this.a.bk);
    this.a.bk = "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie.4
 * JD-Core Version:    0.7.0.1
 */