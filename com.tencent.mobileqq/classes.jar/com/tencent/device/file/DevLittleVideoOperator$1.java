package com.tencent.device.file;

import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.MobileQQ;

class DevLittleVideoOperator$1
  implements Runnable
{
  DevLittleVideoOperator$1(DevLittleVideoOperator paramDevLittleVideoOperator, ShortVideoUploadInfo paramShortVideoUploadInfo) {}
  
  public void run()
  {
    if ((this.a.a instanceof MessageForDevLittleVideo)) {}
    for (MessageRecord localMessageRecord = (MessageRecord)this.a.a;; localMessageRecord = null)
    {
      if (localMessageRecord == null) {}
      Object localObject;
      label298:
      label320:
      label491:
      do
      {
        do
        {
          return;
        } while (!(localMessageRecord instanceof MessageForDevLittleVideo));
        boolean bool1 = NetworkUtil.g(this.this$0.a.getApplication().getApplicationContext());
        localObject = (MessageForDevLittleVideo)localMessageRecord;
        int i;
        long l;
        if (bool1)
        {
          i = 1002;
          ((MessageForDevLittleVideo)localObject).videoFileStatus = i;
          ((MessageForDevLittleVideo)localObject).videoFileProgress = 0;
          ((MessageForDevLittleVideo)localObject).serial();
          this.this$0.a.getMessageFacade().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, localMessageRecord.msgData);
          if (!bool1) {
            break label491;
          }
          l = System.currentTimeMillis();
          if (!this.this$0.a(localMessageRecord.frienduin)) {
            break label320;
          }
          i = ((SmartDeviceProxyMgr)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(((MessageForDevLittleVideo)localObject).frienduin), ((MessageForDevLittleVideo)localObject).videoFileName, ((MessageForDevLittleVideo)localObject).videoFileSize, ((MessageForDevLittleVideo)localObject).videoFileTime, ((MessageForDevLittleVideo)localObject).mThumbFilePath);
          if (i == 0) {
            break label298;
          }
          Logger.a(this.this$0.g, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          DeviceMsgChatPie.a(i, (MessageRecord)localObject);
        }
        for (;;)
        {
          Logger.a(this.this$0.g, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          return;
          i = 1005;
          break;
          Logger.a(this.this$0.g, this.this$0.f, "doSendShortVideo failed");
          continue;
          ((DeviceMsgHandle)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(DeviceMsgHandle.e, ((MessageForDevLittleVideo)localObject).videoFileName, Long.parseLong(((MessageForDevLittleVideo)localObject).frienduin), localMessageRecord.uniseq, localMessageRecord.istroop, 0);
          bool1 = ((SmartDeviceProxyMgr)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(localMessageRecord.frienduin)).booleanValue();
          boolean bool2 = SettingCloneUtil.readValue(this.this$0.a.getApp(), localMessageRecord.frienduin, null, "devicemsg_showvideotips_first", true);
          if ((bool1) && (bool2))
          {
            ((DeviceMsgHandle)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a(localMessageRecord.frienduin, HardCodeUtil.a(2131703273), MessageCache.a(), true, false, true);
            SettingCloneUtil.writeValue(this.this$0.a.getApp(), localMessageRecord.frienduin, null, "devicemsg_showvideotips_first", false);
          }
        }
        localObject = ((DeviceMsgHandle)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a();
      } while (localObject == null);
      ((DeviceAVFileMsgObserver)localObject).a(localMessageRecord, Boolean.valueOf(false));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.file.DevLittleVideoOperator.1
 * JD-Core Version:    0.7.0.1
 */