package com.tencent.device.file;

import agkk;
import alpo;
import awen;
import ayvc;
import azae;
import bdee;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import mqq.app.MobileQQ;
import zpa;
import zqf;
import zqi;
import ztk;

public class DevLittleVideoOperator$1
  implements Runnable
{
  public DevLittleVideoOperator$1(zqf paramzqf, azae paramazae) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = null;
    if ((this.a.a instanceof MessageForDevLittleVideo)) {
      localMessageRecord = (MessageRecord)this.a.a;
    }
    if (localMessageRecord == null) {}
    Object localObject;
    label300:
    label322:
    label490:
    do
    {
      do
      {
        return;
      } while (!(localMessageRecord instanceof MessageForDevLittleVideo));
      boolean bool1 = bdee.g(this.this$0.a.getApplication().getApplicationContext());
      localObject = (MessageForDevLittleVideo)localMessageRecord;
      int i;
      long l;
      if (bool1)
      {
        i = 1002;
        ((MessageForDevLittleVideo)localObject).videoFileStatus = i;
        ((MessageForDevLittleVideo)localObject).videoFileProgress = 0;
        ((MessageForDevLittleVideo)localObject).serial();
        this.this$0.a.a().a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq, localMessageRecord.msgData);
        if (!bool1) {
          break label490;
        }
        l = System.currentTimeMillis();
        if (!this.this$0.a(localMessageRecord.frienduin)) {
          break label322;
        }
        i = ((zpa)this.this$0.a.a(51)).a(Long.parseLong(((MessageForDevLittleVideo)localObject).frienduin), ((MessageForDevLittleVideo)localObject).videoFileName, ((MessageForDevLittleVideo)localObject).videoFileSize, ((MessageForDevLittleVideo)localObject).videoFileTime, ((MessageForDevLittleVideo)localObject).mThumbFilePath);
        if (i == 0) {
          break label300;
        }
        awen.a(this.this$0.g, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
        agkk.a(i, (MessageRecord)localObject);
      }
      for (;;)
      {
        awen.a(this.this$0.g, this.this$0.f, "doSendShortVideo", "cost:" + (System.currentTimeMillis() - l));
        return;
        i = 1005;
        break;
        awen.a(this.this$0.g, this.this$0.f, "doSendShortVideo failed");
        continue;
        ((ztk)this.this$0.a.a(49)).a().a(ztk.e, ((MessageForDevLittleVideo)localObject).videoFileName, Long.parseLong(((MessageForDevLittleVideo)localObject).frienduin), localMessageRecord.uniseq, localMessageRecord.istroop, 0);
        bool1 = ((zpa)this.this$0.a.a(51)).a(Long.parseLong(localMessageRecord.frienduin)).booleanValue();
        boolean bool2 = SettingCloneUtil.readValue(this.this$0.a.getApp(), localMessageRecord.frienduin, null, "devicemsg_showvideotips_first", true);
        if ((bool1) && (bool2))
        {
          ((ztk)this.this$0.a.a(49)).a(localMessageRecord.frienduin, alpo.a(2131703623), ayvc.a(), true, false, true);
          SettingCloneUtil.writeValue(this.this$0.a.getApp(), localMessageRecord.frienduin, null, "devicemsg_showvideotips_first", false);
        }
      }
      localObject = ((ztk)this.this$0.a.a(49)).a();
    } while (localObject == null);
    ((zqi)localObject).a(localMessageRecord, Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.file.DevLittleVideoOperator.1
 * JD-Core Version:    0.7.0.1
 */