package com.tencent.mobileqq.ark.image;

import agrz;
import alvj;
import alvo;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class PhotoListLogicArk$2
  implements Runnable
{
  public PhotoListLogicArk$2(alvo paramalvo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListLogicArk", 1, "copy file to res: " + alvo.a(this.this$0));
    }
    String str = alvj.a(alvo.a(this.this$0).a, alvo.a(this.this$0), alvo.a(this.this$0), alvo.b(this.this$0));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", str);
    alvj.a().a("callbackArk", localBundle, null);
    ThreadManagerV2.getUIHandlerV2().post(new PhotoListLogicArk.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoListLogicArk.2
 * JD-Core Version:    0.7.0.1
 */