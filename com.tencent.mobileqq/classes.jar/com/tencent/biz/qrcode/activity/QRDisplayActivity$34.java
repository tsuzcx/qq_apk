package com.tencent.biz.qrcode.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.vas.qid.QidCardManager;
import com.tencent.mobileqq.vas.qid.QidCardManager.QidCardReport;

class QRDisplayActivity$34
  implements DialogInterface.OnClickListener
{
  QRDisplayActivity$34(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QidCardManager.a(this.a.app, this.a, 1);
    QidCardManager.QidCardReport.b("0X800B971");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.34
 * JD-Core Version:    0.7.0.1
 */