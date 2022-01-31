package com.tencent.mobileqq.apollo.process.video;

import alag;
import alao;
import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CmGameTxVideoPlayer$1
  implements Runnable
{
  public CmGameTxVideoPlayer$1(alag paramalag) {}
  
  public void run()
  {
    if (alag.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = alag.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        alao localalao = (alao)localIterator.next();
        if (localalao != null) {
          localalao.a(alag.a(this.this$0), this.this$0.a());
        }
      }
      alag.a(this.this$0, this.this$0.a() - this.this$0.b());
    } while (alag.a(this.this$0) == null);
    alag.a(this.this$0).postDelayed(this, alag.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */