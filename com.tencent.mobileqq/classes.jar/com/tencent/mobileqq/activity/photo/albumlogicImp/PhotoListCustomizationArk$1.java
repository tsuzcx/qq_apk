package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.qphone.base.util.QLog;

class PhotoListCustomizationArk$1
  implements Runnable
{
  PhotoListCustomizationArk$1(PhotoListCustomizationArk paramPhotoListCustomizationArk) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("copy file to res: ");
      ((StringBuilder)localObject).append(PhotoListCustomizationArk.a(this.this$0));
      QLog.d("PhotoListCustomizationArk", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = ChooseImageIPCModule.a(this.this$0.a.selectedPhotoList, PhotoListCustomizationArk.a(this.this$0), PhotoListCustomizationArk.a(this.this$0), PhotoListCustomizationArk.b(this.this$0));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", (String)localObject);
    ChooseImageIPCModule.a().a("callbackArk", localBundle, null);
    ThreadManagerV2.getUIHandlerV2().post(new PhotoListCustomizationArk.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationArk.1
 * JD-Core Version:    0.7.0.1
 */