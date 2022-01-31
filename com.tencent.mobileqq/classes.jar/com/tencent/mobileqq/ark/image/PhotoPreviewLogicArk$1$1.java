package com.tencent.mobileqq.ark.image;

import aggf;
import algw;
import alhd;
import alhe;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class PhotoPreviewLogicArk$1$1
  implements Runnable
{
  public PhotoPreviewLogicArk$1$1(alhe paramalhe) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewLogicArk", 2, "ArkApp copy file to res: " + alhd.a(this.a.a));
    }
    String str = algw.a(alhd.e(this.a.a).a, alhd.a(this.a.a), alhd.a(this.a.a), alhd.b(this.a.a));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", str);
    algw.a().a("callbackArk", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoPreviewLogicArk.1.1
 * JD-Core Version:    0.7.0.1
 */