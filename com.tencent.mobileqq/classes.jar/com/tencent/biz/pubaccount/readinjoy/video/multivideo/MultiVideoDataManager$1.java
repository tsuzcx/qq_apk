package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import qol;
import qxj;
import qxu;

public class MultiVideoDataManager$1
  implements Runnable
{
  public MultiVideoDataManager$1(qxj paramqxj, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    int i = this.a;
    if ((i < this.a + this.b) && (i < qxj.a(this.this$0).a().size()))
    {
      localObject = (VideoInfo)qxj.a(this.this$0).a().get(i);
      if ((TextUtils.isEmpty(((VideoInfo)localObject).j)) || (((VideoInfo)localObject).b)) {}
      for (;;)
      {
        i += 1;
        break;
        localHashMap.put(((VideoInfo)localObject).j, localObject);
      }
    }
    Object localObject = localHashMap.keySet().iterator();
    label172:
    label243:
    label244:
    for (;;)
    {
      String str;
      if (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        boolean bool = qol.a(qxj.a(this.this$0), Long.valueOf(str).longValue());
        Iterator localIterator = localHashMap.values().iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
          if (localVideoInfo.k == bool) {
            break label243;
          }
          localVideoInfo.k = bool;
          i = 1;
        }
      }
      for (;;)
      {
        break label172;
        if (i == 0) {
          break label244;
        }
        qxj.a(this.this$0).post(new MultiVideoDataManager.1.1(this, str));
        break;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoDataManager.1
 * JD-Core Version:    0.7.0.1
 */