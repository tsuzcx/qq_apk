package com.tencent.mobileqq.ark.image;

import android.os.Bundle;
import aqba;
import aqbg;
import aqbh;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qphone.base.util.QLog;

public class PhotoPreviewLogicArk$1$1
  implements Runnable
{
  public PhotoPreviewLogicArk$1$1(aqbh paramaqbh) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewLogicArk", 2, "ArkApp copy file to res: " + aqbg.a(this.a.a));
    }
    String str = aqba.a(aqbg.e(this.a.a).selectedPhotoList, aqbg.a(this.a.a), aqbg.a(this.a.a), aqbg.b(this.a.a));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", str);
    aqba.a().a("callbackArk", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoPreviewLogicArk.1.1
 * JD-Core Version:    0.7.0.1
 */