package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.qphone.base.util.QLog;

class PhotoListCustomizationAIO$4
  implements DialogInterface.OnClickListener
{
  PhotoListCustomizationAIO$4(PhotoListCustomizationAIO paramPhotoListCustomizationAIO) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQAlbum", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
    if (this.a.a.a != null) {
      this.a.a.a.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAIO.4
 * JD-Core Version:    0.7.0.1
 */