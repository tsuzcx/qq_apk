package com.tencent.device.msg.activities;

import android.view.View;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceAVFileMsgObserver;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class DevicePttItemBuilder$1
  implements ActionSheet.OnButtonClickListener
{
  DevicePttItemBuilder$1(DevicePttItemBuilder paramDevicePttItemBuilder, MessageForPtt paramMessageForPtt, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.c.d.getMessageFacade().h(this.a.frienduin, this.a.istroop, this.a.uniseq);
    if (this.c.f != null)
    {
      paramView = MessageRecordFactory.a(this.a);
      ((MessageForPtt)paramView).fileSize = -3L;
      this.c.d.getMessageFacade().a(paramView, this.c.d.getCurrentAccountUin());
    }
    else
    {
      paramView = null;
    }
    if (paramView != null) {
      if ("device_groupchat".equals(paramView.extStr))
      {
        if ((!NetworkUtil.isNetSupport(BaseApplication.getContext())) && ((paramView instanceof MessageForDevPtt)))
        {
          paramView = (MessageForDevPtt)paramView;
          paramView.fileSize = -1L;
          paramView.extraflag = 32768;
          paramView.extStr = "device_groupchat";
          paramView.serial();
          this.c.d.getMessageFacade().a(paramView.frienduin, paramView.istroop, paramView.uniseq, paramView.msgData);
          this.c.d();
          this.b.dismiss();
          return;
        }
        DeviceMsgChatPie.a(((SmartDeviceProxyMgr)this.c.d.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(this.c.f.b), this.a.url, this.a.voiceLength), paramView);
      }
      else
      {
        ((DeviceMsgHandle)this.c.d.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(DeviceMsgHandle.f, this.a.url, Long.parseLong(this.c.f.b), paramView.uniseq, paramView.istroop, (int)this.a.msgRecTime / 1000);
      }
    }
    this.c.d();
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevicePttItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */