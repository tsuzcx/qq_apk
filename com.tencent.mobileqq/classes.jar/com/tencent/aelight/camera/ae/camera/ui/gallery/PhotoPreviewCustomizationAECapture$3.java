package com.tencent.aelight.camera.ae.camera.ui.gallery;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.Button;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;

class PhotoPreviewCustomizationAECapture$3
  implements DialogInterface.OnDismissListener
{
  PhotoPreviewCustomizationAECapture$3(PhotoPreviewCustomizationAECapture paramPhotoPreviewCustomizationAECapture) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (PhotoPreviewCustomizationAECapture.j(this.a) != null)
    {
      PhotoPreviewCustomizationAECapture.i(this.a).removeObserver(PhotoPreviewCustomizationAECapture.j(this.a));
      PhotoPreviewCustomizationAECapture.a(this.a, null);
    }
    this.a.s().l.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoPreviewCustomizationAECapture.3
 * JD-Core Version:    0.7.0.1
 */