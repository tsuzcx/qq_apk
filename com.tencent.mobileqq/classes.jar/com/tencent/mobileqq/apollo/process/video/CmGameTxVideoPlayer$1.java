package com.tencent.mobileqq.apollo.process.video;

import android.os.Handler;
import anfg;
import anfo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameTxVideoPlayer$1
  implements Runnable
{
  public CmGameTxVideoPlayer$1(anfg paramanfg) {}
  
  public void run()
  {
    if (anfg.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = anfg.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        anfo localanfo = (anfo)localIterator.next();
        if (localanfo != null) {
          localanfo.a(anfg.a(this.this$0), this.this$0.a());
        }
      }
      anfg.a(this.this$0, this.this$0.a() - this.this$0.b());
    } while (anfg.a(this.this$0) == null);
    anfg.a(this.this$0).postDelayed(this, anfg.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */