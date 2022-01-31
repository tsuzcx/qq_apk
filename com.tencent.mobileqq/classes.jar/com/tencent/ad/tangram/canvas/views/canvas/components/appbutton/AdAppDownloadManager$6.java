package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.util.AdAppUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class AdAppDownloadManager$6
  implements AdAppDownloadManager.d
{
  AdAppDownloadManager$6(AdAppDownloadManager paramAdAppDownloadManager) {}
  
  public void onPkgExist(boolean paramBoolean)
  {
    if ((AdAppDownloadManager.access$700(this.this$0) == null) || (AdAppDownloadManager.access$700(this.this$0).get() == null) || (AdAppDownloadManager.access$200(this.this$0) == null) || (AdAppDownloadManager.access$800(this.this$0) == null) || (AdAppDownloadManager.access$800(this.this$0).size() == 0)) {}
    label184:
    label333:
    for (;;)
    {
      return;
      Object localObject = AdAppDownloadManager.access$200(this.this$0).packageName;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        h localh;
        if (paramBoolean)
        {
          if (AdAppUtil.isInstalled((Context)AdAppDownloadManager.access$700(this.this$0).get(), (String)localObject))
          {
            AdAppDownloadManager.access$1000(this.this$0, (String)localObject);
            return;
          }
          AdLog.w("AdAppDownloadManager", "onActivityResume already finishDownload. " + (String)localObject);
          localObject = AdAppDownloadManager.access$800(this.this$0).iterator();
          for (;;)
          {
            if (!((Iterator)localObject).hasNext()) {
              break label184;
            }
            localh = (h)((Iterator)localObject).next();
            if (!(localh instanceof e)) {
              break;
            }
            ((e)localh).finishDownloadUpdateUI(AdAppDownloadManager.access$200(this.this$0));
          }
        }
        else
        {
          if (AdAppUtil.isInstalled((Context)AdAppDownloadManager.access$700(this.this$0).get(), (String)localObject))
          {
            AdAppDownloadManager.access$1000(this.this$0, (String)localObject);
            return;
          }
          if ((AdAppDownloadManager.access$200(this.this$0).cState == 6) || (AdAppDownloadManager.access$200(this.this$0).cState == 0) || (AdAppDownloadManager.access$200(this.this$0).cState == 3))
          {
            AdLog.w("AdAppDownloadManager", "onActivityResume already installed or finishDownload but not exist." + (String)localObject);
            localObject = AdAppDownloadManager.access$800(this.this$0).iterator();
            for (;;)
            {
              if (!((Iterator)localObject).hasNext()) {
                break label333;
              }
              localh = (h)((Iterator)localObject).next();
              if (!(localh instanceof e)) {
                break;
              }
              ((e)localh).resetDownloadStateUi(AdAppDownloadManager.access$200(this.this$0));
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager.6
 * JD-Core Version:    0.7.0.1
 */