package com.tencent.mobileqq.apollo.process.video;

import ajef;
import ajen;
import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameTxVideoPlayer$1
  implements Runnable
{
  public CmGameTxVideoPlayer$1(ajef paramajef) {}
  
  public void run()
  {
    if (ajef.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = ajef.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        ajen localajen = (ajen)localIterator.next();
        if (localajen != null) {
          localajen.a(ajef.a(this.this$0), this.this$0.a() / 1000L);
        }
      }
      ajef.b(this.this$0);
    } while (ajef.a(this.this$0) == null);
    ajef.a(this.this$0).postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */