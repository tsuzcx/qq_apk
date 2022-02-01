package com.tencent.biz.pubaccount.weishi_new.player;

import java.util.Set;
import mqq.util.WeakReference;

public class WSVideoPreDownloadManager$PreDownloadNotAlreadyVideoTask
  implements Runnable
{
  private WeakReference<WSVideoPreDownloadManager> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public WSVideoPreDownloadManager$PreDownloadNotAlreadyVideoTask(WSVideoPreDownloadManager paramWSVideoPreDownloadManager, boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramWSVideoPreDownloadManager);
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = (WSVideoPreDownloadManager)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localWSVideoPreDownloadManager == null) {
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (WSVideoPreDownloadManager.a(localWSVideoPreDownloadManager) != null)) {
      WSVideoPreDownloadManager.a(localWSVideoPreDownloadManager).add(WSVideoPreDownloadManager.a(localWSVideoPreDownloadManager));
    }
    WSVideoPreDownloadManager.a(localWSVideoPreDownloadManager, null);
    WSVideoPreDownloadManager.b(localWSVideoPreDownloadManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.PreDownloadNotAlreadyVideoTask
 * JD-Core Version:    0.7.0.1
 */