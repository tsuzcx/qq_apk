package com.tencent.av.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class ShareChat$SharePanel$2
  implements DialogInterface.OnDismissListener
{
  ShareChat$SharePanel$2(ShareChat.SharePanel paramSharePanel) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel())
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("ShareActionSheetBuilder.onDismiss, mChoosedChannel[");
      paramDialogInterface.append(this.a.b);
      paramDialogInterface.append("], mIHandle[");
      paramDialogInterface.append(this.a.f);
      paramDialogInterface.append("]");
      QLog.w("ShareChat", 1, paramDialogInterface.toString());
    }
    if ((this.a.b == -1) && (this.a.f != null))
    {
      paramDialogInterface = this.a;
      paramDialogInterface.a(paramDialogInterface.b, this.a.c, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.2
 * JD-Core Version:    0.7.0.1
 */