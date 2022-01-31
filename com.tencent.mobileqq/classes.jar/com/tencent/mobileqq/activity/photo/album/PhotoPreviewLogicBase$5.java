package com.tencent.mobileqq.activity.photo.album;

import android.view.View;
import android.view.View.OnClickListener;

class PhotoPreviewLogicBase$5
  implements View.OnClickListener
{
  PhotoPreviewLogicBase$5(PhotoPreviewLogicBase paramPhotoPreviewLogicBase) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mActivity.finish();
    QAlbumUtil.anim(this.this$0.mActivity, true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase.5
 * JD-Core Version:    0.7.0.1
 */