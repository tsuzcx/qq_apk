package com.tencent.device.msg.activities;

import abgm;
import abjz;
import abkw;
import android.text.TextUtils;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DevLittleVideoItemBuilder$6
  implements Runnable
{
  public DevLittleVideoItemBuilder$6(abjz paramabjz, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    abgm localabgm = (abgm)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    abkw localabkw = (abkw)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.DEVICEMSG_HANDLER);
    for (;;)
    {
      synchronized (localabkw.b)
      {
        Iterator localIterator = localabkw.b.entrySet().iterator();
        if (localIterator.hasNext())
        {
          if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq != this.a.uniseq) {
            continue;
          }
          i = 1;
          if ((i == 0) && (!TextUtils.isEmpty(this.a.videoFileKey)))
          {
            long l = localabgm.a(this.a.videoFileKey, this.a.fileKey2, 2201);
            localabkw.b.put(Long.valueOf(l), this.a);
          }
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */