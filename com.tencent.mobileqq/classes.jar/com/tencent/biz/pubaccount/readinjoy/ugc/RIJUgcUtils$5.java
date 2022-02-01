package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;

final class RIJUgcUtils$5
  implements DialogInterface.OnClickListener
{
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.dismiss();
      ThreadManager.executeOnSubThread(new RIJUgcUtils.5.1(this));
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      for (;;)
      {
        QLog.e("RIJUGC.RIJUgcUtils", 1, "showCantUploadTips error", paramDialogInterface);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils.5
 * JD-Core Version:    0.7.0.1
 */