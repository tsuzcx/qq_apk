package com.tencent.mobileqq.ark.image;

import anqu;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

class PhotoListLogicArk$2$1
  implements Runnable
{
  PhotoListLogicArk$2$1(PhotoListLogicArk.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.mActivity != null) {
      ((NewPhotoListActivity)this.a.this$0.mActivity).closeContextMenu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoListLogicArk.2.1
 * JD-Core Version:    0.7.0.1
 */