package com.tencent.device.msg.activities;

import abur;
import abye;
import abzb;
import android.text.TextUtils;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DevLittleVideoItemBuilder$6
  implements Runnable
{
  public DevLittleVideoItemBuilder$6(abye paramabye, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    abur localabur = (abur)this.this$0.a.a(51);
    abzb localabzb = (abzb)this.this$0.a.a(49);
    for (;;)
    {
      synchronized (localabzb.b)
      {
        Iterator localIterator = localabzb.b.entrySet().iterator();
        if (localIterator.hasNext())
        {
          if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq != this.a.uniseq) {
            continue;
          }
          i = 1;
          if ((i == 0) && (!TextUtils.isEmpty(this.a.videoFileKey)))
          {
            long l = localabur.a(this.a.videoFileKey, this.a.fileKey2, 2201);
            localabzb.b.put(Long.valueOf(l), this.a);
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