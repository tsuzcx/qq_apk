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

public class DevLittleVideoItemBuilder$7
  implements Runnable
{
  public DevLittleVideoItemBuilder$7(abye paramabye, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    abur localabur = (abur)this.this$0.a.a(51);
    abzb localabzb = (abzb)this.this$0.a.a(49);
    for (;;)
    {
      synchronized (localabzb.a)
      {
        Iterator localIterator = localabzb.a.entrySet().iterator();
        if (localIterator.hasNext())
        {
          if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq != this.a.uniseq) {
            continue;
          }
          i = 1;
          if ((i == 0) && (!TextUtils.isEmpty(this.a.thumbFileKey)))
          {
            long l = localabur.a(this.a.thumbFileKey, this.a.coverkey2, 2154);
            localabzb.a.put(Long.valueOf(l), this.a);
          }
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.msg.activities.DevLittleVideoItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */