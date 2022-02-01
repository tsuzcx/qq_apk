package com.tencent.device.msg.activities;

import aara;
import aaun;
import aavk;
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
  public DevLittleVideoItemBuilder$7(aaun paramaaun, MessageForDevLittleVideo paramMessageForDevLittleVideo) {}
  
  public void run()
  {
    aara localaara = (aara)this.this$0.a.getBusinessHandler(51);
    aavk localaavk = (aavk)this.this$0.a.getBusinessHandler(49);
    for (;;)
    {
      synchronized (localaavk.a)
      {
        Iterator localIterator = localaavk.a.entrySet().iterator();
        if (localIterator.hasNext())
        {
          if (((MessageRecord)((Map.Entry)localIterator.next()).getValue()).uniseq != this.a.uniseq) {
            continue;
          }
          i = 1;
          if ((i == 0) && (!TextUtils.isEmpty(this.a.thumbFileKey)))
          {
            long l = localaara.a(this.a.thumbFileKey, this.a.coverkey2, 2154);
            localaavk.a.put(Long.valueOf(l), this.a);
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