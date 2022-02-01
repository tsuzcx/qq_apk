package com.tencent.biz.pubaccount;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class VideoReporter$3
  implements Runnable
{
  VideoReporter$3(MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    long l1;
    Object localObject1;
    if ((this.a.msgtype == -2011) && (!this.a.isSend()))
    {
      l1 = System.currentTimeMillis();
      localStructMsgItemVideo = PAVideoStructMsgUtil.a(this.a);
      if (localStructMsgItemVideo != null) {
        localObject1 = "";
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("vid", localStructMsgItemVideo.ae);
        ((JSONObject)localObject2).put("os", "1");
        if (!UinTypeUtil.b(this.a.istroop)) {
          continue;
        }
        i = 1;
        ((JSONObject)localObject2).put("aiotype", i);
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        int i;
        IPublicAccountReportUtils localIPublicAccountReportUtils;
        long l2;
        localException.printStackTrace();
        continue;
        String str = localStructMsgItemVideo.aj;
        continue;
      }
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      if (localStructMsgItemVideo.aj != null) {
        continue;
      }
      localObject2 = "0";
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X80077DF", "0X80077DF", 0, 0, "0", "2", (String)localObject2, (String)localObject1, false);
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("VideoReporter", 2, "reportVideoStructMsgRecv cost = " + (l2 - l1) + "ms");
      }
      return;
      if (this.a.istroop == 1)
      {
        i = 2;
      }
      else
      {
        i = this.a.istroop;
        if (i == 3000) {
          i = 3;
        } else {
          i = 4;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoReporter.3
 * JD-Core Version:    0.7.0.1
 */