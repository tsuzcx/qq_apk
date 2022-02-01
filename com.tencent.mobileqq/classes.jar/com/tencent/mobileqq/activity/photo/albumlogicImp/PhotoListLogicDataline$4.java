package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

class PhotoListLogicDataline$4
  implements DialogInterface.OnClickListener
{
  PhotoListLogicDataline$4(PhotoListLogicDataline paramPhotoListLogicDataline) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (((NewPhotoListActivity)this.a.mActivity).sendBtn != null) {
      ((NewPhotoListActivity)this.a.mActivity).sendBtn.setClickable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicDataline.4
 * JD-Core Version:    0.7.0.1
 */