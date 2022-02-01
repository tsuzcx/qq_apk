package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.qphone.base.util.QLog;

class PhotoPreviewCustomizationArk$1$1
  implements Runnable
{
  PhotoPreviewCustomizationArk$1$1(PhotoPreviewCustomizationArk.1 param1) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ArkApp copy file to res: ");
      ((StringBuilder)localObject).append(PhotoPreviewCustomizationArk.a(this.a.a));
      QLog.d("PhotoPreviewCustomizationArk", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ChooseImageIPCModule.a(this.a.a.a.selectedPhotoList, PhotoPreviewCustomizationArk.a(this.a.a), PhotoPreviewCustomizationArk.a(this.a.a), PhotoPreviewCustomizationArk.b(this.a.a));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", (String)localObject);
    ChooseImageIPCModule.a().a("callbackArk", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationArk.1.1
 * JD-Core Version:    0.7.0.1
 */