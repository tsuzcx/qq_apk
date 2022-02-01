package com.tencent.biz.qrcode.activity;

import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener;
import com.tencent.mobileqq.statistics.ReportController;

class QRDisplayActivity$3
  implements LongClickCopyAction.ICopyListener
{
  QRDisplayActivity$3(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onCopyContent(String paramString)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X800AEB3", "0X800AEB3", 0, 0, "", "", "", "");
  }
  
  public void onShowCopyMenu()
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X800AEB1", "0X800AEB1", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.3
 * JD-Core Version:    0.7.0.1
 */