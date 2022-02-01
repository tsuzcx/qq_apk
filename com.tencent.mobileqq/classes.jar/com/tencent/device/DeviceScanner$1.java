package com.tencent.device;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qrcode.ipc.QrHandleResultCallBack;

final class DeviceScanner$1
  implements DialogInterface.OnClickListener
{
  DeviceScanner$1(QrHandleResultCallBack paramQrHandleResultCallBack) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.val$callBack != null) {
      this.val$callBack.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.device.DeviceScanner.1
 * JD-Core Version:    0.7.0.1
 */