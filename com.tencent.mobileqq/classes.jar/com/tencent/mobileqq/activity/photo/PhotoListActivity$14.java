package com.tencent.mobileqq.activity.photo;

import alvj;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

class PhotoListActivity$14
  implements Runnable
{
  PhotoListActivity$14(PhotoListActivity paramPhotoListActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListActivity", 1, "copy file to res: " + PhotoListActivity.a(this.this$0));
    }
    String str = alvj.a(this.this$0.c, PhotoListActivity.a(this.this$0), PhotoListActivity.m(this.this$0), PhotoListActivity.b(this.this$0));
    Bundle localBundle = new Bundle();
    localBundle.putString("bundle_key_info", str);
    alvj.a().a("callbackArk", localBundle, null);
    ThreadManagerV2.getUIHandlerV2().post(new PhotoListActivity.14.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoListActivity.14
 * JD-Core Version:    0.7.0.1
 */