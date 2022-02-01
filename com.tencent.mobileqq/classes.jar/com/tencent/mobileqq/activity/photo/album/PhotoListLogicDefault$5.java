package com.tencent.mobileqq.activity.photo.album;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.qphone.base.util.QLog;

class PhotoListLogicDefault$5
  implements DialogInterface.OnClickListener
{
  PhotoListLogicDefault$5(PhotoListLogicDefault paramPhotoListLogicDefault) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PhotoListActivity", 2, "cancel shortvideo_mobile_send_confirm dialog");
    }
    if (((NewPhotoListActivity)this.a.mActivity).sendBtn != null) {
      ((NewPhotoListActivity)this.a.mActivity).sendBtn.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.5
 * JD-Core Version:    0.7.0.1
 */