package com.tencent.mobileqq.apollo.process.video;

import amtk;
import amtu;
import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameGdtVideoPlayer$1
  implements Runnable
{
  public CmGameGdtVideoPlayer$1(amtk paramamtk) {}
  
  public void run()
  {
    if (amtk.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = amtk.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        amtu localamtu = (amtu)localIterator.next();
        if (localamtu != null) {
          localamtu.a(amtk.a(this.this$0), this.this$0.a());
        }
      }
      amtk.a(this.this$0, this.this$0.a() - this.this$0.b());
    } while (amtk.a(this.this$0) == null);
    amtk.a(this.this$0).postDelayed(this, amtk.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameGdtVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */