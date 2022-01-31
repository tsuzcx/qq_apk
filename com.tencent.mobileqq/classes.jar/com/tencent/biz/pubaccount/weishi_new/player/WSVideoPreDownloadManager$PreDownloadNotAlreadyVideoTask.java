package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.Set;

public class WSVideoPreDownloadManager$PreDownloadNotAlreadyVideoTask
  implements Runnable
{
  private boolean a;
  
  public WSVideoPreDownloadManager$PreDownloadNotAlreadyVideoTask(WSVideoPreDownloadManager paramWSVideoPreDownloadManager, boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void run()
  {
    if ((this.a) && (WSVideoPreDownloadManager.a(this.this$0) != null)) {
      WSVideoPreDownloadManager.a(this.this$0).add(WSVideoPreDownloadManager.a(this.this$0));
    }
    WSVideoPreDownloadManager.a(this.this$0, null);
    WSVideoPreDownloadManager.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.PreDownloadNotAlreadyVideoTask
 * JD-Core Version:    0.7.0.1
 */