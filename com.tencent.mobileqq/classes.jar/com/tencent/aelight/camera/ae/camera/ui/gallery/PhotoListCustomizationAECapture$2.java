package com.tencent.aelight.camera.ae.camera.ui.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.Button;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;

class PhotoListCustomizationAECapture$2
  implements DialogInterface.OnDismissListener
{
  PhotoListCustomizationAECapture$2(PhotoListCustomizationAECapture paramPhotoListCustomizationAECapture) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (PhotoListCustomizationAECapture.a(this.a) != null)
    {
      PhotoListCustomizationAECapture.a(this.a).removeObserver(PhotoListCustomizationAECapture.a(this.a));
      PhotoListCustomizationAECapture.a(this.a, null);
    }
    this.a.a.a.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoListCustomizationAECapture.2
 * JD-Core Version:    0.7.0.1
 */