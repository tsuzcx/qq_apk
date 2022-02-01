package com.tencent.mobileqq.activity.photo.album;

import android.support.v7.widget.GridLayoutManager;

class PhotoListLogicDefault$9
  implements Runnable
{
  PhotoListLogicDefault$9(PhotoListLogicDefault paramPhotoListLogicDefault, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.mActivity != null) {
      ((NewPhotoListActivity)this.this$0.mActivity).gridLayoutManager.scrollToPositionWithOffset(this.a, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.9
 * JD-Core Version:    0.7.0.1
 */