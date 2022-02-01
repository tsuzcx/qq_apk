package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class MultiVideoEnterPageActivity$DialogInterfaceOnClickListener
  implements DialogInterface.OnClickListener
{
  int a;
  
  public MultiVideoEnterPageActivity$DialogInterfaceOnClickListener(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = this.a;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (QLog.isColorLevel())
        {
          String str = this.b.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("DialogInterfaceOnClickListener-->Wrong type.mode=");
          localStringBuilder.append(this.a);
          QLog.e(str, 2, localStringBuilder.toString());
        }
        paramDialogInterface.dismiss();
        return;
      }
      paramDialogInterface.dismiss();
      return;
    }
    this.b.sendBroadcast(new Intent("com.gvideo.com.tencent.av.EXIT_GROUP_VIDEO"));
    this.b.sendBroadcast(new Intent("tencent.video.v2g.exitAVGame"));
    paramDialogInterface.dismiss();
    this.b.u.a(this.b.u.k().aQ, this.b.u.k().aN, 81);
    paramDialogInterface = this.b;
    paramDialogInterface.f(paramDialogInterface.r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.DialogInterfaceOnClickListener
 * JD-Core Version:    0.7.0.1
 */