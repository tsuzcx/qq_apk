package com.tencent.mobileqq.apollo.process.video;

import akvr;
import akvz;
import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameTxVideoPlayer$1
  implements Runnable
{
  public CmGameTxVideoPlayer$1(akvr paramakvr) {}
  
  public void run()
  {
    if (akvr.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = akvr.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        akvz localakvz = (akvz)localIterator.next();
        if (localakvz != null) {
          localakvz.a(akvr.a(this.this$0), this.this$0.a());
        }
      }
      akvr.a(this.this$0, this.this$0.a() - this.this$0.b());
    } while (akvr.a(this.this$0) == null);
    akvr.a(this.this$0).postDelayed(this, akvr.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */