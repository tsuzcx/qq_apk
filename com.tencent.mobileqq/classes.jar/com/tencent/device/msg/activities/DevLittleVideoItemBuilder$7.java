package com.tencent.device.msg.activities;

import android.text.TextUtils;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import yah;
import ydu;
import yer;

public class DevLittleVideoItemBuilder$7
  implements Runnable
{
  public DevLittleVideoItemBuilder$7(ydu paramydu, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    yah localyah = (yah)this.this$0.a.a(51);
    yer localyer = (yer)this.this$0.a.a(49);
    for (;;)
    {
      synchronized (localyer.a)
      {
        Iterator localIterator = localyer.a.entrySet().iterator();
        if (localIterator.hasNext())
        {
          if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq != this.a.uniseq) {
            continue;
          }
          i = 1;
          if ((i == 0) && (!TextUtils.isEmpty(this.a.thumbFileKey)))
          {
            long l = localyah.a(this.a.thumbFileKey, this.a.coverkey2, 2154);
            localyer.a.put(Long.valueOf(l), this.a);
          }
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */