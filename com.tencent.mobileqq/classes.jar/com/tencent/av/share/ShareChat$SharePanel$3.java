package com.tencent.av.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class ShareChat$SharePanel$3
  implements DialogInterface.OnDismissListener
{
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append("ActionSheet.onDismiss, mChoosedLinkType[");
    paramDialogInterface.append(this.b.c);
    paramDialogInterface.append("], mIHandle[");
    paramDialogInterface.append(this.b.f);
    paramDialogInterface.append("], seq[");
    paramDialogInterface.append(this.a);
    paramDialogInterface.append("]");
    QLog.w("ShareChat", 1, paramDialogInterface.toString());
    if ((this.b.c == -1) && (this.b.f != null))
    {
      paramDialogInterface = this.b;
      paramDialogInterface.a(paramDialogInterface.b, this.b.c, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.3
 * JD-Core Version:    0.7.0.1
 */