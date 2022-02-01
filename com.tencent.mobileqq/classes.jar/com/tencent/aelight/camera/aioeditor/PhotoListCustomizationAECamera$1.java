package com.tencent.aelight.camera.aioeditor;

import com.tencent.aelight.camera.aioeditor.activity.richmedia.QQStoryFlowCallback;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;

class PhotoListCustomizationAECamera$1
  implements MediaScanner.OnMediaInfoScannerListener
{
  PhotoListCustomizationAECamera$1(PhotoListCustomizationAECamera paramPhotoListCustomizationAECamera) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (QQStoryFlowCallback.a(PhotoListCustomizationAECamera.a(this.a), paramLocalMediaInfo))
    {
      PhotoListCustomizationAECamera.a(this.a, paramLocalMediaInfo);
      VSReporter.a("mystatus_localupload", "pic_select", 0, 0, new String[0]);
      return;
    }
    PhotoListCustomizationAECamera.a(this.a).a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.PhotoListCustomizationAECamera.1
 * JD-Core Version:    0.7.0.1
 */