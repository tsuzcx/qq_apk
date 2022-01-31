package com.tencent.mobileqq.ark.image;

import alvp;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import mqq.util.WeakReference;

class PhotoListLogicArk$2$1
  implements Runnable
{
  PhotoListLogicArk$2$1(PhotoListLogicArk.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.a.get() != null) {
      ((NewPhotoListActivity)this.a.this$0.a.get()).closeContextMenu();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoListLogicArk.2.1
 * JD-Core Version:    0.7.0.1
 */