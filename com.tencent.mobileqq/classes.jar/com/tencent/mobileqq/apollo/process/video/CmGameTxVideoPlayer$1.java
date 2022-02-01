package com.tencent.mobileqq.apollo.process.video;

import amtm;
import amtu;
import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameTxVideoPlayer$1
  implements Runnable
{
  public CmGameTxVideoPlayer$1(amtm paramamtm) {}
  
  public void run()
  {
    if (amtm.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = amtm.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        amtu localamtu = (amtu)localIterator.next();
        if (localamtu != null) {
          localamtu.a(amtm.a(this.this$0), this.this$0.a());
        }
      }
      amtm.a(this.this$0, this.this$0.a() - this.this$0.b());
    } while (amtm.a(this.this$0) == null);
    amtm.a(this.this$0).postDelayed(this, amtm.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */