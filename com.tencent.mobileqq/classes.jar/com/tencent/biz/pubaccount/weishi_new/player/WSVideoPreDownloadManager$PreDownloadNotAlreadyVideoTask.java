package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.Set;
import mqq.util.WeakReference;

class WSVideoPreDownloadManager$PreDownloadNotAlreadyVideoTask
  implements Runnable
{
  private WeakReference<WSVideoPreDownloadManager> a;
  private boolean b;
  
  WSVideoPreDownloadManager$PreDownloadNotAlreadyVideoTask(WSVideoPreDownloadManager paramWSVideoPreDownloadManager, boolean paramBoolean)
  {
    this.a = new WeakReference(paramWSVideoPreDownloadManager);
    this.b = paramBoolean;
  }
  
  public void run()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = (WSVideoPreDownloadManager)this.a.get();
    if (localWSVideoPreDownloadManager == null) {
      return;
    }
    if ((this.b) && (WSVideoPreDownloadManager.c(localWSVideoPreDownloadManager) != null)) {
      WSVideoPreDownloadManager.c(localWSVideoPreDownloadManager).add(WSVideoPreDownloadManager.d(localWSVideoPreDownloadManager));
    }
    WSVideoPreDownloadManager.a(localWSVideoPreDownloadManager, null);
    WSVideoPreDownloadManager.e(localWSVideoPreDownloadManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.PreDownloadNotAlreadyVideoTask
 * JD-Core Version:    0.7.0.1
 */