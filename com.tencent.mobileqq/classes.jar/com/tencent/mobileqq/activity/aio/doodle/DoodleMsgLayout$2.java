package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;

class DoodleMsgLayout$2
  implements Runnable
{
  DoodleMsgLayout$2(DoodleMsgLayout paramDoodleMsgLayout) {}
  
  public void run()
  {
    Bitmap localBitmap = BitmapManager.a(BaseApplication.getContext().getResources(), 2130839407);
    if ((localBitmap != null) && (GlobalImageCache.a != null)) {
      GlobalImageCache.a.put("aio_doodle_progress", localBitmap, (byte)0);
    }
    new Handler(Looper.getMainLooper()).post(new DoodleMsgLayout.2.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.2
 * JD-Core Version:    0.7.0.1
 */