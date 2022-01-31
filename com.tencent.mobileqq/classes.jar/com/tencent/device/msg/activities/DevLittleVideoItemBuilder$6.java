package com.tencent.device.msg.activities;

import android.text.TextUtils;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import ztp;
import zxc;
import zxz;

public class DevLittleVideoItemBuilder$6
  implements Runnable
{
  public DevLittleVideoItemBuilder$6(zxc paramzxc, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    ztp localztp = (ztp)this.this$0.a.a(51);
    zxz localzxz = (zxz)this.this$0.a.a(49);
    for (;;)
    {
      synchronized (localzxz.b)
      {
        Iterator localIterator = localzxz.b.entrySet().iterator();
        if (localIterator.hasNext())
        {
          if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq != this.a.uniseq) {
            continue;
          }
          i = 1;
          if ((i == 0) && (!TextUtils.isEmpty(this.a.videoFileKey)))
          {
            long l = localztp.a(this.a.videoFileKey, this.a.fileKey2, 2201);
            localzxz.b.put(Long.valueOf(l), this.a);
          }
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */