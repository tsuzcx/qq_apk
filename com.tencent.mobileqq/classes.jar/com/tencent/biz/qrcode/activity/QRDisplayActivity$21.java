package com.tencent.biz.qrcode.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;

class QRDisplayActivity$21
  implements DialogInterface.OnCancelListener
{
  QRDisplayActivity$21(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.a.h) {
      return;
    }
    this.a.i = -1;
    this.a.h = true;
    QRDisplayActivity.a(this.a).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.21
 * JD-Core Version:    0.7.0.1
 */