package com.tencent.mobileqq.apollo.game.process.video.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.apollo.game.process.video.ICmGameVideoCallback;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class CmGameVideoPlayerImpl$1
  implements Runnable
{
  CmGameVideoPlayerImpl$1(CmGameVideoPlayerImpl paramCmGameVideoPlayerImpl) {}
  
  public void run()
  {
    if (CmGameVideoPlayerImpl.access$000(this.this$0) < 0L) {
      return;
    }
    Object localObject = CmGameVideoPlayerImpl.access$100(this.this$0).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ICmGameVideoCallback localICmGameVideoCallback = (ICmGameVideoCallback)((Iterator)localObject).next();
      if (localICmGameVideoCallback != null) {
        localICmGameVideoCallback.a(CmGameVideoPlayerImpl.access$000(this.this$0), this.this$0.getVideoDuration());
      }
    }
    localObject = this.this$0;
    CmGameVideoPlayerImpl.access$002((CmGameVideoPlayerImpl)localObject, ((CmGameVideoPlayerImpl)localObject).getVideoDuration() - this.this$0.getCurrentPosition());
    if (CmGameVideoPlayerImpl.access$200(this.this$0) != null) {
      CmGameVideoPlayerImpl.access$200(this.this$0).postDelayed(this, CmGameVideoPlayerImpl.access$300(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.video.api.impl.CmGameVideoPlayerImpl.1
 * JD-Core Version:    0.7.0.1
 */