package com.tencent.mobileqq.activity.aio.photo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class AIOGalleryScene$26
  implements DialogInterface.OnKeyListener
{
  AIOGalleryScene$26(AIOGalleryScene paramAIOGalleryScene) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramDialogInterface = this.a;
      paramDialogInterface.n = true;
      AIOGalleryScene.a(paramDialogInterface).dismiss();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.26
 * JD-Core Version:    0.7.0.1
 */