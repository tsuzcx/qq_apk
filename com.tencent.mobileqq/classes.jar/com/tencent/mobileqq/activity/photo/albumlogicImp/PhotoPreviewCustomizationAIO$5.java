package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.qphone.base.util.QLog;

class PhotoPreviewCustomizationAIO$5
  implements DialogInterface.OnClickListener
{
  PhotoPreviewCustomizationAIO$5(PhotoPreviewCustomizationAIO paramPhotoPreviewCustomizationAIO) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAlbum", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
    if (this.a.s().l != null) {
      this.a.s().l.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO.5
 * JD-Core Version:    0.7.0.1
 */