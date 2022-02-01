package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.statistics.c;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class AdAppDownloadManager$4
  implements AdAppDownloadManager.e
{
  AdAppDownloadManager$4(AdAppDownloadManager paramAdAppDownloadManager, boolean paramBoolean) {}
  
  public void onPkgExist(boolean paramBoolean)
  {
    if ((AdAppDownloadManager.access$200(this.this$0) != null) && (AdAppDownloadManager.access$800(this.this$0) != null))
    {
      if (AdAppDownloadManager.access$800(this.this$0).get() == null) {
        return;
      }
      Object localObject1 = AdAppDownloadManager.access$200(this.this$0).packageName;
      Object localObject2 = AdAppDownloadManager.access$200(this.this$0).apkUrlhttp;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          return;
        }
        if (paramBoolean)
        {
          AdAppDownloadManager.access$200(this.this$0).cState = 3;
          c.reportAsync(AdAppDownloadManager.access$800(this.this$0), this.this$0.ad, 270);
          this.this$0.installDownload((String)localObject2);
        }
        else
        {
          AdAppDownloadManager localAdAppDownloadManager = this.this$0;
          int j = localAdAppDownloadManager.getCurrentPkgDownloadProgress((Context)AdAppDownloadManager.access$800(localAdAppDownloadManager).get(), (String)localObject1, (String)localObject2);
          int i = j;
          if (j < 0) {
            i = 0;
          }
          AdAppDownloadManager.access$200(this.this$0).cProgerss = i;
          if ((!this.val$isUserClick) && (!AdAppDownloadManager.access$000(this.this$0)))
          {
            localAdAppDownloadManager = this.this$0;
            if (localAdAppDownloadManager.isPkgDownloading((Context)AdAppDownloadManager.access$800(localAdAppDownloadManager).get(), (String)localObject1, (String)localObject2) >= 0)
            {
              AdAppDownloadManager.access$200(this.this$0).cState = 8;
              this.this$0.setStartedDownload(true);
            }
            else
            {
              localAdAppDownloadManager = this.this$0;
              if (localAdAppDownloadManager.isPkgDownloadPaused((Context)AdAppDownloadManager.access$800(localAdAppDownloadManager).get(), (String)localObject1, (String)localObject2) >= 0) {
                AdAppDownloadManager.access$200(this.this$0).cState = 2;
              }
            }
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("isUserClick || autodownload && wifi ");
            ((StringBuilder)localObject2).append(this.val$isUserClick);
            ((StringBuilder)localObject2).append(" ,");
            ((StringBuilder)localObject2).append((String)localObject1);
            AdLog.i("AdAppDownloadManager", ((StringBuilder)localObject2).toString());
            AdAppDownloadManager.access$200(this.this$0).cState = 1;
            this.this$0.startDownload();
            if ((AdAppDownloadManager.access$900(this.this$0) != null) && (AdAppDownloadManager.access$900(this.this$0).size() > 0))
            {
              localObject1 = AdAppDownloadManager.access$900(this.this$0).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (h)((Iterator)localObject1).next();
                if ((localObject2 instanceof e)) {
                  ((h)localObject2).startDownload(i);
                }
              }
            }
          }
        }
        localObject1 = this.this$0;
        AdAppDownloadManager.access$1000((AdAppDownloadManager)localObject1, AdAppDownloadManager.access$200((AdAppDownloadManager)localObject1).cState);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.4
 * JD-Core Version:    0.7.0.1
 */