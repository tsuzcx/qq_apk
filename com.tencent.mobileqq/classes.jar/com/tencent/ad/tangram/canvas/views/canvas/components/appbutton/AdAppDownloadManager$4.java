package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class AdAppDownloadManager$4
  implements AdAppDownloadManager.d
{
  AdAppDownloadManager$4(AdAppDownloadManager paramAdAppDownloadManager, boolean paramBoolean) {}
  
  public void onPkgExist(boolean paramBoolean)
  {
    if ((AdAppDownloadManager.access$200(this.this$0) == null) || (AdAppDownloadManager.access$700(this.this$0) == null) || (AdAppDownloadManager.access$700(this.this$0).get() == null)) {}
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      localObject1 = AdAppDownloadManager.access$200(this.this$0).packageName;
      localObject2 = AdAppDownloadManager.access$200(this.this$0).apkUrlhttp;
    } while ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject2)));
    if (paramBoolean)
    {
      AdAppDownloadManager.access$200(this.this$0).cState = 3;
      b.reportAsync(AdAppDownloadManager.access$700(this.this$0), this.this$0.ad, 270);
      this.this$0.installDownload((String)localObject2);
      AdAppDownloadManager.access$900(this.this$0, AdAppDownloadManager.access$200(this.this$0).cState);
      return;
    }
    int i = this.this$0.getCurrentPkgDownloadProgress((Context)AdAppDownloadManager.access$700(this.this$0).get(), (String)localObject1, (String)localObject2);
    if (i < 0) {
      i = 0;
    }
    for (;;)
    {
      AdAppDownloadManager.access$200(this.this$0).cProgerss = i;
      if ((this.val$isUserClick) || (AdAppDownloadManager.access$000(this.this$0)))
      {
        AdLog.i("AdAppDownloadManager", "isUserClick || autodownload && wifi " + this.val$isUserClick + " ," + (String)localObject1);
        AdAppDownloadManager.access$200(this.this$0).cState = 1;
        this.this$0.startDownload();
        if ((AdAppDownloadManager.access$800(this.this$0) == null) || (AdAppDownloadManager.access$800(this.this$0).size() <= 0)) {
          break;
        }
        localObject1 = AdAppDownloadManager.access$800(this.this$0).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (h)((Iterator)localObject1).next();
          if ((localObject2 instanceof e)) {
            ((h)localObject2).startDownload(i);
          }
        }
        break;
      }
      if (this.this$0.isPkgDownloading((Context)AdAppDownloadManager.access$700(this.this$0).get(), (String)localObject1, (String)localObject2) >= 0)
      {
        AdAppDownloadManager.access$200(this.this$0).cState = 8;
        this.this$0.setStartedDownload(true);
        break;
      }
      if (this.this$0.isPkgDownloadPaused((Context)AdAppDownloadManager.access$700(this.this$0).get(), (String)localObject1, (String)localObject2) < 0) {
        break;
      }
      AdAppDownloadManager.access$200(this.this$0).cState = 2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */