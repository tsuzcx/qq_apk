package com.tencent.mobileqq.ark.image;

import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qphone.base.util.QLog;

class PhotoPreviewLogicArk$1$1
  implements Runnable
{
  PhotoPreviewLogicArk$1$1(PhotoPreviewLogicArk.1 param1) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewLogicArk", 2, "ArkApp copy file to res: " + PhotoPreviewLogicArk.a(this.a.a));
    }
    String str = ChooseImageIPCModule.a(PhotoPreviewLogicArk.e(this.a.a).selectedPhotoList, PhotoPreviewLogicArk.a(this.a.a), PhotoPreviewLogicArk.a(this.a.a), PhotoPreviewLogicArk.b(this.a.a));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", str);
    ChooseImageIPCModule.a().a("callbackArk", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoPreviewLogicArk.1.1
 * JD-Core Version:    0.7.0.1
 */