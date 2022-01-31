package com.tencent.mobileqq.ark.image;

import agrz;
import alvj;
import alvq;
import alvr;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

public class PhotoPreviewLogicArk$1$1
  implements Runnable
{
  public PhotoPreviewLogicArk$1$1(alvr paramalvr) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewLogicArk", 2, "ArkApp copy file to res: " + alvq.a(this.a.a));
    }
    String str = alvj.a(alvq.e(this.a.a).a, alvq.a(this.a.a), alvq.a(this.a.a), alvq.b(this.a.a));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", str);
    alvj.a().a("callbackArk", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoPreviewLogicArk.1.1
 * JD-Core Version:    0.7.0.1
 */