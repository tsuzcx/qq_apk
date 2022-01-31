package com.tencent.mobileqq.activity.photo.album.logicImp;

import agrs;
import ague;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import mqq.util.WeakReference;

class PhotoListLogicQzone$2$1
  implements Runnable
{
  PhotoListLogicQzone$2$1(PhotoListLogicQzone.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.a.get() != null)
    {
      agrs localagrs = ((NewPhotoListActivity)this.a.this$0.a.get()).a;
      if (localagrs != null) {
        localagrs.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicQzone.2.1
 * JD-Core Version:    0.7.0.1
 */