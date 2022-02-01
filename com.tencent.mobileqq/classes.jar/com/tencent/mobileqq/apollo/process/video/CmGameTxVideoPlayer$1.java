package com.tencent.mobileqq.apollo.process.video;

import anaq;
import anay;
import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameTxVideoPlayer$1
  implements Runnable
{
  public CmGameTxVideoPlayer$1(anaq paramanaq) {}
  
  public void run()
  {
    if (anaq.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = anaq.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        anay localanay = (anay)localIterator.next();
        if (localanay != null) {
          localanay.a(anaq.a(this.this$0), this.this$0.a());
        }
      }
      anaq.a(this.this$0, this.this$0.a() - this.this$0.b());
    } while (anaq.a(this.this$0) == null);
    anaq.a(this.this$0).postDelayed(this, anaq.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */