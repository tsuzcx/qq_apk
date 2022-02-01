package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;

class PhotoListCustomizationDataline$1
  implements Runnable
{
  PhotoListCustomizationDataline$1(PhotoListCustomizationDataline paramPhotoListCustomizationDataline, Intent paramIntent) {}
  
  public void run()
  {
    PhotoListCustomizationDataline localPhotoListCustomizationDataline = this.this$0;
    localPhotoListCustomizationDataline.a(PhotoListCustomizationDataline.a(localPhotoListCustomizationDataline), this.a, this.this$0.a.selectedPhotoList);
    com.tencent.mobileqq.shortvideo.SVBusiUtil.b = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationDataline.1
 * JD-Core Version:    0.7.0.1
 */