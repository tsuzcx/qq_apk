package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class AIOGalleryScene$23
  implements DialogInterface.OnClickListener
{
  AIOGalleryScene$23(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    AIOGalleryScene.N(this.a).setResult(8001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.23
 * JD-Core Version:    0.7.0.1
 */