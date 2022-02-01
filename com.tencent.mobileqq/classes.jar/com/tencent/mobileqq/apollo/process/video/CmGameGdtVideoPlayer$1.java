package com.tencent.mobileqq.apollo.process.video;

import anao;
import anay;
import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameGdtVideoPlayer$1
  implements Runnable
{
  public CmGameGdtVideoPlayer$1(anao paramanao) {}
  
  public void run()
  {
    if (anao.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = anao.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        anay localanay = (anay)localIterator.next();
        if (localanay != null) {
          localanay.a(anao.a(this.this$0), this.this$0.a());
        }
      }
      anao.a(this.this$0, this.this$0.a() - this.this$0.b());
    } while (anao.a(this.this$0) == null);
    anao.a(this.this$0).postDelayed(this, anao.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameGdtVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */