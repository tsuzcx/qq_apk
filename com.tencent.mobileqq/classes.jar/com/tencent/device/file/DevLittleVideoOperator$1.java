package com.tencent.device.file;

import abgm;
import abhr;
import abhu;
import abkw;
import ahzx;
import anvx;
import azjq;
import bcrg;
import bcyj;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import mqq.app.MobileQQ;

public class DevLittleVideoOperator$1
  implements Runnable
{
  public DevLittleVideoOperator$1(abhr paramabhr, bcyj parambcyj) {}
  
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
        boolean bool1 = NetworkUtil.isNetworkAvailable(this.this$0.a.getApplication().getApplicationContext());
        localObject = (MessageForDevLittleVideo)localMessageRecord;
        int i;
        long l;
        if (bool1)
        {
          i = 1002;
          ((MessageForDevLittleVideo)localObject).videoFileStatus = i;
          ((MessageForDevLittleVideo)localObject).videoFileProgress = 0;
          ((MessageForDevLittleVideo)localObject).serial();
          this.this$0.a.getMessageFacade().updateMsgContentByUniseq(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, localMessageRecord.msgData);
          if (!bool1) {
            break label491;
          }
          l = System.currentTimeMillis();
          if (!this.this$0.a(localMessageRecord.frienduin)) {
            break label320;
          }
          i = ((abgm)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(((MessageForDevLittleVideo)localObject).frienduin), ((MessageForDevLittleVideo)localObject).videoFileName, ((MessageForDevLittleVideo)localObject).videoFileSize, ((MessageForDevLittleVideo)localObject).videoFileTime, ((MessageForDevLittleVideo)localObject).mThumbFilePath);
          if (i == 0) {
            break label298;
          }
          azjq.a(this.this$0.g, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          ahzx.a(i, (MessageRecord)localObject);
        }
        for (;;)
        {
          azjq.a(this.this$0.g, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
          return;
          i = 1005;
          break;
          azjq.a(this.this$0.g, this.this$0.f, "doSendShortVideo failed");
          continue;
          ((abkw)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a().a(abkw.e, ((MessageForDevLittleVideo)localObject).videoFileName, Long.parseLong(((MessageForDevLittleVideo)localObject).frienduin), localMessageRecord.uniseq, localMessageRecord.istroop, 0);
          bool1 = ((abgm)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(Long.parseLong(localMessageRecord.frienduin)).booleanValue();
          boolean bool2 = SettingCloneUtil.readValue(this.this$0.a.getApp(), localMessageRecord.frienduin, null, "devicemsg_showvideotips_first", true);
          if ((bool1) && (bool2))
          {
            ((abkw)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a(localMessageRecord.frienduin, anvx.a(2131702725), bcrg.a(), true, false, true);
            SettingCloneUtil.writeValue(this.this$0.a.getApp(), localMessageRecord.frienduin, null, "devicemsg_showvideotips_first", false);
          }
        }
        localObject = ((abkw)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER)).a();
      } while (localObject == null);
      ((abhu)localObject).a(localMessageRecord, Boolean.valueOf(false));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.file.DevLittleVideoOperator.1
 * JD-Core Version:    0.7.0.1
 */