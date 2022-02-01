package com.tencent.biz.pubaccount.weishi_new.player;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSPlayerManager$PlayStartVideoRunnable
  implements Runnable
{
  private WSPlayerParam a;
  private WSPlayerWrapper b;
  private boolean c;
  
  WSPlayerManager$PlayStartVideoRunnable(WSPlayerManager paramWSPlayerManager, WSPlayerParam paramWSPlayerParam, WSPlayerWrapper paramWSPlayerWrapper, boolean paramBoolean)
  {
    this.a = paramWSPlayerParam;
    this.b = paramWSPlayerWrapper;
    this.c = paramBoolean;
  }
  
  public void run()
  {
    WSLog.e("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] post thread");
    if ((!this.c) && (!WSPlayerManager.a(this.this$0, this.b))) {
      return;
    }
    if ((this.a != null) && (this.b != null))
    {
      if (WSPlayerManager.o(this.this$0)) {
        return;
      }
      boolean bool2 = this.c;
      boolean bool1 = true;
      if (!bool2) {
        WSPlayerManager.a(this.this$0, true);
      }
      long l = this.a.g;
      if (l > 0L) {
        WSPlayerManager.g(this.this$0, true);
      }
      if (TextUtils.isEmpty(this.a.c.e)) {
        return;
      }
      Object localObject = WSPlayerManager.b(this.this$0);
      if ((localObject == null) || (!((WSVideoPreDownloadManager)localObject).a(this.a.c.e))) {
        bool1 = false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSPlayerManager.java][PlayStartVideoRunnable.run] goto playerStartByUrl!! isPreDownload:");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(", videoUrl:");
      ((StringBuilder)localObject).append(this.a.c.e);
      WSLog.e("WS_VIDEO_PLAYER", ((StringBuilder)localObject).toString());
      this.b.f(bool1);
      if (!this.b.a("", this.a.c.e, 101, l, 0L, this.a.c.d, true, this.a.h))
      {
        WSLog.d("WS_VIDEO_PLAYER", "[WSPlayerManager.java][PlayStartVideoRunnable.run] playerStartByUrl failed, sendMsg retry.");
        WSPlayerManager.h(this.this$0).sendEmptyMessage(-4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */