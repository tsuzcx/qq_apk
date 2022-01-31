package com.tencent.mobileqq.apollo.process.video;

import ajeh;
import ajep;
import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameTxVideoPlayer$1
  implements Runnable
{
  public CmGameTxVideoPlayer$1(ajeh paramajeh) {}
  
  public void run()
  {
    if (ajeh.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = ajeh.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        ajep localajep = (ajep)localIterator.next();
        if (localajep != null) {
          localajep.a(ajeh.a(this.this$0), this.this$0.a() / 1000L);
        }
      }
      ajeh.b(this.this$0);
    } while (ajeh.a(this.this$0) == null);
    ajeh.a(this.this$0).postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */