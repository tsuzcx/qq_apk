package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class VideoInviteActivity$DialogInterfaceOnClickListener
  implements DialogInterface.OnClickListener
{
  int a;
  
  public VideoInviteActivity$DialogInterfaceOnClickListener(VideoInviteActivity paramVideoInviteActivity, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.b.H == null) {
      return;
    }
    long l = AudioHelper.c();
    String str = this.b.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onClick, seq[");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    localObject = ((StringBuilder)localObject).toString();
    paramInt = 1;
    QLog.w(str, 1, (String)localObject);
    int i = this.a;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      paramDialogInterface.dismiss();
      this.b.a(l, true);
      this.b.finish();
      return;
    }
    paramDialogInterface.dismiss();
    this.b.d().G();
    paramDialogInterface = this.b;
    paramDialogInterface.r = true;
    paramDialogInterface = paramDialogInterface.d();
    if (!this.b.g) {
      paramInt = 2;
    }
    paramDialogInterface.a(l, paramInt, false, true);
    this.b.j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.DialogInterfaceOnClickListener
 * JD-Core Version:    0.7.0.1
 */