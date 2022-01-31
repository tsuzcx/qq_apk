package com.huawei.hiar;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import com.huawei.hiar.exceptions.ARFatalException;

class InformActivityImpl$2
  implements DialogInterface.OnClickListener
{
  InformActivityImpl$2(InformActivityImpl paramInformActivityImpl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      Log.d(InformActivityImpl.TAG, " __arengine_install onClick: ");
      InformActivityImpl.access$100(InformActivityImpl.access$000(this.a));
      InformActivityImpl.access$000(this.a).finish();
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface)
    {
      throw new ARFatalException("Failed to launch ARInstallActivity");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.InformActivityImpl.2
 * JD-Core Version:    0.7.0.1
 */