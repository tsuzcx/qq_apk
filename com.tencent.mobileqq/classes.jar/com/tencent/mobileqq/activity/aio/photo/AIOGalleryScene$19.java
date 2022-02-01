package com.tencent.mobileqq.activity.aio.photo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.widget.immersive.ImmersiveUtils;

class AIOGalleryScene$19
  implements DialogInterface.OnDismissListener
{
  AIOGalleryScene$19(AIOGalleryScene paramAIOGalleryScene) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((ImmersiveUtils.isSupporImmersive() == 1) && (AIOGalleryScene.a(this.a) != null)) {
      this.a.r();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.19
 * JD-Core Version:    0.7.0.1
 */