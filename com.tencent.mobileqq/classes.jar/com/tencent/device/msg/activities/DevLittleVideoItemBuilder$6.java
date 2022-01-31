package com.tencent.device.msg.activities;

import android.text.TextUtils;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import yak;
import ydx;
import yeu;

public class DevLittleVideoItemBuilder$6
  implements Runnable
{
  public DevLittleVideoItemBuilder$6(ydx paramydx, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    yak localyak = (yak)this.this$0.a.a(51);
    yeu localyeu = (yeu)this.this$0.a.a(49);
    for (;;)
    {
      synchronized (localyeu.b)
      {
        Iterator localIterator = localyeu.b.entrySet().iterator();
        if (localIterator.hasNext())
        {
          if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq != this.a.uniseq) {
            continue;
          }
          i = 1;
          if ((i == 0) && (!TextUtils.isEmpty(this.a.videoFileKey)))
          {
            long l = localyak.a(this.a.videoFileKey, this.a.fileKey2, 2201);
            localyeu.b.put(Long.valueOf(l), this.a);
          }
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */