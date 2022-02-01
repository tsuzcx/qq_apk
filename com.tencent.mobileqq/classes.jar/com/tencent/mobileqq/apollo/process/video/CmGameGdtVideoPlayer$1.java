package com.tencent.mobileqq.apollo.process.video;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class CmGameGdtVideoPlayer$1
  implements Runnable
{
  CmGameGdtVideoPlayer$1(CmGameGdtVideoPlayer paramCmGameGdtVideoPlayer) {}
  
  public void run()
  {
    if (CmGameGdtVideoPlayer.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = CmGameGdtVideoPlayer.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        ICmGameVideoCallback localICmGameVideoCallback = (ICmGameVideoCallback)localIterator.next();
        if (localICmGameVideoCallback != null) {
          localICmGameVideoCallback.a(CmGameGdtVideoPlayer.a(this.this$0), this.this$0.a());
        }
      }
      CmGameGdtVideoPlayer.a(this.this$0, this.this$0.a() - this.this$0.b());
    } while (CmGameGdtVideoPlayer.a(this.this$0) == null);
    CmGameGdtVideoPlayer.a(this.this$0).postDelayed(this, CmGameGdtVideoPlayer.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameGdtVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */