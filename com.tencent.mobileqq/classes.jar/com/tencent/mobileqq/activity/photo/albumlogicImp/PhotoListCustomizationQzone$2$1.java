package com.tencent.mobileqq.activity.photo.albumlogicImp;

import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;

class PhotoListCustomizationQzone$2$1
  implements Runnable
{
  PhotoListCustomizationQzone$2$1(PhotoListCustomizationQzone.2 param2) {}
  
  public void run()
  {
    if (PhotoListCustomizationQzone.b(this.a.this$0) != null)
    {
      PhotoListAdapter localPhotoListAdapter = this.a.this$0.a.a;
      if (localPhotoListAdapter != null) {
        localPhotoListAdapter.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone.2.1
 * JD-Core Version:    0.7.0.1
 */