package com.tencent.ad.tangram.views.canvas.components.appbutton;

import com.tencent.ad.tangram.statistics.canvas.b;

class AdAppDownloadManager$7
  implements AdAppDownloadManager.e
{
  AdAppDownloadManager$7(AdAppDownloadManager paramAdAppDownloadManager) {}
  
  public void onPkgExist(boolean paramBoolean)
  {
    if (paramBoolean) {
      b.reportAppBtnClickAsync(this.this$0.ad);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppDownloadManager.7
 * JD-Core Version:    0.7.0.1
 */