package com.tencent.device;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;

final class DeviceScanner$1
  implements DialogInterface.OnClickListener
{
  DeviceScanner$1(OnQRHandleResultCallback paramOnQRHandleResultCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.val$callBack;
    if (paramDialogInterface != null) {
      paramDialogInterface.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.DeviceScanner.1
 * JD-Core Version:    0.7.0.1
 */