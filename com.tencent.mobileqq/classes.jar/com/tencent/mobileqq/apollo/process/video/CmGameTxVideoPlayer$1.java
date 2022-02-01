package com.tencent.mobileqq.apollo.process.video;

import amaa;
import amai;
import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameTxVideoPlayer$1
  implements Runnable
{
  public CmGameTxVideoPlayer$1(amaa paramamaa) {}
  
  public void run()
  {
    if (amaa.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = amaa.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        amai localamai = (amai)localIterator.next();
        if (localamai != null) {
          localamai.a(amaa.a(this.this$0), this.this$0.a());
        }
      }
      amaa.a(this.this$0, this.this$0.a() - this.this$0.b());
    } while (amaa.a(this.this$0) == null);
    amaa.a(this.this$0).postDelayed(this, amaa.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */