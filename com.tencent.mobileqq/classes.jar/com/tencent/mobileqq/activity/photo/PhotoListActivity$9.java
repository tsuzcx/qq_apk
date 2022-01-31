package com.tencent.mobileqq.activity.photo;

import android.os.Handler;
import android.os.Message;
import bbbx;
import java.util.Map;

class PhotoListActivity$9
  implements Runnable
{
  PhotoListActivity$9(PhotoListActivity paramPhotoListActivity, String paramString) {}
  
  public void run()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    String str = PhotoListActivity.a(this.this$0, this.a);
    localMessage.obj = str;
    LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
    bbbx.a(localLocalMediaInfo, str);
    PhotoListActivity.a().put(str, localLocalMediaInfo);
    this.this$0.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoListActivity.9
 * JD-Core Version:    0.7.0.1
 */