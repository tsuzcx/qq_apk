package com.tencent.device.file;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.msg.data.DeviceMsgHandle;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.MobileQQ;

class DevLittleVideoSendOperator$1
  implements Runnable
{
  DevLittleVideoSendOperator$1(DevLittleVideoSendOperator paramDevLittleVideoSendOperator, ShortVideoUploadInfo paramShortVideoUploadInfo) {}
  
  public void run()
  {
    Object localObject1;
    if ((this.a.s instanceof MessageForDevLittleVideo)) {
      localObject1 = (MessageRecord)this.a.s;
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return;
    }
    if ((localObject1 instanceof MessageForDevLittleVideo))
    {
      boolean bool1 = NetworkUtil.isNetworkAvailable(this.this$0.a.getApplication().getApplicationContext());
      Object localObject2 = (MessageForDevLittleVideo)localObject1;
      int i;
      if (bool1) {
        i = 1002;
      } else {
        i = 1005;
      }
      ((MessageForDevLittleVideo)localObject2).videoFileStatus = i;
      ((MessageForDevLittleVideo)localObject2).videoFileProgress = 0;
      ((MessageForDevLittleVideo)localObject2).serial();
      ((IMessageFacade)this.this$0.a.getRuntimeService(IMessageFacade.class)).updateMsgContentByUniseq(((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).uniseq, ((MessageRecord)localObject1).msgData);
      if (bool1)
      {
        long l = System.currentTimeMillis();
        if (this.this$0.c(((MessageRecord)localObject1).frienduin))
        {
          i = ((SmartDeviceProxyMgr)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(((MessageForDevLittleVideo)localObject2).frienduin), ((MessageForDevLittleVideo)localObject2).videoFileName, ((MessageForDevLittleVideo)localObject2).videoFileSize, ((MessageForDevLittleVideo)localObject2).videoFileTime, ((MessageForDevLittleVideo)localObject2).mThumbFilePath);
          if (i != 0)
          {
            localObject1 = this.this$0.e;
            localObject3 = this.this$0.d;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("cost:");
            localStringBuilder.append(System.currentTimeMillis() - l);
            Logger.a((String)localObject1, (String)localObject3, "doSendShortVideo", localStringBuilder.toString());
            DeviceMsgChatPie.a(i, (MessageRecord)localObject2);
          }
          else
          {
            Logger.a(this.this$0.e, this.this$0.d, "doSendShortVideo failed");
          }
        }
        else
        {
          ((DeviceMsgHandle)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(DeviceMsgHandle.e, ((MessageForDevLittleVideo)localObject2).videoFileName, Long.parseLong(((MessageForDevLittleVideo)localObject2).frienduin), ((MessageRecord)localObject1).uniseq, ((MessageRecord)localObject1).istroop, 0);
          bool1 = ((SmartDeviceProxyMgr)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).f(Long.parseLong(((MessageRecord)localObject1).frienduin)).booleanValue();
          boolean bool2 = SettingCloneUtil.readValue(this.this$0.a.getApp(), ((MessageRecord)localObject1).frienduin, null, "devicemsg_showvideotips_first", true);
          if ((bool1) && (bool2))
          {
            ((DeviceMsgHandle)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a(((MessageRecord)localObject1).frienduin, HardCodeUtil.a(2131901364), MessageCache.c(), true, false, true);
            SettingCloneUtil.writeValue(this.this$0.a.getApp(), ((MessageRecord)localObject1).frienduin, null, "devicemsg_showvideotips_first", false);
          }
        }
        localObject1 = this.this$0.e;
        localObject2 = this.this$0.d;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("cost:");
        ((StringBuilder)localObject3).append(System.currentTimeMillis() - l);
        Logger.a((String)localObject1, (String)localObject2, "doSendShortVideo", ((StringBuilder)localObject3).toString());
        return;
      }
      localObject2 = ((DeviceMsgHandle)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a();
      if (localObject2 != null) {
        ((DeviceAVFileMsgObserver)localObject2).a((MessageRecord)localObject1, Boolean.valueOf(false));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DevLittleVideoSendOperator.1
 * JD-Core Version:    0.7.0.1
 */