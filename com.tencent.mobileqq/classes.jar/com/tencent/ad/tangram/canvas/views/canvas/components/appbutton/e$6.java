package com.tencent.ad.tangram.canvas.views.canvas.components.appbutton;

import android.content.Context;
import com.tencent.ad.tangram.util.AdAppUtil;

class e$6
  implements AdAppDownloadManager.d
{
  e$6(e parame, Context paramContext, AdAppBtnData paramAdAppBtnData) {}
  
  public void onPkgExist(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (AdAppUtil.isInstalled(this.val$mContext, this.val$mCgdtAppBtnData.packageName)) {
        e.access$200(this.this$0, this.val$mCgdtAppBtnData, this.val$mContext);
      }
    }
    do
    {
      return;
      this.this$0.finishDownloadUpdateUI(this.val$mCgdtAppBtnData);
      e.access$300(this.this$0).installDownload(this.val$mCgdtAppBtnData.apkUrlhttp);
      return;
      if (AdAppUtil.isInstalled(this.val$mContext, this.val$mCgdtAppBtnData.packageName))
      {
        e.access$200(this.this$0, this.val$mCgdtAppBtnData, this.val$mContext);
        return;
      }
      int j = e.access$300(this.this$0).getCurrentPkgDownloadProgress(this.val$mContext, this.val$mCgdtAppBtnData.packageName, this.val$mCgdtAppBtnData.apkUrlhttp);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      e.access$300(this.this$0).startDownload();
      this.this$0.startDownload(i);
    } while (this.this$0.data == null);
    this.this$0.data.canShowProgress = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.e.6
 * JD-Core Version:    0.7.0.1
 */