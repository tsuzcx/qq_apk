package com.tencent.ad.tangram.views.button;

import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.downloader.AdDownloaderV2;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdClickUtil.Params;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppBtnData;
import com.tencent.ad.tangram.views.canvas.components.appbutton.b;

class AdButtonController$4
  implements Runnable
{
  AdButtonController$4(AdButtonController paramAdButtonController, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.val$visible) {
      AdButtonController.access$300(this.this$0, 5, 0);
    }
    AdButtonController.access$200(this.this$0, 3, 0);
    AdAppBtnData localAdAppBtnData = b.loadGdtAppBtnData(AdButtonController.access$800(this.this$0).ad.getAppId(), AdButtonController.access$800(this.this$0).ad.getAppChannelId(), -1);
    if ((localAdAppBtnData != null) && (!TextUtils.isEmpty(localAdAppBtnData.apkUrlhttp)))
    {
      AdButtonController.access$002(this.this$0, localAdAppBtnData.apkUrlhttp);
      AdButtonController.access$200(this.this$0, 4, 0);
      if (AdButtonController.access$900(this.this$0) != null)
      {
        a.a locala = new a.a();
        locala.version = localAdAppBtnData.versionName;
        locala.developer = localAdAppBtnData.authorName;
        AdButtonController.access$900(this.this$0).setParams(locala);
      }
      if (AdDownloaderV2.INSTANCE.isDownloadedOnFileThread(AdButtonController.access$000(this.this$0))) {
        AdButtonController.access$100(this.this$0, 8, 100);
      }
      if (this.val$autoDownload)
      {
        AdThreadManager.INSTANCE.post(new AdButtonController.4.1(this), 0);
        return;
      }
      int i = AdDownloaderV2.INSTANCE.getProgressOnFileThread(AdButtonController.access$000(this.this$0));
      if (i > 0) {
        AdButtonController.access$100(this.this$0, 7, i);
      }
    }
    else
    {
      if (this.val$visible)
      {
        AdButtonController.access$100(this.this$0, 2, 0);
        return;
      }
      AdButtonController.access$200(this.this$0, 2, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.AdButtonController.4
 * JD-Core Version:    0.7.0.1
 */