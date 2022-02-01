package com.tencent.mobileqq.ark.image;

import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

class PhotoListLogicArk$1$1
  implements Runnable
{
  PhotoListLogicArk$1$1(PhotoListLogicArk.1 param1) {}
  
  public void run()
  {
    if (this.a.this$0.mActivity != null) {
      ((NewPhotoListActivity)this.a.this$0.mActivity).closeContextMenu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoListLogicArk.1.1
 * JD-Core Version:    0.7.0.1
 */