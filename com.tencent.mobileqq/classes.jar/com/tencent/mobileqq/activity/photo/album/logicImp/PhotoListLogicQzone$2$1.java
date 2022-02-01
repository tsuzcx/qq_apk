package com.tencent.mobileqq.activity.photo.album.logicImp;

import akod;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

class PhotoListLogicQzone$2$1
  implements Runnable
{
  PhotoListLogicQzone$2$1(PhotoListLogicQzone.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.mActivity != null)
    {
      AbstractPhotoListActivity.PhotoListAdapter localPhotoListAdapter = ((NewPhotoListActivity)this.a.this$0.mActivity).photoListAdapter;
      if (localPhotoListAdapter != null) {
        localPhotoListAdapter.notifyDataSetChanged();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicQzone.2.1
 * JD-Core Version:    0.7.0.1
 */