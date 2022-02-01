package com.tencent.ad.tangram.views.canvas.components.appbutton;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdAppUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class AdAppDownloadManager$6
  implements AdAppDownloadManager.e
{
  AdAppDownloadManager$6(AdAppDownloadManager paramAdAppDownloadManager) {}
  
  public void onPkgExist(boolean paramBoolean)
  {
    if ((AdAppDownloadManager.access$800(this.this$0) != null) && (AdAppDownloadManager.access$800(this.this$0).get() != null) && (AdAppDownloadManager.access$200(this.this$0) != null) && (AdAppDownloadManager.access$900(this.this$0) != null))
    {
      if (AdAppDownloadManager.access$900(this.this$0).size() == 0) {
        return;
      }
      Object localObject1 = AdAppDownloadManager.access$200(this.this$0).packageName;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      Object localObject2;
      if (paramBoolean)
      {
        if (AdAppUtil.isInstalled((Context)AdAppDownloadManager.access$800(this.this$0).get(), (String)localObject1))
        {
          AdAppDownloadManager.access$1100(this.this$0, (String)localObject1);
          return;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onActivityResume already finishDownload. ");
        ((StringBuilder)localObject2).append((String)localObject1);
        AdLog.w("AdAppDownloadManager", ((StringBuilder)localObject2).toString());
        localObject1 = AdAppDownloadManager.access$900(this.this$0).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (h)((Iterator)localObject1).next();
          if (!(localObject2 instanceof e)) {
            return;
          }
          ((e)localObject2).finishDownloadUpdateUI(AdAppDownloadManager.access$200(this.this$0));
        }
      }
      if (AdAppUtil.isInstalled((Context)AdAppDownloadManager.access$800(this.this$0).get(), (String)localObject1))
      {
        AdAppDownloadManager.access$1100(this.this$0, (String)localObject1);
        return;
      }
      if ((AdAppDownloadManager.access$200(this.this$0).cState == 6) || (AdAppDownloadManager.access$200(this.this$0).cState == 0) || (AdAppDownloadManager.access$200(this.this$0).cState == 3))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onActivityResume already installed or finishDownload but not exist.");
        ((StringBuilder)localObject2).append((String)localObject1);
        AdLog.w("AdAppDownloadManager", ((StringBuilder)localObject2).toString());
        localObject1 = AdAppDownloadManager.access$900(this.this$0).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (h)((Iterator)localObject1).next();
          if (!(localObject2 instanceof e)) {
            return;
          }
          ((e)localObject2).resetDownloadStateUi(AdAppDownloadManager.access$200(this.this$0));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.6
 * JD-Core Version:    0.7.0.1
 */