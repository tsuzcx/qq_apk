package com.tencent.avgame.business.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class AvGameManagerImpl$4
  implements DialogInterface.OnClickListener
{
  AvGameManagerImpl$4(AvGameManagerImpl paramAvGameManagerImpl, Activity paramActivity, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      this.e.joinAvGameRoom(this.a, this.b, this.c, this.d);
      return;
    }
    this.e.onPermisionDenied(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.api.impl.AvGameManagerImpl.4
 * JD-Core Version:    0.7.0.1
 */