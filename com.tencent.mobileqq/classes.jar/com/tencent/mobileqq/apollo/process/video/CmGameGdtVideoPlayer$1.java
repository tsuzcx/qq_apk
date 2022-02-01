package com.tencent.mobileqq.apollo.process.video;

import alzy;
import amai;
import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameGdtVideoPlayer$1
  implements Runnable
{
  public CmGameGdtVideoPlayer$1(alzy paramalzy) {}
  
  public void run()
  {
    if (alzy.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = alzy.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        amai localamai = (amai)localIterator.next();
        if (localamai != null) {
          localamai.a(alzy.a(this.this$0), this.this$0.a());
        }
      }
      alzy.a(this.this$0, this.this$0.a() - this.this$0.b());
    } while (alzy.a(this.this$0) == null);
    alzy.a(this.this$0).postDelayed(this, alzy.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameGdtVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */