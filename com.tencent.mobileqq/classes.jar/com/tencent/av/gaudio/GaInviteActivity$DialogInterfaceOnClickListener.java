package com.tencent.av.gaudio;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class GaInviteActivity$DialogInterfaceOnClickListener
  implements DialogInterface.OnClickListener
{
  int a;
  
  public GaInviteActivity$DialogInterfaceOnClickListener(GaInviteActivity paramGaInviteActivity, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramInt = this.a;
    if (paramInt != 0)
    {
      if ((paramInt == 1) || (paramInt == 2)) {
        this.b.finish();
      }
    }
    else
    {
      if (this.b.f.j) {
        this.b.f.G();
      }
      this.b.g();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteActivity.DialogInterfaceOnClickListener
 * JD-Core Version:    0.7.0.1
 */