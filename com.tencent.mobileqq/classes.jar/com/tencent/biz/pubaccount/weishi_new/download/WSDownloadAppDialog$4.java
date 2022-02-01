package com.tencent.biz.pubaccount.weishi_new.download;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;

final class WSDownloadAppDialog$4
  implements DialogInterface.OnClickListener
{
  WSDownloadAppDialog$4(Activity paramActivity, WSDownloadParams paramWSDownloadParams) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof WSDownloadAppDialog)) {
      WSDownloadAppDialog.a(this.a, this.b);
    } else {
      Log.e("weishi-808", "dialog type is error");
    }
    paramDialogInterface.dismiss();
    WSDownloadAppDialog.a(125, this.b);
    WSReportDc00898.a(this.b.mScene, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WSDownloadAppDialog.4
 * JD-Core Version:    0.7.0.1
 */