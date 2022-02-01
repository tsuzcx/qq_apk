package com.tencent.biz.pubaccount;

import acnh;
import bdte;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import olh;
import org.json.JSONObject;
import usj;

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
      localbdte = usj.a(this.a);
      if (localbdte != null) {
        localObject1 = "";
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("vid", localbdte.ae);
        ((JSONObject)localObject2).put("os", "1");
        if (!acnh.d(this.a.istroop)) {
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
        String str = localbdte.aj;
        continue;
      }
      if (localbdte.aj != null) {
        continue;
      }
      localObject2 = "0";
      olh.a(null, "", "0X80077DF", "0X80077DF", 0, 0, "0", "2", (String)localObject2, (String)localObject1, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoReporter.3
 * JD-Core Version:    0.7.0.1
 */