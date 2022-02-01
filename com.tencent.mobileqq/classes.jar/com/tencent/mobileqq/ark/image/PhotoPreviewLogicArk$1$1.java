package com.tencent.mobileqq.ark.image;

import android.os.Bundle;
import aqel;
import aqer;
import aqes;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qphone.base.util.QLog;

public class PhotoPreviewLogicArk$1$1
  implements Runnable
{
  public PhotoPreviewLogicArk$1$1(aqes paramaqes) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewLogicArk", 2, "ArkApp copy file to res: " + aqer.a(this.a.a));
    }
    String str = aqel.a(aqer.e(this.a.a).selectedPhotoList, aqer.a(this.a.a), aqer.a(this.a.a), aqer.b(this.a.a));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", str);
    aqel.a().a("callbackArk", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoPreviewLogicArk.1.1
 * JD-Core Version:    0.7.0.1
 */