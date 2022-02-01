package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.tencent.image.URLDrawable;

class DoodleMsgLayout$4
  implements Runnable
{
  DoodleMsgLayout$4(DoodleMsgLayout paramDoodleMsgLayout) {}
  
  public void run()
  {
    Drawable localDrawable1 = DoodleResHelper.a().a(1, DoodleMsgLayout.a(this.this$0), true);
    if (localDrawable1 != null) {
      ((URLDrawable)localDrawable1).setIndividualPause(true);
    }
    Drawable localDrawable2 = DoodleResHelper.a().a(2, DoodleMsgLayout.a(this.this$0), false);
    if (localDrawable2 != null) {
      ((URLDrawable)localDrawable2).startDownload();
    }
    new Handler(Looper.getMainLooper()).post(new DoodleMsgLayout.4.1(this, localDrawable1, localDrawable2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.4
 * JD-Core Version:    0.7.0.1
 */