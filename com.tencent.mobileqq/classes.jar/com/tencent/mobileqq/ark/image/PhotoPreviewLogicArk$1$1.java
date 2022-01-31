package com.tencent.mobileqq.ark.image;

import aimj;
import android.os.Bundle;
import anmg;
import anmn;
import anmo;
import com.tencent.qphone.base.util.QLog;

public class PhotoPreviewLogicArk$1$1
  implements Runnable
{
  public PhotoPreviewLogicArk$1$1(anmo paramanmo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewLogicArk", 2, "ArkApp copy file to res: " + anmn.a(this.a.a));
    }
    String str = anmg.a(anmn.e(this.a.a).selectedPhotoList, anmn.a(this.a.a), anmn.a(this.a.a), anmn.b(this.a.a));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", str);
    anmg.a().a("callbackArk", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoPreviewLogicArk.1.1
 * JD-Core Version:    0.7.0.1
 */