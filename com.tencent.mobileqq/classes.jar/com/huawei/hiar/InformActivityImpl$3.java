package com.huawei.hiar;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.Log;

class InformActivityImpl$3
  implements DialogInterface.OnClickListener
{
  InformActivityImpl$3(InformActivityImpl paramInformActivityImpl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Log.d(InformActivityImpl.TAG, " __arengine_set_wireless onClick: ");
    j.b().b = this.a.timeoutFatal;
    if (InformActivityImpl.access$200(this.a) != HuaweiArApkBase.ARAvailability.UNKNOWN_ERROR) {
      InformActivityImpl.access$000(this.a).startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }
    InformActivityImpl.access$000(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.InformActivityImpl.3
 * JD-Core Version:    0.7.0.1
 */