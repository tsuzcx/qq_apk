package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.TransFileControllerBusHelper;

class DialogActivity$2
  implements DialogInterface.OnClickListener
{
  DialogActivity$2(DialogActivity paramDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (ITransFileController)this.a.app.getRuntimeService(ITransFileController.class);
    paramDialogInterface.getBusHelper().resumeLastRawSend();
    paramDialogInterface.getBusHelper().resumeLastShortVideoTransfer();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DialogActivity.2
 * JD-Core Version:    0.7.0.1
 */