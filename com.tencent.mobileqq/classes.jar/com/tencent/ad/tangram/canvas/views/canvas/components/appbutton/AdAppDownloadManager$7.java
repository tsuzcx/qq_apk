package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import com.tencent.ad.tangram.canvas.report.AdDMPReportUtil;

class AdAppDownloadManager$7
  implements AdAppDownloadManager.d
{
  AdAppDownloadManager$7(AdAppDownloadManager paramAdAppDownloadManager) {}
  
  public void onPkgExist(boolean paramBoolean)
  {
    if (paramBoolean) {
      AdDMPReportUtil.reportAppBtnClickAsync(this.this$0.ad);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppDownloadManager.7
 * JD-Core Version:    0.7.0.1
 */