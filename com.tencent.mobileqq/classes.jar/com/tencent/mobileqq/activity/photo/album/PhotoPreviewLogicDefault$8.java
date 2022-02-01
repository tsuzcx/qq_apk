package com.tencent.mobileqq.activity.photo.album;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;

class PhotoPreviewLogicDefault$8
  implements DialogInterface.OnClickListener
{
  PhotoPreviewLogicDefault$8(PhotoPreviewLogicDefault paramPhotoPreviewLogicDefault) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoPreviewActivity", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
    if (((NewPhotoPreviewActivity)this.a.mActivity).sendBtn != null) {
      ((NewPhotoPreviewActivity)this.a.mActivity).sendBtn.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault.8
 * JD-Core Version:    0.7.0.1
 */