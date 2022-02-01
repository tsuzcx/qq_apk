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
    if (this.a.aM) {
      return;
    }
    paramDialogInterface = this.a;
    paramDialogInterface.aN = -1;
    paramDialogInterface.aM = true;
    QRDisplayActivity.b(paramDialogInterface).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.21
 * JD-Core Version:    0.7.0.1
 */