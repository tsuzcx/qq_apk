package com.tencent.biz.pubaccount;

import akbm;
import awzo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import ndn;
import org.json.JSONObject;
import rse;

public final class VideoReporter$3
  implements Runnable
{
  public VideoReporter$3(MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    int i = 1;
    long l1;
    Object localObject1;
    if ((this.a.msgtype == -2011) && (!this.a.isSend()))
    {
      l1 = System.currentTimeMillis();
      localawzo = rse.a(this.a);
      if (localawzo != null) {
        localObject1 = "";
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("vid", localawzo.U);
        ((JSONObject)localObject2).put("os", "1");
        if (!akbm.c(this.a.istroop)) {
          continue;
        }
        ((JSONObject)localObject2).put("aiotype", i);
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        long l2;
        localException.printStackTrace();
        continue;
        String str = localawzo.Z;
        continue;
      }
      if (localawzo.Z != null) {
        continue;
      }
      localObject2 = "0";
      ndn.a(null, "", "0X80077DF", "0X80077DF", 0, 0, "0", "2", (String)localObject2, (String)localObject1, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoReporter.3
 * JD-Core Version:    0.7.0.1
 */