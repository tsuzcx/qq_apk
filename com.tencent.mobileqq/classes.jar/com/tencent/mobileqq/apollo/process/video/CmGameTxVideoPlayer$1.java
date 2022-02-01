package com.tencent.mobileqq.apollo.process.video;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class CmGameTxVideoPlayer$1
  implements Runnable
{
  CmGameTxVideoPlayer$1(CmGameTxVideoPlayer paramCmGameTxVideoPlayer) {}
  
  public void run()
  {
    if (CmGameTxVideoPlayer.a(this.this$0) < 0L) {}
    do
    {
      return;
      Iterator localIterator = CmGameTxVideoPlayer.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        ICmGameVideoCallback localICmGameVideoCallback = (ICmGameVideoCallback)localIterator.next();
        if (localICmGameVideoCallback != null) {
          localICmGameVideoCallback.a(CmGameTxVideoPlayer.a(this.this$0), this.this$0.a());
        }
      }
      CmGameTxVideoPlayer.a(this.this$0, this.this$0.a() - this.this$0.b());
    } while (CmGameTxVideoPlayer.a(this.this$0) == null);
    CmGameTxVideoPlayer.a(this.this$0).postDelayed(this, CmGameTxVideoPlayer.b(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.video.CmGameTxVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */