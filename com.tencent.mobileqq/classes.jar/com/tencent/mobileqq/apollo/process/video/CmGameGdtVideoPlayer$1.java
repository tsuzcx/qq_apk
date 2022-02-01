package com.tencent.mobileqq.apollo.process.video;

import android.os.Handler;
import anfe;
import anfo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameGdtVideoPlayer$1
  implements Runnable
{
  public CmGameGdtVideoPlayer$1(anfe paramanfe) {}
  
  public void run()
  {
    if (anfe.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = anfe.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        anfo localanfo = (anfo)localIterator.next();
        if (localanfo != null) {
          localanfo.a(anfe.a(this.this$0), this.this$0.a());
        }
      }
      anfe.a(this.this$0, this.this$0.a() - this.this$0.b());
    } while (anfe.a(this.this$0) == null);
    anfe.a(this.this$0).postDelayed(this, anfe.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameGdtVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */