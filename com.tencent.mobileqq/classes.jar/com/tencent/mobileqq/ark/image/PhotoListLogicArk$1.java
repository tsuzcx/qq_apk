package com.tencent.mobileqq.ark.image;

import android.os.Bundle;
import android.os.Handler;
import apqv;
import apra;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class PhotoListLogicArk$1
  implements Runnable
{
  public PhotoListLogicArk$1(apra paramapra) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListLogicArk", 1, "copy file to res: " + apra.a(this.this$0));
    }
    String str = apqv.a(apra.a(this.this$0).selectedPhotoList, apra.a(this.this$0), apra.a(this.this$0), apra.b(this.this$0));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", str);
    apqv.a().a("callbackArk", localBundle, null);
    ThreadManagerV2.getUIHandlerV2().post(new PhotoListLogicArk.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.PhotoListLogicArk.1
 * JD-Core Version:    0.7.0.1
 */