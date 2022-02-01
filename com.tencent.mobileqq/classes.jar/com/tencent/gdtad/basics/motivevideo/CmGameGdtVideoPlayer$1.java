package com.tencent.gdtad.basics.motivevideo;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class CmGameGdtVideoPlayer$1
  implements Runnable
{
  CmGameGdtVideoPlayer$1(CmGameGdtVideoPlayer paramCmGameGdtVideoPlayer) {}
  
  public void run()
  {
    if (CmGameGdtVideoPlayer.access$000(this.this$0) < 0L) {
      return;
    }
    Object localObject = CmGameGdtVideoPlayer.access$100(this.this$0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ICmGameVideoCallback localICmGameVideoCallback = (ICmGameVideoCallback)((Iterator)localObject).next();
      if (localICmGameVideoCallback != null) {
        localICmGameVideoCallback.a(CmGameGdtVideoPlayer.access$000(this.this$0), this.this$0.getVideoDuration());
      }
    }
    localObject = this.this$0;
    CmGameGdtVideoPlayer.access$002((CmGameGdtVideoPlayer)localObject, ((CmGameGdtVideoPlayer)localObject).getVideoDuration() - this.this$0.getCurrentPosition());
    if (CmGameGdtVideoPlayer.access$200(this.this$0) != null) {
      CmGameGdtVideoPlayer.access$200(this.this$0).postDelayed(this, CmGameGdtVideoPlayer.access$300(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.CmGameGdtVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */