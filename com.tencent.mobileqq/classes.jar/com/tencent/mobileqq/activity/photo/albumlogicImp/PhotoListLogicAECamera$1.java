package com.tencent.mobileqq.activity.photo.albumlogicImp;

import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;

class PhotoListLogicAECamera$1
  implements MediaScanner.OnMediaInfoScannerListener
{
  PhotoListLogicAECamera$1(PhotoListLogicAECamera paramPhotoListLogicAECamera) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (QQStoryFlowCallback.a(this.a.mActivity, paramLocalMediaInfo))
    {
      PhotoListLogicAECamera.a(this.a, paramLocalMediaInfo);
      VSReporter.a("mystatus_localupload", "pic_select", 0, 0, new String[0]);
      return;
    }
    ((NewPhotoListActivity)this.a.mActivity).cancleProgressDailog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicAECamera.1
 * JD-Core Version:    0.7.0.1
 */