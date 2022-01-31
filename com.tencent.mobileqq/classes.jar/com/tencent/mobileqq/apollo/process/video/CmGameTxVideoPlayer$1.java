package com.tencent.mobileqq.apollo.process.video;

import airj;
import airr;
import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameTxVideoPlayer$1
  implements Runnable
{
  public CmGameTxVideoPlayer$1(airj paramairj) {}
  
  public void run()
  {
    if (airj.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = airj.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        airr localairr = (airr)localIterator.next();
        if (localairr != null) {
          localairr.a(airj.a(this.this$0), this.this$0.a() / 1000L);
        }
      }
      airj.b(this.this$0);
    } while (airj.a(this.this$0) == null);
    airj.a(this.this$0).postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */