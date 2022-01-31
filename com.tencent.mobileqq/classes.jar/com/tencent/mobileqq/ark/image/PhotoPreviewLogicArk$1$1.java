package com.tencent.mobileqq.ark.image;

import aiqy;
import android.os.Bundle;
import anqp;
import anqw;
import anqx;
import com.tencent.qphone.base.util.QLog;

public class PhotoPreviewLogicArk$1$1
  implements Runnable
{
  public PhotoPreviewLogicArk$1$1(anqx paramanqx) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewLogicArk", 2, "ArkApp copy file to res: " + anqw.a(this.a.a));
    }
    String str = anqp.a(anqw.e(this.a.a).selectedPhotoList, anqw.a(this.a.a), anqw.a(this.a.a), anqw.b(this.a.a));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", str);
    anqp.a().a("callbackArk", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoPreviewLogicArk.1.1
 * JD-Core Version:    0.7.0.1
 */