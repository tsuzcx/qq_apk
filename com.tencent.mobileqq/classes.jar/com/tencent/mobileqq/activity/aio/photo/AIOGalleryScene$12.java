package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class AIOGalleryScene$12
  implements DialogInterface.OnClickListener
{
  AIOGalleryScene$12(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    AIOGalleryScene.r(this.a).setResult(8001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.12
 * JD-Core Version:    0.7.0.1
 */