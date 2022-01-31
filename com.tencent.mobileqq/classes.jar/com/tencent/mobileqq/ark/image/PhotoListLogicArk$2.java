package com.tencent.mobileqq.ark.image;

import aggf;
import algw;
import alhb;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class PhotoListLogicArk$2
  implements Runnable
{
  public PhotoListLogicArk$2(alhb paramalhb) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListLogicArk", 1, "copy file to res: " + alhb.a(this.this$0));
    }
    String str = algw.a(alhb.a(this.this$0).a, alhb.a(this.this$0), alhb.a(this.this$0), alhb.b(this.this$0));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", str);
    algw.a().a("callbackArk", localBundle, null);
    ThreadManagerV2.getUIHandlerV2().post(new PhotoListLogicArk.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoListLogicArk.2
 * JD-Core Version:    0.7.0.1
 */