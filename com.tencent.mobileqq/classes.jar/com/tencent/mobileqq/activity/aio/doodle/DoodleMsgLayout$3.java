package com.tencent.mobileqq.activity.aio.doodle;

import aggx;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class DoodleMsgLayout$3
  implements Runnable
{
  DoodleMsgLayout$3(DoodleMsgLayout paramDoodleMsgLayout, int paramInt) {}
  
  public void run()
  {
    QLog.d("DoodleMsgLayout", 2, "setDoodleContent start create drawable:" + this.a);
    if (!aggx.a().b(1, this.a)) {
      aggx.a().b(1, this.a, this.this$0, this.this$0);
    }
    Drawable localDrawable;
    do
    {
      return;
      localDrawable = aggx.a().a(2, this.a, true);
      if (localDrawable != null) {
        ((URLDrawable)localDrawable).startDownload();
      }
    } while (this.a != DoodleMsgLayout.a(this.this$0));
    new Handler(Looper.getMainLooper()).post(new DoodleMsgLayout.3.1(this, localDrawable));
    QLog.d("DoodleMsgLayout", 2, "setDoodleContent finish create drawable:" + this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.3
 * JD-Core Version:    0.7.0.1
 */