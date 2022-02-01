package com.tencent.ad.tangram.views.button;

import com.tencent.ad.tangram.downloader.AdDownloaderV2;

class AdButtonController$1
  implements Runnable
{
  AdButtonController$1(AdButtonController paramAdButtonController) {}
  
  public void run()
  {
    if (AdDownloaderV2.INSTANCE.isDownloadedOnFileThread(AdButtonController.access$000(this.this$0)))
    {
      AdButtonController.access$100(this.this$0, 8, 100);
      return;
    }
    int i = AdDownloaderV2.INSTANCE.getProgressOnFileThread(AdButtonController.access$000(this.this$0));
    if (i > 0)
    {
      AdButtonController.access$100(this.this$0, 7, i);
      return;
    }
    AdButtonController.access$200(this.this$0, 4, 0);
    AdButtonController.access$300(this.this$0, 2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.AdButtonController.1
 * JD-Core Version:    0.7.0.1
 */