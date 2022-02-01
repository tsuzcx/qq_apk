package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.content.Context;
import java.lang.ref.WeakReference;

class AdAppDownloadManager$5
  implements Runnable
{
  AdAppDownloadManager$5(AdAppDownloadManager paramAdAppDownloadManager, AdAppDownloadManager.e parame) {}
  
  public void run()
  {
    if ((AdAppDownloadManager.access$800(this.this$0) != null) && (AdAppDownloadManager.access$800(this.this$0).get() != null))
    {
      if (AdAppDownloadManager.access$200(this.this$0) == null) {
        return;
      }
      AdAppDownloadManager localAdAppDownloadManager = this.this$0;
      if (localAdAppDownloadManager.isPkgExist((Context)AdAppDownloadManager.access$800(localAdAppDownloadManager).get(), AdAppDownloadManager.access$200(this.this$0).packageName, AdAppDownloadManager.access$200(this.this$0).apkUrlhttp))
      {
        this.val$callback.onPkgExist(true);
        return;
      }
      this.val$callback.onPkgExist(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.5
 * JD-Core Version:    0.7.0.1
 */