package com.tencent.biz.pubaccount.weishi_new.download;

import android.content.DialogInterface;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;

final class WSDownloadAppDialog$5
  extends DialogUtil.DialogOnClickAdapter
{
  WSDownloadAppDialog$5(WSDownloadParams paramWSDownloadParams) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    WSDownloadAppDialog.a(126, this.a);
    WSReportDc00898.a(this.a.mScene, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.download.WSDownloadAppDialog.5
 * JD-Core Version:    0.7.0.1
 */