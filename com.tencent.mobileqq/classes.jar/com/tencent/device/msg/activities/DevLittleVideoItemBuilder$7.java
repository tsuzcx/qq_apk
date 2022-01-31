package com.tencent.device.msg.activities;

import android.text.TextUtils;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import zpa;
import zsn;
import ztk;

public class DevLittleVideoItemBuilder$7
  implements Runnable
{
  public DevLittleVideoItemBuilder$7(zsn paramzsn, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    zpa localzpa = (zpa)this.this$0.a.a(51);
    ztk localztk = (ztk)this.this$0.a.a(49);
    for (;;)
    {
      synchronized (localztk.a)
      {
        Iterator localIterator = localztk.a.entrySet().iterator();
        if (localIterator.hasNext())
        {
          if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq != this.a.uniseq) {
            continue;
          }
          i = 1;
          if ((i == 0) && (!TextUtils.isEmpty(this.a.thumbFileKey)))
          {
            long l = localzpa.a(this.a.thumbFileKey, this.a.coverkey2, 2154);
            localztk.a.put(Long.valueOf(l), this.a);
          }
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */