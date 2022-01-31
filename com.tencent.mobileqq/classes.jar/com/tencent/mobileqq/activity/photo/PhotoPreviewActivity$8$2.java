package com.tencent.mobileqq.activity.photo;

import agov;
import alvk;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class PhotoPreviewActivity$8$2
  implements Runnable
{
  public PhotoPreviewActivity$8$2(agov paramagov) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "ArkApp copy file to res: " + PhotoPreviewActivity.a(this.a.a));
    }
    String str = alvk.a(this.a.a.b, PhotoPreviewActivity.a(this.a.a), PhotoPreviewActivity.e(this.a.a), PhotoPreviewActivity.b(this.a.a));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", str);
    alvk.a().a("callbackArk", localBundle, null);
    ThreadManagerV2.getUIHandlerV2().post(new PhotoPreviewActivity.8.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoPreviewActivity.8.2
 * JD-Core Version:    0.7.0.1
 */