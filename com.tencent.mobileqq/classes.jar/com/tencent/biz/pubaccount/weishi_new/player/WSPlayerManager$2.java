package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

class WSPlayerManager$2
  implements Runnable
{
  WSPlayerManager$2(WSPlayerManager paramWSPlayerManager, WeakReference paramWeakReference, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    WSPlayerParam localWSPlayerParam = (WSPlayerParam)this.a.get();
    if (localWSPlayerParam == null) {
      return;
    }
    Object localObject = WSPlayerManager.w(this.this$0);
    localWSPlayerParam.d = ((WSPlayerWrapper)localObject);
    if ((localObject != null) && (WSPlayerManager.h(this.this$0) != null))
    {
      ((WSPlayerWrapper)localObject).a(localWSPlayerParam.c);
      WSPlayerManager.x(this.this$0).put(localObject, WSPlayerManager.u());
      WSPlayerManager.h(this.this$0).post(new WSPlayerManager.2.1(this));
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSPlayerManager.java][createVideoPlayerAndPlay] async run error! playerParam.videoPlayer:");
    ((StringBuilder)localObject).append(localWSPlayerParam.d);
    ((StringBuilder)localObject).append(", mUIHandler:");
    ((StringBuilder)localObject).append(WSPlayerManager.h(this.this$0));
    WSLog.d("WS_VIDEO_PLAYER", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.2
 * JD-Core Version:    0.7.0.1
 */